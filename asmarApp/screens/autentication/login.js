import * as React from "react";
import {useEffect, useState} from 'react';
import { productService } from '../../services/productService';
import { View, Text } from "react-native";

export default function LoginScreen(navigation) {
    return(
        <View style={{ flex: 1, alignItems: "center", justifyContent: "center"}}>
            <Text style={{ fontSize: 26, fontWeight: "bold"}}>Login Screen</Text>
        </View>
    );

}