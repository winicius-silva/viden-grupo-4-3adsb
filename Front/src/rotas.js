import React from "react";
import {BrowserRouter,Switch, Route} from 'react-router-dom';
import Home from "./pages/Home";
import Login from "./pages/Login";
import Cadastro from "./pages/Cadastro";
import Perfil from "./pages/Perfil";
import Dashboard from "./pages/Dashboard";
import VideoPlayer from "./pages/VideoPlayer"
import Pesquisa from "./pages/Pesquisa";

function Rotas(){
    return(
      <BrowserRouter>
        <Switch>
            <Route exact path="/" component={Home}/>
            <Route exact path="/login" component={Login}/>
            <Route exact path="/cadastro" component={Cadastro}/>
            <Route exact path="/perfil" component={Perfil}/>
            <Route exact path="/dashboard" component={Dashboard}/>
            <Route exact path="/videoplayer/:idCurso" component={VideoPlayer}/>
            <Route exact path="/pesquisa" component={Pesquisa}/>
        </Switch>
      </BrowserRouter>
    );
}

export default Rotas;