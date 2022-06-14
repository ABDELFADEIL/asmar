import React, {useEffect, useState} from 'react';
import {Button, Card, Col, Row} from "react-bootstrap";
import {FaEye} from "react-icons/fa";
import "./cartProduct.css";
import {Link} from "react-router-dom";

const CardProduct = ({product, viewProduct})=> {

    const  [imageP,setImageP] = useState();

    const getImagePrincipal =() => {
            if(product.urlImages.length !== 0 ){
                for(let image of product.urlImages){
                    if(image.principal){
                        setImageP(image.url);
                    }
                }
            }
    }
    useEffect(() => {
        getImagePrincipal();
    }, []);

        return (

            <Col>
                <Card style={{width: 240, height: 380}} className="cart-product mb-2">
                    <Link to={`/product-details/${product.id}`}>
                        <Card.Img variant="top" src={imageP} />
                        <Card.ImgOverlay>
                            <Card.Title>{product ? product.label : 'undefined'}</Card.Title>
                            <Card.Text>
                                {product ? product.description : 'undefined'}
                            </Card.Text>
                            <Row className="color2 justify-content-around footer-card">
                                <Col>{product ? product.price + '€' : 'undefined'}</Col>
                                <Col className="mt-1 me-2">
                                    <Button style={{background: '#003B49', borderRadius: 9}} id="button"
                                            variant="flat" size="sm"> <FaEye  className="me-2"/>Afficher</Button>
                                </Col>
                            </Row>
                        </Card.ImgOverlay>
                    </Link>
                </Card>

            </Col>

        );
}


export default CardProduct;