import React from 'react';
import { createBottomTabNavigator } from '@react-navigation/bottom-tabs';
import { StyleSheet, Text, View } from 'react-native';
import MainContainer from "./containers/mainContainer";


const Tab = createBottomTabNavigator();

export default class App extends React.Component{
  render()
  {
    return (
        <>
          <MainContainer/>
        </>

    );
  }

}

const styles = StyleSheet.create({
  container: {

  },
});
