import axios from "axios";
import {BASE_URL} from "../utils/constants";
import {GET_JWT_TOKEN} from "./userService";


export const GetAddresses = (userId) => {
    const JWT =  GET_JWT_TOKEN();
    return axios({
        method: 'get',
        url: BASE_URL + '/api/addresses/user-addresses?userId='+ userId,
        headers: {
            'Content-Type': 'application/json',
            'Authorization': JWT
        },
    });
}

export const UpdateAddress = (addressId, addressType) => {
    const JWT =  GET_JWT_TOKEN();
    return axios(
        {
            method: 'put',
            url: BASE_URL + '/api/addresses/update-active/' + addressId+ '?addressType=' + addressType,
            headers: {
                'Content-Type': 'application/json',
                'Authorization': JWT

            },
        });
}