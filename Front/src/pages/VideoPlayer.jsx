import React from "react";
import "../assets/styles/VideoPlayer.css"
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

                    <div id="icon-perfil-dash">
                        <img id="img-perfil-dash" src={Perfil} alt="" />
                    </div>
                    
                    <div id="btn-sair">
                        <h4> Sair </h4>
                    </div>
                </div>
            </div>

            <div className="container-video">
                <div className="videoPlayer">
                    <iframe src="https://www.youtube.com/embed/ae6w0-kZ3-M" title="Aula 1" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>
                </div>  
                
                <div className="aulas-right">
                    {/* <div className={}>

                    </div>

                    <div className={}>

                    </div>

                    <div className={}>

                    </div>

                    <div className={}>
                        
                    </div> */}
                </div>

            </div>

            
        </>
    );
}

export default VideoPlayer;