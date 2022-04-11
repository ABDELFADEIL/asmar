import * as React from "react";
import {Container, Row, Col, Card, ProgressBar} from "react-bootstrap";
import "../shoppingCart/shopping_cart.css"
import {useEffect, useState} from "react";
import {getShoppingCartItems} from "../../services/commandLineService";
import CommandLine from "../../components/templates/commandLine/commandLine";
import { Link } from "react-router-dom";
import OrderSummary from "../../components/templates/order-summary";

const Order = ()=>{

    const [ commandLines, setCommandLines] = useState([]);
    const [ step, setStep ] = useState(2);


    const getShoppingCart = (id)=> {
        getShoppingCartItems(id).then(res => {
            setCommandLines(res.data)
            console.log(res);
        }).catch(error => console.log(error));
    }

    useEffect(() => {
        getShoppingCart(34)
    }, []);

    const total = () => {
        let total = 0;
        commandLines.map((commandLine)=> {
            total = total + commandLine.price;
        });
        return total;
    }
    return (
            <div>
                <Container className="cart-container" fluid>
                  <Row>
                     <div className="title">
                         <h5>Passer la commande</h5>
                     </div>
                  </Row>
                    <Row>
                        <div className="items-title col-sm-12">
                            <Row className="justify-content-center">
                                <Col className={(step >= 1 ? 'step-first': '')}><h6>Panier</h6></Col>
                                <Col className={"text-center " + (step >= 2 ? 'step-first': 'step-two')} ><h6>Livraison</h6></Col>
                                <Col className={"text-end " +(step >= 3 ? 'step-first': 'step-two')}><h6>Paiment</h6></Col>
                            </Row>
                            <ProgressBar now={(step === 2 ? 50: 0)} variant="success"/>
                        </div>
                        <Col md={8}>
                                    <Card className="item-cart">
                                    <p className="text-center m-auto">Passer la commande !</p>
                                    </Card>
                        </Col>
                        <Col md={4}>
                            <OrderSummary total={total} commandLines={commandLines} btn={false} />
                        </Col>
                    </Row>
                </Container>
            </div>
        );

}

export default Order;