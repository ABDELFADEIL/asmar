import Row from 'react-bootstrap/Row';
import React, { useEffect, useRef, useState} from 'react';
import {productService} from '../../services/productService';
import ProductItem from "../../components/ProductItem";
import {useLocation} from "react-router-dom";

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

         <div className='row-wrapper'>
             <Row>
                 {products.map(product => (
                     <ProductItem key={product.id} product={product}/>
                 ))}
             </Row>
         </div>
     )
};