import * as React from "react";
import { useEffect, useState } from "react";
// import {View, Text, Button, image} from "react-native";
import { View, ScrollView, image } from "react-native";
import LoginScreen from "../autentication/login";
import ProductScreen from "../product/productDetails";
import { productService } from '../../services/productService';
import ArticleMini from "../../components/templates/articleMini";
import SignUpScreen from "../autentication/signUp";
import ProductDetailsScreen from "../product/productDetails";
import { ScreenContainer } from "react-native-screens";
import { Text, Card, Button, Icon } from 'react-native-elements';



// screen names
const homeName = "Asmar Boutique";
const profileName = "Profile";
const searchName = "Rechercher";
const categoriesName = "Catégories";
const shoppingCartName = "Panier";
const productDetailsName = "Détails";
const LoginName = "Connexion ";
const SignUpName = "Créer un compte";

export default function HomeScreen({ navigation }) {

  const [newProductsList, setNewProductsList] = useState([]);

  let getNewArticles = (nb) => {
    productService
      .getNbProductDetailsByDate(nb)
      .then((res) => {
        console.log("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA")
        console.log(res);
        if (res == null) {
          return
        }
        let list = [];
        console.log("BBBBBBBBBBBBBBBBBBBBBBBB")
        console.log(res)
        for (const [i, article] of res.entries()) {
          list.push(
            // <Col key={i} style={{ marginTop: "1rem" }}>
            <View key={i} style={{ width: 300,height:400 }} >
              <ArticleMini navigation={navigation} article={article} />
            </View>
            // </Col>
          )
        }
        setNewProductsList(list);
      })
      .catch(err => console.log(err))
  };

  useEffect(() => {
    getNewArticles(5)
  }, []);
let teste = (val)=> {
  console.log("1111111111111111111111111")
  console.log(val)
}

  return (
    <View style={{ flex: 1, alignItems: "center", justifyContent: "space-around" }}>
      <Text style={{ fontSize: 26, fontWeight: "bold" }}>Home Screen</Text>

      {/* <Card>
            <Card.Title>HELLO WORLD</Card.Title>
            <Card.Divider />
            <Card.Image
              style={{ padding: 0 }}
              source={{
                uri:
                  'https://awildgeographer.files.wordpress.com/2015/02/john_muir_glacier.jpg',
              }}
            />
            <Text style={{ marginBottom: 10 }}>
              The idea with React Native Elements is more about component
              structure than actual design.
            </Text>
            <Button
              icon={
                <Icon
                  name="code"
                  color="#ffffff"
                  iconStyle={{ marginRight: 10 }}
                />
              }
              buttonStyle={{
                borderRadius: 0,
                marginLeft: 0,
                marginRight: 0,
                marginBottom: 0,
              }}
              title="VIEW NOW"
            />
          </Card> */}
          
      <Text style={{ fontSize: 26, fontWeight: "bold" }}>Nouveautés</Text>
      <ScrollView horizontal={true}>
        <View style={{ display: "flex", flexDirection: "row"}}>
          {newProductsList}
        </View>
      </ScrollView>
      <Button
        title="Login"
        onPress={() =>
          // navigation.push(LoginName)
          navigation.push("ProductDetailsScreen")
        }
      />
      <Button
        title="SignUp"
        onPress={() =>
          navigation.push(SignUpName)
        }
      />
      <Button
        title="Détail de produit page"
        onPress={() =>
          navigation.navigate("Détails")
        }
      />
    </View>
  );

}
