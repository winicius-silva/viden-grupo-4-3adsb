// import Home from "./pages/Home";
// import Login from "./pages/Login";
// import Cadastro from "./pages/Cadastro";
import Rotas from './rotas';

import { CursosProvider } from './contexts/cursos'
import { ToastsProvider } from './contexts/toasts'

function App() {
  return (
    <ToastsProvider>
      <CursosProvider>
        <Rotas />
      </CursosProvider>
    </ToastsProvider>
  );
}

export default App;
