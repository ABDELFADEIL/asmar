import axios from 'axios';

const BASE_URL = 'http://localhost:8080/api/categories';

function getCategories() {
    return axios.get('/');
}


