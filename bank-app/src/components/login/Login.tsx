import { useState } from 'react';
import './main.css'
import axios from 'axios';
import { useNavigate } from 'react-router-dom';

function Login() {
  const [name, setName] = useState("");
  const [password, setPassword] = useState("");
  const [error, setError] = useState("");
  const navigate = useNavigate();

  const handleSubmit = (e: { preventDefault: () => void; }) => {
    e.preventDefault();
    axios.get(`http://localhost:8081/bank/getuser?name=${name}&password=${password}`)
      .then((res) => {
        if (res.data === "success") {
          navigate("/home");
        } else {
          setName("");
          setPassword("");
          setError("Incorrect username or password");
        }
      })
      .catch((error) => {
        console.error('Login failed:', error);
        setError("An error occurred during login");
      });
  };

  return (
    <body>
      <div className="wrapper">
        <div className="form-wrapper sign-in">
          <form onSubmit={handleSubmit}>
            <h2>Bank App</h2>
            <div className="input-group">
              <input
                className="input100"
                type="text"
                name="usern"
                value={name}
                onChange={(e) => setName(e.target.value)}
                required
              />
              <label htmlFor="">Username</label>
            </div>
            <div className="input-group">
              <input
                className="input100"
                type="password"
                name="pass"
                value={password}
                onChange={(e) => setPassword(e.target.value)}
                required
              />
              <label htmlFor="">Password</label>
            </div>
            <div className="remember">
              <label><input type="checkbox" /> Remember me</label>
            </div>
            <button type="submit">Login</button>
            {error && <div style={{ color: 'red' }}>{error}</div>}
          </form>
        </div>
      </div>
    </body>
  )
}

export default Login;
