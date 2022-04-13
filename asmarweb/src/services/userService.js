import axios from 'axios';
import {BASE_URL} from "../utils/constants";
import jwt_decode from "jwt-decode";

export const //BASE_URL = 'http://localhost:8080',
    Login = (user) => {
    return axios.post(BASE_URL + '/login', user);
},
    Signup = (user) => {
    return axios.post(BASE_URL + '/api/users/add', user);
},
    SET_JWT_TOKEN = (jwtToken) => {
    localStorage.setItem('jwtToken', jwtToken);
},
    GET_JWT_TOKEN = () => {
    const jwt_token = localStorage.getItem('jwtToken');
    const jwt_decoded = jwt_decode(jwt_token);
        console.log("jwt_decoded");
    console.log(jwt_decoded);
    return localStorage.getItem('jwtToken');
},
    REMOVE_JWT_TOKEN = () => {
    localStorage.removeItem('jwtToken');

},

    userInfo = (JWT) => {
        return axios({
            method: 'get',
            url: BASE_URL +'/api/users/user',
            headers: {
                'Content-Type' : 'application/json',
                'Authorization': JWT
            },
        });

};

