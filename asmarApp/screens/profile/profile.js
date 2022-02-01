import * as React from "react";
import { View, Text } from "react-native";
import { ScreenContainer } from "react-native-screens";
import {GET_JWT_TOKEN, SET_JWT_TOKEN} from "../../services/userService";

export default function ProfileScreen({navigation}) {
    console.log(GET_JWT_TOKEN())
    return(
        <View style={{ flex: 1, alignItems: "center", justifyContent: "center"}}>
            <Text style={{ fontSize: 26, fontWeight: "bold"}}>Profile Screen</Text>
        </View>
    );

}