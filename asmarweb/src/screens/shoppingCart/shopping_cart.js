import * as React from "react";
import { Container, Row, Col, Card} from "react-bootstrap";
import "./shopping_cart.css"
import {useEffect, useState} from "react";
import {getShoppingCartItems} from "../../services/commandLineService";
import CommandLine from "../../components/templates/commandLine/commandLine";
import { Link } from "react-router-dom";
import OrderSummary from "../../components/templates/order-summary";

export default function ShoppingCartScreen(){

    const [empty, setEmpty ] = useState(true);
    const [ activated, setActivated ] = useState(false);
    const [ commandLines, setCommandLines] = useState([]);

    function getShoppingCart(id) {
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
                            <OrderSummary total={total} commandLines={commandLines} btn={true} />
                        </Col>
                    </Row>
                </Container>
            </div>
        );

}