import React, {Component} from 'react';
import {Col, Row, Image, Card} from "react-bootstrap";
import {BsBagPlus, BsPlus, FaCross, FaCrosshairs, FaLock, FaPlus, ImCross} from "react-icons/all";

const CommandLine = ({commandLine})=> {
        return (
            <Card className="cart-item">
            <Row className="item">
                <Col sm="2"><Image src={commandLine.product.urlImages[0].url} width="72px" height="98px"/> </Col>
                <Col sm="4">
                    <p>{commandLine.product.label}</p>
                    <p>{commandLine.product.description}</p>
                </Col>
                <Col sm="1"><p>{commandLine.quantity}</p></Col>
                <Col sm="2"><p>{commandLine.quantity}</p></Col>
                <Col sm="2"><p>{commandLine.price}$</p></Col>
                <Col sm="1">
                    <ImCross size={14} color="rgba(0, 59, 73, 0.47)"/>
                </Col>
            </Row>
            </Card>
        );
}

export default CommandLine;