import axios from 'react-native-axios';


//  const BASE_URL = 'http://localhost:8080';
 const BASE_URL = '';
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
    getProductById

};



