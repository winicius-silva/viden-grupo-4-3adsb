import React from "react";

export default function CardVideo(props) {
    return (
        <>
            <div className="card_video" onClick="">
                <label className="card_titulo">{props.titulo}</label>
                <label className="card_desc">{props.desc}</label>
            </div>

        </>
    )
}