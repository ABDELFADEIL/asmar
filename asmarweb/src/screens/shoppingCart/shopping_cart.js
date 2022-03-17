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
                        <div className="items-title col-sm-12">
                            <h6>Articles</h6>
                            <hr/>
                        </div>
                        <Col md={8}>


                                {commandLines.length==0 ?
                                    <Card className="item-cart">
                                    <p className="text-center m-auto">Votre panier est vide !</p>
                                    </Card>
                                    :
                                    <Col gap={3}>
                                        {commandLines.map(commandLine => (
                                            <CommandLine key={commandLines.id} commandLine={commandLine}/>
                                        ))}
                                    </Col>

                                }


                        </Col>
                        <Col md={4}>
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