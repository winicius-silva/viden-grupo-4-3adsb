import React from "react";
import Perfil from "../../pages/Perfil";
import { Link, useHistory } from 'react-router-dom'

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
        </>
    )

}