import axios from 'axios';
import {BASE_URL} from "../utils/constants";

export const AddAddress = (address) => {
        return axios.post(BASE_URL + '/api/addresses/add', address);
    };