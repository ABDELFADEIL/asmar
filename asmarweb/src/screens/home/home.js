import React, { useEffect, useState } from "react";
import ArticleMini from "../../components/templates/ArticleMini";
import { productService } from '../../services/productService'
import { Button, Card, Container, Row, Col, Carousel } from 'react-bootstrap';
import './../../index.css'
import './home.css'


export default function HomeScreen() {

  const [newProductsList, setNewProductsList] = useState([]);

  let getNewArticles = (nb) => {
    productService
      .getNbProductDetailsByDate(nb)
      .then((res) => {
        console.log(res);
        if (res?.data == null) {
          return
        }
        let list = [];
        for (const [i, article] of res.data.entries()) {
          list.push(
            <Col key={i} style={{ marginTop: "1rem" }}>
              <ArticleMini article={article} />
            </Col>
          )
        }
        setNewProductsList(list);
      })
      .catch(err => console.log(err))
  };

  useEffect(() => {
    getNewArticles(5)
  }, []);

  return (
    <div style={{ margin: "2rem" }}>
      <Carousel style={{ margin: "auto", width: "80%" }} >
        <Carousel.Item>
          <img
            className="d-block w-100 sizeimg"
            src="https://upload.wikimedia.org/wikipedia/commons/4/44/Cat_img.jpg"
            alt="First slide"
          />
          <Carousel.Caption>
            <h3>First slide label</h3>
            <p>Nulla vitae elit libero, a pharetra augue mollis interdum.</p>
          </Carousel.Caption>
        </Carousel.Item>
        <Carousel.Item>
          <img
            className="d-block w-100 sizeimg"
            src="https://cdn.pixabay.com/photo/2017/02/20/18/03/cat-2083492__480.jpg"
            alt="Second slide"
          />

          <Carousel.Caption>
            <h3>Second slide label</h3>
            <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit.</p>
          </Carousel.Caption>
        </Carousel.Item>
        <Carousel.Item>
          <img
            className="d-block w-100 sizeimg"
            src="https://media.istockphoto.com/photos/feline-picture-id108226626?k=20&m=108226626&s=612x612&w=0&h=bDaWwxhcygjerdR71qQu8YFSXaDUIi_HUZV2AADg5L8="
            alt="Third slide"
          />

          <Carousel.Caption>
            <h3>Third slide label</h3>
            <p>Praesent commodo cursus magna, vel scelerisque nisl consectetur.</p>
          </Carousel.Caption>
        </Carousel.Item>
      </Carousel>
      {/* <ArticleMini article={article} /> */}
      <Container>
        <h3 style={{ marginBottom: "0rem" }} className="color3 mgt2" >Nouveautés</h3>
        <Row>
          {newProductsList}
        </Row>
        <h3 style={{ marginBottom: "0rem" }} className="color3 mgt2" >Catégories les plus recherchées:</h3>
        <Row>
          {newProductsList}
        </Row>
      </Container>
      <p>Home page</p>
    </div>

  );
}