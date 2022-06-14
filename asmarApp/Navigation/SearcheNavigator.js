import { createStackNavigator } from '@react-navigation/stack';
import React from 'react';
import SearchScreen from "../screens/search/search";
import ProductDetailsScreen from "../screens/product/productDetails";




const UserStack = createStackNavigator();
const SearchNavigator = () => {

    return (
        <UserStack.Navigator initialRouteName="search">
            <UserStack.Screen
                name="search"
                component={SearchScreen}
            />
            <UserStack.Screen
                name="détails"
                component={ProductDetailsScreen}
                options={{ title: 'Product détails' }}
            />
        </UserStack.Navigator>
    );
};

export default SearchNavigator;


