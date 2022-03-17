import React, {Component} from 'react';
import {Col, Row, Image, Card} from "react-bootstrap";
import {BsBagPlus, BsPlus, FaCross, FaCrosshairs, FaLock, FaPlus, ImCross} from "react-icons/all";
import "./commandLine.css"
const CommandLine = ({commandLine})=> {
        return (
            <Card className="cart-item">
            <Row className="item">
                <Col sm="2" lg="auto"><Image src={commandLine.product.urlImages[0] != null ?
                commandLine.product.urlImages[0].url : "https://m.media-amazon.com/images/I/51XgqzfXiiL._AC_.jpg"} width="72px" height="98px"/> </Col>
                <Col sm="4" className="description">
                    <p>{commandLine.product.label}</p>
                    <p>{commandLine.product.description}</p>
                </Col>
                <Col sm="2" className="price">
                    <p>{commandLine.price}€</p>
                </Col>
                <Col sm="3" className="quantity">
                    <button>
                        <p>-</p>
                    </button>
                    <button>
                    <p>{commandLine.quantity}</p>
                    </button>
                    <button>
                        <p>+</p>
                    </button>
                </Col>
                <Col sm="1" className="remove">
                    <button>
                        <ImCross size={13} color="rgba(0, 59, 73, 0.47)"/>
                    </button>
                </Col>
            </Row>
            </Card>
        );
}

export default CommandLine;