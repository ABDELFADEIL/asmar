import * as React from "react";
import { View, Text } from "react-native";
import { ScreenContainer } from "react-native-screens";
import {GET_JWT_TOKEN, SET_JWT_TOKEN} from "../../services/userService";

export default function ProfileScreen({navigation}) {

    const JWT = async ()=> {
        const jwt = await GET_JWT_TOKEN();
        console.log(jwt);
        return jwt;
    }
    JWT().then(r => console.log(r))
    return(
        <View style={{ flex: 1, alignItems: "center", justifyContent: "center"}}>
            <Text style={{ fontSize: 26, fontWeight: "bold"}}>Profile Screen</Text>
        </View>
    );

}