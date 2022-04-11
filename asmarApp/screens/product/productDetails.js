import React, { useEffect, useState } from 'react';
import {productService} from '../../services/productService';
import { Button } from 'react-native-paper';
import {StyleSheet, Text, View, Image, SafeAreaView, ScrollView, PixelRatio} from 'react-native';
import {onAddProductToCart} from "../../services/commandLineService";
import {GET_JWT_TOKEN, userInfo} from "../../services/userService";
import {PickerItem} from "../../components/pickerItem";


// const ProductDetailsScreen = (navigation) =>{
const ProductDetailsScreen = () => {
    const [productDetails, setProductDetails] = useState({});
    const [urlImages, setUrlImages]= useState([]);
    const [imagePrincipal,setImagePrincipal] =useState(null);
    const [noImagePrincipal, setNoImagePrincipal] = useState([]);
    const [selectedQty, setSelectedQty] = useState(1);


    const getProductDetailsById = () => {
      let id = navigation?.route?.params?.idProduct??1;
        productService
            // .getProductDetailsById(id)
            // .getProductDetailsById(1)
            .getProductById(1)
            .then((res) => {
                setProductDetails(res.data);
                setSelectedQty(res.data.quantity)
                setUrlImages(res.data.urlImages);
                let imgTab = [];
                let firstImg = null;
                for (let item of res.data.urlImages) {
                    imgTab.push(item.url);
                    if (item.principal == true) {
                        firstImg = item.url;
                        setImagePrincipal(firstImg);
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
                               height: PixelRatio.getPixelSizeForLayoutSize( 118 +  (noImagePrincipal.length )),
                               resizeMode:'stretch',
                           }}
                           alt="principal"/>
                </View>
            </View>
        )
    }

    const addProductToCart = async () => {
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
        onAddProductToCart(commandLine).then(response => {
            console.log(response);
        }).catch(error => console.log(error));
    }
    const renderButton= () => {
        return (
            <Button icon="cart" mode="contained"
                    style={{width:95
                        , height: 25, backgroundColor:
                            '#003B49', padding:0, margin:10,marginLeft:20,marginTop:15}} labelStyle={{color:'#F4D19E' , fontSize: 10,marginTop: 7}}
                    onPress={() => { addProductToCart();}}>
                Ajouter
            </Button>
        )};

    return (
        <>
            <SafeAreaView style={styles.container}>
                <ScrollView>
                    <View style={{padding: 20,
                        flexDirection: "row"}} >

                        {urlImages.length ? renderUrlImages(urlImages) :null}
                        {urlImages.length ? renderImageP(urlImages) :null}
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
                        <Text style={{color: productDetails.quantity > 0 ? 'green' : 'red',paddingLeft:20,paddingBottom:0}}>
                            Status :{''}
                            {productDetails.quantity > 0 ? 'disponible' : 'épuisé'}
                        </Text>
                        <Text style={{paddingLeft:20,marginTop:20}}>Quantité:</Text>
                        <PickerItem quantity={productDetails.quantity} setSelectedQty={setSelectedQty} />

                        {/*<PickerItem quantity={productDetails.quantity} setSelectedQty={setSelectedQty} />*/}
                        <View>
                        {(renderButton())}
                        </View>

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
        flex: 1,
        paddingTop: 40,
        marginBottom: 40,
    },
    imagePrincipal: {
        width: 160,
    },
    text: {
        color: '#003B49',
        fontWeight: 'bold',
        paddingLeft: 20,
    },
});




