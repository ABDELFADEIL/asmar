import React, {Component} from 'react';
import {Col, Row, Image} from "react-bootstrap";

const CommandLine = ({commandLine})=> {
        return (
            <Row>
                <Col sm="2"><Image src={commandLine.product.urlImages[0].url} fluid/> </Col>
                <Col sm="4">
                    <p>{commandLine.product.label}</p>
                    <p>{commandLine.product.description}</p>
                </Col>
                <Col sm="1"><p>{commandLine.quantity}</p></Col>
                <Col sm="2"><p>{commandLine.quantity}</p></Col>
                <Col sm="2"><p>{commandLine.price}$</p></Col>
                <Col sm="1"></Col>
            </Row>
        );
}

export default CommandLine;