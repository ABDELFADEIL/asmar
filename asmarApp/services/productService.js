import axios from 'react-native-axios';
import { BASE_URL } from '../utils/constants';
export const getProductById = async (id) => {
    return axios.get(BASE_URL + '/api/products/'+ id);
};
function getProductsBySearch(keyword) {
    return axios.get(BASE_URL+'/api/products/search?keyword='+keyword);
}
async function getProductDetailsById(id) {
    return new Promise((resolve, reject) => {
        axios
            .get(`${BASE_URL}/api/products/${id}`)
            .then((response) => {
                resolve(response.data);
            }).catch(err => console.log(err))
    });
}
function getNbProductDetailsByDate(nb) {
    // return axios.get(BASE_URL+'/api/products/bydate/'+nb);
    return new Promise((resolve, reject) => {
        axios
            .get(`${BASE_URL}/api/products/bydate/${nb}`)
            .then((response) => {
                resolve(response.data);
            }).catch(err => console.log(err))
    });
}
export const productService = {
    getProductDetailsById,
    getNbProductDetailsByDate,
    getProductById,
    getProductsBySearch
};