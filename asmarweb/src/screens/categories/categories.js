import Row from 'react-bootstrap/Row';
import React, { useEffect, useRef, useState} from 'react';
import {productService} from '../../services/productService';
import ProductItem from "../../components/ProductItem";
import {useLocation} from "react-router-dom";
import {Col, Container} from "react-bootstrap";
import CardProduct from "../../components/card_product/cardProduct";

export default function CategoriesScreen() {

    const location = useLocation();
    const [products, setProducts] = useState([]);

    const getProducts = () => {
        const idCat = location.pathname.split('/')[2];
        console.log(idCat);
        productService
            .getProductsByCategoryId(idCat)
            .then((res) => {
                setProducts(res.data);
            })
            .catch(err => console.log(err))
    };

    useEffect(() => {
        getProducts();
    }, [location.pathname]);
     return (

         <Container className="">
             <Row>
                 <Col lg={2} md={2} sm={2} xs={2} className="ms-1" style={{ minWidth: 140}}>

                 </Col>
                 <Col>
                     <Row className="d-flex mt-4">
                         {products.map(product => (
                             <CardProduct key={product.id} product={product}/>
                         ))}
                     </Row>
                 </Col>

             </Row>

         </Container>
     )
};