import axios from 'axios';

const BASE_URL = 'http://localhost:8080';

export const Login =  (user) => {
    return axios.post(BASE_URL+'/login', user);
}

export const Signup =  (user) => {
    return axios.post(BASE_URL+'/api/users/add', user);
}