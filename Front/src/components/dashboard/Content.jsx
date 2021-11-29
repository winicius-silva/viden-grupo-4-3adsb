import React from "react";

export default function Content(props){
    return(
        <>

            <div className="content_container">]
                <div className="title_content">
                    <h4 id="title">Cursos da Viden</h4>
                    <h2>{props.titleContent}</h2>
                </div>

                <div className="text_content">
                    <h3>
                        {props.textContent}
                    </h3>
                </div>
            </div>

        </>
    )
}