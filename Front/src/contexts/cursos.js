import { useContext, createContext, useState, useCallback, useEffect } from 'react'

import api from '../api'
// import cursosJSON from 'src/assets/json_dash.json'

const CursoContext = createContext({})

const cursosJSON = [
    {
        "id": "geral",
        "title": "GERAL",
        "content": "Encontre uma vasta Variedade de cursos, desde Cursos de Gestão a cursos de Mobile, explore, aprenda e coloque em prática.",
        "categoria": "GERAL"
    },

    {
        "id": "back_end",
        "title": "BACK-END",
        "content": "Programe nas principais linguagens e plataformas. Explore plataformas como Python, Node.JS, PHP, Java, e .NET a fundo, além de muito conteúdo em outras linguagens como GoLang, Clojure, C/C++, VB ou Cobol.  Saiba como começar com Programação.  Conheça mais da Escola de Programação ou navegue nessa página para ver todos nossos cursos e formações.",
        "categoria": "BACK-END"
    },

    {
        "id": "front_end",
        "title": "FRONT-END",
        "content": "Desenvolva experiências web incríveis com HTML, CSS e JavaScript, além de se aprofundar nos principais frameworks do mercado, como React, Angular e domine JavaScript a fundo.",
        "categoria": "FRONT-END"
    },

    {
        "id": "nuvem",
        "title": "NUVEM & CLOUD",
        "content": "Aprenda Amazon AWS, Microsoft Azure e Google Cloud de forma prática e sem complicações com os cursos que vão te possibilitar a escalar seus sistemas na nuvem. Saiba como começar com AWS.",
        "categoria": "NUVEM"
    },

    {
        "id": "ux_design",
        "title": "UX-DESIGN",
        "content": "O universo de UX & Design é gigante. Crie diferentes layouts para plataformas digitais.Construa e expanda o seu conhecimento nas principais tendências do mercado.",
        "categoria": "UX-DESIGN"
    }
]

