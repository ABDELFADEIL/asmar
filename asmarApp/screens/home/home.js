import * as React from "react";
import {View, Text, Button} from "react-native";
import LoginScreen from "../autentication/login";
import ProductScreen from "../product/productDetails";
import SignUpScreen from "../autentication/signUp";

export default function HomeScreen(navigation) {
    return(
        <View style={{ flex: 1, alignItems: "center", justifyContent: "space-around"}}>
            <Text style={{ fontSize: 26, fontWeight: "bold"}}>Home Screen</Text>

            <Button
                title="Login"
                onPress={() =>
                    navigation.push('LoginScreen', {name: 'Login'})
                }
            />
            <Button
                title="SignUp"
                onPress={() =>
                    navigation.push('SignUpScreen', {name: 'SignUp'})
                }
            />
            <Button
                title="Détail de produit page"
                onPress={() =>
                    navigation.push('ProductScreen', {name: 'Détails de produit'})
                }
            />
        </View>
    );

}