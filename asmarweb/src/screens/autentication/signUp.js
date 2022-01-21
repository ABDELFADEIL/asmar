import React, {Component} from "react";
import Logo from "../../assets/asmar_logo.png";
import {FaEnvelope, FaLock} from "react-icons/all";
import {Link, useNavigate} from "react-router-dom";
import "./signup.css"
import {GET_JWT_TOKEN, Login, SET_JWT_TOKEN, Signup} from "../../services/userService";



export default class SignUpScreen extends Component {



    constructor() {
        super();

        this.state = {
            firstName: "",
            lastName: "",
            password: "",
            repassword: "",
            email: "",
            telephone: "",
            username: "",
            birthDate: "",
            street: "",
            city: "",
            state: "",
            postalCode: "",
            country: "",
            addInfos: "",
            active: true
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
        const response = await Signup(this.state);
        try {
            console.log(response);
            console.log(GET_JWT_TOKEN("jwtToken"));
            if (response.status === 201){

            }
        }catch (e) {
            console.log(e);
        }
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
                                <input type="text"
                                       name="lastName" value={this.state.lastName}  onChange={this.onInputchange}
                                       placeholder=""/>
                                <hr/>
                            </div>
                            <div className="signupForm">
                                <label>Prénom</label>
                                <input type="text" name="firstName"
                                       value={this.state.firstName}  onChange={this.onInputchange} placeholder=""/>
                                <hr/>
                            </div>
                        </div>
                        <div className="signupFormGroup">
                            <div className="signupForm">
                                <label>Email</label>
                                <input type="email"
                                       name="email" value={this.state.email}  onChange={this.onInputchange}
                                       placeholder=""/>
                                <hr/>
                            </div>
                            <div className="signupForm">
                                <label>Date de naissance</label>
                                <input type="text" placeholder=""
                                       name="birthDate" value={this.state.birthDate}  onChange={this.onInputchange}/>
                                <hr/>
                            </div>
                        </div>
                        <div className="signupFormGroup">
                            <div className="signupForm">
                                <label>N° téléphon</label>
                                <input type="text" placeholder=""
                                       name="telephone" value={this.state.telephone}  onChange={this.onInputchange}/>
                                <hr/>
                            </div>
                            <div className="signupForm">
                                <label>Username</label>
                                <input type="text" placeholder="" name="userName"
                                       value={this.state.username}  onChange={this.onInputchange}/>
                                <hr/>
                            </div>
                        </div>
                        <div className="signupFormGroup">
                            <div className="signupForm">
                                <label>Mot de passe</label>
                                <input type="password" placeholder="" name="password"
                                       value={this.state.password}  onChange={this.onInputchange}/>
                                <hr/>
                            </div>
                            <div className="signupForm">
                                <label>Confirmer mot de passe</label>
                                <input type="password" placeholder="" name="repassword"
                                       value={this.state.repassword}  onChange={this.onInputchange}/>
                                <hr/>
                            </div>
                        </div>
                        <div className="signupFormGroup">
                            <div className="signupForm">
                                <label>N° + voie</label>
                                <input type="text" placeholder="" name="street"
                                       value={this.state.street}  onChange={this.onInputchange}/>
                                <hr/>
                            </div>
                            <div className="signupForm">
                                <label>Complément </label>
                                <input type="text" placeholder="" name="addInfos"
                                       value={this.state.addInfos}  onChange={this.onInputchange}/>
                                <hr/>
                            </div>
                        </div>
                        <div className="signupFormGroup">
                            <div className="signupForm">
                                <label>Ville</label>
                                <input type="text" placeholder="" name="city"
                                       value={this.state.city}  onChange={this.onInputchange}/>
                                <hr/>
                            </div>
                            <div className="signupForm">
                                <label>Code postal</label>
                                <input type="text" placeholder="" name="postalCode"
                                       value={this.state.postalCode}  onChange={this.onInputchange}/>
                                <hr/>
                            </div>
                        </div>
                        <div className="signupFormGroup">
                            <div className="signupForm">
                                <label>Pays</label>
                                <input type="text" placeholder="" name="country"
                                       value={this.state.country}  onChange={this.onInputchange}/>
                                <hr/>
                            </div>
                            <div className="signupForm">
                                <label>Provance</label>
                                <input type="text" placeholder="" placeholder="" name="state"
                                       value={this.state.state}  onChange={this.onInputchange}/>
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