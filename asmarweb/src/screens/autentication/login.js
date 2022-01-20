import React, {Component} from "react";
import './login.css';
import Logo from "../../assets/asmar_logo.png"
import {FaEnvelope, FaLock} from "react-icons/all";
import {Link} from "react-router-dom";

export default class LoginScreen extends Component{
        render() {
                return (<div className="LoginPage">
                            <div className="LoginPageCart">
                                <div className="loginLogo"><img src={Logo} width="120px" alt="asmar logo"/></div>
                                <div className="connHead"><h5>Se connecter</h5></div>
                                <div className="loginInput">
                                    <div className="loginEmail">
                                        <FaEnvelope/>
                                        <input type="email" placeholder="Email adresse"/>
                                        <hr/>
                                    </div>
                                    <div className="loginPassword">
                                      <FaLock/>
                                        <input type="password" placeholder="Mot de passe"/>
                                        <hr/>
                                    </div>
                                    <div className="pwdForget">
                                        <Link to="/">Mot de passe oublié</Link>
                                    </div>
                                </div>
                                <div className="btnConn">
                                    <div className="btnSignup"><Link to="/signup">Créer un compte</Link></div>
                                    <div className="btnSignin">se connecter</div>
                                </div>
                            </div>
                    </div>
                );
        }


}