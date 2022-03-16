import axios from 'axios';

 const BASE_URL = 'http://localhost:8080/api/products';

function getProductDetailsById(id) {
    return axios.get(BASE_URL+'/'+id);
}
function getNbProductDetailsByDate(nb) {
  return axios.get(BASE_URL+'/bydate/'+nb);
}
function getProductsByCategoryId(categoryId) {
    return axios.get(BASE_URL+'/category/'+categoryId);
}

export const productService = {

    getProductDetailsById,
    getProductsByCategoryId,
    getNbProductDetailsByDate

};