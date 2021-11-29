import React from "react";
import Footer from "../components/Footer";
import BotaoLogar from "../components/home/Botao";
import '../assets/styles/global.css';
import '../assets/styles/home.css';
import Card from "../components/home/Card";
import code from "../assets/img/code.png";
import cloud from "../assets/img/cloud.png";
import ux from "../assets/img/front.png";
import front from "../assets/img/ux.png";
import samuel from "../assets/img/perfil.jpg";
import jorge from "../assets/img/jorge.jpeg";
import kaue from "../assets/img/kaue.jpeg";
import duo from "../assets/img/duo.jpeg";
import carlos from "../assets/img/carlos.jpeg";
import wini from "../assets/img/wini.jpeg";
import { Link, NavLink } from "react-router-dom";

function Home() {
    return (
        <>
            <div className="root_home">
                <div className="header_index">
                    <h1 className="font_header_index">&#60;&#47;Viden</h1>

                   
                    <div id="sobre-text">
                        <h4> Sobre nós </h4>
                    </div>

                    <div id="idealizadores-text">
                        <a href="#collaborators"></a>
                        <h4> Idealizadores </h4>
                    </div>

                    <div>
                        <BotaoLogar texto="Login" destino="/login" />
                    </div>
                </div>

                <div id="banner-about_index">
                    <h3 id="text-banner_about">
                        <h3 id="title_text_banner">Mergulhe no conhecimento!</h3>
                        <br />
                        Uma plataforma de cursos inovadora, focada em aprendizado,
                        onde o conhecimento e o conforto é o nosso ponto forte!</h3>
                </div>

            </div>

            <div id="banner2-about_index">
                <h3 id="title-banner_about2">Mergulhe em Tecnologia!</h3>
                <h2 id="text-banner_about2">Você vai estudar, praticar, discutir e se aprofundar em uma plataforma que respira tecnologia.</h2>
            </div>

            <div className="cards">
                <div>
                    <Card color="backend" img={code} title="Back-End" desc="Lógica, Python, PHP, Java, .NET, Node JS, C, Computação, Jogos, IoT e mais..." />
                </div>

                <div>
                    <Card color="front" img={front} title="Front-End" desc="HTML, CSS, React, Angular, JavaScript, jQuery e mais..." />
                </div>

                <div>
                    <Card color="cloud" img={cloud} title="Cloud" desc="AWS, Azure, Docker, Segurança, IaC, Linux e mais..." />
                </div>

                <div>
                    <Card color="ux" img={ux} title="UX / Design" desc="Photoshop e Illustrator, Usabilidade e UX, Vídeo e Motion, 3D e mais..." />
                </div>
            </div>

            <div className="container">
                <div className="banner3">
                    <iframe src="https://www.youtube.com/embed/kZcc4bA647M" title="YouTube video player" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>
                </div>

                <div className="title-banner3">
                    <h3>A maior plataforma
                        brasileira de cursos de
                        tecnologia.
                    </h3>
                    <h4>
                        Mergulhe com profundidade e navegue em outras áreas de
                        Tecnologia. Profissional em TI.
                    </h4>
                </div>
            </div>

            <div className="collaborators">
                <h2 id="title-coll">Conheça os idealizadores!</h2>
                
                <div className="container-coll-imgs">
                    <div className="coll-img-top">
                        <img id="imagem_collaboratores" src={kaue} alt="Kaue Volpe"/>
                        <img id="imagem_collaboratores" src={samuel} alt="Samuel Almeida" />
                        <img id="imagem_collaboratores" src={duo} alt="Pedro Duo" />
                    </div>

                    <div className="coll-img-bottom">
                        <img id="imagem_collaboratores" src={wini} alt="Winicius Silva" />
                        <img id="imagem_collaboratores" src={carlos} alt="Carlos Mascena" />
                        <img id="imagem_collaboratores" src={jorge} alt="Jorge Uliam" />
                    </div>
                </div>
            </div>

            <Footer />
        </>
    );
}

export default Home;