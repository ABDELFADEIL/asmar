import axios from 'axios';


const BASE_URL = 'http://localhost:8080/api/commandLine';

async function addProductToCart(userId,productId,quantity){
    const newCommandLine = {
        userId: userId,
        productId: productId,
        quantity: quantity
    };
    return new Promise((resolve, reject) => {
        axios
            .post(`${BASE_URL}/add`, newCommandLine)
            .then((response) => {
                resolve(response);
            })
            .catch((err) => reject(err));
    });
}
    export const commandLineService = {
        addProductToCart
    };



