import axios from 'axios';
import { BASE_URL } from '../utils/constants'
import {GET_JWT_TOKEN} from "./userService";


export async function onAddProductToCart(newCommandLine) {
    const jwtToken = await GET_JWT_TOKEN();
    return new Promise((resolve, reject) => {
        axios
            .post(`${BASE_URL}/api/commandLine/add`, newCommandLine, {headers: {'Authorization': jwtToken}})
            .then((response) => {
                resolve(response);
            })
            .catch((err) => reject(err));
    });
}

 export const getShoppingCartItems = async () => {
     const jwtToken = await GET_JWT_TOKEN();
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

/*
    export const commandLineService = {
        onAddProductToCart
    };
 */

