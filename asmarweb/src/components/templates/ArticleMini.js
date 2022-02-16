import React from 'react';
import { Button, Card, Container, Row, Col, Carousel } from 'react-bootstrap';
import './ArticleMini.css'
// import Button  from  'react-bootstrap/Button';


export default function ArticleMini({ article }) {
  // function afficher() {
  //   console.log("AFFICHER")
    
  // };
  let afficher = () => {
    console.log("AFFICHER")
  };

  return (
    <div>

      <Card className="cardbackground" style={{ width: '18rem' }}>
        <Card.Body>
          <Card.Img style={{ maxHeight: "15rem" }} variant="top" src="https://m.media-amazon.com/images/I/51XgqzfXiiL._AC_.jpg" />
          <Card.Title>
            {article.name}
          </Card.Title>
          <Card.Text>
            {article.description}
          </Card.Text>
          <Card.Text>
            <Container>
              <Row>
                <Col className='color2' style={{ fontWeight: 'bold', margin: "auto" }} >{article.prix} € </Col>
                <Col>
                <Button onClick={afficher} className='color2bg color3' variant="primary">AFFICHER</Button>
                </Col>
              </Row>
            </Container>
          </Card.Text>
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
