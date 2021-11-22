// import Home from "./pages/Home";
// import Login from "./pages/Login";
// import Cadastro from "./pages/Cadastro";
import Rotas from './rotas';

import { CursosProvider } from './contexts/cursos'

function App() {
  return (
    <CursosProvider>
      <Rotas/>
    </CursosProvider>
  );
}

export default App;
