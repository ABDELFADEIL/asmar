import * as React from "react";
import { View, Text } from "react-native";
import { ScreenContainer } from "react-native-screens";

export default function ProductScreen() {
    return(
        <View style={{ flex: 1, alignItems: "center", justifyContent: "center"}}>
            <Text style={{ fontSize: 26, fontWeight: "bold"}}>Product Screen</Text>
        </View>
    );

}