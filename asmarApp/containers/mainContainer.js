import * as React from 'react';
import { NavigationContainer } from '@react-navigation/native';
import { createBottomTabNavigator } from '@react-navigation/bottom-tabs';
import Ionicons from 'react-native-vector-icons/Ionicons';
import {Image, StyleSheet, Text, TouchableOpacity, View} from 'react-native';
import { createNativeStackNavigator } from '@react-navigation/native-stack';

// Screens
import HomeScreen from "../screens/home/home";
import CategoriesScreen from "../screens/categories/categories";
import ProfileScreen from "../screens/profile/profile";
import SearchScreen from "../screens/search/search";
import ShoppingCartScreen from "../screens/shoppingCart/shopping_cart";
import productDetailsScreen from "../screens/product/productDetails";


// screen names
const homeName = "Accueil";
const profileName = "Profile";
const searchName = "Rechercher";
const categoriesName = "Categories";
const shppingCartName = "Panier";
const productDetailsName = "Détails de produit";

const Tab = createBottomTabNavigator();
const CustomTabBarButton = ({children, onPress}) =>(
    <TouchableOpacity
    style={{
        top: -35,
        justifyContent: 'center',
        alignItems: 'center',
    }}
    onPress={onPress}>
        <View
        style={{
            position: 'absolute',
            top: -35,
            width: 60,
            height: 60,
            backgroundColor: '#003B49',
            borderRadius: 30,
            borderWidth: 4,
            borderColor: '#FFF',
            justifyContent: 'center',
            alignItems: 'center',
        }}> {children}</View>
    </TouchableOpacity>
);
export default function MainContainer() {
    return (
        <NavigationContainer>
            <Tab.Navigator
                initialRouteName={homeName}
                screenOptions={({navigation, route}) => ({
                    tabBarStyle: { padding: 10, height: 60, backgroundColor: '#003B49',
                        borderTopEndRadius: 20, borderTopStartRadius: 20, elevation: 0,
                    margin: 0, position: 'absolute', bottom: 0},
                    headerShown: true,
                    headerStyle: { backgroundColor: '#FFF' },
                    tabBarIcon: ({focused, color, size}) => {
                        let iconName;
                        let routeName = route.name;

                        if (routeName === homeName){
                            iconName = focused ? 'home' : 'home';
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
                <Tab.Screen name={homeName} component={HomeScreen}
                            options={{
                                tabBarIcon: ({ focused }) => (

                                        <View
                                            style={{
                                            position: 'absolute',
                                            top: -35,
                                            width: 60,
                                            height: 60,
                                            backgroundColor: '#003B49',
                                            borderRadius: 30,
                                            borderWidth: 4,
                                            borderColor: '#FFF',
                                            justifyContent: 'center',
                                            alignItems: 'center',

                                        }}>
                                            <Ionicons style={{
                                                color: focused ? '#F7B14C' : '#F4D19E'
                                            }} name={'home'} size={30} color={'#F4D19E'}/>
                                        </View>

                                )
                            }}/>
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
