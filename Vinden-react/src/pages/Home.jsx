import React from "react";
import BotaoLogar from "../components/Botao";
import '../assets/styles/global.css';
import '../assets/styles/home.css';
import Card from "../components/Card";
import eclipse from "../assets/img/eclipse.png"
import news from "../assets/img/newspaper.png";
import exclusive from "../assets/img/exclusivo.png";
import back from "../assets/img/backend.png";
import coding from "../assets/img/coding.png";
import cloud from "../assets/img/ux-design.png";
import ux from "../assets/img/ux-design.png";
import front from "../assets/img/frontend.png";
import samuel from "../assets/img/perfil.jpg";
import jorge from "../assets/img/jorge.jpeg";
import kaue from "../assets/img/kaue.jpeg";
import duo from "../assets/img/duo.jpeg";
import carlos from "../assets/img/carlos.jpeg";
import wini from "../assets/img/wini.jpeg";

function Home() {
    return (
        <>
            <div className="root_home">
                <div className="header_index">
                    <h1 className="font_header_index">&#60;&#47;Viden</h1>
                    <div id="search_index">
                        <input id="search_input_index" type="text" placeholder=" Ex: Java cursos..." />
                    </div>


                    <div id="sobre-text">
                        <h3> Sobre nós </h3>
                    </div>


                    <div id="pipe">

                    </div>


                    <div id="empresas-text">
                        <h3>Empresas Parceiras</h3>
                    </div>
                    <div>
                        <BotaoLogar texto="Login" />
                    </div>
                </div>

                <div id="banner-about_index">
                    <h3 id="text-banner_about">Uma plataforma de cursos inovadora, diferente de todas as outras já vistas, onde o conhecimento e o conforto é o nosso ponto chave.</h3>
                </div>

            </div>

            <div id="banner2-about_index">
                <h3 id="title-banner_about2">Mergulhe em Tecnologia!</h3>
                <h2 id="text-banner_about2">Você vai estudar, praticar, discutir e se aprofundar em uma plataforma que respira tecnologia.</h2>
            </div>

            <div className="cards">
                <div>
                    <Card color="backend" img={coding} title="BACKEND" desc="Lógica, Python, PHP, Java, .NET, Node JS, C, Computação, Jogos, IoT e mais..."/>
                </div>

                <div>
                    <Card color="front" img={front} title="Front-End" desc="HTML, CSS, React, Angular, JavaScript, jQuery e mais..."/>
                </div>

                <div>
                    <Card color="cloud" img={cloud} title="Cloud" desc="AWS, Azure, Docker, Segurança, IaC, Linux e mais..."/>
                </div>

                <div>
                    <Card color="ux" img={ux} title="Cloud" desc="Photoshop e Illustrator, Usabilidade e UX, Vídeo e Motion, 3D e mais..."/>
                </div>
            </div>

            <div className="container">
                <div className="banner3">
                    <embed src="https://www.youtube.com/watch?v=kZcc4bA647M&ab_channel=ProgramadorBR" type="" />
                </div>

                <div className="title-banner3">
                    <h3>A maior plataforma
                        brasileira de cursos de 
                        tecnologia.
                    </h3>
                <br />
                <br />
                    <h4 id="subtitle-banner3">
                        Mergulhe com profundidade e navegue em outras áreas de 
                        Tecnologia. Profissional em TI.
                    </h4>
                </div>

                    
            </div>
            

            
        </>
    );
}

export default Home;