import Row from 'react-bootstrap/Row';
import React, {useEffect, useState} from 'react';
import {productService} from '../../services/productService';
import ProductItem from "../../components/ProductItem";


export default function CategoriesScreen() {

    const [products, setProducts] = useState([]);


    const getProducts = () => {
        const idCat = window.location.pathname.split('/')[2];
        productService
            .getProductsByCategoryId(idCat)
            .then((res) => {
                setProducts(res.data);
            })
            .catch(err => console.log(err))

    }

    useEffect(() => {
        getProducts()
    }, [products]);


    return (

        <div className='row-wrapper'>
            <Row>
                {products.map(product => (
                    <ProductItem key={product.id} product={product} />
                ))}
            </Row>
        </div>
    )

};
