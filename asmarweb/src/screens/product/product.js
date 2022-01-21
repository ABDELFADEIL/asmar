import React, {useEffect, useState} from 'react';
import { productService } from '../../services/productService';
import 'bootstrap/dist/css/bootstrap.min.css';
import './product.css';
import 'react-multi-carousel/lib/styles.css';
import Button from 'react-bootstrap/Button';
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
        return (
            <>
                <Container style={{padding: 50}}>
                    <Row>
                        <Col md={6} className="imagesContainer">
                            <Col sm={10} md={4} className="images">
                                {noImagePrincipal.map((img, index)=>(
                                    <img src={img} key={index} style={{ width: '100%', height: 550/noImagePrincipal.length}} alt="productImage"/>

                                ))}
                            </Col>
                            <Col sm={10} md={8} className="imagePrincipal">
                                <img src={imagePrincipal}style={{height: 550+ 5*(noImagePrincipal.length-1), width: '100%'}} alt="principal"/>
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
                                    <li><span style={{color: productDetails.quantity > 0 ? 'green' : 'red'}}>
                            Status :{''}
                                        {productDetails.quantity > 0 ? 'disponible' : 'épuisé'}
                        </span>
                                    </li>
                                    <li style={{marginTop: '1rem'}}><h6 style={{color: '#003B49'}}>
                                        Quantité :{''}   </h6>
                                        <select value={qty}
                                                onChange={(e) => {
                                                    setQty(e.target.value);
                                                }
                                                }>
                                            {[...Array(productDetails.quantity).keys()].map((x) => (
                                                <option key={x + 1} value={x + 1}> {x + 1} </option>))}
                                        </select>
                                    </li>
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
                                    <li>
                                        {productDetails.quantity > 0 && (
                                            <Button onClick={ajouterPanier} variant="flat" size="xxl">Ajouter</Button>)}
                                    </li>
                                </ul>
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




