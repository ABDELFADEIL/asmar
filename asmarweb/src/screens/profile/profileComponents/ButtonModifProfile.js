import React, { useEffect, useState } from 'react';
import { Button, Form, Card, Container, Row, Col, Carousel } from 'react-bootstrap';
// import {
//   BrowserRouter as Router,
//   Switch,
//   Route,
//   Link,
//   useParams,
//   useNavigate
// } from "react-router-dom";
import { BsBagPlus, BsPlus, FaCross, FaCrosshairs, FaLock, BsFillPencilFill, ImCross } from "react-icons/all";
import Modal from 'react-bootstrap/Modal'


export default function ProfilePopup({ user, callback }) {
  // const navigate = useNavigate();
  const [show, setShow] = useState(false);

  const handleClose = () => setShow(false);
  const handleShow = () => setShow(true);
  let updateProfile = (e) => {
    e.preventDefault();
    e.stopPropagation();
    console.log("event", e);
    // console.log("update profile", user)
    callback();

  };

  let FormGroup = (prop) => {
    return (
      <Form.Group style={{ display: "flex" }} className="mb-3" controlId={prop.id}>
        <Form.Label style={{ width: "30%", margin: "auto" }} >{prop.label}</Form.Label>
        <Form.Control
          required={true}
          type={prop.type}
          defaultValue={prop.defaultVal}
          autoFocus={false}
        />
      </Form.Group>
    )
  }

  return (
    <>
      <Button style={{ background: "#003B49", margin: "auto" }} onClick={handleShow}><BsFillPencilFill /></Button>
      <Modal show={show} size="lg" onHide={handleClose} centered>
        <Form onSubmit={updateProfile} >
          <Modal.Header closeButton>
            <Modal.Title>Modification des informations du profile</Modal.Title>
          </Modal.Header>
          <Modal.Body>
            <FormGroup label="Prénom :" type="text" defaultVal={user.firstName} id="firstNameId" />
            <FormGroup label="Nom :" type="text" defaultVal={user.lastName} id="lastNameId" />
            <FormGroup label="Date de naissance :" type="date" defaultVal={user.birthDate} id="birthDateId" />
            <FormGroup label="Email :" type="email" defaultVal={user.email} id="emailId" />
            <FormGroup label="Téléphone :" type="number" defaultVal={user.telephone} id="telephoneId" />
          </Modal.Body>
          <Modal.Footer>
            <Button variant="secondary" onClick={handleClose}>
              Close
            </Button>
            <Button type="submit">Submit form</Button>
          </Modal.Footer>
        </Form>
      </Modal>
    </>
  );

}
