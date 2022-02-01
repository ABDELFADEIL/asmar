import axios from 'axios';

const BASE_URL = 'http://localhost:8080/api/products';


function getProductDetailsById(id) {
    return axios.get(BASE_URL+'/'+id);
}

function getProductsByCategoryId(categoryId) {
    return axios.get(BASE_URL+'/'+categoryId);
}
export const productService = {
    getProductDetailsById
};
