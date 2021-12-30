import * as React from "react";
import {View, Text, Button} from "react-native";
import LoginScreen from "../autentication/login";
import ProductScreen from "../product/productDetails";
import SignUpScreen from "../autentication/signUp";
import {ScreenContainer} from "react-native-screens";


  const productDetailsName = "Détails de produit";
  const LoginName = "Connexion";

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
                    navigation.push('SignUpScreen')
                }
            />
            <Button
                title="Détail de produit page"
                onPress={() =>
                    navigation.push(productDetailsName)
                }
            />
        </View>
    );

}
