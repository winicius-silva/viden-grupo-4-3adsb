import React from "react";
import { Link } from "react-router-dom";

function H2Link(props) {
    return (
        <>
            <Link to={props.destino}>
                <h2 class="fonte" id="sign">{props.texto}</h2>
            </Link>
        </>
    );
}

export default H2Link;