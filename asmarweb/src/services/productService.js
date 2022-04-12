import axios from 'axios';
import {BASE_URL} from "../utils/constants";



function getProductDetailsById(id) {
    return axios.get(BASE_URL+'/api/products/'+id);
}
function getNbProductDetailsByDate(nb) {
  return axios.get(BASE_URL+'/api/products/bydate/'+nb);
}
function getProductsBySearch(keyword) {
    return axios.get(BASE_URL+'/api/products/search?keyword='+keyword);
}
function getProductsByCategoryId(categoryId) {
    return axios.get(BASE_URL+'/api/products/category/'+categoryId);
}
function getAllProducts() {
    return axios.get(BASE_URL+'/api/products/all');
}

export const productService = {

    getProductDetailsById,
    getProductsByCategoryId,
    getNbProductDetailsByDate,
    getProductsBySearch,
    getAllProducts
};