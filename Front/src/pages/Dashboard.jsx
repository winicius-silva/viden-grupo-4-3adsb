import React, { useState, useEffect } from "react";
import { useHistory } from 'react-router-dom'
import Perfil from "../assets/img/perfil-white.png"
import Content from "../components/dashboard/Content";
import Curso from "../components/dashboard/cursoItem";
import CursoRecent from "../components/dashboard/cursoRecentItem";
import Botao from "../components/dashboard/nav_button"
import '../assets/styles/dashboard.css'
import '../assets/styles/global.css';

import { useCursosContext } from '../contexts/cursos'


function Dashboard() {
    const { getCategoriaCursoSelecionado, cursosData, cursosCategorias, getRecentCursos, cursosRecentes } = useCursosContext()
    const history = useHistory() 

    const [cursoSelecionadoInfo, setCursoSelecionadoInfo] = useState(getCategoriaCursoSelecionado())

    useEffect(() => {
        if(localStorage.getItem('id_usuario') == null) {
            history.push('/login')
            alert("Faça o login para acessar a dashboard!")
        }
    }, [])

    useEffect(() => {
        setCursoSelecionadoInfo(getCategoriaCursoSelecionado())
        getRecentCursos()
    }, [getCategoriaCursoSelecionado, setCursoSelecionadoInfo, getRecentCursos, cursosRecentes])

    function sair() {
        history.push('/')
        localStorage.clear()
    }

    return (
        <>
            <div className="root_dashboard">
                <div className="header_dashboard">
                    <h1 className="font_header_index">&#60;&#47;Viden</h1>
                    <div id="search_dash">
                        <input id="search_input_index" type="text" placeholder=" Ex: Java cursos..." />
                    </div>

                    <div className="options_dash">
                        <div id="dash_text">
                            <h4> Meus cursos </h4>
                        </div>

                        <div id="icon-perfil_dash">
                            <img id="img_perfil_dash" src={Perfil} alt="" />
                        </div>

                        <div id="btn_sair" onClick={sair}>
                            <h4> Sair </h4>
                        </div>

                    </div>

                </div>
            </div>

            <div className="nav_bar_dash">
                <Botao idCurso={'geral'} texto="Geral" />
                <Botao idCurso={'back_end'} texto="Back-End" />
                <Botao idCurso={'front_end'} texto="Front-End" />
                <Botao idCurso={'nuvem'} texto="Nuvem" />
                <Botao idCurso={'ux_design'} texto="UX-Design" />
            </div>

            <div className="container-dashboard" id="container_dashboard">
                <Content
                    titleContent={cursoSelecionadoInfo.title}
                    textContent={cursoSelecionadoInfo.content}
                />
            </div>

            <div>
                {cursosCategorias && cursosCategorias.map(cursoCategoria => (
                    <div className="container_cursos">
                        <h2>{cursoCategoria}</h2>
                        <div className="list_cursos">
                            {cursosData && cursosData.map(cursoData =>
                                cursoData.subCategoria == cursoCategoria && <Curso desc={`${cursoData.nomeCurso}: ${cursoData.descricao}`} />
                            )}
                        </div>
                    </div>
                ))}
            </div>

            <div>
                <h2 className="recentes_title">Cursos recentes</h2>
                <div className="container_recentes">
                    {cursosRecentes && cursosRecentes.map(cursoRecente => (
                        <CursoRecent desc={cursoRecente.nomeCurso} data={cursoRecente.date} />                        
                    ))}

                </div>
            </div>

            <div>

            </div>
        </>
    )
}

export default Dashboard;