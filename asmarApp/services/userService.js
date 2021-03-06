import axios from 'axios';
import {BASE_URL} from "../utils/constants";
import AsyncStorage from '@react-native-async-storage/async-storage';

export const Login = (user) => {
        return axios.post(BASE_URL + '/login', user);
    },
    Signup = (user) => {
        return axios.post(BASE_URL + '/api/users/new', user);
    },
    SET_JWT_TOKEN = async (jwtToken) => {
        try {
            await AsyncStorage.setItem('jwtToken', jwtToken);
        } catch (e) {
            console.log(e);
        }
    },
    GET_JWT_TOKEN = async () => {
        try {
            const jwtToken = await AsyncStorage.getItem('jwtToken');
            console.log("jwtToken");
            console.log(jwtToken);
            return jwtToken != null ? jwtToken : null;
        } catch(e) {
            console.log(e);
        }
    },
    REMOVE_JWT_TOKEN = () => {
        AsyncStorage.removeItem('jwtToken');
    },
     userInfo = (JWT) => {
         return axios({
             method: 'get',
             url: BASE_URL + '/api/users/user',
             headers: {
                 'Content-Type': 'application/json',
                 'Authorization': JWT
             },
         });
     }