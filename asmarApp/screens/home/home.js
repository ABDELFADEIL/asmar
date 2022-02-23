import * as React from "react";
import {View, Text, Button} from "react-native";
import LoginScreen from "../autentication/login";
import ProductScreen from "../product/productDetails";
import SignUpScreen from "../autentication/signUp";
import ProductDetailsScreen from "../product/productDetails";
import {ScreenContainer} from "react-native-screens";



// screen names
const homeName = "Asmar Boutique";
const profileName = "Profile";
const searchName = "Rechercher";
const categoriesName = "Catégories";
const shoppingCartName = "Panier";
const productDetailsName = "Détails";
const LoginName = "Connexion ";
const SignUpName = "Créer un compte";

export default function HomeScreen({navigation}) {
    return (
        <View style={{flex: 1, alignItems: "center", justifyContent: "space-around"}}>
            <Text style={{fontSize: 26, fontWeight: "bold"}}>Home Screen</Text>

            <Button
                title="Login"
                onPress={() =>
                    navigation.push(LoginName)
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
