import React, {useEffect, useState} from 'react';
import { productService } from '../../services/productService';
import 'bootstrap/dist/css/bootstrap.min.css';
import './product.css';
import 'react-multi-carousel/lib/styles.css';
import Button from 'react-bootstrap/Button';
import { AiOutlineShoppingCart } from 'react-icons/ai';
import { Container, Col, Row
} from 'react-bootstrap';



export default function ProductScreen() {
    const [qty, setQty] = useState(1);
    const [productDetails, setProductDetails] = useState({});
    const [urlImages, setUrlImages]= useState([]);
    const [imagePrincipal,setImagePrincipal] =useState(null);
    const [noImagePrincipal, setNoImagePrincipal] = useState([]);
    let ajouterPanier = () => {
        console.log("IMAGESSS");
        console.log(urlImages);
    }
   const getProductDetailsById = () => {
        productService
            .getProductDetailsById(1)
            .then((res) => {
                setProductDetails(res.data);
                setUrlImages(res.data.urlImages);
                let imgTab =[];
                let firstImg = null;
                for( let item of res.data.urlImages){
                    console.log(item);
                    imgTab.push(item.url);
                    console.log(imgTab);

                    if (item.principal){
                      firstImg = item.url;
                      setImagePrincipal(firstImg);
                      console.log(firstImg);
                    }

                };
                setNoImagePrincipal(imgTab) ;

                console.log(res.data);
            })
            .catch(err => console.log(err))
}
    useEffect(() => {
        getProductDetailsById();
    }, []);

    const renderIcon = () => {
        switch(this.props.btnText) {
            case 'Ajouter': return <i className="fa fa-AiOutlineShoppingCart" />;
        }
    }

    return (
            <>
                <Container style={{padding: 50}}>
                    <Row>
                        <Col md={6} className="imagesContainer">
                            <Col sm={10} md={4} className="images">
                                {noImagePrincipal.map((img, index)=>(
                                    <img src={img} key={index} style={{ width: '100%', height: 500/noImagePrincipal.length}} alt="productImage"/>

                                ))}
                            </Col>
                            <Col sm={10} md={8} className="imagePrincipal">
                                <img src={imagePrincipal}style={{height: 500+ 5*(noImagePrincipal.length-1), width: '100%'}} alt="principal"/>
                            </Col>
                        </Col>

                        <Col md={6}>
                            <div className="productDetails">
                                <ul>
                                    <li>
                                        <h5>{productDetails.label}</h5>
                                    </li>


                                    <li>
                                        <h5>Origin : {productDetails.origin}</h5>
                                    </li>
                                    <li>
                                        <h5>Material : {productDetails.composition}</h5>
                                    </li>
                                    <li>{productDetails.usage_ && (<h5> Model d'emploi : {productDetails.usage_}</h5>)}
                                    </li>

                                    <li>
                                        <h5>{productDetails.price} € </h5>
                                    </li>


                                 <li style={{color: productDetails.quantity > 0 ? 'green' : 'red'}}>
                            Status :{''}
                                        {productDetails.quantity > 0 ? 'disponible' : 'épuisé'}
                        </li>
                                </ul>
                        <Row>
                                    <Col style={{marginTop: '1rem',color: '#003B49',marginLeft:32}}>
                                        Quantité :{''}
                                        <select value={qty}
                                                onChange={(e) => {
                                                    setQty(e.target.value);
                                                }
                                                } style={{width:100, borderRadius:2, marginLeft:40}} >
                                            {[...Array(productDetails.quantity).keys()].map((x) => (
                                                <option key={x + 1} value={x + 1}> {x + 1} </option>))}
                                        </select>

                                    <style type="text/css">
                                        {`
                              .btn-flat {
                               background-color: darkGreen;
                               color: lightYellow;
                               border-radius:3rem;
                               margin-top: 1rem;
                              }

                               .btn-xxl {
                                padding: 0.5rem 2rem;
                                 font-size: 1rem;
                               }
                               `}
                                    </style>
                                    <span style={{marginLeft:40}}>
                                        {productDetails.quantity > 0 && (
                                            <Button style={{margin:0,backgroundColor:'#003B49'}}  onClick={ajouterPanier} variant="flat" size="sm" >
                                                <AiOutlineShoppingCart/>   Ajouter
                                            </Button>)}
                                    </span>
                                    </Col>
                                    </Row>
                            </div>
                        </Col>
                    </Row>
                    <Row>
                    <Col sm>
                        <li>{productDetails.description && (<h4> Description : {productDetails.description}</h4>)}
                        </li>
                    </Col>
                    <Col sm>
                        <li>{productDetails.history && (<h4> Histoire : {productDetails.history}</h4>)}
                        </li>
                    </Col>
                    </Row>
                </Container>
            </>
        );
    }




