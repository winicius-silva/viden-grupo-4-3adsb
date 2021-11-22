import React from "react";
import imgCurso from "../../assets/img/curso_icon.png"

function Cursos(props) {
    return (
        <>
            <div className="cardCurso">
                <img src={imgCurso} className="img_curso"/>
                <h3 className="desc_curso">{props.desc}</h3>
            </div>

        </>
    )
}

export default Cursos;