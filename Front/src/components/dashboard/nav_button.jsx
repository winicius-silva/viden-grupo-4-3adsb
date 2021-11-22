import React, {useCallback } from "react";
import Content from "../dashboard/Content";
import { useCursosContext } from '../../contexts/cursos'


function BotaoCategories({ texto, idCurso, ...opts }) {
    const { changeCategoriaCursoSelecionado } = useCursosContext()

    const mudarCursoAtual = useCallback(() => {
        changeCategoriaCursoSelecionado(idCurso)
    }, [])

    return (
        <>
            <button className="button_nav_bar" onClick={mudarCursoAtual} {...opts}>{texto}</button>
        </>
    );
}

export default BotaoCategories;