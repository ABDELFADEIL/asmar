import React, {useState} from 'react';
import Icon from 'react-native-vector-icons/FontAwesome';
import {getShoppingCartItems, RemoveItem, UpdateItemQuantity} from "../../services/commandLineService";
import * as PropTypes from "prop-types";
import {Image, Pressable, StyleSheet, Text, View} from "react-native";
import FontAwesome5Icon from "react-native-vector-icons/FontAwesome5";


const CommandLine = ({setCommandLines, commandLine}) => {

    const [command, setCommand] = useState(commandLine);

    const getImagePrincipal = () => {
        if (commandLine.product.urlImages.length !== 0) {
            return command.product.urlImages.find((img) => img.principal == true).url;
        } else {
            return "https://m.media-amazon.com/images/I/51XgqzfXiiL._AC_.jpg";
        }

    }


    const removeItem = () => {
        console.log(command.id);
        RemoveItem(command.id).then(res => {
            console.log(res);
            getShoppingCartItems(34).then(res => {
                setCommandLines(res.data);
            }).catch(error => {
                console.log(error)
            })

        }).catch(error => console.log(error));
    }
    const updateItemQuantity = (id, quantity) => {
        console.log(id, quantity);
        UpdateItemQuantity(id, quantity).then(res => {
            if (command.quantity + quantity > 0) {
                setCommand(res.data);
            }
            getShoppingCartItems(34).then(res => {
                setCommandLines(res.data);
            }).catch(error => {
                console.log(error)
            });
            console.log(command);
        }).catch(error => console.log(error));

    }
    return (
        <View style={styles.cart}>
            <View style={styles.cartImage}>
                <Image source={{uri: getImagePrincipal()}} style={styles.imageItem}/>
            </View>
            <View style={styles.cartText}>
                <View style={styles.cartTitle}>
                    <Text>
                        {command.product.label}
                    </Text>
                    <Text>
                        {command.product.description}
                    </Text>
                </View>
                <View style={styles.cartPrice}>
                    <Text style={styles.itemPrice}>{command.price}€</Text>
                </View>
                <View style={styles.cartQuantity}>
                    <Pressable  onPress={() => updateItemQuantity(command.id, -1)}>
                        <Text style={styles.quantityMin}>-</Text>
                    </Pressable>
                    <Pressable>
                        <Text style={styles.quantityQty}>{command.quantity}</Text>
                    </Pressable>
                    <Pressable  onPress={() => updateItemQuantity(command.id, 1)}>
                        <Text style={styles.quantityPlus}>+</Text>
                    </Pressable>
                </View>
            </View>
            <View style={styles.cartRemove}>
                <Pressable onPress={removeItem}>
                    <Text>
                        <Icon name="times" size={13} color="rgba(0, 59, 73, 0.47)"/>
                    </Text>
                </Pressable>
            </View>
        </View>

    );
}

CommandLine.propTypes = {
    commandLine: PropTypes.object,
    setCommandLines: PropTypes.func
};

CommandLine.defaultProps = {
    commandLine: null,
};

export default CommandLine;

const styles = StyleSheet.create({
    cart: {
        backgroundColor: 'white',
        justifyContent: 'center',
        flexDirection: 'row',
        marginBottom: 10,
        width: '100%',
        borderRadius: 5

    },
    cartText: {
        flex: 3,
        marginRight: 5,
        marginLeft: 5,
        justifyContent: 'center',
        alignItems: 'flex-start'
    },
    cartImage: {

    },
    cartRemove: {
        width: 10,
        textAlign: 'center',
        marginRight: 10,
        alignSelf: 'center',
    },
    cartQuantity: {
        flexDirection: 'row',
        marginLeft: 10

    },
    imageItem: {
        width: 76,
        height: 110,
    },
    quantityPlus: {
        fontSize: 24,
        backgroundColor: '#003B494C',
        borderWidth: 1,
        borderStyle: 'solid',
        borderColor: '#003B49',
        borderRadius: 20,
        width: 30,
        height: 30,
        margin: 'auto',
        textAlign: 'center',
        lineHeight:  28,

    },
    quantityMin: {
        fontSize: 24,
        backgroundColor: '#003B494C',
        borderWidth: 1,
        borderStyle: 'solid',
        borderColor: '#003B49',
        borderRadius: 20,
        width: 30,
        height: 30,
        margin: 'auto',
        textAlign: 'center',
        lineHeight:  28,
    },
    quantityQty: {
        fontSize: 22,
        marginLeft: 10,
        marginRight: 10
    },
    cartTitle: {
        marginLeft: 10,

    },
    cartPrice: {
        marginLeft: 10,
        marginTop: 5,
        marginBottom: 5,

    },
    itemPrice: {
        color: 'red'
    }
});