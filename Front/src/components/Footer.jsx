import React from "react";
import face from "../assets/img/facebook.png";
import insta from "../assets/img/instagram.png";
import twitter from "../assets/img/twitter.png";
import yt from "../assets/img/youtube.png";

export default function Footer(){
    return(
        <>
            <div className="top_footer"></div>
            <div className="container_footer">
                <div className="div_footer_right">
                    <h2><b>Viden</b></h2>
                    <br />
                    <h4>Viden-Solutions S.A</h4>
                    <br />
                    <h4>Nossas redes sociais:</h4>
                    <br />
                    <div className="icons_social">
                        <img src={face} alt="" />
                        <img src={insta} alt="" />
                        <img src={twitter} alt="" />
                        <img src={yt} alt="" />
                    </div>
                </div>

                <div className="div_footer_left">
                <iframe src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d3075.4049491979613!2d-46.66340274023784!3d-23.557902040563814!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x94ce59d2b3fc1ab9%3A0xe212f067274c24c3!2sRua%20Haddock%20Lobo%2C%20586%20-%20Cerqueira%20C%C3%A9sar%2C%20S%C3%A3o%20Paulo%20-%20SP%2C%2001414-000!5e0!3m2!1spt-BR!2sbr!4v1637724721293!5m2!1spt-BR!2sbr" width="700" height="250" styles="border:0;" allowfullscreen="" loading="lazy"></iframe>
                </div>
                <div className="text_middle_footer">Viden - 2021</div>
            </div>
        </>
    );
}