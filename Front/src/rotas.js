import React from "react";
import {BrowserRouter,Switch, Route} from 'react-router-dom';
import Home from "./pages/Home";
import Login from "./pages/Login";
import Cadastro from "./pages/Cadastro";
import Dashboard from "./pages/Dashboard";

function Rotas(){
    return(
      <BrowserRouter>
        <Switch>
            <Route exact path="/" component={Home}/>
            <Route exact path="/login" component={Login}/>
            <Route exact path="/cadastro" component={Cadastro}/>
            <Route exact path="/dashboard" component={Dashboard}/>
        </Switch>
      </BrowserRouter>
    );
}

export default Rotas;