import { BrowserRouter,Route,Routes } from "react-router-dom";
import Login from "./components/login/Login";
import Home from "./components/home/Home"; 
function App() {
  return (
    <div>
      <BrowserRouter>
      <Routes>
        <Route path='/login' element={<Login/>}></Route>
        <Route path='/Home' element={<Home/>}></Route>
        <Route></Route>
      </Routes>
      </BrowserRouter>
    </div>
  )
}
export default App;