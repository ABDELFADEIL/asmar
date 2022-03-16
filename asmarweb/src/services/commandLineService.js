import axios from 'axios';
import { BASE_URL } from '../utils/constants'


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



