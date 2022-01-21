import React, {Component} from "react";
import './login.css';
import Logo from "../../assets/asmar_logo.png"
import {FaEnvelope, FaLock} from "react-icons/all";
import {Link, useNavigate, withRouter} from "react-router-dom";
import {GET_JWT_TOKEN, Login, SET_JWT_TOKEN} from "../../services/userService";
import {BASE_URL} from "../../utils/constants";

export default class LoginScreen extends Component{



    constructor(props) {
        super();
        this.state = {
            email: "",
            password: "",
        }
        this.onInputchange = this.onInputchange.bind(this);
        this.onSubmitForm = this.onSubmitForm.bind(this);
    }


    onInputchange(event) {
        this.setState({
            [event.target.name]: event.target.value
        });
    }
    async onSubmitForm() {
        console.log(this.state);
        const response = await Login(this.state);
        try {
            const headers = response.headers;
            SET_JWT_TOKEN(headers.authorization);
            console.log(GET_JWT_TOKEN("jwtToken"));
            if (response.status === 200){
                this.props.history.push('/');
            }
        }catch (e) {
            console.log(e);
        }
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
