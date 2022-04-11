import * as React from "react";
import {Container, Row, Col, Card, ProgressBar} from "react-bootstrap";
import "../shoppingCart/shopping_cart.css"
import {useEffect, useLayoutEffect, useState} from "react";
import {getShoppingCartItems} from "../../services/commandLineService";
import CommandLine from "../../components/templates/commandLine/commandLine";
import {Link} from "react-router-dom";
import OrderSummary from "../../components/templates/order-summary";
import Address from "./address";
import {GetAddresses} from "../../services/addressService";
import {GET_JWT_TOKEN, userInfo} from "../../services/userService";


const Order = () => {

    const [commandLines, setCommandLines] = useState([]);
    const [addresses, setAddresses] = useState([]);
    const [step, setStep] = useState(2);
    const [ user, setUser ] = useState({});
    const [ active, setActive ] = useState(false);
    const [addressClassName, setAddressClassName] = useState('address');
    useLayoutEffect(() => {
    }, [])

  const getAddresses = (userId)=> {
      GetAddresses(userId)
          .then(response => {
              console.log(response);
              setAddresses(response.data);
          })
          .catch(error => {
              console.log(error);
          })
  }
  const getCurrentUser = () => {
      const jwt = GET_JWT_TOKEN("jwtToken");
      userInfo(jwt)
          .then(res=> {
           setUser(res.data);
          })
          .catch(error => {
           console.log(error);
          })
  }
    const getShoppingCart = (id) => {
        getShoppingCartItems(id).then(res => {
            setCommandLines(res.data)
            console.log(res);
        }).catch(error => console.log(error));
    }

    useEffect(() => {
        getAddresses(34);
        getShoppingCart(34);
        getCurrentUser();
    }, []);

    const total = () => {
        let total = 0;
        commandLines.map((commandLine) => {
            total = total + commandLine.price;
        });
        return total;
    }
    const toggleClass = () => {
        setActive(!active);
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
                            <Col className={(step >= 1 ? 'step-first' : '')}><h6>Panier</h6></Col>
                            <Col className={"text-center " + (step >= 2 ? 'step-first' : 'step-two')}><h6>Livraison</h6>
                            </Col>
                            <Col className={"text-end " + (step >= 3 ? 'step-first' : 'step-two')}><h6>Paiment</h6>
                            </Col>
                        </Row>
                        <ProgressBar now={(step === 2 ? 50 : 0)} variant="success"/>
                    </div>
                    <Col md={8} className={"mb-2"}>
                        <Card className="order-cart p-2">
                            <Row className={"justify-content-center mt-2 ms-2"}>
                                <Col className={"mb-sm-2"}>
                                    <p className={"mb-1"}>
                                        <span className={"fw-bold color1"}>Adresse de livraison</span>
                                    </p>
                                    {addresses.map((address, id) =>
                                        <div key={id} className={`address ${address.delivery? ' active' : ''}`} onClick={toggleClass}>
                                            <Address
                                                address={address}
                                                key={id}
                                                telephone={user.telephone}
                                                setAddresses={setAddresses}
                                                active={address.delivery}
                                                setActive={setActive}
                                            />
                                        </div>

                                    )}
                                </Col>
                            </Row>

                        </Card>
                    </Col>
                    <Col md={4}>
                        <OrderSummary total={total} commandLines={commandLines} btn={false}/>
                    </Col>
                </Row>
            </Container>
        </div>
    );

}

export default Order;