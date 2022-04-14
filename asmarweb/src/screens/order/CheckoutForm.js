import React, {useEffect, useState} from 'react';
import ReactDOM from 'react-dom';
import {loadStripe} from '@stripe/stripe-js';
import { CardElement, Elements, useStripe, useElements } from '@stripe/react-stripe-js';
import ButtonApp from "../../components/templates/ButtonApp";
import {BASE_URL} from "../../utils/constants";
import jwt_decode from "jwt-decode";
import {Col, Row} from "react-bootstrap";
import axios from "axios";

const CheckoutForm = ({title, orderPassed, setOrderPassed, setStep, total}) => {
    const stripe = useStripe();
    const elements = useElements();
    const [ message, setMessage ] = useState(false);
    const [ purchase, setPurchase ] = useState({
        email:'',
        amount: 0,
        featureRequest: ''
    });

    const checkout =(id) => {
        if (id !== null){
            setOrderPassed(true);
            console.log('commande passé avec succès');
        }

    }

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
        checkout(paymentIntent.id);
    };

    useEffect(()=>{
            let cancel = false;
            setTimeout(function () {
                if (cancel) return;
                setMessage(false);
            }, 10000);
            return () => {
                cancel = true;
            }
        },
        [message])

    const onPrevious = ()=> {
       setStep(2);
    }

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
                <Row className="justify-content-center flex-row">
                        <Col lg={6} md={6} sm={12} className="order-md-2 ">
                            <ButtonApp title={title} setStep={setStep} disable={!stripe || !elements} />
                        </Col>
                    <Col lg={6} md={6} sm={12} className="order-md-1">
                        <Row className={"row-btn m-auto text-center"}>
                            <a onClick={onPrevious} className={"order checkout activated btn-return"}>
                                Précédent
                            </a>
                        </Row>

                    </Col>
                </Row>

            </form>
        </div>

    );
};

export default CheckoutForm;