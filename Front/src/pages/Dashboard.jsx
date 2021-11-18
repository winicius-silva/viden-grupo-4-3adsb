import React from "react";
import Perfil from "../assets/img/perfil-white.png"
import Content from "../components/Content";
import Cursos from "../components/CursosLatest";
import cardCurso from "../assets/img/senha.png";
import timing from "../assets/img/clock.png"
import '../assets/styles/dashboard.css'
import '../assets/styles/global.css';


export default function Dashboard() {
    return(
        <>
            <div className="root-dashboard">
                <div className="header-dashboard">
                    <h1 className="font_header_index">&#60;&#47;Viden</h1>
                    <div id="search_dash">
                        <input id="search_input_index" type="text" placeholder=" Ex: Java cursos..." />
                    </div>

                    <div id="dash-text">
                        <h4> Meus cursos </h4>
                    </div>

                    <div id="icon-perfil-dash">
                        <img id="img-perfil-dash" src={Perfil} alt="" />
                    </div>
                    
                    <div id="btn-sair">
                        <h4> Sair </h4>
                    </div>
                </div>
            </div>

            <div className="nav-bar-dash">
                <div className="nav-btn-dash button">
                    <h4>Geral</h4>
                </div>

                <div className="nav-btn-dash button">
                    <h4>Back-end</h4>
                </div>

                <div className="nav-btn-dash button">
                    <h4>Front-end</h4>
                </div>

                <div className="nav-btn-dash button">
                    <h4>Cloud</h4>
                </div>

                <div className="nav-btn-dash button">
                    <h4>Ux & Desing</h4>
                </div>
            </div>

            <div className="container-dashboard">
                <Content 
                    titleContent="BACK-END" 
                    textContent="Programe nas principais linguagens e plataformas. 
                        Explore plataformas como Python, Node.JS, PHP, Java, e .NET a fundo, além de muito conteúdo em outras linguagens como GoLang, Clojure, C/C++, VB ou Cobol. 
                        Saiba como começar com Programação. 
                        Conheça mais da Escola de Programação ou navegue nessa página para ver todos nossos cursos e formações."
                />
            </div>
            <div className="cursos">
                <h2>Lógica de programação</h2>

                <Cursos prog="backend-dash" img={cardCurso} textProg="Curso de lógica de programação para iniciantes, utilizando JS" tempoCurso={timing}/>

                <Cursos prog="backend-dash" img={cardCurso} textProg="Curso de lógica de programação para iniciantes, utilizando JS" tempoCurso={timing}/>

                <Cursos prog="backend-dash" img={cardCurso} textProg="Curso de lógica de programação para iniciantes, utilizando JS" tempoCurso={timing}/>   

            </div>
            
        </>
    )   
}