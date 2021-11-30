import React, { useState, useEffect } from "react";
import { Link, useHistory } from 'react-router-dom'
import { Bar } from "react-chartjs-2";
import {
    Chart as ChartJS,
    CategoryScale,
    LinearScale,
    BarElement,
    Title,
    Tooltip,
    Legend,
} from 'chart.js';
import Perfil from "../assets/img/perfil-white.png"
import gold from "../assets/img/gold-medal.png";
import bronze from "../assets/img/bronze-medal.png";
import average from "../assets/img/average.png";
import Search from "../assets/img/search.png"
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
    const { getCategoriaCursoSelecionado, cursosData, cursosCategorias, getRecentCursos, cursosRecentes, cursosFinalizados, getPontosUsuario, pontosUsuario } = useCursosContext()
    const history = useHistory()

    const [cursoSelecionadoInfo, setCursoSelecionadoInfo] = useState(getCategoriaCursoSelecionado())

    const [inputSearch, setInputSearch] = useState("");

    const [scores, setScores] = useState({
        lowest: 0,
        average: 0,
        highest: 0,
    })

    const [chartLabels, setChartLabels] = useState({
        'JAN': '01',
        'FEV': '02',
        'MAR': '03',
        'ABR': '04',
        'MAI': '05',
        'JUN': '06',
        'JUL': '07',
        'AGO': '08',
        'SET': '09',
        'OUT': '10',
        'NOV': '11',
        'DEZ': '12'
    })

    const [chartData, setChartData] = useState({
        labels: Object.keys(chartLabels),
        datasets: [
            {
                label: 'VidenCoins',
                data: new Array(12).fill(0),
                borderColor: '#052957',
                backgroundColor: '#052957',
            }
        ],
    })

    const [chartOptions, setChartOptions] = useState({
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
    })

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

    useEffect(() => {
        getPontosUsuario()
    }, [])

    useEffect(() => {
        setChartData(oldChartData => {
            const monthDatas = new Array(Object.keys(chartLabels).length)
                .fill([])
                .map((_monthArray, monthArrayIndex) => pontosUsuario.filter(pontoUsuario => pontoUsuario.data.split('-')[1] === Object.values(chartLabels)[monthArrayIndex]))
                .map(monthArray => monthArray.length ? monthArray.map(monthData => monthData.pontos).reduce((prev, cur) => prev + cur) : monthArray)
                .map((monthValue, monthIndex, monthArray) => {
                    return typeof monthValue === 'object' ? 0 : monthValue
                })

            return {
                ...oldChartData,
                datasets: [{
                    ...oldChartData.datasets[0],
                    data: monthDatas
                }]
            }
        })
    }, [pontosUsuario])

    useEffect(() => {
        const currentChartData = [...chartData.datasets[0].data]
        setScores({
            lowest: currentChartData.sort((a, b) => a > b ? 1 : -1)[0],
            average: currentChartData.reduce((prev, cur) => prev + cur) / currentChartData.length,
            highest: currentChartData.sort((a, b) => a < b ? 1 : -1)[0]
        })
    }, [chartData])

    function sair() {
        history.push('/')
        localStorage.clear()
    }

    ChartJS.register(
        CategoryScale,
        LinearScale,
        BarElement,
        Title,
        Tooltip,
        Legend
    );

    return (
        <>
            <div className="root_dashboard">
                <div className="header_dashboard">
                    <h1 className="font_header_index">&#60;&#47;Viden</h1>
                    <div className="options_dash">

                        <div id="icon-perfil_dash">
                            <Link to="/perfil"> <img id="img_perfil_dash" src={Perfil} alt="" /> </Link>
                        </div>

                        <div id="btn_sair" onClick={sair}>
                            <h4> Logoff </h4>
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
                <div className="titles">
                    <h2 className="recentes_title">Cursos disponíveis:</h2>
                    <input id="search_input_index" className="input_search" type="text" placeholder=" Ex: Java cursos..." onChange={e => setInputSearch(e.target.value)} />
                </div>

                {Array.isArray(cursosCategorias) && cursosCategorias.length
                    ? cursosCategorias.map(cursoCategoria => (
                        <div className="container_cursos">
                            <h2>{cursoCategoria}</h2>
                            <div className="list_cursos">
                                {cursosData && cursosData.filter(cursoData => cursoData.nomeCurso.includes(inputSearch) || cursoData.descricao.includes(inputSearch)).map(cursoData =>
                                    cursoData.subCategoria === cursoCategoria && <Curso fkCurso={cursoData.idCurso} desc={`${cursoData.nomeCurso}: ${cursoData.descricao}`} pontos={cursoData.qtdPontos} />
                                )}
                            </div>
                        </div>
                    )) : (
                        <NotFound desc="Não encotramos nada aqui. Tente novamente mais tarde :(" />
                    )}
            </div>

            <div className="cursos_div">
                <h2 className="recentes_title">Cursos recentes:</h2>
                <div className="container_recentes">
                    {cursosRecentes && cursosRecentes.length ? cursosRecentes.map(cursoRecente => (
                        <CursoRecent fkCurso={cursoRecente.idCurso} desc={cursoRecente.nomeCurso} data={cursoRecente.dadosCurso.date} />
                    )) : (<NotFound desc="Não há cursos recentes. Experimente ver alguns :)" />)}

                </div>
            </div>

            <div className="cursos_div">
                <h2 className="recentes_title">Cursos finalizados:</h2>
                <div className="container_recentes">
                    {cursosFinalizados && cursosFinalizados.length ? cursosFinalizados.map(cursosFinalizado => (
                        <CursoRecent desc={cursosFinalizado.nomeCurso} data={cursosFinalizado.dadosCurso.date} />
                    )) : (<NotFound desc="Não há cursos finalizados" />)}

                </div>
            </div>

            <div className="performance_dash">
                <h2 className="recentes_title">Sua performance</h2>
                <div className="grafico_dash">
                    <Bar options={chartOptions} data={chartData} />
                </div>
                <div className="info_dash">
                    <h4 className="info_dash_title">Estatística (VidenCoins)</h4>
                    <div className="icons_dash">
                        <StatsDash img={gold} result={scores.highest} desc="Resultado mais alto do teste" />
                        <StatsDash img={average} result={scores.average.toFixed(2)} desc="Média de resultado do teste" />
                        <StatsDash img={bronze} result={scores.lowest} desc="Resultado mais baixo do teste" />
                    </div>

                </div>
            </div>

            <Footer />
        </>
    )
}

export default Dashboard;