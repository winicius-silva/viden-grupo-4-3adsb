import { useContext, createContext, useState, useCallback, useEffect } from 'react'

import api from '../api'
import cursosJSON from '../assets/json_dash.json'

const CursoContext = createContext({})

export function CursosProvider(props) {
    const [categoriaCursoSelecionado, setCategoriaCursoSelecionado] = useState('back_end')
    const [cursosData, setCursosData] = useState([])
    const [cursosCategorias, setCursosCategorias] = useState([])
    const [cursosRecentes, setCursosRecentes] = useState([])
    const [cursosFinalizados, setCursosFinalizados] = useState([])

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
    }, [categoriaCursoSelecionado])

    /**
     * Preenche e filtra cursosCategorias e cursosData por categorias
     */
    const getCursoPorCategoria = useCallback(() => {
        api.get(`/cursos/filter/${getCategoriaCursoSelecionado().categoria}`).then(response => {
            if (response.status == 204) setCursosData([])

            setCursosData(response.data)
            setCursosCategorias(response.data.length ? response.data.map(cursos => cursos.subCategoria).filter((subCategoria, index, subCategorias) => subCategorias.indexOf(subCategoria) == index) : [])
        })
    }, [getCategoriaCursoSelecionado])


    const getRecentCursos = useCallback(() => {
        api.get(`/usuarios_cursos/recent-cursos/${localStorage.getItem("id_usuario")}`).then(recentCursosResponse => {
            if (recentCursosResponse.status == 204) {
                setCursosRecentes([])
                return
            }

            Promise.allSettled(
                recentCursosResponse.data.map(recentCursosData => api.get(`/cursos/${recentCursosData.fkCurso}`))
            ).then(recentCursosPromises => {
                recentCursosPromises = recentCursosPromises
                    .filter(recentCursosPromise => recentCursosPromise.status == 'fulfilled')
                    .map(recentCursosPromise => recentCursosPromise.value.data)
                    .map(recentCursosPromiseData => ({
                        dadosCurso: recentCursosResponse.data.find(cursoRecente => recentCursosPromiseData.idCurso == cursoRecente.fkCurso),
                        ...recentCursosPromiseData
                    }))

                setCursosRecentes(recentCursosPromises.filter(recentCursosData => !recentCursosData.dadosCurso.finalizado))
                setCursosFinalizados(recentCursosPromises.filter(recentCursosData => !!recentCursosData.dadosCurso.finalizado))
                console.log('recentCursosPromises GET END', recentCursosPromises)
            })


            console.log('recentCursosResponse GET', recentCursosResponse.data)


        })
    }, [])

    const createRecentCurso = useCallback((fkCurso) => {
        api.post('/usuarios_cursos/recent-cursos/', {
            fkUsuario: localStorage.getItem("id_usuario"),
            fkCurso,
            date: new Date().toJSON(),
            finalizado: 0,
            progresso: 0
        }, {
            headers: { "Access-Control-Allow-Origin": "*", "crossorigin": true }
        })
        .then()
        .catch(console.error)
    }, [])

    const getVideosCurso = useCallback(() => {
        api.get(`/video-curso/`)
    })

    /**
     * Todas as vezes que a categoria de cursos for alterada via interface, ele executará tudo o que está dentro desse useEffect
     */
    useEffect(() => {
        setCursosData([])
        getCursoPorCategoria()
    }, [categoriaCursoSelecionado])


    /**
     * Retorno das funções
     */
    return (
        <CursoContext.Provider value={{ 
            categoriaCursoSelecionado, 
            changeCategoriaCursoSelecionado,
            createRecentCurso,
            cursosCategorias,
            cursosData,
            cursosFinalizados,
            cursosRecentes,
            getCategoriaCursoSelecionado,
            getCursoPorCategoria,
            getRecentCursos,
            }}>
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