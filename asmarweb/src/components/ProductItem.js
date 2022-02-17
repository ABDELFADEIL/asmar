import React, {useEffect, useState} from 'react';
import Card from 'react-bootstrap/Card'
import Col from 'react-bootstrap/Col';
import theme from '../../src/utils/theme';
import {productService} from "../services/productService";


export const ProductItem = ({product}) => {
    const  [imageP,setImageP] = useState();


    const getImage = () => {
        productService
            .getProductsByCategoryId(2)
            .then((res) => {
                let firstImg = null;
                for(let item of res.data) {
                    for(let i of item.urlImages){
                    if(i.principal) {
                        firstImg = i.url;
                        setImageP(firstImg);
                        console.log(firstImg);
                    }
                    }
                }
            })
            .catch(err => console.log(err))
    }
    useEffect(() => {
        getImage();
    }, []);


    return (
     <>
        <Col xs={12} md={6} lg={3}>

            <Card style={{width: '15rem',
                          height:'20rem',
                          marginBottom: '1rem',
                          marginLeft:'2rem',
                          marginTop:'1rem',
                          borderRadius: "10px",
                          overflow:'hidden'}}>
                   <Card.Img style={{height:'10rem'}}  alt="productImagePrincipal"
                   src={imageP}/>
                <Card.Body style={{backgroundColor:theme.COLORS.SECOND_DARK_GREEN, height:'6rem'}}>
                    <Card.Title>{product.label}</Card.Title>
                    <Card.Text style={{color:theme.COLORS.BASIC_LIGHT_YELLOW, fontSize:'0.8rem'}}>
                        {product.description}
                    </Card.Text>
                </Card.Body>
                <Card.Footer style={{backgroundColor:theme.COLORS.BASIC_GREEN}}>
                    <small style={{color:theme.COLORS.BASIC_LIGHT_YELLOW}}>{product.price} €</small>
                </Card.Footer>
            </Card>
        </Col>
         </>

    )
}

export default ProductItem;


