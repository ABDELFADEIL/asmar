import * as React from 'react';
import {NavigationContainer} from '@react-navigation/native';
import {createBottomTabNavigator} from '@react-navigation/bottom-tabs';
import Ionicons from 'react-native-vector-icons/Ionicons';
import {Image, Pressable, StyleSheet, Text, TouchableOpacity, TouchableWithoutFeedback, View} from 'react-native';
import {createNativeStackNavigator} from '@react-navigation/native-stack';
import {createStackNavigator} from "@react-navigation/stack";

// Screens
import HomeScreen, { Details } from "../screens/home/home";
import CategoriesScreen from "../screens/categories/categories";
import ProfileScreen from "../screens/profile/profile";
import SearchScreen from "../screens/search/search";
import ShoppingCartScreen from "../screens/shoppingCart/shopping_cart";
import productDetailsScreen from "../screens/product/productDetails";
import LoginScreen from "../screens/autentication/login";
import SignUpScreen from "../screens/autentication/signUp";
import ProductScreen from '../screens/product/productDetails';

// screen names
const homeName = "Accueil";
const profileName = "Profile";
const searchName = "Rechercher";
const categoriesName = "Categories";
const shoppingCartName = "Panier";
const productDetailsName = "Détails de produit";
const LoginName = "Connexion";
const SignUpName = "Créer un compte";

const Tab = createBottomTabNavigator();
const AuthStack = createStackNavigator();
const HomeStack = createStackNavigator();
const CategoriesStack = createStackNavigator();
const SearchStack = createStackNavigator();
const ProfileStack = createStackNavigator();
const ShoppingCartStack = createStackNavigator();

const HomeStackScreen = () => (
    <HomeStack.Navigator>
        <HomeStack.Screen name={homeName} component={HomeScreen}/>
        <HomeStack.Screen name={productDetailsName} component={ProductScreen}/>
    </HomeStack.Navigator>
);
const CategoriesStackScreen = () => (
    <CategoriesStack.Navigator>
        <CategoriesStack.Screen name={categoriesName} component={CategoriesScreen}/>
        <CategoriesStack.Screen name={productDetailsName} component={productDetailsScreen}/>
    </CategoriesStack.Navigator>
);
const SearchStackScreen = () => (
    <SearchStack.Navigator>
        <SearchStack.Screen name={searchName} component={SearchScreen} />
    </SearchStack.Navigator>
);
const ProfileStackScreen = () => (
    <ProfileStack.Navigator>
        <ProfileStack.Screen name={profileName} component={ProfileScreen} />
    </ProfileStack.Navigator>
);
const ShoppingCartStackScreen = () => (
    <ShoppingCartStack.Navigator>
        <ShoppingCartStack.Screen name={shoppingCartName} component={ShoppingCartScreen} />
    </ShoppingCartStack.Navigator>
);
const AuthStackScreen = () => (
    <AuthStack.Navigator>
        <AuthStack.Screen
            name={LoginName}
            component={LoginScreen}
            options={{title: LoginName}}
        />
        <AuthStack.Screen
            name={SignUpName}
            component={SignUpScreen}
            options={{title: SignUpName}}
        />
    </AuthStack.Navigator>
);



export default function MainContainer() {
    return (
        <NavigationContainer>
            <Tab.Navigator
                initialRouteName={homeName}
                screenOptions={({navigation, route}) => ({
                    labelStyle: {paddingBottom: 5, paddingTop: 5, fontSize: 10},
                    tabBarShowLabel: true,
                    tabBarStyle: {
                        padding: 6, height: 60, backgroundColor: '#003B49',
                        borderTopEndRadius: 20, borderTopStartRadius: 20, elevation: 0,
                        margin: 0, position: 'absolute', bottom: 0
                    },
                    headerShown: false,
                    headerStyle: {backgroundColor: '#FFF'},
                    tabBarIcon: ({focused, color, size}) => {
                        let iconName;
                        let routeName = route.name;

                        if (routeName === homeName) {
                            iconName = focused ? 'home' : 'home';
                        } else if (routeName === profileName) {
                            iconName = focused ? 'person' : 'person'
                        } else if (routeName === searchName) {
                            iconName = focused ? 'search' : 'search-outline'
                        } else if (routeName === categoriesName) {
                            iconName = focused ? 'grid' : 'grid'
                        } else if (routeName === shoppingCartName) {
                            iconName = focused ? 'basket' : 'basket'
                        }
                        return <Ionicons name={iconName} size={size} color={color}/>
                    },

                })}

                tabBarOptions={{
                    labelStyle: {paddingBottom: 5, paddingTop: 5, fontSize: 10},
                    activeTintColor: '#F7B14C',
                    inactiveTintColor: '#F4D19E',
                }}>
                <Tab.Screen name={categoriesName} component={CategoriesStackScreen}/>
                <Tab.Screen name={searchName} component={SearchStackScreen}/>
                <Tab.Screen name={homeName} component={HomeStackScreen}
                            options={{
                                tabBarLabel: '',
                                tabBarIcon: ({navigation, focused}) => (
                                    <Ionicons style={{
                                        color: focused ? '#F7B14C' : '#F4D19E',
                                        position: 'absolute',
                                        top: -25,
                                        width: 60,
                                        height: 60,
                                        paddingLeft: 15,
                                        paddingTop: 10,
                                        backgroundColor: '#003B49',
                                        borderRadius: 40,
                                        borderWidth: 4,
                                        borderColor: '#FFF',
                                        justifyContent: 'center',
                                        alignItems: 'center',
                                    }} name={'home'} size={30} color={'#F4D19E'}/>
                                )
                            }}/>
                <Tab.Screen name={shoppingCartName} component={ShoppingCartStackScreen}/>
                <Tab.Screen name={profileName} component={ProfileStackScreen}/>
            </Tab.Navigator>
        </NavigationContainer>
    );
}

const styles = StyleSheet.create({
    container: {},
});
