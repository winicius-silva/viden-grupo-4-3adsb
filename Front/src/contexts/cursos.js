import { useContext, createContext, useState, useCallback, useEffect } from 'react'

import api from '../api'
import cursosJSON from '../assets/json_dash.json'

const CursoContext = createContext({})

export function CursosProvider(props) {
    const [categoriaCursoSelecionado, setCategoriaCursoSelecionado] = useState('back_end')
    const [cursosData, setCursosData] = useState([])
    const [cursosCategorias, setCursosCategorias] = useState([])
    const [cursosRecentes, setCursosRecentes] = useState([])

    const [cursos] = useState(cursosJSON)

    /**
     * Muda a categoria do Curso Selecionado via interface na dashboard
     */
    const changeCategoriaCursoSelecionado = useCallback((newCursoSelecionadoId) => {
        if (!cursos.some(curso => newCursoSelecionadoId == curso.id) && newCursoSelecionadoId != categoriaCursoSelecionado) return

        setCategoriaCursoSelecionado(newCursoSelecionadoId)
    }, [cursos, setCategoriaCursoSelecionado])

    /**
     * Requisita todas as informações da categoria de curso atual
     */
    const getCategoriaCursoSelecionado = useCallback(() => {
        const cursoSelecionado = cursos.find(curso => categoriaCursoSelecionado == curso.id)

        return !cursoSelecionado ? cursos[0] : cursoSelecionado
    })

    /**
     * Preenche e filtra cursosCategorias e cursosData por categorias
     */
    const getCursoPorCategoria = useCallback(() => {
        api.get(`/cursos/filter/${getCategoriaCursoSelecionado().categoria}`).then(response => {
            if (response.status == 204) setCursosData([])

            setCursosData(response.data)
            setCursosCategorias(response.data.length ? response.data.map(cursos => cursos.subCategoria).filter((subCategoria, index, subCategorias) => subCategorias.indexOf(subCategoria) == index) : [])
        })
    }, [getCategoriaCursoSelecionado, categoriaCursoSelecionado, setCursosData])


    const getRecentCursos = useCallback(() => {
        api.get(`/usuarios_cursos/recent-cursos/${localStorage.getItem("id_usuario")}/2021-11-22`).then(response => {
            if(response.status == 204) setCursosRecentes([])

            setCursosRecentes(response.data)
        })
        
    }, [setCursosRecentes])

    /**
     * Todas as vezes que a categoria de cursos for alterada via interface, ele executará tudo o que está dentro desse useEffect
     */
    useEffect(() => {
        setCursosData([])
        getCursoPorCategoria()
    }, [categoriaCursoSelecionado, setCursosData])

    
    /**
     * Retorno das funções
     */
    return (
        <CursoContext.Provider value={{categoriaCursoSelecionado, cursosData, cursosCategorias, getCategoriaCursoSelecionado, changeCategoriaCursoSelecionado, getCursoPorCategoria, getRecentCursos, cursosRecentes}}>
            {props.children}
        </CursoContext.Provider>
    )
}

/**
 * Disponibiliza as funções e valores do contexto de curso
 */
export function useCursosContext() {
    const cursosContext = useContext(CursoContext)

    if (cursosContext == null) throw new Error('Componente precisa estar dentro do contexto de Cursos')

    return cursosContext
}