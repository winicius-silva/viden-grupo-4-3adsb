import React from "react";

import { useCursosContext } from '../../contexts/cursos'

export default function CardVideo(props) {
    const { changeCursoVideoLinkAtual } = useCursosContext()

    function videoChange() {
        changeCursoVideoLinkAtual(props.videoLink)
    }

    return (
        <>
            <div className="card_video" onClick={videoChange}>
                <label className="card_titulo">{props.titulo}</label>
                <label className="card_desc">{props.desc}</label>
            </div>

        </>
    )
}