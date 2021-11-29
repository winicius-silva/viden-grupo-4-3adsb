import React, {useCallback } from "react";
import { useCursosContext } from '../../contexts/cursos'


function BotaoCategories({ texto, idCurso, ...opts }) {
    const { changeCategoriaCursoSelecionado } = useCursosContext()

    const mudarCursoAtual = useCallback(() => {
        changeCategoriaCursoSelecionado(idCurso)
    }, [changeCategoriaCursoSelecionado, idCurso])

    return (
        <>
            <button className="button_nav_bar" onClick={mudarCursoAtual} {...opts}>{texto}</button>
        </>
    );
}

export default BotaoCategories;