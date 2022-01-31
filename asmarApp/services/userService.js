import axios from 'axios';
import {BASE_URL} from "../utils/constants";

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
        return localStorage.getItem('jwtToken');
    },
    REMOVE_JWT_TOKEN = () => {
        localStorage.removeItem('jwtToken');

    };