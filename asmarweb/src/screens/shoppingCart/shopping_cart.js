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

    function getShoppingCart(id) {
        const array = Array.from({length: 20}, (x, i) => i);

        console.log(array)
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
                                    <Col>
                                        {commandLines.map((commandLine, index) =>
                                            <CommandLine setCommandLines={setCommandLines} key={index} commandLine={commandLine}/>
                                        )}
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
                                    <Row className={"row-checkout m-auto text-center" }>
                                        <button onClick={()=> console.log("")} className={"checkout "+(commandLines.length == 0 ? " not-activated": " activated")}>
                                            Valider mon panier
                                        </button>
                                    </Row>
                                </div>
                            </Card>
                        </Col>
                    </Row>
                </Container>
            </div>
        );

}