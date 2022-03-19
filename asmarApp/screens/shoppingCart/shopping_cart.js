import * as React from "react";
import {View, Text, StyleSheet, Button, Pressable} from "react-native";
import {useEffect, useState} from "react";
import {GET_JWT_TOKEN} from "../../services/userService";
import {Dimensions} from 'react-native';
import {getShoppingCartItems} from "../../services/commandLineService";
import * as PropTypes from "prop-types";
import CommandLine from "./commandLine";


export default function ShoppingCartScreen(navigation) {

    const windowWidth = Dimensions.get('window').width;
    const windowHeight = Dimensions.get('window').height;
    const [token, setToken] = useState(GET_JWT_TOKEN());
    const [commandLines, setCommandLines] = useState([]);

    function getShoppingCart(id) {
        console.log('id of user : ', id)
        getShoppingCartItems(id).then(res => {
            console.log(res.status);
            setCommandLines(res.data)
            console.log(res.data);
        }).catch(error => console.log(error));
    }

    useEffect(() => {
        getShoppingCart(34)
    }, []);

    return (
        <View style={styles.container}>
            <View>
                {commandLines.length == 0 ?
                    <View style={styles.emptyCart}>
                        <Text style={styles.emptyCartTextHead}>Votre panier est vide !</Text>
                        <Text style={styles.emptyCartText}>Ajouter des nouveaux articles à votre panier</Text>
                        <Pressable style={styles.button} onPress={() => console.log('navigate')}>
                            <Text style={styles.text}>Aller à la page catégories</Text>
                        </Pressable>
                    </View>
                    :
                    <View style={styles.cartItemsContainer}>
                        <View style={styles.cartItems}>
                            {commandLines.map((commandLine, index) =>
                                <CommandLine setCommandLines={setCommandLines} key={index} commandLine={commandLine}/>
                            )}
                        </View>
                    </View>
                }
            </View>
            <View>

            </View>
        </View>
    );

}

const windowWidth = Dimensions.get('window').width;
const windowHeight = Dimensions.get('window').height;

const styles = StyleSheet.create({
    container:
        {
            flex: 1,
            flexDirection: 'row',
            justifyContent: "center",


        },
    emptyCart: {
        justifyContent: 'center',
        flexDirection: 'column',
        alignItems: 'center',
        height: 400,
        backgroundColor: 'rgba(79,162,178,0.1)',
        width: 340,
        borderRadius: 4,
        marginTop: 20

    },
    cartItems: {
        flex: 1,
        backgroundColor: 'rgba(79,162,178,0.1)',
        width: windowWidth - (10 % windowWidth),
        borderRadius: 4,
        marginTop: 20,

    },
    emptyCartText: {
        textAlign: 'center',
        width: '100%',
        marginBottom: 20,
        marginTop: 10
    },
    emptyCartTextHead: {
        fontSize: 20,
        fontWeight: 'bold',

    },
    button: {
        alignItems: 'center',
        justifyContent: 'center',
        paddingVertical: 12,
        paddingHorizontal: 32,
        borderRadius: 4,
        elevation: 3,
        backgroundColor: '#003B49',
    },
    text: {
        fontSize: 16,
        lineHeight: 21,
        letterSpacing: 0.25,
        color: '#F3BD6E',
    }, cartItemsContainer: {
        flex: 1
    }


});

