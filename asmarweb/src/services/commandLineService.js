import axios from 'axios';
import { BASE_URL } from '../utils/constants'
import {GET_JWT_TOKEN} from "./userService";


export async function onAddProductToCart(newCommandLine){
    return new Promise((resolve, reject) => {
        axios
            .post(`${BASE_URL}/api/commandLine/add`, newCommandLine)
            .then((response) => {
                resolve(response);
            })
            .catch((err) => reject(err));
    });
}
    export const commandLineService = {
        onAddProductToCart
    };
 export const getShoppingCartItems = (userId) => {
     return axios({
         method: 'get',
         url: BASE_URL + '/api/commandLine/shopping-cart?userId='+ userId,
         headers: {
             'Content-Type': 'application/json'
         },
     });
 }

export const RemoveItem = (id) => {
     const JWT =  GET_JWT_TOKEN();
     return axios(
     {
         method: 'delete',
             url: BASE_URL + '/api/commandLine/remove/' + id,
         headers: {
             'Content-Type': 'application/json',
             'Authorization': JWT

     },
     });
 }

export const UpdateItemQuantity = (id, quantity) => {
    const JWT =  GET_JWT_TOKEN();
    return axios(
        {
            method: 'put',
            url: BASE_URL + '/api/commandLine/update-quantity/' + id+ '?quantity=' + quantity,
            headers: {
                'Content-Type': 'application/json',
                'Authorization': JWT

            },
        });
}



