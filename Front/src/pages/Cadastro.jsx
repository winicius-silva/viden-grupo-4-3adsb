import React, { useState } from "react";
import axios from 'axios';
import * as yup from 'yup'
import { ValidationError } from 'yup'
import Input from "../components/login_cadastro/Inputs";
import Header from "../components/login_cadastro/HeaderSign";
import Botao from "../components/login_cadastro/BotaoSign";
import Email from "../assets/img/email.png"
import Senha from "../assets/img/senha.png"
import Nome from "../assets/img/nome.png"
import Cpf from "../assets/img/cpf.png"
import Telefone from "../assets/img/telefone.png"

import { getValidationErrors } from '../utils/getValidationErrors'
import {NotificationContainer, NotificationManager} from 'react-notifications';

import '../assets/styles/global.css';
import '../assets/styles/sign.css';

function Cadastro() {

    const [nome, setNome] = useState("");
    const [cpf, setCpf] = useState("");
    const [telefone, setTelefone] = useState("");
    const [email, setEmail] = useState("");
    const [senha, setSenha] = useState("");

    const [formErrors, setFormErrors] = useState({})

    async function cadastrar(e) {
        e.preventDefault();

        // if(nome.length < 5) {
        //     alert("nome muito pequeno") 
        // }

        // if(cpf.length != 11) {
        //     alert("cpf inválido")
        // }

        // if(telefone.length != 11 || telefone.length != 10 ) {
        //     alert("telefone inválido")
        // }

        // if(senha.length < 5 ) {
        //     alert("tamanho de senha inválida")
        // }

        // if(senha.includes(nome)) {
        //     alert("senha não pode possuir o seu nome!")
        // }

        const schema = yup.object().shape({
            nome: yup.string().min(5, 'Nome não pode ser menor que 5 caracteres').required('Nome é obrigatório'),
            cpf: yup.string().length(11, 'CPF inválido').required('CPF é obrigatório'),
            email: yup.string().email('Digite um email válido').required('E-mail é obrigatório'),
            telefone: yup.string().min(10, 'Número deve conter no mínimo 10 dígitos').max(11, 'Número deve conter no mínimo 11 dígitos').required('N. de telefone é obrigatório'),
            senha: yup.string().min(5, 'Senha deve contar pelo menos 5 caracteres').required('Senha é obrigatória')
        })

        try {
            await schema.validate({ nome, cpf, telefone, senha }, {
                abortEarly: false,
            })

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
                window.location.href= "../Login";
            }).catch(function (error) {
                console.log('não cadastrou')
            })
        } catch (error) {
            if (ValidationError.isError(error)) setFormErrors(getValidationErrors(error))
        }
    }


    return (
        <>
            <div className="root_sign">

                <div className="header_form">
                    <div className="formulario">
                        <h1 className="fonte" id="subtitulo">Faça seu cadastro:</h1>
                        <form onSubmit={cadastrar} className="form_inputs_cadastro">
                            <Input hasError={!!formErrors['nome']} img={Nome} type="text" onChange={e => setNome(e.target.value)} placeholder="Nome completo" autocomplete="off" />
                            <Input hasError={!!formErrors['cpf']} img={Cpf} type="text" onChange={e => setCpf(e.target.value)} placeholder="CPF" autocomplete="off"/>
                            <Input hasError={!!formErrors['telefone']} img={Telefone} type="text" onChange={e => setTelefone(e.target.value)} placeholder="Telefone" autocomplete="off"/>
                            <Input hasError={!!formErrors['email']} img={Email} type="email" onChange={e => setEmail(e.target.value)} placeholder="E-mail" autocomplete="off"/>
                            <Input hasError={!!formErrors['senha']} img={Senha} type="password" onChange={e => setSenha(e.target.value)} placeholder="Senha" autocomplete="off"/>
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