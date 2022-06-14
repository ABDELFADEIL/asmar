import axios from 'axios';
import {BASE_URL} from "../utils/constants";
import {GET_JWT_TOKEN} from "./userService";

export const AddAddress = async (address) => {
    const jwtToken = await GET_JWT_TOKEN();
    return axios.post(BASE_URL + '/api/addresses/add', address, {headers: jwtToken});
};