import React from "react";
import "../assets/styles/VideoPlayer.css"
import "../assets/styles/dashboard.css"
import Perfil from "../assets/img/perfil-white.png";


function VideoPlayer() {
    return (
        <>
            <div className="root-TelaVideo">
                <div className="header-TelaVideo">
                    <h1 className="font_header_index">&#60;&#47;Viden</h1>
                    <div id="search_dash">
                        <input id="search_input_index" type="text" placeholder=" Ex: Java cursos..." />
                    </div>

                    <div id="dash-text">
                        <h4> Meus cursos </h4>
                    </div>

                    <div id="icon-perfil">
                        <img id="img-perfil" src={Perfil} alt="" />
                    </div>
                    
                    <div id="btn-sair">
                        <h4> Sair </h4>
                    </div>
                </div>
            </div>

            <div className="container-video">
                <div className="videoPlayer">
                    <iframe src="https://www.youtube.com/embed/WObC_2e0kZk?list=PLdsnXVqbHDUcrE56CH8sXaPF3TTqoBP2z" title="YouTube video player" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>
                </div>  
                
                <div className="aulas-right">
                    
                    <div>
                        <h3>Aula 1:</h3>
                        <iframe src="https://www.youtube.com/embed/p9-WuJbVHHc?list=PLdsnXVqbHDUcrE56CH8sXaPF3TTqoBP2z" title="YouTube video player" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>
                    </div>

                    <div>
                        <h3>Aula 2:</h3>
                        <iframe src="https://www.youtube.com/embed/XcTTajFENHI?list=PLdsnXVqbHDUcrE56CH8sXaPF3TTqoBP2z" title="YouTube video player" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>
                    </div>

                    <div>
                        <h3>Aula 3:</h3>
                        <iframe src="https://www.youtube.com/embed/NwAvovzHRDU?list=PLdsnXVqbHDUcrE56CH8sXaPF3TTqoBP2z" title="YouTube video player" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>
                    </div>

                    <div>
                        <h3>Aula 4:</h3>
                        <iframe src="https://www.youtube.com/embed/O4CWVQLbi48?list=PLdsnXVqbHDUcrE56CH8sXaPF3TTqoBP2z" title="YouTube video player" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>
                    </div>
                </div>

            </div>

            <div className="descricao-aulas">
                <br />
                <h2>Sobre esse curso:</h2>
                <br />
                <h4>Este curso como objetivo ensinar ao aluno os principais conceitos de programação, para que ele esteja preparado ao executar as principais atividades que o mercado exige.</h4>
            </div>

            
        </>
    );
}

export default VideoPlayer;