import React from "react";
import { Link } from "react-router-dom";

function BotaoCadastrar(props){
    return(
        <>
        <Link to={props.destino}>
            <button className="btn">{props.texto}</button> 
        </Link>
        </>
    );
}

export default BotaoCadastrar;