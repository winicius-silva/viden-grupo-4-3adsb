import React, { useEffect, useState } from "react";
import "../assets/styles/VideoPlayer.css"
import "../assets/styles/dashboard.css"
import Perfil from "../assets/img/perfil-white.png";
import { useHistory, useParams } from "react-router";
import { Link } from "react-router-dom";
import VideoMain from "../components/dashboard/VideoPlayerDiv";
import CardVideo from "../components/dashboard/CardVideo.jsx"

import { useCursosContext } from '../contexts/cursos'


function VideoPlayer() {
    const { createRecentCurso, getVideosCurso, cursosVideos, cursoVideoLinkAtual, patchFinalizarCurso } = useCursosContext()

    const history = useHistory()
    const params = useParams()

    const [videoLinkAtual, setVideoLinkAtual] = useState(cursoVideoLinkAtual)

    useEffect(() => {
        if (localStorage.getItem('id_usuario') == null) {
            history.push('/login')
            alert("Faça o login para acessar a dashboard!")
        }
    }, [history])

    useEffect(() => {
        setVideoLinkAtual(cursoVideoLinkAtual)
        console.log('RELOAD cursoVideoLinkAtual', cursoVideoLinkAtual)
    }, [cursoVideoLinkAtual])

    function sair() {
        history.push('/')
        localStorage.clear()
    }

    useEffect(() => {
        createRecentCurso(params.idCurso)

        getVideosCurso(params.idCurso)
    }, [params, params.idCurso])

    function botao_finalizar() {
        patchFinalizarCurso(params.idCurso)
    }

    return (
        <>
            <div className="root_TelaVideo">
                <div className="header_TelaVideo">
                    <h1 className="font_header_index">&#60;&#47;Viden</h1>
                    <div id="search_dash">
                        <input id="search_input_index" type="text" placeholder=" Ex: Java cursos..." />
                    </div>

                    <Link to="/perfil">
                        <div id="icon_perfil">
                            <img id="img_perfil" src={Perfil} alt="" />
                        </div>
                    </Link>

                    <Link to="/dashboard">
                        <div id="btn_sair">
                            <h4> Voltar </h4>
                        </div>
                    </Link>


                    <div id="btn_sair" onClick={sair}>
                        <h4> Logoff </h4>
                    </div>
                </div>
            </div>

            <div className="container_video">

                <VideoMain link={videoLinkAtual} />

                <div className="aulas_right">
                    {cursosVideos && cursosVideos.length ? cursosVideos.map(cursosVideo => (
                        <CardVideo titulo={cursosVideo.titulo} desc={cursosVideo.descricaoVideo} videoLink={cursosVideo.link} />
                    )) : ([])}

                </div>

            </div>

            <div className="div_under_video">
                <div className="descricao_aulas">
                    <h2>Sobre esse curso:</h2>
                    <h4>Este curso como objetivo ensinar ao aluno os principais conceitos de programação, para que ele esteja preparado ao executar as principais atividades que o mercado exige.</h4>
                </div>

                <div className="div_button_finalizar">
                    <button className="button_finalizar" onClick={botao_finalizar}>FINALIZAR CURSO</button>
                </div>
            </div>
        </>
    );
}

export default VideoPlayer;