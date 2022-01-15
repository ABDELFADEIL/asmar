import React from 'react';
import { StyleSheet, Text, View, Image, ImageBackground } from 'react-native';
import { MaterialIcons } from '@expo/vector-icons';
import {Appbar} from 'react-native-paper';

export default function Header({ title, navigation }) {

    return (

            <View style={styles.header}>
                <View style={{ backgroundColor: "white", marginRight: 30 }}>
                    <Image source={require('../assets/asmar_logo.png')} style={styles.headerImage} />
                </View>
                <View style={{ }}>
                    <Text style={styles.headerText}>{title}</Text>
                </View>
            </View>

    );
}

const styles = StyleSheet.create({
    header: {
        width: '100%',
        height: '100%',
        flexDirection: 'row',
        alignItems: 'center',
        justifyContent: 'space-between',
        
    },
    headerText: {
        fontWeight: 'bold',
        fontSize: 20,
        color: '#F4D19E',
        letterSpacing: 1,
        alignSelf: 'flex-start'
    },
    icon: {
        position: 'absolute',
        left: 16,
    },
    headerTitle: {
        flexDirection: 'row'
    },
    headerImage: {
        width: 40,
        height: 30,
        marginHorizontal: 10
    },
});