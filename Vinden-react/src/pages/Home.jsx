import React from "react";
import BotaoEntrar from "../components/Botao";
import eclipse from "../assets/img/eclipse.png"
import news from "../assets/img/newspaper.png";
import exclusive from "../assets/img/exclusivo.png";
import back from "../assets/img/backend.png";
import coding from "../assets/img/coding.png";
import ux from "../assets/img/ux-design.png";
import front from "../assets/img/frontend.png";
import samuel from "../assets/img/perfil.jpg";
import jorge from "../assets/img/jorge.jpeg";
import kaue from "../assets/img/kaue.jpeg";
import duo from "../assets/img/duo.jpeg";
import carlos from "../assets/img/carlos.jpeg";
import wini from "../assets/img/wini.jpeg";


export default function Home() {
    return (
        <React.Fragment>
            <div className="header_index">
                <h1 className="header_font" id="title"> &#60;&#47;Viden </h1>
                <div className="search">
                    <input type="text" placeholder="Ex: Python cursos..." className="form_font" id="input" />
                    <img src="../assets/img/loupe.svg" alt="" id="input_img"/>
                </div>
                <div>
                    <BotaoEntrar destino="/login" texto="Login"/>
                </div>
            </div>
            <img src="../assets/img/background_index.svg" alt=""/>
            
            <div id="banner-sobre-nos">
                <h3 id="texto-banner">Uma plataforma de cursos inovadora, diferente de todas as outras já vistas, onde o conhecimento e o conforto é o nosso ponto chave. </h3>
            </div>

            <div id="container-left">
                <div id="text-1">
                    <img className="container-left-mg" src={eclipse} alt="" />
                    <br/>
                    <br/>
                    <h3>Estude 24h/dia, onde e quando quiser.</h3>
                </div>
                <div id="text-2">
                    <img className="container-left-mg" src={news} alt="novos-cursos"/>
                    <br/>
                    <br/>
                    <h3>Novos cursos todas as semanas.</h3>
                </div>
                <div id="text-3">
                    <img className="container-left-mg" src={exclusive} alt="exclusividade-aos-parceiros" styles="width: 100px;"/>
                    <br/>
                    <br/>
                    <h3>Plataforma de cursos p/ funcionários de empresas parceiras exclusiva.</h3> 
                </div>
            </div>

            <div id="container-right">
                <div id="coding">
                    <img id="img1" src={coding} alt=""/> 
                    <h2>Coding</h2>
                </div>

                <div id="front">
                    <img id="img2" src={front} alt=""/>
                    <h2>Frontend</h2>
                </div>

                <div id="backend">
                    <img id="img3" src={back} alt=""/>
                <h2>Backend</h2>
                </div>

                <div id="ux">
                    <img id="img4" src={ux} alt=""/>
                    <h2>UX-design</h2>
                </div>
            </div>

            <div id="container-bottom">
                <h1 styles="font-family: -apple-system, BlinkMacSystemFont, 'Segoe UI', Roboto, Oxygen, Ubuntu, Cantarell, 'Open Sans', 'Helvetica Neue', sans-serif; font-size: 8vh; color: rgb(16, 70, 139);">Conheça os idealizadores!</h1>
            </div>

            <div id="fotos">
                <div id="fotoup" className="fotodiv" styles="width: 100%; height: 50%;">
                    
                        <div className="user">
                            <img src={carlos} alt="" height="130px" />
                            <br/>
                            <h3 styles= "color: #052957;font-family: -apple-system, BlinkMacSystemFont, 'Segoe UI', Roboto, Oxygen, Ubuntu, Cantarell, 'Open Sans', 'Helvetica Neue', sans-serif;">
                            Carlos Mascena
                            </h3>
                        </div>

                        <div className="user">
                            <img src={kaue} alt="" height="130px" />
                            <br/>
                            <h3 styles="color: #052957; font-family: -apple-system, BlinkMacSystemFont, 'Segoe UI', Roboto, Oxygen, Ubuntu, Cantarell, 'Open Sans', 'Helvetica Neue', sans-serif;">
                                Kaue Volpe
                            </h3>
                        </div>

                        <div className="user">
                            <img src={duo} alt="" height="130px" />
                            <br/>
                            <h3 styles="color: #052957; font-family: -apple-system, BlinkMacSystemFont, 'Segoe UI', Roboto, Oxygen, Ubuntu, Cantarell, 'Open Sans', 'Helvetica Neue', sans-serif;">
                                Pedro Duó
                            </h3>
                        </div>
                </div>

                <div id="fotodown" class="fotodiv" styles="width: 100%; height: 50%;"> 
                    <div className="user">
                        <img src={jorge} alt="" height="130px" styles="border-radius: 50px;"/>
                        <br/>
                        <h3 styles= "color: #052957;font-family: -apple-system, BlinkMacSystemFont, 'Segoe UI', Roboto, Oxygen, Ubuntu, Cantarell, 'Open Sans', 'Helvetica Neue', sans-serif;">
                            Jorge Uliam
                        </h3>
                    </div>

                    <div className="user">
                        <img src={samuel} alt="" height="130px" styles="border-radius: 50px;"/>
                        <br/>
                        <h3 styles="color: #052957; font-family: -apple-system, BlinkMacSystemFont, 'Segoe UI', Roboto, Oxygen, Ubuntu, Cantarell, 'Open Sans', 'Helvetica Neue', sans-serif;">
                            Samuel Lopes
                        </h3>
                    </div>

                    <div class="user">
                        <img src={wini} alt="" height="135px" styles="border-radius: 50px;"/>
                        <br/>
                        <h3 styles="color: #052957; font-family: -apple-system, BlinkMacSystemFont, 'Segoe UI', Roboto, Oxygen, Ubuntu, Cantarell, 'Open Sans', 'Helvetica Neue', sans-serif;">
                            Winicius Silva
                        </h3>
                    </div>
                </div>
            </div>

            <div id="footer">
                <h2 styles="margin: 15px; padding-top: 10px;">&#60;&#47;Viden</h2>
                <br/>
                <h3 styles="margin: 10px;">Tel: (11) 91234-5678</h3>
                <h3 styles="margin-left: 30px;"> <a styles="color: white;" href="https://www.google.com/maps/place/Bandtec+Digital+School/@-23.5577869,-46.6615711,16z/data=!4m12!1m6!3m5!1s0x0:0xc567c0d16d0bc582!2sBandtec+Digital+School!8m2!3d-23.5581213!4d-46.661614!3m4!1s0x0:0xc567c0d16d0bc582!8m2!3d-23.5581213!4d-46.661614">Rua Haddock Lobo, 595 - Cerqueira César, São Paulo - SP, 01414-001</a></h3>
                <h3> Direitos reservados por &#60;&#47;Viden &copy; </h3>
            </div>      
    </React.Fragment>
    )
}