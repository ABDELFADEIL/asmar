import HomeScreen from "../screens/home/home";
import Header from "../components/header";
import ProductDetailsScreen from "../screens/product/productDetails";
import React from "react";
import {NavigationContainer} from "@react-navigation/native";
import {createStackNavigator} from "@react-navigation/stack";

const homeName = "Asmar Boutique";
// const productDetailsName = "Détails";
const HomeStack = createStackNavigator();
const HomeNavigator = () => {
    return (
        <HomeStack.Navigator
            initialRouteName={'Asmar'}
            screenOptions={(route, navigation, title) => ({
                headerStyle: {backgroundColor: '#003B49'},
                headerTitleStyle: {color: '#F4D19E'},
                //headerTitleAlign: 'center',
                //headerMode: 'screen',
                headerShown: true,


            })}>
            <HomeStack.Screen name={'home'} component={HomeScreen}
                              options={{title: <Header title={homeName}/>}}/>
            <HomeStack.Screen name='Détails' component={ProductDetailsScreen}
                              options={{headerShown: false}}
            />
        </HomeStack.Navigator>

    );
}
export default HomeNavigator;