export function CursosProvider(props) {
    const [categoriaCursoSelecionado, setCategoriaCursoSelecionado] = useState('back_end')
    const [cursosData, setCursosData] = useState([])
    const [cursosCategorias, setCursosCategorias] = useState([])
    const [cursosRecentes, setCursosRecentes] = useState([])
    const [cursosFinalizados, setCursosFinalizados] = useState([])
    const [cursosVideos, setCursosVideos] = useState([])
    const [cursoVideoLinkAtual, setCursoVideoLinkAtual] = useState('')
    const [pontosUsuario, setPontosUsuario] = useState([])

    const [cursos] = useState(cursosJSON)

    /**
     * Muda a categoria do Curso Selecionado via interface na dashboard
     */
    const changeCategoriaCursoSelecionado = useCallback((newCursoSelecionadoId) => {
        if (!cursos.some(curso => newCursoSelecionadoId === curso.id) && newCursoSelecionadoId !== categoriaCursoSelecionado) return

        setCategoriaCursoSelecionado(newCursoSelecionadoId)
    }, [cursos, categoriaCursoSelecionado, setCategoriaCursoSelecionado])

    const changeCursoVideoLinkAtual = useCallback(cursoVideoIndice => {
        setCursoVideoLinkAtual(cursoVideoIndice)
    }, [setCursoVideoLinkAtual])

    /**
     * Requisita todas as informações da categoria de curso atual
     */
    const getCategoriaCursoSelecionado = useCallback(() => {
        const cursoSelecionado = cursos.find(curso => categoriaCursoSelecionado === curso.id)

        return !cursoSelecionado ? cursos[0] : cursoSelecionado
    }, [cursos, categoriaCursoSelecionado])

    /**
     * Preenche e filtra cursosCategorias e cursosData por categorias
     */
    const getCursoPorCategoria = useCallback(async () => {
        return api.get(`/cursos/filter/${getCategoriaCursoSelecionado().categoria}`).then(response => {
            if (response.status === 204) setCursosData([])

            setCursosData(response.data)
            setCursosCategorias(response.data.length ? response.data.map(cursos => cursos.subCategoria).filter((subCategoria, index, subCategorias) => subCategorias.indexOf(subCategoria) === index) : [])
        })
    }, [getCategoriaCursoSelecionado])


    const getRecentCursos = useCallback(async () => {
        return api.get(`/usuarios_cursos/recent-cursos/${localStorage.getItem("id_usuario")}`).then(recentCursosResponse => {
            if (recentCursosResponse.status === 204) {
                setCursosRecentes([])
                return
            }

            Promise.allSettled(
                recentCursosResponse.data.map(recentCursosData => api.get(`/cursos/${recentCursosData.fkCurso}`))
            ).then(recentCursosPromises => {
                recentCursosPromises = recentCursosPromises
                    .filter(recentCursosPromise => recentCursosPromise.status === 'fulfilled')
                    .map(recentCursosPromise => recentCursosPromise.value.data)
                    .map(recentCursosPromiseData => ({
                        dadosCurso: recentCursosResponse.data.find(cursoRecente => recentCursosPromiseData.idCurso === cursoRecente.fkCurso),
                        ...recentCursosPromiseData
                    }))

                setCursosRecentes(recentCursosPromises.filter(recentCursosData => !recentCursosData.dadosCurso.finalizado))
                setCursosFinalizados(recentCursosPromises.filter(recentCursosData => !!recentCursosData.dadosCurso.finalizado))
                console.log('recentCursosPromises GET END', recentCursosPromises)
            })


            console.log('recentCursosResponse GET', recentCursosResponse.data)


        })
    }, [])

    const createRecentCurso = useCallback(async (fkCurso) => {
        return api.post('/usuarios_cursos/recent-cursos/', {
            fkUsuario: localStorage.getItem("id_usuario"),
            fkCurso,
            date: new Date().toJSON(),
            finalizado: 0,
            progresso: 0
        }, {
            headers: { "Access-Control-Allow-Origin": "*", "crossorigin": true }
        })
        .then()
        .catch(() => {})
    }, [])

    const getPontosUsuario = useCallback(async () => {
        return api.get(`/pontuacoes/${localStorage.getItem('id_usuario')}`).then(pontosUsuarioResponse => {
            console.log('PontosUsuario GET', pontosUsuarioResponse.data)
            setPontosUsuario(pontosUsuarioResponse.data || [])

        })
        .catch((err) => { console.log('ERROR getPontosUsuario', err)})
    }, [setPontosUsuario])

    const getVideosCurso = useCallback(async (fkCurso) => {
        return api.get(`/video-curso/${fkCurso}`).then(videoCursoResponse => {
            if(videoCursoResponse.status === 200)
            setCursosVideos(videoCursoResponse.data.sort((a, b) => a.indice > b.indice ? 1 : -1 ))
            console.log(videoCursoResponse.data.sort((a, b) => a.indice > b.indice ? 1 : -1 ))
        })
        .catch((err) => { console.log('ERROR getVideosCurso', err)})

    }, [setCursosVideos])

    const patchFinalizarCurso = useCallback(async (fkCurso) => {
        return api.patch(`/usuarios_cursos/progresso/${100}/${fkCurso}/${localStorage.getItem('id_usuario')}`)
            .then(finalizarCursoData => {
                console.log(finalizarCursoData.status)
                return finalizarCursoData
            })
            .catch((err) => { console.log('ERROR patchFinalizarCurso', err)})

    }, [])

    const postPontuacaoUsuario = useCallback(async (fkCurso, pontosCurso) => {
        console.log('Fui chamado %s %s', fkCurso, pontosCurso, localStorage.getItem("id_usuario"))
        return api.post(`/pontuacoes`, {
            data: new Date().toJSON(),
            pontos: pontosCurso,
            fkUsuario: localStorage.getItem("id_usuario"),
            fkCurso
        }, {
            headers: { "Access-Control-Allow-Origin": "*", "crossorigin": true }
        })
        .then(res => console.log("Pontos cadastrados pro usuario RES: %O", res))
        .catch(err => console.log("Pontos não cadastrados pro usuario RES: %O", err))
    }, [])

    /**
     * Todas as vezes que a categoria de cursos for alterada via interface, ele executará tudo o que está dentro desse useEffect
     */
    useEffect(() => {
        setCursosData([])
        getCursoPorCategoria()
    }, [categoriaCursoSelecionado, getCursoPorCategoria])


    /**
     * Retorno das funções
     */
    return (
        <CursoContext.Provider value={{ 
            categoriaCursoSelecionado, 
            changeCategoriaCursoSelecionado,
            changeCursoVideoLinkAtual,
            createRecentCurso,
            cursoVideoLinkAtual,
            cursosCategorias,
            cursosData,
            cursosFinalizados,
            cursosRecentes,
            cursosVideos,
            pontosUsuario,
            getCategoriaCursoSelecionado,
            getCursoPorCategoria,
            getPontosUsuario,
            getRecentCursos,
            getVideosCurso,
            patchFinalizarCurso,
            postPontuacaoUsuario,
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