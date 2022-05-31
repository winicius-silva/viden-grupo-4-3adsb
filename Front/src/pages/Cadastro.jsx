import React, { useState } from "react";
import axios from 'axios';
import * as yup from 'yup'
import { ValidationError } from 'yup'
import { useHistory } from 'react-router-dom'

import Input from "../components/login_cadastro/Inputs";
import Header from "../components/login_cadastro/HeaderSign";
import Botao from "../components/login_cadastro/BotaoSign";
import Email from "../assets/img/email.png"
import Senha from "../assets/img/senha.png"
import Nome from "../assets/img/nome.png"
import Cpf from "../assets/img/cpf.png"
import Telefone from "../assets/img/telefone.png"

import { getValidationErrors } from '../utils/getValidationErrors'

import { useToastsContext } from '../contexts/toasts'

import '../assets/styles/global.css';
import '../assets/styles/sign.css';

function Cadastro() {
    const { addToast } = useToastsContext()
    const history = useHistory()

    const [nome, setNome] = useState("");
    const [cpf, setCpf] = useState("");
    const [telefone, setTelefone] = useState("");
    const [email, setEmail] = useState("");
    const [senha, setSenha] = useState("");

    const [formErrors, setFormErrors] = useState({})

    async function cadastrar(e) {
        e.preventDefault();

        const schema = yup.object().shape({
            nome: yup.string().min(5, 'Nome não pode ser menor que 5 caracteres').required('Nome é obrigatório'),
            cpf: yup.string().length(11, 'CPF inválido').required('CPF é obrigatório'),
            email: yup.string().email('Digite um email válido'),
            telefone: yup.string().min(10, 'Número deve conter no mínimo 10 dígitos').max(11, 'Número deve conter no mínimo 11 dígitos').required('Nº    de telefone é obrigatório'),
            senha: yup.string().min(5, 'Senha deve contar pelo menos 5 caracteres').required('Senha é obrigatória')
        })

        try {
            await schema.validate({ nome, cpf, telefone, senha }, {
                abortEarly: false,
            })

            console.log('values %s, %s, %s, %s, %s,',nome, cpf, telefone, email, senha)

            axios.post(`http://174.129.43.180:8080/usuarios/`, {
                headers: { "Access-Control-Allow-Origin": "*", "crossorigin": true },
                "nomeUsuario": nome,
                "cpf": cpf,
                "celular": telefone,
                "email": email,
                "senha": senha,
            }).then(response => {
                addToast({
                    type: 'success',
                    title: 'Cadastrado com sucesso',
                })

                history.push('/Login')
            }).catch(function (error) {
                addToast({
                    type: 'error',
                    title: 'Usúario já cadastrado. Faça o login',
                })
                console.log('%o', error)
                console.log('não cadastrou')
            })
        } catch (error) {
            if (ValidationError.isError(error)) {
                const yupErrors = getValidationErrors(error)
                setFormErrors(yupErrors)

                Object.values(yupErrors).forEach(yupError => {
                    addToast({
                        type: 'error',
                        title: yupError,
                    })
                })
            }
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