import React from 'react';
import { NavigationContainer } from '@react-navigation/native';
import { createBottomTabNavigator } from '@react-navigation/bottom-tabs';
import Ionicons from 'react-native-vector-icons/Ionicons';
import { StyleSheet, Text, View } from 'react-native';


// Screens
import HomeScreen from "./screens/home/home";
import CategoriesScreen from "./screens/categories/categories";
import ProfileScreen from "./screens/profile/profile";
import SearchScreen from "./screens/search/search";
import ShoppingCartScreen from "./screens/shoppingCart/shopping_cart";

// screen names
const homeName = "Accueil";
const profileName = "Profile";
const searchName = "Rechercher";
const categoriesName = "Categories";
const shppingCartName = "Panier";

const Tab = createBottomTabNavigator();

export default function App() {
  return (
      <NavigationContainer>
        <Tab.Navigator
            initialRouteName={homeName}
            screenOptions={({route}) => ({
              tabBarIcon: ({focused, color, size}) => {
                let iconName;
                let routeName = route.name;

                if (routeName === homeName){
                  iconName = focused ? 'home-sharp' : 'home-sharp'
                }else if (routeName === profileName){
                  iconName = focused ? 'person' : 'person'
                }else if (routeName === searchName){
                  iconName = focused ? 'search' : 'search-outline'
                }else if (routeName === categoriesName){
                  iconName = focused ? 'grid' : 'grid'
                }
                else if (routeName === shppingCartName){
                    iconName = focused ? 'basket' : 'basket'
                }
                return <Ionicons name={iconName} size={size} color={color}/>
              },
            })}>
            <Tab.Screen name={categoriesName} component={CategoriesScreen}/>
            <Tab.Screen name={searchName} component={SearchScreen}/>
            <Tab.Screen name={homeName} component={HomeScreen}/>
            <Tab.Screen name={shppingCartName} component={ShoppingCartScreen}/>
            <Tab.Screen name={profileName} component={ProfileScreen}/>
        </Tab.Navigator>
      </NavigationContainer>
  );
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    backgroundColor: '#fff',
    alignItems: 'center',
    justifyContent: 'center',
  },
});
