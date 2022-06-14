import axios from 'axios';
import { BASE_URL } from '../utils/constants';
import {GET_JWT_TOKEN} from "./userService";
import AsyncStorage from "@react-native-async-storage/async-storage";

export async function onAddProductToCart(newCommandLine){
    let jwtToken;
    GET_JWT_TOKEN().then(res=> jwtToken = res);
    return new Promise((resolve, reject) => {
        axios
            .post(`${BASE_URL}/api/commandLine/add`, newCommandLine, {headers: jwtToken})
            .then((response) => {
                resolve(response);
            })
            .catch((err) => reject(err));
    });
}
export const commandLineService = {
        onAddProductToCart
    };
 export const getShoppingCartItems = async () => {
     const jwtToken = await GET_JWT_TOKEN();
     console.log('getShoppingCartItems ' + jwtToken);
     console.log(jwtToken);
     return axios({
         method: 'get',
         url: BASE_URL + '/api/commandLine/shopping-cart',
         headers: {
             'Content-Type': 'application/json',
             'Authorization': jwtToken
         },
     });
 }
export const RemoveItem = async (id) => {
    const jwtToken = await GET_JWT_TOKEN();
     return axios(
     {
         method: 'delete',
             url: BASE_URL + '/api/commandLine/remove/' + id,
         headers: {
             'Content-Type': 'application/json',
             'Authorization': jwtToken

     },
     });
 }

export const UpdateItemQuantity = async (id, quantity) => {
    const jwtToken = await GET_JWT_TOKEN();
    return axios(
        {
            method: 'put',
            url: BASE_URL + '/api/commandLine/update-quantity/' + id+ '?quantity=' + quantity,
            headers: {
                'Content-Type': 'application/json',
                'Authorization': jwtToken

            },
        });
}


