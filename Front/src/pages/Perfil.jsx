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
import HeaderBlack from "../components/dashboard/HeaderBlack";

function Perfil() {

    const history = useHistory()

    function sair() {
        history.push('/')
        localStorage.clear()
    }

    const data = JSON.parse(localStorage.getItem('data'))
    console.log(data)
    
    return (
        <>  
            <div className="background">

            <HeaderBlack />

                <div className="background2">
                    <div className="Perfil">
                        <div className="dadosPerfil">

                            <div className="imgPerfil">
                                <img src={imgPerfil} alt="" />
                            </div>

                            <div className="infoPerfil">
                                <h2 className="nome">{data.nomeUsuario}</h2>
                                <br />
                                <label>CPF:</label>
                                <label className="usuario">{data.cpf}</label>
                                <br />
                                <br />
                                <label>Email:</label>
                                <label className="email">{data.email}</label>
                                <br />
                                <br />
                                <label>Empresa:</label>
                                <label className="empresa">{data.empresa}</label>
                            </div>

                            <div className="um">
                                <img id="img2" src={calendario} alt="" />
                                <h3 id="cor">Data de inscrição:</h3>
                                <h3 id="cor">{data.horaCadastro}</h3>
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