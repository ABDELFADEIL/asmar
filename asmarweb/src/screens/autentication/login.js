import React, {Component} from "react";
import './login.css';
import Logo from "../../assets/asmar_logo.png"
import {FaEnvelope, FaLock} from "react-icons/all";
import {Link} from "react-router-dom";
import {Login} from "../../services/userService";

export default class LoginScreen extends Component{

    state = {
        email: "",
        password: "",
        jwtToken: null
            }

    constructor() {
        super();
        this.state = {
        };
        this.onInputchange = this.onInputchange.bind(this);
        this.onSubmitForm = this.onSubmitForm.bind(this);
    }

    onInputchange(event) {
        this.setState({
            [event.target.name]: event.target.value
        });
    }
    onSubmitForm() {
        console.log(this.state);
        Login(this.state).then(res=> {
            console.log(res);
            this.state.jwtToken = res.data;
            console.log(this.state.jwtToken);
        })
    }


    render() {
                return (<div className="LoginPage">
                            <div className="LoginPageCart">
                                <div className="loginLogo"><img src={Logo} width="120px" alt="asmar logo"/></div>
                                <div className="connHead"><h5>Se connecter</h5></div>
                                <div className="loginInput">
                                    <div className="loginEmail" >
                                        <FaEnvelope/>
                                        <input type="email" name="email" value={this.state.email} placeholder="Email adresse" onChange={this.onInputchange}/>
                                        <hr/>
                                    </div>
                                    <div className="loginPassword">
                                      <FaLock/>
                                        <input type="password" name="password" value={this.state.password} placeholder="Mot de passe" onChange={this.onInputchange}/>
                                        <hr/>
                                    </div>
                                    <div className="pwdForget">
                                        <Link to="/">Mot de passe oublié</Link>
                                    </div>
                                </div>
                                <div className="btnConn">
                                    <div className="btnSignup"><Link to="/signup">Créer un compte</Link></div>
                                    <button onClick={this.onSubmitForm} className="btnSignin">se connecter</button>
                                </div>
                            </div>
                    </div>
                );
        }


}