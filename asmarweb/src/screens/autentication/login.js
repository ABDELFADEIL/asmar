import React, {Component, useState} from "react";
import './login.css';
import Logo from "../../assets/asmar_logo.png"
import {FaEnvelope, FaLock} from "react-icons/all";
import {Link, useNavigate} from "react-router-dom";
import {GET_JWT_TOKEN, Login, SET_JWT_TOKEN} from "../../services/userService";


export default function LoginScreen() {

    let navigate = useNavigate();
    const [state, setState] = useState({
        email: "",
        password: "",
    });



    const onInputchange = (e) => {
        setState(state => ({...state, [e.target.name]: e.target.value}))
    }

    const onSubmitForm = async () => {
        const response = await Login(state);
        try {
            const headers = response.headers;
            SET_JWT_TOKEN(headers.authorization);
            console.log(GET_JWT_TOKEN("jwtToken"));
            if (response.status === 200) {
                navigate("/");
            }
        } catch (e) {
            console.log(e);
        }
    }

    return (
        <div className="LoginPage">
            <div className="LoginPageCart">
                <div className="loginLogo"><img src={Logo} width="120px" alt="asmar logo"/></div>
                <div className="connHead"><h5>Se connecter</h5></div>
                <div className="loginInput">
                    <div className="loginEmail">
                        <FaEnvelope/>
                        <input type="email" name="email" value={state.email} placeholder="Email adresse"
                               onChange={onInputchange}/>
                        <hr/>
                    </div>
                    <div className="loginPassword">
                        <FaLock/>
                        <input type="password" name="password" value={state.password} placeholder="Mot de passe"
                               onChange={onInputchange}/>
                        <hr/>
                    </div>
                    <div className="pwdForget">
                        <Link to="/">Mot de passe oublié</Link>
                    </div>
                </div>
                <div className="btnConn">
                    <div className="btnSignup"><Link to="/signup">Créer un compte</Link></div>
                    <button onClick={onSubmitForm} className="btnSignin">se connecter</button>
                </div>
            </div>
        </div>
    );
}


