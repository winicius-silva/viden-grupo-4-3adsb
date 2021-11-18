import React from "react";

export default function(props){
    return(
        <>

            <div className="content-container">
                <div className="title-content">
                    <h4 id="title">Cursos da Viden</h4>
                    <h2>{props.titleContent}</h2>
                </div>

                <div className="text-content">
                    <h3>
                        {props.textContent}
                    </h3>
                </div>
            </div>

        </>
    )
}