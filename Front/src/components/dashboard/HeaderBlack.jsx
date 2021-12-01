import React from "react";
import Perfil from "../../pages/Perfil";
import { Link, useHistory } from 'react-router-dom'
import Perfil2 from "../../assets/img/perfil-white.png"

export default function HeaderBlack() {

    const history = useHistory()

    function sair() {
        history.push('/')
        localStorage.clear()
    }

    return(


        <>
        <div className="root_TelaVideo">
                <div className="header_TelaVideo">
                    <h1 className="font_header_index">&#60;&#47;Viden</h1>

                    <Link to="/perfil">
                        <div id="icon_perfil">
                            <img id="img_perfil" src={Perfil2} alt="" />
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
        </>
    )

}