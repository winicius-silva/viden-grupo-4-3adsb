import React, { useState, useEffect } from "react";
import { Link, useHistory } from 'react-router-dom'
import { Line } from "react-chartjs-2";
import {
    Chart as ChartJS,
    CategoryScale,
    LinearScale,
    PointElement,
    LineElement,
    Title,
    Tooltip,
    Legend,
} from 'chart.js';
import Perfil from "../assets/img/perfil-white.png"
import gold from "../assets/img/gold-medal.png";
import bronze from "../assets/img/bronze-medal.png";
import average from "../assets/img/average.png";
import Content from "../components/dashboard/Content";
import Curso from "../components/dashboard/cursoItem";
import CursoRecent from "../components/dashboard/cursoRecentItem";
import Botao from "../components/dashboard/nav_button"
import StatsDash from "../components/dashboard/StatsDash";
import Footer from "../components/Footer";
import NotFound from "../components/dashboard/NotFound";
import '../assets/styles/dashboard.css'
import '../assets/styles/global.css';

import { useCursosContext } from '../contexts/cursos'


function Dashboard() {
    const { getCategoriaCursoSelecionado, cursosData, cursosCategorias, getRecentCursos, cursosRecentes , cursosFinalizados} = useCursosContext()
    const history = useHistory()

    const [cursoSelecionadoInfo, setCursoSelecionadoInfo] = useState(getCategoriaCursoSelecionado())

    useEffect(() => {
        if (localStorage.getItem('id_usuario') == null) {
            history.push('/login')
            alert("Faça o login para acessar a dashboard!")
        }
    }, [history])

    useEffect(() => {
        setCursoSelecionadoInfo(getCategoriaCursoSelecionado())
    }, [getCategoriaCursoSelecionado, getRecentCursos, cursosRecentes])

    useEffect(() => {
        getRecentCursos()
    }, [getRecentCursos])

    function sair() {
        history.push('/')
        localStorage.clear()
    }

    ChartJS.register(
        CategoryScale,
        LinearScale,
        PointElement,
        LineElement,
        Title,
        Tooltip,
        Legend
    );

    const options = {
        responsive: true,
        plugins: {
            legend: {
                position: '',
            },
            title: {
                display: true,
                text: '',
            },
        },
    };

    const labels = ['JAN', 'FEV', 'MAR', 'ABR', 'MAI', 'JUN', 'JUL', 'AGO', 'SET', 'OUT', 'NOV', 'DEZ'];

    const data = {
        labels,
        datasets: [
            {
                label: 'Dataset 1',
                data: [0, 15, 30, 5, 10, 33, 55, 0, 10, 43, 21, 10],
                borderColor: 'rgb(255, 99, 132)',
                backgroundColor: 'rgba(255, 99, 132, 0.5)',
            }
        ],
    };
    return (
        <>
            <div className="root_dashboard">
                <div className="header_dashboard">
                    <h1 className="font_header_index">&#60;&#47;Viden</h1>
                    <div id="search_dash">
                        <input id="search_input_index" type="text" placeholder=" Ex: Java cursos..." />
                    </div>

                    <div className="options_dash">

                        <div id="icon-perfil_dash">
                            <Link to="/perfil"> <img id="img_perfil_dash" src={Perfil} alt="" /> </Link>
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

            <div className="cursos_div">
                <h2 className="recentes_title">Cursos disponíveis:</h2>
                {Array.isArray(cursosCategorias) && cursosCategorias.length
                    ? cursosCategorias.map(cursoCategoria => (
                        <div className="container_cursos">
                            <h2>{cursoCategoria}</h2>
                            <div className="list_cursos">
                                {cursosData && cursosData.map(cursoData => 
                                    cursoData.subCategoria === cursoCategoria && <Curso  fkCurso={cursoData.idCurso} desc={`${cursoData.nomeCurso}: ${cursoData.descricao}`} pontos={cursoData.qtdPontos} />
                                )}
                            </div>
                        </div>
                    )) : (
                        <NotFound desc="Não encotramos nada aqui. Tente novamente mais tarde :("/>
                    )}
            </div>

            <div className="cursos_div">
                <h2 className="recentes_title">Cursos recentes:</h2>
                <div className="container_recentes">
                    {cursosRecentes && cursosRecentes.length ? cursosRecentes.map(cursoRecente => (
                        <CursoRecent desc={cursoRecente.nomeCurso} data={cursoRecente.dadosCurso.date} />
                    )) : (<NotFound desc="Não há cursos recentes. Experimente ver alguns :)"/>)}

                </div>
            </div>

            <div className="cursos_div">
                <h2 className="recentes_title">Cursos finalizados:</h2>
                <div className="container_recentes">
                    {cursosFinalizados && cursosFinalizados.length ? cursosFinalizados.map(cursosFinalizado => (
                        <CursoRecent desc={cursosFinalizado.nomeCurso} data={cursosFinalizado.dadosCurso.date} />
                    )) : (<NotFound desc="Não há cursos finalizados"/>)}

                </div>
            </div>

            <div className="performance_dash">
                <h2 className="recentes_title">Sua performance</h2>
                <div className="grafico_dash">
                    <Line options={options} data={data} />
                </div>
                <div className="info_dash">
                    <h4 className="info_dash_title">Estatística (VidenCoins)</h4>
                    <div className="icons_dash">
                        <StatsDash img={gold} result="-/-" desc="Resultado mais alto do teste" />
                        <StatsDash img={average} result="-/-" desc="Média de resultado do teste" />
                        <StatsDash img={bronze} result="-/-" desc="Resultado mais baixo do teste" />
                    </div>

                    <h4 className="info_dash_title">Estatística (Porcentagem)</h4>
                    <div className="icons_dash">
                        <StatsDash img={gold} result="-/-" desc="Resultado mais alto do teste" />
                        <StatsDash img={average} result="-/-" desc="Média de resultado do teste" />
                        <StatsDash img={bronze} result="-/-" desc="Resultado mais baixo do teste" />
                    </div>

                </div>
            </div>

            <Footer />
        </>
    )
}

export default Dashboard;