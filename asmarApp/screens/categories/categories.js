import * as React from "react";
import { View, Text, Button } from "react-native";

const productDetailsName = "Détails de produit";

export default function CategoriesScreen({navigation}) {
    return(
        <View style={{ flex: 1, alignItems: "center", justifyContent: "center"}}>
            <Text style={{ fontSize: 26, fontWeight: "bold"}}>Categories Screen</Text>
            <Button
                title="Détail de produit page"
                onPress={() =>
                    navigation.push(productDetailsName)
                }
            />
        </View>
    );

}