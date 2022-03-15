import React, {useEffect, useState} from 'react';
import Card from 'react-bootstrap/Card'
import Col from 'react-bootstrap/Col';
import theme from '../../src/utils/theme';
import {Link} from "react-router-dom";

export const ProductItem = ({product}) => {
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
     <>
        <Col xs={12} md={6} lg={3}>
            <Link to="/product-details">
            <Card style={{width: '15rem',
                          height:'20rem',
                          marginBottom: '1rem',
                          marginLeft:'2rem',
                          marginTop:'1rem',
                          borderRadius: "10px",
                          overflow:'hidden'}}>

                   <Card.Img style={{height:'12rem'}}  alt="productImagePrincipal"
                   src={imageP}/>
                <Card.Body style={{backgroundColor:theme.COLORS.SECOND_DARK_GREEN, height:'6rem'}}>
                    <Card.Title style={{color:theme.COLORS.BASIC_GREEN}}>{product.label}</Card.Title>
                    <Card.Text style={{color:theme.COLORS.BASIC_LIGHT_YELLOW, fontSize:'0.8rem'}}>
                        {product.description}
                    </Card.Text>
                </Card.Body>
                <Card.Footer style={{backgroundColor:theme.COLORS.BASIC_GREEN}}>
                    <small style={{color:theme.COLORS.BASIC_LIGHT_YELLOW}}>{product.price} €</small>
                </Card.Footer>
            </Card>
        </Link>
        </Col>
         </>

    )
}

export default ProductItem;


