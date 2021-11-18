import React from "react";
import {BrowserRouter,Switch, Route} from 'react-router-dom';
import Home from "./pages/Home";
import Login from "./pages/Login";
import Cadastro from "./pages/Cadastro";
import Perfil from "./pages/Perfil";
import Dashboard from "./pages/Dashboard";
import VideoPlayer from "./pages/VideoPlayer"

function Rotas(){
    return(
      <BrowserRouter>
        <Switch>
            <Route exact path="/" component={Home}/>
            <Route exact path="/login" component={Login}/>
            <Route exact path="/cadastro" component={Cadastro}/>
            <Route exact path="/perfil" component={Perfil}/>
            <Route exact path="/dashboard" component={Dashboard}/>
            <Route exact path="/videoplayer" component={VideoPlayer}/>
        </Switch>
      </BrowserRouter>
    );
}

export default Rotas;