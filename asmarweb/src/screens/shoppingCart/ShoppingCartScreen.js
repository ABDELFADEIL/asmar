import * as React from "react";
import {Container, Row, Col, Card} from "react-bootstrap";
import "./shopping_cart.css"
import {useEffect, useState} from "react";
import {getShoppingCartItems} from "../../services/commandLineService";
import CommandLine from "../../components/templates/commandLine/commandLine";
import OrderSummary from "../../components/templates/order-summary";
import {GET_JWT_TOKEN, userInfo} from "../../services/userService";
import {useNavigate} from "react-router-dom";

export default function ShoppingCartScreen(){

    const [ commandLines, setCommandLines] = useState([]);
    const [ user, setUser] = useState();
    let navigate = useNavigate();

    function getShoppingCart() {
        const jwt = GET_JWT_TOKEN();
        userInfo(jwt).then(res => {
            setUser(res.data);
            getShoppingCartItems(res.data.id).then(response => {
                setCommandLines(response.data)
                console.log(response);
            }).catch(error => console.log(error));
        }).catch(error=>{
            console.log(error);
            navigate('/login');
        })
    }
    useEffect(() => {
        if (user){
        getShoppingCart();
        }
    }, []);
    const getTotal = () => {
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
                            <OrderSummary total={getTotal} commandLines={commandLines} btn={true} />
                        </Col>
                    </Row>
                </Container>

            </div>
        );

}

