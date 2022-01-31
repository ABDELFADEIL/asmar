import * as React from 'react';
import {NavigationContainer} from '@react-navigation/native';
import {createBottomTabNavigator} from '@react-navigation/bottom-tabs';
import Ionicons from 'react-native-vector-icons/Ionicons';
import {Image, Pressable, StyleSheet, Text, TouchableOpacity, TouchableWithoutFeedback, View} from 'react-native';
import {createStackNavigator} from "@react-navigation/stack";
import {createDrawerNavigator} from "@react-navigation/drawer"
import Logo from "../assets/asmar-logo.svg";
import Header from "../components/header";


// Screens
import HomeScreen, {Details} from "../screens/home/home";
import CategoriesScreen from "../screens/categories/categories";
import ProfileScreen from "../screens/profile/profile";
import SearchScreen from "../screens/search/search";
import ShoppingCartScreen from "../screens/shoppingCart/shopping_cart";
import productDetailsScreen from "../screens/product/productDetails";
import LoginScreen from "../screens/autentication/login";
import SignUpScreen from "../screens/autentication/signUp";
import ProductScreen from '../screens/product/productDetails';
import {useState} from "react";
import {Animated} from "react-native-web";


// screen names
const homeName = "Asmar Boutique";
const profileName = "Profile";
const searchName = "Rechercher";
const categoriesName = "Catégories";
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
const RootStack = createStackNavigator();

const Drawer = createDrawerNavigator();
const RootStackScreen = () => (
    <RootStack.Navigator headerMod="none">
        <RootStack.Screen name={LoginName} component={LoginScreen}/>
    </RootStack.Navigator>
)


const HomeStackScreen = () => (
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
        <HomeStack.Screen name={'Détails'} component={ProductScreen}
        />
    </HomeStack.Navigator>
);
const CategoriesStackScreen = () => (
    <CategoriesStack.Navigator screenOptions={(route, navigation) => ({
        headerStyle: {backgroundColor: '#003B49'},
        headerTitleStyle: {color: '#F4D19E'},
        //headerTitleAlign: 'center',
        headerShown: true,
    })}>
        <CategoriesStack.Screen name={'categories'} component={CategoriesScreen}
                                options={{title: <Header title={categoriesName}/>}}/>
        <CategoriesStack.Screen name={'Détails'} component={productDetailsScreen}/>
    </CategoriesStack.Navigator>
);
const SearchStackScreen = () => (
    <SearchStack.Navigator screenOptions={(route, navigation) => ({
        headerStyle: {backgroundColor: '#003B49'},
        headerTitleStyle: {color: '#F4D19E'},
        //headerTitleAlign: 'center',
        headerShown: true,
    })}>
        <SearchStack.Screen name={'search'} component={SearchScreen}
                            options={{title: <Header title={searchName}/>}}/>
    </SearchStack.Navigator>
);
const ProfileStackScreen = () => (
    <ProfileStack.Navigator screenOptions={(route, navigation) => ({
        headerStyle: {backgroundColor: '#003B49'},
        headerTitleStyle: {color: '#F4D19E'},
        //headerTitleAlign: 'center',
        headerShown: true,
    })}>
        <ProfileStack.Screen name={'profile'} component={ProfileScreen}
                             options={{title: <Header title={profileName}/>}}/>
    </ProfileStack.Navigator>
);
const ShoppingCartStackScreen = () => (
    <ShoppingCartStack.Navigator screenOptions={(route, navigation) => ({
        headerStyle: {backgroundColor: '#003B49'},
        headerTitleStyle: {color: '#F4D19E'},
        //headerTitleAlign: 'center',
        headerShown: true,
    })}>
        <ShoppingCartStack.Screen name={'shoppingCart'} component={ShoppingCartScreen}
                                  options={{title: <Header title={shoppingCartName}/>}}/>
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
    const [isLoding] = useState(false);
    const [token, setToken] = useState(null);

    function TabsApp() {
        return (
            <Tab.Navigator
                initialRouteName={homeName}
                screenOptions={({navigation, route}) => ({
                    tabBarShowLabel: true,
                    tabBarActiveTintColor: '#F7B14C',
                    tabBarInactiveTintColor: '#F4D19E',
                    tabBarLabelStyle: {paddingBottom: 5, paddingTop: 5, fontSize: 10},
                    tabBarStyle: {
                        padding: 6, height: 60, backgroundColor: '#003B49',
                        borderTopEndRadius: 20, borderTopStartRadius: 20, elevation: 0,
                        margin: 0, position: 'absolute', bottom: 0,
                        paddingBottom: 5, paddingTop: 5, fontSize: 10
                    },
                    headerShown: false,
                    //headerStyle: {backgroundColor: '#FFF'},
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

                })}>
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
                <Tab.Screen name={profileName} component={ProfileStackScreen}
                            listeners={({navigation}) => ({
                                tabPress: event => {
                                    event.preventDefault();
                                    //navigation.navigate(LoginName);
                                    openModal(navigation);
                                }
                            })}
                />
            </Tab.Navigator>
        );
    }

    const openModal = (navigation) => {
        console.log('open modal.....');
        if (token) {
            navigation.navigate(profileName);
        } else {
            console.log('open modal.. no token exist');
            navigation.navigate(LoginName);
        }
    }

    return (
        <NavigationContainer>
            <RootStack.Navigator
                initialRouteName={homeName}
                screenOptions={{
                    animationEnabled: false,
                    headerShown: false,
                    presentation: "modal"
                }}
            >

                <RootStack.Group>
                    <RootStack.Screen name="Home" component={TabsApp}/>

                </RootStack.Group>
                <RootStack.Group screenOptions={{
                    presentation: 'transparentModal',
                    animationType: "slide"
                }}>
                    <RootStack.Screen name={LoginName} component={LoginScreen}
                                      options={{
                                          animationEnabled: true,
                                          cardOverlayEnabled: true
                                      }}
                    />
                </RootStack.Group>
            </RootStack.Navigator>
        </NavigationContainer>
    );
}

const styles = StyleSheet.create({
    container: {},
});
