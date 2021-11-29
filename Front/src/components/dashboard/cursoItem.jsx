import React from "react";
import { Link } from "react-router-dom";
import imgCurso from "../../assets/img/curso_icon.png"

function Cursos(props) {
    return (
        <Link to={`/videoplayer/${props.fkCurso}`}>
            <div className="cardCurso">
                <img src={imgCurso} className="img_curso"/>
                <h3 className="desc_curso">{props.desc}</h3>
            </div>
        </Link>
    )
}

export default Cursos;