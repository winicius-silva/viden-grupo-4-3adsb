import React, { useState, useRef } from "react";
import Input from "../components/login_cadastro/Inputs";
import Header from "../components/login_cadastro/HeaderSign";
import Botao from "../components/login_cadastro/BotaoSign";
import emailImg from "../assets/img/email.png"
import Senha from "../assets/img/senha.png"
import '../assets/styles/global.css';
import '../assets/styles/sign.css';
import axios from 'axios';

function Login() {

    const [email, setEmail] = useState("");
    const [senha, setSenha] = useState("");

    function entrar(e) {
        e.preventDefault();

        console.log('values %s %s', email, senha)

        axios.get(`http://localhost:8080/usuarios/login/${email}/${senha}`, {
            headers: {"Access-Control-Allow-Origin": "*", "crossorigin": true },
        }).then(response => {
            localStorage.setItem('id_usuario', response.data);
            localStorage.setItem('login_usuario', email);
            console.log('usuário certo');
            // console.log(email)
            // console.log(response.data)

            window.location.href= "../Dashboard";
        }).catch(function (error) {
            console.log('usuário errado');
        })

    }

    return (
        <>
            <div className="root_sign">
                <Header sign="header_login" texto="Não tem uma conta?" texto2="Cadastre-se aqui" link="/cadastro" />
                <div className="header_form">
                    <div className="formulario">
                        <h1 className="fonte" id="subtitulo">Faça seu login:</h1>
                        <form onSubmit={entrar} className="form_inputs_login">
                            <Input img={emailImg} type="email" onChange={e => setEmail(e.target.value)} placeholder="Email" autocomplete="off"/>
                            <Input img={Senha} type="password" onChange={e => setSenha(e.target.value)} placeholder="Senha" />
                            <Botao texto="Entrar" func="" />
                        </form>
                    </div>
                </div>

            </div>


        </>
    );

 

}

export default Login;