import React from "react";
import H2Link from "./H2";
import { Link } from "react-router-dom";

function Header(props) {
    return (
        <>
            <div className={props.sign}>
                <Link to="/">
                    <h1 className="fonte" id="titulo"> &#60;&#47;Viden </h1>
                </Link>
                <div className="opcoes">
                    <div className="conta">
                        <h2 className="fonte">{props.texto}</h2>
                        <H2Link destino={props.link} texto={props.texto2} />
                    </div>
                </div>
            </div>
        </>
    );
}

export default Header;