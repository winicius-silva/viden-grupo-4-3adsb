import React from "react";

export default function Cursos(props) {
    return(
        <>
            <div className="container-cursos">
                <div className="cursos-latest">

                    <div className="cardCurso">
                        <div className={props.prog}>
                            <div className="imgProg">
                                <img src={props.img} alt="" />
                                <h4>{props.textProg}</h4>
                            </div>
                        </div>
                        <div className="tempo-curso">
                            <img className="timing" src={props.tempoCurso} alt="" />
                            <h4>{props.tempo}</h4>
                        </div>    
                    </div>

                    
                </div>
                
            </div>

        </>
    )
}