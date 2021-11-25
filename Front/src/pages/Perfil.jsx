import React from "react";
import Footer from "../components/Footer";
import imgPerfil from "../assets/img/imgPerfil.png";
import user from "../assets/img/user.png";
import calendario from "../assets/img/calendario.png";
import relogio from "../assets/img/relogio.png";
import curosativos from "../assets/img/curosativos.png";
import perfil from "../assets/img/perfil-white.png"
import '../assets/styles/perfil.css';
import { Link, useHistory } from 'react-router-dom'

function Perfil() {

    const history = useHistory()

    function sair() {
        history.push('/')
        localStorage.clear()
    }
    
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
                        
                        <Link to= "/dashboard"><div id="btn-sair">               
                            <h4> Voltar </h4>
                        </div></Link>

                        <div id="btn-sair" onClick={sair}>
                            <h4> Logoff </h4>
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
                                <h2 className="nome">Winicius Silva</h2>
                                <br />
                                <label>CPF:</label>
                                <label className="usuario">497.878.608-81</label>
                                <br />
                                <br />
                                <label>Email:</label>
                                <label className="email">winicius.silva@bandtec.com.br</label>
                                <br />
                                <br />
                                <label>Empresa:</label>
                                <label className="empresa">Valemobi</label>
                            </div>

                            <div className="um">
                                <img id="img2" src={calendario} alt="" />
                                <h3 id="cor">29/10/2021</h3>
                                <h3 id="cor"> 09:41:22</h3>
                                <label>Data de inscrição</label>
                            </div>

                            <div className="dois">
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