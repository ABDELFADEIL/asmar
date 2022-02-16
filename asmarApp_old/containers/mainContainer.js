import * as React from 'react';
import { NavigationContainer } from '@react-navigation/native';
import { createBottomTabNavigator } from '@react-navigation/bottom-tabs';
import Ionicons from 'react-native-vector-icons/Ionicons';
import { StyleSheet, Text, View } from 'react-native';


// Screens
import HomeScreen from "./screens/home/home";
import CategoriesScreen from "./screens/categories/categories";
import ProfileScreen from "./screens/profile/profile";
import SearchScreen from "./screens/search/search";

// screen names
const homeName = "Accueil";
const profileName = "Profile";
const searchName = "Rechercher";
const categoriesName = "Categories";

export default function MainContainer() {
    return (
        <NavigationContainer>
            <Tab.Navigator
                initialRouteName={homeName}
                screenOptions={({route}) => ({
                    tabBarIcon: ({focused, color, size}) => {
                        let iconName;
                        let routeName = route.name;

                        if (routeName === homeName){
                            iconName = focused ? 'home' : 'home-outline'
                        }else if (routeName === profileName){
                            iconName = focused ? 'user' : 'user-outline'
                        }else if (routeName === searchName){
                            iconName = focused ? 'search' : 'search-outline'
                        }else if (routeName === categoriesName){
                            iconName = focused ? 'grip' : 'grip-outline'
                        }
                        return <Ionicons name={iconName} size={size} color={color}/>
                    },
                })}>
                <Tab.Screen name={homeName} component={HomeScreen}/>
                <Tab.Screen name={categoriesName} component={CategoriesScreen}/>
                <Tab.Screen name={profileName} component={ProfileScreen}/>
                <Tab.Screen name={searchName} component={SearchScreen}/>
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
