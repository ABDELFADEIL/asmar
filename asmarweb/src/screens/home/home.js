import * as React from "react";
import ArticleMini from "../../components/templates/ArticleMini";
import { Button, Card, Container, Row, Col, Carousel } from 'react-bootstrap';
import './../../index.css'
import './home.css'

export default function HomeScreen() {
  let articles = [{ name: "robe", prix: 11 }, { name: "robe", prix: 12 }, { name: "robe", prix: 13 }, { name: "robe", prix: 14 }, { name: "robe", prix: 15 }]

  const list = []

  for (const [i, article] of articles.entries()) {
    // list.push(<li>{product}</li>)
    list.push(
      <Col>
        <ArticleMini  article={article} />
      </Col>
    )
  }

  return (
    <div>

      <Carousel style={{ margin: ".5rem" }} >
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
      <h3 className="color3" >Catégories les plus recherchées:</h3>
      <Container>
        <Row>
          {list}
        </Row>
      </Container>
      {/* <div>
        {list}
      </div> */}
      <p>Home page</p>
    </div>

  );

}