import React from "react";
import Footer from "../components/Footer";
import '../assets/styles/pesquisa.css';
import HeaderBlack from "../components/dashboard/HeaderBlack";


function Pesquisa(){

    return(
        <>
            <HeaderBlack />

            <div className="cursos_pesquisados">
                <div className="titulo_cursos_pesquisados">
                    <h2>Encontramos esses cursos:</h2>
                </div>

                {/* <div>
                    Aqui vai ficar os cursos que forem pesquisados!
                </div> */}
            </div>

            <Footer />
        </>
    )
}

export default Pesquisa;