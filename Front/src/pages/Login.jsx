import React from "react";
import Input from "../components/login_cadastro/Inputs";
import Header from "../components/login_cadastro/HeaderSign";
import Botao from "../components/login_cadastro/BotaoSign";
import Email from "../assets/img/email.png"
import Senha from "../assets/img/senha.png"
import '../assets/styles/global.css';
import '../assets/styles/sign.css';

function Login() {
    return (
        <>
            <div className="root_sign">
                <Header sign="header_login" texto="Não tem uma conta?" texto2="Cadastre-se aqui" link="/cadastro" />
                <div className="formulario">
                    <h1 className="fonte" id="subtitulo">Faça seu login:</h1>
                    <form action="" className="form_inputs_login">
                        <Input img={Email} type="email" placeholder="E-mail" />
                        <Input img={Senha} type="password" placeholder="Senha" />
                        <Botao texto="Entrar" />
                    </form>
                </div>
            </div>


        </>
    );

}

export default Login;