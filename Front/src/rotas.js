import React from "react";
import {BrowserRouter,Switch, Route} from 'react-router-dom';
import Home from "./pages/Home";
import Login from "./pages/Login";
import Cadastro from "./pages/Cadastro";
import Perfil from "./pages/Perfil";

function Rotas(){
    return(
      <BrowserRouter>
        <Switch>
            <Route exact path="/" component={Home}/>
            <Route exact path="/login" component={Login}/>
            <Route exact path="/cadastro" component={Cadastro}/>
            <Route exact path="/perfil" component={Perfil}/>
        </Switch>
      </BrowserRouter>
    );
}

export default Rotas;