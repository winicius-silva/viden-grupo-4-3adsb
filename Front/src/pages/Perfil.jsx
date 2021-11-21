import React from "react";
import Footer from "../components/Footer";
import imgPerfil from "../assets/img/imgPerfil.png";
import user from "../assets/img/user.png";
import calendario from "../assets/img/calendario.png";
import relogio from "../assets/img/relogio.png";
import curosativos from "../assets/img/curosativos.png";
import perfil from "../assets/img/perfil-white.png"
import '../assets/styles/perfil.css';

function Perfil() {
    return (
        <>


            <div className="background">


                <div className="root-dashboard">
                    <div className="header-dashboard">
                        <h1 className="font_header_index">&#60;&#47;Viden</h1>
                        <div id="search_dash">
                            <input id="search_input_index" type="text" placeholder=" Ex: Java cursos..." />
                        </div>

                        <div id="dash-text">
                            <h4> Meus cursos </h4>
                        </div>

                        <div id="icon-perfil-dash">
                            <img id="img-perfil-dash" src={perfil} alt="" />
                        </div>

                        <div id="btn-sair">
                            <h4> Sair </h4>
                        </div>
                    </div>
                </div>


                <div className="background2">
                    <div className="Perfil">
                        <div className="dadosPerfil">

                            <div className="imgPerfil">
                                <img src={imgPerfil} alt="" />
                            </div>

                            <div className="infoPerfil">
                                <h2 className="nome">Kauê Volpe</h2>
                                <h3>122HS89HS-S8WWOJS-SMKNXNS</h3>
                                <br />
                                <label>Nível:</label>
                                <label className="usuario">Usuário</label>
                                <br />
                                <br />
                                <label>Email:</label>
                                <label className="email">Kauevolpe01@gmail.com</label>
                                <br />
                                <br />
                                <label>Empresa:</label>
                                <label className="empresa">Accenture</label>
                            </div>
                        </div>

                        <div className="dadosPerfil2">

                            <div className="um">
                                <img id="img1" src={user} alt="" />
                                <h3 id="cor">27/10/2021 </h3>
                                <h3 id="cor"> 18:07:47</h3>
                                <label>Dados de inscrição</label>
                            </div>

                            <div className="dois">
                                <img id="img2" src={calendario} alt="" />
                                <h3 id="cor">29/10/2021</h3>
                                <h3 id="cor"> 09:41:22</h3>
                                <label>Data de inscrição</label>
                            </div>
                        </div>

                        <div className="dadosPerfil3">

                            <div className="tres">
                                <img id="img3" src={relogio} alt="" />
                                <h3 id="cor">7h:51m</h3>
                                <label> Tempo real</label>
                            </div>

                            <div className="quatro">
                                <img id="img4" src={curosativos} alt="" />
                                <h3 id="cor">2</h3>
                                <label>Cursos Ativos</label>
                            </div>

                        </div>



                        <div className="progresso">

                        </div>
                    </div>
                </div>
            </div>
            <Footer />
        </>
    );
    
}

export default Perfil;