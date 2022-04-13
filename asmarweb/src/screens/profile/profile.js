import React, { useEffect, useState } from 'react';
import { productService } from '../../services/productService'
import {GET_JWT_TOKEN, userInfo} from "../../services/userService";


export default function ProfileScreen(){

let getUserInfos = async () => {
  const JWT = GET_JWT_TOKEN();
        console.log(JWT);
        const response = await userInfo(JWT);
        console.log("user", response);
}

  useEffect(() => {
    getUserInfos()
  }, []);


        return (
            <div>
                <div>Profile Screen</div>
                <p>profile page</p>
            </div>
        );

}