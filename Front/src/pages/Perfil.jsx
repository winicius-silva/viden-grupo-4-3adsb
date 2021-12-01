import React, { useCallback, useState } from "react";
import Footer from "../components/Footer";
import imgPerfil from "../assets/img/imgPerfil.png";
import calendario from "../assets/img/calendario.png";
import '../assets/styles/perfil.css';
import { useHistory } from 'react-router-dom'
import HeaderBlack from "../components/dashboard/HeaderBlack";
import api from '../api'

function Perfil() {

    const history = useHistory()
    const data = JSON.parse(localStorage.getItem('data'))
    console.log(data)
    const [empresa, setEmpresa] = useState([])

    const getEmpresa = useCallback(() => {
        api.get(`/empresas/${data.fkEmpresa}`).then(empresaData => {
            if (empresaData.status === 204) {
                setEmpresa([])
                return
            }

            setEmpresa(empresaData.data)
        })
    })
    
    return (
        <>  
            <div className="background">

            <HeaderBlack />

                <div className="background2">
                    <div className="Perfil">
                        <div className="dadosPerfil">

                            <div className="imgPerfil">
                                <img className="real_img_perfil" src={imgPerfil}/>
                            </div>

                            <div className="infoPerfil">
                                <h2 className="nome">{data.nomeUsuario}</h2>
                                <br />
                                <label className="label_perfil">CPF:</label>
                                <label className="usuario">{data.cpf}</label>
                                <br />
                                <br />
                                <label className="label_perfil" >Email:</label>
                                <label className="email">{data.email}</label>
                                <br />
                                <br />
                                <label className="label_perfil" >Empresa:</label>
                                <label className="empresa">{empresa.nome}</label>
                            </div>

                            <div className="um">
                                <img id="img2" src={calendario} alt="" />
                                <h3 id="inscricao_titulo">Data de inscrição:</h3>
                                <h3 id="cor">{data.horaCadastro.split("T")[0]}</h3>
                            </div>
                            
                        </div>

                        <div className="progresso">

                        </div>
                    </div>
                </div>
            </div>
            <Footer />
        </>
    );
    
}

export default Perfil;