import React from "react";
import {Elements} from '@stripe/react-stripe-js';
import {loadStripe} from '@stripe/stripe-js';
import {PK_STRIPE} from "../../utils/constants";
import CheckoutForm from "./CheckoutForm";

const stripePromise = loadStripe(PK_STRIPE);

const Stripe = ({title, func, total}) => {

    return(
        <Elements stripe={stripePromise}>
            <CheckoutForm  title={title} func={func} total={total}/>
        </Elements>
    )
}

export default Stripe;