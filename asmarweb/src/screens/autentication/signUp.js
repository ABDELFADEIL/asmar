import React, {Component} from "react";
import Logo from "../../assets/asmar_logo.png";
import {FaEnvelope, FaLock} from "react-icons/all";
import {Link} from "react-router-dom";
import "./signup.css"

export default class SignUpScreen extends Component {

    state = {
        firstName: "",
        lastName: "",
        password: "",
        repassword: "",
        email: "",
        userName: "",
        birthDate: "",
        street: "",
        city: "",
        state: "",
        postalCode: "",
        country: "",
        addInfos: "",
        active: true
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
        console.log(this.state)
    }

    render() {
        return (<div className="SignupPage">
                <div className="SignupPageCart">
                    <div className="loginLogo">
                        <img src={Logo} width="120px" alt="asmar logo"/>
                        <h5>Créer un compte</h5>
                    </div>
                    {/*<div className="connHead"><h5>Créer un compte</h5></div>*/}
                    <div className="signupInput">
                        <div className="signupFormGroup">
                            <div className="signupForm">
                                <label>Nom</label>
                                <input type="text" placeholder=""/>
                                <hr/>
                            </div>
                            <div className="signupForm">
                                <label>Prénom</label>
                                <input type="text" placeholder=""/>
                                <hr/>
                            </div>
                        </div>
                        <div className="signupFormGroup">
                            <div className="signupForm">
                                <label>Email</label>
                                <input type="email" placeholder=""/>
                                <hr/>
                            </div>
                            <div className="signupForm">
                                <label>Date de naissance</label>
                                <input type="text" placeholder=""/>
                                <hr/>
                            </div>
                        </div>
                        <div className="signupFormGroup">
                            <div className="signupForm">
                                <label>N° téléphon</label>
                                <input type="text" placeholder=""/>
                                <hr/>
                            </div>
                            <div className="signupForm">
                                <label>Username</label>
                                <input type="text" placeholder=""/>
                                <hr/>
                            </div>
                        </div>
                        <div className="signupFormGroup">
                            <div className="signupForm">
                                <label>Mot de passe</label>
                                <input type="password" placeholder=""/>
                                <hr/>
                            </div>
                            <div className="signupForm">
                                <label>Confirmer mot de passe</label>
                                <input type="password" placeholder=""/>
                                <hr/>
                            </div>
                        </div>
                        <div className="signupFormGroup">
                            <div className="signupForm">
                                <label>N° + voie</label>
                                <input type="text" placeholder=""/>
                                <hr/>
                            </div>
                            <div className="signupForm">
                                <label>Complément </label>
                                <input type="text" placeholder=""/>
                                <hr/>
                            </div>
                        </div>
                        <div className="signupFormGroup">
                            <div className="signupForm">
                                <label>Ville</label>
                                <input type="text" placeholder=""/>
                                <hr/>
                            </div>
                            <div className="signupForm">
                                <label>Code postal</label>
                                <input type="text" placeholder=""/>
                                <hr/>
                            </div>
                        </div>
                        <div className="signupFormGroup">
                            <div className="signupForm">
                                <label>Pays</label>
                                <input type="text" placeholder=""/>
                                <hr/>
                            </div>
                            <div className="signupForm">
                                <label>Provance</label>
                                <input type="text" placeholder=""/>
                                <hr/>
                            </div>
                        </div>
                    </div>
                    <div>
                        <div className="btnSend">
                            <button onClick={this.onSubmitForm} className="btnSignin">Envoyer</button>
                        </div>
                        <div className="btnLog">
                            <p>Si vous avez un compte <span><Link to="/login">Se connecter</Link></span></p>
                        </div>
                    </div>
                </div>
            </div>
        );
    }

}