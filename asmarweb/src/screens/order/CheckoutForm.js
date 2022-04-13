import React, {useEffect, useState} from 'react';
import ReactDOM from 'react-dom';
import {loadStripe} from '@stripe/stripe-js';
import { CardElement, Elements, useStripe, useElements } from '@stripe/react-stripe-js';
import ButtonApp from "../../components/templates/ButtonApp";
import {BASE_URL} from "../../utils/constants";
import jwt_decode from "jwt-decode";

const CheckoutForm = ({title, func, total}) => {
    const stripe = useStripe();
    const elements = useElements();

    const [ message, setMessage ] = useState(false);
    const [ purchase, setPurchase ] = useState({
        email:'',
        amount: 0,
        featureRequest: ''
    });
    const handleSubmit = async (event) => {
        event.preventDefault();
        if (!stripe || !elements) {
            return;
        }
        const {error, paymentMethod} = await stripe.createPaymentMethod({
            type: 'card',
            card: elements.getElement(CardElement),
        });
        console.log("paymentMethod");
        console.log(paymentMethod);
        console.log("paymentMethod created");
        console.log(error);
        // create payment intent on the server.
        setPurchase({
            email:'abdelfadeil@gmail.com',
            amount: 10000,
            featureRequest: 'payment with react js'
        });
       const { error: backendError, clientSecret} = await fetch(BASE_URL + '/create-payment-intent',
            {
                method: 'POST',
                headers: {
                    'Content-type': 'application/json',
                },
                body: JSON.stringify( {
                    email:'abdalfadeil@gmail.com',
                    amount: total,
                    featureRequest: 'payment with react js'
                })
            }).then(res => res.json());
       if (backendError){
           setMessage(true);
           console.log(backendError);
           return;
       }
        console.log("payment created");
        console.log("clientSecret");
       console.log(clientSecret);
       // confirm payment on the client
        const { error: stripeError ,paymentIntent } = await stripe.confirmCardPayment(clientSecret,
            {
                payment_method: {
                    card: elements.getElement(CardElement),
                }
            });
        if (stripeError){
            setMessage(true);
            console.log(stripeError);
            return;
        }
        console.log(paymentIntent.id);
        console.log(paymentIntent.id);
    };

    useEffect(()=>{
            setTimeout(function() {
                setMessage(false)
            }, 10000);
        },
        [message])

    return (
        <div>
            <form onSubmit={handleSubmit}>
                <h6>Mode de paiement</h6>
                <p><input type="checkbox" checked onChange={()=>{}}/> Carte de crédit</p>
                {message ?
                    <div style={{ color: "red"}} className="error">
                        <p>Paiment a été échoué</p>
                    </div>
                    : <></> }
                <div className="payment">
                    <CardElement id="card-element"/>
                </div>
                <ButtonApp title={title} func={func} type="submit" disable={!stripe || !elements} />
            </form>
        </div>

    );
};

export default CheckoutForm;