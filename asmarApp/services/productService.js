import axios from 'react-native-axios';


 const BASE_URL = 'https://0526-176-175-44-133.ngrok.io';

/*

function getProductDetailsById(id) {
    return axios.get(BASE_URL+'/'+id);
}
function getProductsByCategoryId(categoryId) {
    return axios.get(BASE_URL+'/'+categoryId);
}
export const productService = {
    getProductDetailsById
};

*/


export const getProductById = async (id) => {
    return axios.get(BASE_URL + '/api/products/'+ id);
};


async function getProductDetailsById(id) {
    return new Promise((resolve, reject) => {
        axios
            .get(`${BASE_URL}/api/products/${id}`)
            .then((response) => {
                resolve(response.data);
            }).catch(err => console.log(err))
            });
}
export const productService = {

    getProductDetailsById,
    getProductById

};



