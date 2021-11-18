import React from "react";

function BotaoSign(props){
    return(
        <>
            <button onClick={props.func} className="botao_sign">{props.texto}</button> 
        </>
    );
}

export default BotaoSign;