import * as React from "react";
import { Container, Row, Col, Card} from "react-bootstrap";
import "./shopping_cart.css"
import {useEffect, useState} from "react";
import {getShoppingCartItems} from "../../services/commandLineService";
import CommandLine from "../../components/templates/commandLine/commandLine";
export default function ShoppingCartScreen(){

    const [empty, setEmpty ] = useState(true);
    const [ activated, setActivated ] = useState(false);
    const [ commandLines, setCommandLines] = useState([]);

    useEffect(() => {
        getShoppingCartItems(34).then(res => {
            setCommandLines(res.data)
            console.log(res);
        }).catch(error => console.log(error));
    }, []);
    return (
            <div>
                <Container className="cart-container" fluid>
                  <Row>
                     <div className="title">
                         <h5>Mon panier</h5>
                     </div>
                  </Row>
                    <Row>
                        <Col md={8}>
                            <div className="items-title">
                            <h6>Articles</h6>
                            <hr/>
                            </div>
                            <Card className="item-cart">
                                {commandLines.length==0 ?
                                    <p className="text-center m-auto">Votre panier est vide !</p>
                                    :
                                    <Card.Body>
                                     <CommandLine commandLine={commandLines[0]}/>
                                    </Card.Body>
                                }

                            </Card>
                        </Col>
                        <Col md={4}>
                            <div className="items-sum">
                            </div>
                            <Card className="cart cart-sum">
                                <div>
                                    <h6 className="text-center">Recapitulatif de panier</h6>
                                    <Container className="recap">
                                        <Row>
                                            <Col>Nombre d'articles</Col>
                                            <Col>0</Col>
                                        </Row>
                                        <Row>
                                            <Col>Prix total des articles</Col>
                                            <Col>0</Col>
                                        </Row>
                                        <Row>
                                            <Col>TVA (0%)</Col>
                                            <Col>0</Col>
                                        </Row>
                                        <Row>
                                            <Col>Total</Col>
                                            <Col>0$</Col>
                                        </Row>
                                    </Container>
                                    <Row className={"row-checkout m-auto text-center" }>
                                        <button onClick={()=> console.log("")} className={"checkout "+(!activated ? " not-activated": " activated")}>Valider</button>
                                    </Row>
                                </div>
                            </Card>
                        </Col>
                    </Row>
                </Container>
            </div>
        );

}