import React from 'react';
import { View, Text, StyleSheet, Button } from "react-native";


const ScreenContainer = ({ children }) => (
    <View style={styles.container}>{children}</View>
  );



  const styles = StyleSheet.create({
    container: {
      flex: 1,
      justifyContent: "center",
      alignItems: "center"
    }
  });