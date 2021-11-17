import React from "react";
import imgPerfil from "../assets/img/imgPerfil.png";
import '../assets/styles/perfil.css';

function Perfil() {
    return (
        <>
            <div className="Perfil">
                <div className="dadosPerfil">

                    <div className="imgPerfil">
                        <img src={imgPerfil} alt="" />
                    </div>

                    <div className="infoPerfil">
                        <label className="nome">Kauê Volpe</label>
                        <label>122HS89HS-S8WWOJS-SMKNXNS</label>
                        <br />
                        <label className="2">Nível</label>
                        <label>Usuário</label>
                        <br />
                        <label className="3">Email</label>
                        <label>kauevolpe01@gmail.com</label>
                        <br />
                        <label className="4">Empresa</label>
                        <label>Accenture</label>
                    </div>
                </div>

                <div className="progresso">

                </div>
            </div>
        </>
    );
}

export default Perfil;