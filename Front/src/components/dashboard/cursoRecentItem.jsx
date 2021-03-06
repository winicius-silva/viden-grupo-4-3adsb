import React from "react";
import { Link } from "react-router-dom";
import imgCurso from "../../assets/img/curso_icon.png"

function CursosRecent(props) {
    return (
        <>
            <Link to={`/videoplayer/${props.fkCurso}`}>
                <div className="cardCursoRecente">
                    <img src={imgCurso} alt={'curso_recente'} className="img_cursoRecent" />
                    <h3 className="desc_cursoRecent">{props.desc}</h3>
                    <h4 className="data_cursoRecent">{props.data}</h4>
                </div>
            </Link>
        </>
    )
}

export default CursosRecent;