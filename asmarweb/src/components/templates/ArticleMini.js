import React, {useCallback} from 'react';
import { Button, Card, Container, Row, Col, Carousel } from 'react-bootstrap';
import './ArticleMini.css'
import {
  BrowserRouter as Router,
  Switch,
  Route,
  Link,
  useParams,
  useNavigate
} from "react-router-dom";


export default function ArticleMini({ article }) {
  const navigate = useNavigate();
  let afficher = (id) => {
    console.log("AFFICHER")
    let chemin= "/product-details/" + id;
    navigate(chemin, {replace: true});
  };

  return (
    <div>

      <Card className="cardbackground" style={{ width: '18rem' }}>
        <Card.Body>
          {/* <Card.Img style={{ maxHeight: "15rem" }} variant="top" src="https://m.media-amazon.com/images/I/51XgqzfXiiL._AC_.jpg" /> */}
          <Card.Img style={{ maxHeight: "15rem" }} variant="top" src={ article.urlImages[0] !=null? article.urlImages[0].url:"https://m.media-amazon.com/images/I/51XgqzfXiiL._AC_.jpg"} />
          <Card.Title>
            {/* {article.name} */}
            {article.label}
          </Card.Title>
          <Card.Text>
            {article.description}
          </Card.Text>
          <Container>
            <Row>
                {/* <Col className='color2' style={{ fontWeight: 'bold', margin: "auto" }} >{article.prix} € </Col> */}
                <Col className='color2' style={{ fontWeight: 'bold', margin: "auto" }} >{article.price} € </Col>
                <Col>
                  <Button onClick={() =>afficher(article.id)} className='color2bg color3' variant="primary">AFFICHER</Button>
                </Col>
            </Row>
          </Container>
        </Card.Body>
      </Card>
      {/* <Button variant="primary">Go somewhere</Button>
<Button variant="primary">Primary</Button> */}
      {/* <h1>Article:  {article.name}</h1>
      <p>prix:{article.prix} </p>
      <Button disabled={false} >Show</Button> */}
    </div>
  );

}
