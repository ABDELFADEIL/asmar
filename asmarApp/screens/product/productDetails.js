import React, { useEffect, useState } from 'react';
import {getProductById, productService} from '../../services/productService';
import { Button } from 'react-native-paper';
import {StyleSheet, Text, View, Image, SafeAreaView, ScrollView, PixelRatio} from 'react-native';
import {GET_JWT_TOKEN, userInfo} from "../../services/userService";
import {PickerItem} from "../../components/pickerItem";
const ProductDetailsScreen = () => {
    const [productDetails, setProductDetails] = useState({});
    const [urlImages, setUrlImages]= useState([]);
    const [imagePrincipal,setImagePrincipal] =useState(null);
    const [noImagePrincipal, setNoImagePrincipal] = useState([]);
    const [selectedQty, setSelectedQty] = useState(1);
    const getProductDetailsById = () => {

        getProductById(1)
            .then((res) => {
                setProductDetails(res.data);
                setSelectedQty(res.data.quantity)
                console.log(res.data);
                setUrlImages(res.data.urlImages);
                console.log(res.data.quantity);
                let imgTab = [];
                let firstImg = null;
                for (let item of res.data.urlImages) {
                    console.log(item);
                    imgTab.push(item.url);
                    console.log(imgTab);
                    if (item.principal == true) {
                        firstImg = item.url;
                        setImagePrincipal(firstImg);
                        console.log(firstImg);
                    }
                };
                setNoImagePrincipal(imgTab);
            })
            .catch(err => console.log(err))
    }
    useEffect(() => {
        getProductDetailsById();
    }, []);
    const renderUrlImages =(noImagePrincipal) => {
        return (
            <View>
                {noImagePrincipal.map((urlImages, i) => (
                    <View key={i} style={styles.images}>
                        <Image source={urlImages}
                               style={{width: PixelRatio.getPixelSizeForLayoutSize(30),
                                   height: PixelRatio.getPixelSizeForLayoutSize(120 / noImagePrincipal.length),
                                   resizeMode:'stretch',
                                   margin:1}}
                               alt="productImage"/>
                    </View>
                ))}
            </View>
        )
    }
    const renderImageP =(imagePrincipal) => {
        return (
            <View>
                <View style={styles.imagePrincipal}>
                    <Image source={imagePrincipal}
                           style={{width: PixelRatio.getPixelSizeForLayoutSize(60),
                               height: PixelRatio.getPixelSizeForLayoutSize( 120 + 3 * (noImagePrincipal.length + 1)),
                               resizeMode:'stretch',
                           }}
                           alt="principal"/>
                </View>
            </View>
        )
    }
    const renderQty = () => {
        return (
            <View>
                <Text style={{ color: '#003B49'}}>
                    Quantité :{''}
                </Text>
            </View>
        );
    };
    {/* <Text style={{ color: '#003B49'}}>
                Quantité :{''}
                <select value={selectedQty}
                        onChange={(e) => {
                            setSelectedQty(e.target.value);
                        }
                        }
                        style={{width: 100, borderRadius: 2, marginLeft: 40}}>
                    {productDetails.quantity.keys().map((x) => (
                        <option key={x + 1} value={x + 1}> {x + 1} </option>))}
                </select>
            </Text>*/}
    const addToCarts = async () => {
        const JWT = GET_JWT_TOKEN();
        console.log(JWT);
        const response = await userInfo(JWT);
        console.log(response);
        let commandLine = {
            userId: response.data.id,
            productId: productDetails.id,
            quantity: selectedQty
        }
        console.log(commandLine);
    }
    const renderButton= () => {
        return (
            <Button icon="cart" mode="contained"
                    style={{width:110
                        , height: 25, backgroundColor:
                            '#003B49', padding: 0, marginLeft:20}} labelStyle={{color:'#F4D19E' , fontSize: 10,marginTop: 7}}
                    onPress={() => { addToCarts();}}>
                Ajouter
            </Button>
        )};
    return (
        <>
            <SafeAreaView style={styles.container}>
                <ScrollView>
                    <View style={{padding: 20,
                        flexDirection: "row"}} >
                        {urlImages.length > 0 ? renderUrlImages(urlImages) :null}
                        {urlImages.length > 0 ? renderImageP(imagePrincipal) :null}
                    </View>
                    <View>
                        <Text style={styles.text}>{productDetails.label}</Text>
                        <Text style={styles.text}>Origin : {productDetails.origin}</Text>
                        <Text style={styles.text}>Material : {productDetails.composition}</Text>
                        <Text style={styles.text}>Model d'emploi : {productDetails.usage_}</Text>
                        <Text style={styles.text}>{productDetails.price ? (
                            <Text>Price : {productDetails.price}</Text>) : null} € </Text>
                    </View>
                    <View>
                        <Text style={{color: productDetails.quantity > 0 ? 'green' : 'red',paddingLeft:20}}>
                            Status :{''}
                            {productDetails.quantity > 0 ? 'disponible' : 'épuisé'}
                        </Text>
                    </View>
                    {/* <View style={{marginTop: 5, color: '#003B49', marginLeft: 5}}>
                         <Text style={{marginTop: 5, color: '#003B49', marginLeft: 5}}>
                         Quantité :{''}
                         <select value={selectedQty}
                                 onChange={(e) => {
                                     setSelectedQty(e.target.value);
                                 }
                                 } style={{width: 100, borderRadius: 2, marginLeft: 40}}>
                             {[...Array(productDetails.quantity).keys()].map((x) => (
                                 <option key={x + 1} value={x + 1}> {x + 1} </option>))}
                         </select>
                         </Text>*/}
                    {/* <Picker
                        selectedValue={qty}
                        onValueChange={(itemValue)=>
                            setQty(itemValue)}
                        style={{width:100, borderRadius:2, marginLeft:40}}>
                        {productDetails.quantity.keys().map((x) => (
                    <Picker.item label="quantity" value="1"/>
                        ))}
                        {[...Array(productDetails.quantity).keys()].map((x) => (<Picker.Item key={x+1} label={x} value={x+1}/>))}
                    </Picker>*/}
                    <View>
                        {/*      <Text style={{ color: '#003B49'}}>Quantité:</Text>*/}
                        {/*{productDetails.quantity > 0 ? renderQty() : null}*/}
                        <PickerItem quantity={productDetails.quantity} setSelectedQty={setSelectedQty} />
                    </View>
                    <View>
                        {(renderButton())}
                    </View>
                    <Text  style={styles.text}>Description:{productDetails.description ? (<Text> Description : {productDetails.description}</Text>): null}
                    </Text>
                    <Text  style={styles.text}>Histoire:{productDetails.history ? (<Text> Histoire : {productDetails.history}</Text>): null}
                    </Text>
                </ScrollView>
            </SafeAreaView>
        </>
    );
};
export default ProductDetailsScreen;
const styles = StyleSheet.create({
    container: {
        flex:1,
        paddingTop: 40,
    },
    imagePrincipal :{
        width: 160,
    },
    text: {
        color:'#003B49',
        fontWeight: 'bold',
        paddingLeft: 20,
    },
    picker: {
        marginVertical: 30,
        width: 300,
        padding: 10,
        borderWidth: 1,
        borderColor: "#666",
    },
});