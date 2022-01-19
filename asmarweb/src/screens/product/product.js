import React, { useEffect, useState} from 'react';
import { productService } from '../../services/productService';
import 'bootstrap/dist/css/bootstrap.min.css';

import 'react-multi-carousel/lib/styles.css';
import Button from 'react-bootstrap/Button';
import { Container, Col, Row
} from 'react-bootstrap';

export default function ProductScreen() {
    const [qty, setQty] = useState(1);
    const [productDetails, setProductDetails] = useState([]);

        useEffect(() => {
                getProductDetailsById();
    }, []);

   const getProductDetailsById = () => {
        productService
            .getProductDetailsById(1)
            .then((res) => {
                setProductDetails(res.data);
                console.log(res.data);
            })
            .catch(err => console.log(err));
    }

    return (

        <>
            <Container>
            <Row>
                <Col sm={8}>
                 <img src={productDetails.urlimages} alt="productImages"/>

                </Col>
                <Col sm={4}>
                <div className="productDetails">
                    <ul>
                        <li>
                            <h4>{productDetails.label}</h4>
                        </li>
                        <li>
                            <h4>{productDetails.price} euros </h4>
                        </li>

                        <li>
                            <h4>Origin: {productDetails.origin}</h4>
                        </li>
                        <li>
                            <h4>Material: {productDetails.composition}</h4>
                        </li>
                        <li>{ productDetails.usage_ && (<h4> Model d'emploi: {productDetails.utilisation}</h4>)}
                        </li>
                        <li>
                            Status:{''}
                            {productDetails.quantity > 0 ? 'disponible' : 'épuisé'}
                        </li>
                        <li>
                            Quantité:{''}
                            <select value={qty}
                                    onChange={(e) => {
                                        setQty(e.target.value);
                                    }
                                    }>
                                {[...Array(productDetails.quantity).keys()].map((x) => (
                                    <option key={x + 1} value={x + 1}> {x + 1} </option>))}
                            </select>
                        </li>
                        <li>
                            {productDetails.quantity > 0 && (
                                <Button>Ajouter</Button>)}
                        </li>
                    </ul>
                </div>
                </Col>
            </Row>
                <Row>
                    <Col sm>  <li>{ productDetails.description  && (<h4> Description: {productDetails.description}</h4>)}
                    </li></Col>
                    <Col sm> <li>{ productDetails.history  && (<h4> Histoire: {productDetails.history}</h4>)}
                    </li></Col>
                </Row>
            </Container>
        </>


    )
}




