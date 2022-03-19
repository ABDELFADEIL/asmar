import * as React from "react";
import {View, Text, StyleSheet, Button, Pressable, SafeAreaView, ScrollView, StatusBar} from "react-native";
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
    const total = () => {
        let total = 0;
        commandLines.map((commandLine)=> {
            total = total + commandLine.price;
        });
        return total;
    }
    return (
        <SafeAreaView style={styles.container}>
        <ScrollView style={styles.scrollView}>
            <View style={{alignItems: 'center'}}>
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

                        <View style={styles.sum}>
                            <View style={styles.sumTitle}>
                                <Text style={styles.sumTitleText}>Recapitulatif de panier</Text>
                            </View>
                            <View style={styles.sumBody}>
                              <View style={styles.sumText}>
                                  <Text style={styles.sumTextText}>Nombre d'articles</Text>
                                  <Text style={styles.sumTextNum}>{commandLines.length}</Text>
                              </View>
                                <View style={styles.sumText}>
                                    <Text style={styles.sumTextText}>Prix total des articles</Text>
                                    <Text style={styles.sumTextNum}>{total()}€</Text>
                                </View>
                                <View style={styles.sumText}>
                                    <Text style={styles.sumTextText}>TVA (0%)</Text>
                                    <Text style={styles.sumTextNum}>0</Text>
                                </View>
                                <View style={styles.sumText}>
                                    <Text style={styles.sumTextText}>Total</Text>
                                    <Text style={styles.sumTextNum}>{total() + total() * 0}€</Text>
                                </View>
                            </View>
                            <View style={styles.sumBtn}>
                              <Text style={styles.sumBtnText}>Valider mon panier</Text>
                            </View>
                        </View>
                    </View>
                }
            </View>
        </ScrollView>
        </SafeAreaView>
    );

}

const windowWidth = Dimensions.get('window').width;
const windowHeight = Dimensions.get('window').height;

const styles = StyleSheet.create({
    container:
        {
            flex: 1,
            paddingBottom: StatusBar.currentHeight + 30,
            backgroundColor: 'rgba(79,162,178,0.1)',
            paddingTop: 0,
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
        width: windowWidth - (10 % windowWidth),
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
    },
    cartItemsContainer: {
        flex: 1,
        justifyContent: 'center',
        alignItems: 'center',
        marginTop: 10
    },
    sum: {
        backgroundColor: 'white',
        borderRadius: 10,
        padding: 10,
        marginBottom: 20,
        width: windowWidth - (10 % windowWidth)
    },
    sumTitle: {
        textAlign: 'center',
        alignSelf: 'center',

    },
    sumBody: {

    },
    sumBtn: {
        backgroundColor: '#F3BD6E',
        borderRadius: 15,
        height: 35,
        textAlign: 'center',
        paddingTop: 3,
        fontSize: 14,
        marginTop: 10
    },
    sumText: {
        flexDirection: 'row',
        justifyContent: 'space-between',
        marginLeft: 10,
        marginRight: 10,
        color: '#003B49',
    },
    sumTitleText: {
        fontSize: 16,
        fontWeight: 'bold',
        color: '#003B49',
    },
    containerSA: {
        flex: 1,
        paddingTop: StatusBar.currentHeight,
    },
    scrollView: {
        marginHorizontal: 0,
    },
    sumBtnText: {
        textAlign: 'center',
        fontSize: 20,
        color: '#003B49',
    },
    sumTextText: {
        marginBottom: 4,
        color: '#003B49',
    },
    sumTextNum: {
        marginBottom: 4,
        fontWeight: 'bold',
        color: '#003B49',
    }


});

