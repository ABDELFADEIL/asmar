import React, {Component, useState} from "react";
import Logo from "../../assets/asmar_logo.png";
import {FaEnvelope, FaLock} from "react-icons/all";
import {Link, useNavigate} from "react-router-dom";
import "./signup.css"
import {GET_JWT_TOKEN, Login, SET_JWT_TOKEN, Signup} from "../../services/userService";



export default function SignUpScreen() {

    let navigate = useNavigate();
    const [state, setState] = useState({
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
    });


    const onInputchange = (e) => {
        setState(state => ({...state, [e.target.name]: e.target.value}))
    }

    const onSubmitForm = async ()=> {
        console.log(state);
        const response = await Signup(state);
        try {
            console.log(response);
            console.log(GET_JWT_TOKEN("jwtToken"));
            if (response.status === 201){
                navigate("/login");
            }
        }catch (e) {
            console.log(e);
        }
    }

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
                                       name="lastName" value={state.lastName}  onChange={onInputchange}
                                       placeholder=""/>
                                <hr/>
                            </div>
                            <div className="signupForm">
                                <label>Prénom</label>
                                <input type="text" name="firstName"
                                       value={state.firstName}  onChange={onInputchange} placeholder=""/>
                                <hr/>
                            </div>
                        </div>
                        <div className="signupFormGroup">
                            <div className="signupForm">
                                <label>Email</label>
                                <input type="email"
                                       name="email" value={state.email}  onChange={onInputchange}
                                       placeholder=""/>
                                <hr/>
                            </div>
                            <div className="signupForm">
                                <label>Date de naissance</label>
                                <input type="text" placeholder=""
                                       name="birthDate" value={state.birthDate}  onChange={onInputchange}/>
                                <hr/>
                            </div>
                        </div>
                        <div className="signupFormGroup">
                            <div className="signupForm">
                                <label>N° téléphon</label>
                                <input type="text" placeholder=""
                                       name="telephone" value={state.telephone}  onChange={onInputchange}/>
                                <hr/>
                            </div>
                            <div className="signupForm">
                                <label>Username</label>
                                <input type="text" placeholder="" name="userName"
                                       value={state.username}  onChange={onInputchange}/>
                                <hr/>
                            </div>
                        </div>
                        <div className="signupFormGroup">
                            <div className="signupForm">
                                <label>Mot de passe</label>
                                <input type="password" placeholder="" name="password"
                                       value={state.password}  onChange={onInputchange}/>
                                <hr/>
                            </div>
                            <div className="signupForm">
                                <label>Confirmer mot de passe</label>
                                <input type="password" placeholder="" name="repassword"
                                       value={state.repassword}  onChange={onInputchange}/>
                                <hr/>
                            </div>
                        </div>
                        <div className="signupFormGroup">
                            <div className="signupForm">
                                <label>N° + voie</label>
                                <input type="text" placeholder="" name="street"
                                       value={state.street}  onChange={onInputchange}/>
                                <hr/>
                            </div>
                            <div className="signupForm">
                                <label>Complément </label>
                                <input type="text" placeholder="" name="addInfos"
                                       value={state.addInfos}  onChange={onInputchange}/>
                                <hr/>
                            </div>
                        </div>
                        <div className="signupFormGroup">
                            <div className="signupForm">
                                <label>Ville</label>
                                <input type="text" placeholder="" name="city"
                                       value={state.city}  onChange={onInputchange}/>
                                <hr/>
                            </div>
                            <div className="signupForm">
                                <label>Code postal</label>
                                <input type="text" placeholder="" name="postalCode"
                                       value={state.postalCode}  onChange={onInputchange}/>
                                <hr/>
                            </div>
                        </div>
                        <div className="signupFormGroup">
                            <div className="signupForm">
                                <label>Pays</label>
                                <input type="text" placeholder="" name="country"
                                       value={state.country}  onChange={onInputchange}/>
                                <hr/>
                            </div>
                            <div className="signupForm">
                                <label>Provance</label>
                                <input type="text" placeholder="" placeholder="" name="state"
                                       value={state.state}  onChange={onInputchange}/>
                                <hr/>
                            </div>
                        </div>
                    </div>
                    <div>
                        <div className="btnSend">
                            <button onClick={onSubmitForm} className="btnSignin">Envoyer</button>
                        </div>
                        <div className="btnLog">
                            <p><span className="span1">Si vous avez un compte</span> <Link to="/login"><span className="span2">Se connecter</span></Link></p>
                        </div>
                    </div>
                </div>
            </div>
        );
}