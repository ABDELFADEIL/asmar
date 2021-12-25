import * as React from 'react';
import { NavigationContainer } from '@react-navigation/native';
import { createBottomTabNavigator } from '@react-navigation/bottom-tabs';
import Ionicons from 'react-native-vector-icons/Ionicons';
import { StyleSheet, Text, View } from 'react-native';
import { createNativeStackNavigator } from '@react-navigation/native-stack';

// Screens
import HomeScreen from "../screens/home/home";
import CategoriesScreen from "../screens/categories/categories";
import ProfileScreen from "../screens/profile/profile";
import SearchScreen from "../screens/search/search";
import ShoppingCartScreen from "../screens/shoppingCart/shopping_cart";
import {setStatusBarBackgroundColor} from "expo-status-bar";
import {source} from "react-native/Libraries/DeprecatedPropTypes/DeprecatedImagePropType";

// screen names
const homeName = "Accueil";
const profileName = "Profile";
const searchName = "Rechercher";
const categoriesName = "Categories";
const shppingCartName = "Panier";

const Tab = createBottomTabNavigator();

export default function MainContainer() {
    return (
        <NavigationContainer>
            <Tab.Navigator
                initialRouteName={homeName}
                screenOptions={({route}) => ({
                    tabBarStyle: { padding: 10, height: 60, backgroundColor: '#003B49',
                        borderTopEndRadius: 20, borderTopStartRadius: 20, elevation: 0,
                    margin: 0, position: 'absolute', bottom: 0},
                    headerShown: true,
                    headerStyle: { backgroundColor: '#FFF' },
                    tabBarIcon: ({focused, color, size}) => {
                        let iconName;
                        let routeName = route.name;

                        if (routeName === homeName){
                            iconName = focused ? 'home' : 'home'
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

                })}

                tabBarOptions={{
                    showLabel: true,
                    activeTintColor: '#F7B14C',
                    inactiveTintColor: '#F4D19E',
                    labelStyle: {paddingBottom: 8, fontSize: 10}
                }}>
                <Tab.Screen name={categoriesName} component={CategoriesScreen} />
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

    },
});
