import React from "react";
import Input from "../components/login_cadastro/Inputs";
import Header from "../components/login_cadastro/HeaderSign";
import Botao from "../components/login_cadastro/BotaoSign";
import Email from "../assets/img/email.png"
import Senha from "../assets/img/senha.png"
import Nome from "../assets/img/nome.png"
import Cpf from "../assets/img/cpf.png"
import Telefone from "../assets/img/telefone.png"
import '../assets/styles/global.css';
import '../assets/styles/sign.css';

function Cadastro() {
    return (
        <>
            <div className="root_sign">

                <div className="header_form">
                    <div className="formulario">
                        <h1 className="fonte" id="subtitulo">Faça seu cadastro:</h1>
                        <form action="" className="form_inputs_cadastro">
                            <Input img={Nome} type="text" placeholder="Nome completo" />
                            <Input img={Cpf} type="number" placeholder="CPF" />
                            <Input img={Telefone} type="number" placeholder="Telefone" />
                            <Input img={Email} type="email" placeholder="E-mail" />
                            <Input img={Senha} type="password" placeholder="Senha" />
                            <Botao texto="Cadastrar" />
                        </form>

                    </div>
                </div>

                <Header sign="header_cadastro" texto="Já possui uma conta?" texto2="Faça o login aqui" link="/login" />


            </div>

        </>
    );


}

export default Cadastro;