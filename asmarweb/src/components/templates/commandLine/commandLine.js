import React, {Component, useState} from 'react';
import {Col, Row, Image, Card} from "react-bootstrap";
import {BsBagPlus, BsPlus, FaCross, FaCrosshairs, FaLock, FaPlus, ImCross} from "react-icons/all";
import "./commandLine.css"
import { func, object } from 'prop-types';
import {getShoppingCartItems, RemoveItem, UpdateItemQuantity} from "../../../services/commandLineService";
const CommandLine = ({setCommandLines, commandLine})=> {

    const [ command, setCommand ] = useState(commandLine);
    const getImagePrincipal = () => {
      return command.product.urlImages.find((img)=> img.principal == true).url;
    }

    const removeItem = () => {
        console.log(command.id);
      RemoveItem(command.id).then(res=> {
          console.log(res);
          getShoppingCartItems(34).then(res=> {
              setCommandLines(res.data);
          }).catch(error=> {console.log(error)})

      }).catch(error=> console.log(error));
    }
    const updateItemQuantity = (id, quantity) => {
        console.log(id, quantity);
        UpdateItemQuantity(id, quantity).then(res=> {
            if (command.quantity + quantity > 0){
                setCommand(res.data);
            }
                getShoppingCartItems(34).then(res=> {
                    setCommandLines(res.data);
                }).catch(error=> {console.log(error)});
                console.log(command);
        }).catch(error=> console.log(error));

    }
        return (
            <Card className="cart-item">
            <Row className="item">
                <Col sm="2" lg="auto"><Image src={command.product.urlImages.length != 0 ?
                    getImagePrincipal() : "https://m.media-amazon.com/images/I/51XgqzfXiiL._AC_.jpg"} width="72px" height="98px"/> </Col>
                <Col sm="4" className="description">
                    <Card.Title>
                        {command.product.label}
                    </Card.Title>
                    <Card.Text>
                        {command.product.description}
                    </Card.Text>
                </Col>
                <Col sm="3" className="quantity">
                    <button onClick={()=> updateItemQuantity(command.id, -1)}>
                        <p>-</p>
                    </button>
                    <button>
                    <p>{command.quantity}</p>
                    </button>
                    <button onClick={()=> updateItemQuantity(command.id, 1)}>
                        <p>+</p>
                    </button>
                </Col>
                <Col sm="2" className="price">
                    <p>{command.price}€</p>
                </Col>
                <Col sm="1" className="remove">
                    <button onClick={removeItem}>
                        <ImCross size={13} color="rgba(0, 59, 73, 0.47)"/>
                    </button>
                </Col>
            </Row>
            </Card>
        );
}

CommandLine.propTypes = {
    commandLine: object,
    setCommandLines: func.isRequired,
};

CommandLine.defaultProps = {
    commandLine: null,
};

export default CommandLine;