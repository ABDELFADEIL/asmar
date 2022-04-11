import React, {useEffect, useState} from 'react'
import "../order/order.css";
import {GetAddresses, UpdateAddress} from "../../services/addressService";
import {func, object} from "prop-types";

const Address = ({setAddresses, address, telephone, setActive, active}) =>{


    const getAddresses = (userId)=> {
        GetAddresses(userId)
            .then(response => {
                console.log(response);
                setAddresses(response.data);
            })
            .catch(error => {
                console.log(error);
            })
    }

    const choiceAddress = () =>{
        UpdateAddress(address.id, "delivery")
            .then(res => {
                console.log(res);
                setActive(res.data.delivery);
                getAddresses(34)
            })
            .catch(error=> {
                console.log(error);
            })
    }

    useEffect(() => {
    }, []);
    return(
        <>
                <p> <input onClick={choiceAddress} onChange={()=> {}} name="address" checked={active} className="input-radio" type="radio"/>
                    {
                        address.fullName + ' ' +
                        address.street + ' ' +
                        address.city + ', ' +
                        address.country + ' Numéro de téléphone: ' +
                        telephone
                    }
                <a className={"primary small"}>Modifier</a>
                </p>

        </>
    );
}

Address.propTypes = {
    address: object,
    setAddresses: func.isRequired,
};
export default Address;

