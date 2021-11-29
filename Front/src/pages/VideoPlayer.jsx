import React, { useEffect } from "react";
import "../assets/styles/VideoPlayer.css"
import "../assets/styles/dashboard.css"
import Perfil from "../assets/img/perfil-white.png";
import { useHistory, useParams } from "react-router";
import { Link } from "react-router-dom";
import VideoMain from "../components/dashboard/VideoPlayerDiv";
import CardVideo from "../components/dashboard/CardVideo.jsx"

import { useCursosContext } from '../contexts/cursos'


function VideoPlayer() {
    const { createRecentCurso } = useCursosContext()

    const history = useHistory()
    const params = useParams()

    useEffect(() => {
        if (localStorage.getItem('id_usuario') == null) {
            history.push('/login')
            alert("Faça o login para acessar a dashboard!")
        }
    }, [])

    function sair() {
        history.push('/')
        localStorage.clear()
    }

    useEffect(() => {
        createRecentCurso(params.idCurso)
    }, [params])

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

                <VideoMain link={'rzOvXvBNzMc'} />

                <div className="aulas_right">
                    <CardVideo titulo="teste" desc="descricao teste"/>
                    <CardVideo titulo="teste" desc="descricao teste"/>
                    <CardVideo titulo="teste" desc="descricao teste"/>
                    <CardVideo titulo="teste" desc="descricao teste"/>
                    <CardVideo titulo="teste" desc="descricao teste"/>
                    <CardVideo titulo="teste" desc="descricao teste"/>
                    
                </div>

            </div>

            <div className="descricao_aulas">
                <br />
                <h2>Sobre esse curso:</h2>
                <br />
                <h4>Este curso como objetivo ensinar ao aluno os principais conceitos de programação, para que ele esteja preparado ao executar as principais atividades que o mercado exige.</h4>
            </div>
        </>
    );
}

export default VideoPlayer;