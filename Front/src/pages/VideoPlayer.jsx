import "../assets/styles/VideoPlayer.css"
import "../assets/styles/dashboard.css"

import React, { useEffect, useState } from "react";
import { useHistory, useParams } from "react-router";
import { Link } from "react-router-dom";

import Perfil from "../assets/img/perfil-white.png";

import VideoMain from "../components/dashboard/VideoPlayerDiv";
import CardVideo from "../components/dashboard/CardVideo.jsx";
import Footer from "../components/Footer";

import { useToastsContext } from '../contexts/toasts'
import { useCursosContext } from '../contexts/cursos'

function VideoPlayer() {
    const { createRecentCurso, getVideosCurso, cursosVideos, cursoVideoLinkAtual, patchFinalizarCurso, postPontuacaoUsuario } = useCursosContext()
    const { addToast } = useToastsContext()

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

    var contador = 0;

    async function botao_finalizar() {
        try {
            const finalizarCursoValues = await patchFinalizarCurso(params.idCurso)

            if (!finalizarCursoValues) throw new Error('finalizarCurso deu erro')

            // await postPontuacaoUsuario(params.idCurso, localStorage.getItem("pontosCurso"))

            addToast({
                type: 'success',
                title: 'Curso finalizado com sucesso!',
            })

            history.push('/dashboard')
        } catch (error) {
            addToast({
                type: 'error',
                title: 'Não foi possível finalizar curso',
            })
        }
    }

    return (
        <>
            <div className="root_TelaVideo">
                <div className="header_TelaVideo">
                    <h1 className="font_header_index">&#60;&#47;Viden</h1>

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

            <div className="background_video">
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
            </div>

            <Footer></Footer>

        </>
    );
}

export default VideoPlayer;