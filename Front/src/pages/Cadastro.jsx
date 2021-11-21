import React, { useState } from "react";
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
import axios from 'axios';

function Cadastro() {

    const [nome, setNome] = useState("");
    const [cpf, setCpf] = useState("");
    const [telefone, setTelefone] = useState("");
    const [email, setEmail] = useState("");
    const [senha, setSenha] = useState("");

    function cadastrar(e) {
        e.preventDefault();

        console.log('values %s, %s, %s, %s, %s,',nome, cpf, telefone, email, senha)

        axios.post(`http://localhost:8080/usuarios/`, {
            headers: { "Access-Control-Allow-Origin": "*", "crossorigin": true },
            "nomeUsuario": nome,
            "cpf": cpf,
            "celular": telefone,
            "email": email,
            "senha": senha,
        }).then(response => {
            console.log('cadastrou');
        }).catch(function (error) {
            console.log('não cadastrou')
        })

    }


    return (
        <>
            <div className="root_sign">

                <div className="header_form">
                    <div className="formulario">
                        <h1 className="fonte" id="subtitulo">Faça seu cadastro:</h1>
                        <form onSubmit={cadastrar} className="form_inputs_cadastro">
                            <Input img={Nome} type="text" onChange={e => setNome(e.target.value)} placeholder="Nome completo" />
                            <Input img={Cpf} type="text" onChange={e => setCpf(e.target.value)} placeholder="CPF" />
                            <Input img={Telefone} type="text" onChange={e => setTelefone(e.target.value)} placeholder="Telefone" />
                            <Input img={Email} type="email" onChange={e => setEmail(e.target.value)} placeholder="E-mail" />
                            <Input img={Senha} type="password" onChange={e => setSenha(e.target.value)} placeholder="Senha" />
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