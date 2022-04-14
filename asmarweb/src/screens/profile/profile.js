import React, { useEffect, useState } from 'react';
import { productService } from '../../services/productService'
import { GET_JWT_TOKEN, userInfo, GET_DECODED_JWT } from "../../services/userService";
import { GetAddresses } from "../../services/addressService";
import { Button, Card, Container, Row, Col, Carousel } from 'react-bootstrap';
import { BsBagPlus, BsPlus, FaCross, FaCrosshairs, FaLock, BsFillPencilFill, ImCross } from "react-icons/all";
import Modal from 'react-bootstrap/Modal'
import ButtonModifProfile from './profileComponents/ButtonModifProfile';


export default function ProfileScreen(navigation) {
  const JWT = GET_JWT_TOKEN();
  const [user, setUser] = useState({});
  const [addresses, setAddresses] = useState({});

  let getUserInfos = async () => {
    // console.log("jwttttttttttttttt");
    // let decoded = GET_DECODED_JWT(JWT)
    const response = await userInfo(JWT);
    setUser(response.data)
    console.log("user", response);

  }
  let getUserAddresses = () => {
    GetAddresses(48)
      .then(response => {
        console.log("adresseeeees", response);
        setAddresses(response.data);
      })
      .catch(error => {
        console.log(error);
      })
  }


  useEffect(() => {
    let storage = localStorage;
    console.log("localstorage", storage)
    getUserInfos();
    getUserAddresses();
    // getUserAddresses();
  }, []);
  //page functions
  let modifyProfile = () => {
    console.log("coucou")
  }
  let updatePorfile = () => {
    console.log("updateprofil")
  }

  // templates
  let CategoryTitle = (prop) => {
    return (
      <div style={{ background: "#003B49" }}>
        <h3 style={{ color: "#F4D19E", padding: "0.5rem", margin: "0.5rem 0" }} > {prop.title} </h3>
      </div>
    )
  };
  let ZoneInfo = (prop) => {
    return (
      <div style={{ width: prop.width, margin: "0.5rem 0" }}>
        <p> <span style={{ fontWeight: "bold" }} >{prop.name}</span> : {prop.value}</p>
      </div>
    )
  }


  return (
    <div style={{ margin: "auto", width: "80%" }}>
      {/* <div className="loginLogo"> */}
      <CategoryTitle title="MON PROFIL" />
      <div style={{ display: "flex" }} >
        <div style={{ display: "flex", flexWrap: "wrap", paddingLeft: "1rem", width: "95%", margin: "0.5rem 0" }} >
          <ZoneInfo name="Prénom" value={user.firstName} width="50%" />
          <ZoneInfo name="Nom" value={user.lastName} width="50%" />
          <ZoneInfo name="Date de naissance" value={user.birthDate} width="50%" />
          <ZoneInfo name="Mail" value={user.email} width="50%" />
          <ZoneInfo name="Tél" value={user.telephone} width="50%" />
        </div>
        <div style={{ margin: "auto" }}>
          <ButtonModifProfile user={user} callback={updatePorfile} />
        </div>
      </div>
      <CategoryTitle title="MOT DE PASSE" />
      <CategoryTitle title="MES ADRESSES" />
      <ZoneInfo name="Tél" value={addresses.length > 0 && addresses ? addresses[0].street :'' } width="50%" />
      <CategoryTitle title="MES CARTES" />
      {/* </div> */}
    </div>
  );

}