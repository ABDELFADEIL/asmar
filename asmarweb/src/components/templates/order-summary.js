import React from "react";
import "../../screens/shoppingCart/shopping_cart.css";
import "../../screens/order/order.css"
import { Container, Row, Col, Card } from "react-bootstrap";
import { Link } from "react-router-dom";

const OrderSummary = ({ total, commandLines, btn }) => {
    return (<>
        <Card className={"cart p-2 order-cart " + (commandLines.length === 0 ? 'empty-cart': '')}>
            <div>
                <h6 className="text-center">Recapitulatif de panier</h6>
                <Container className="sum">
                    <Row>
                        <Col>Nombre d'articles</Col>
                        <Col>{commandLines.length}</Col>
                    </Row>
                    <Row>
                        <Col>Prix total des articles</Col>
                        <Col>{total()}€</Col>
                    </Row>
                    <Row>
                        <Col>TVA (0%)</Col>
                        <Col>0€</Col>
                    </Row>
                    <Row>
                        <Col>Total</Col>
                        <Col>{total() + total() * 0}€</Col>
                    </Row>
                </Container>
                {btn ?
                    <Row className={"row-checkout m-auto text-center"}>
                        <Link to="/order">
                            <button className={"checkout " + (commandLines.length === 0 ? " not-activated" : " activated")}>
                                Passer la commande
                            </button>
                        </Link>
                    </Row>:
                    <></>
                                    }

            </div>
        </Card>
    </>);
}

export default OrderSummary;