import * as React from 'react';
import { NavigationContainer } from '@react-navigation/native';
import { createBottomTabNavigator } from '@react-navigation/bottom-tabs';
import Ionicons from 'react-native-vector-icons/Ionicons';
import { StyleSheet, Text, View } from 'react-native';
import { createNativeStackNavigator } from '@react-navigation/native-stack';


// Screens
import HomeScreen from "./screens/home/home";
import CategoriesScreen from "./screens/categories/categories";
import ProfileScreen from "./screens/profile/profile";
import SearchScreen from "./screens/search/search";
import ShoppingCartScreen from "./screens/shoppingCart/shopping_cart";
import {setStatusBarBackgroundColor} from "expo-status-bar";
import MainContainer from "./containers/mainContainer";

// screen names
const homeName = "Accueil";
const profileName = "Profile";
const searchName = "Rechercher";
const categoriesName = "Categories";
const shppingCartName = "Panier";

const Tab = createBottomTabNavigator();

export default class App extends React.Component{
  render()
  {
    return (
        <MainContainer/>
    );
  }

}

const styles = StyleSheet.create({
  container: {

  },
});
