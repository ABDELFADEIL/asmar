import React, { useEffect, useState } from 'react';
import { productService } from '../../services/productService';
import { Button } from 'react-native-paper';
import {StyleSheet, Text, View, Image,SafeAreaView, Dimensions }from 'react-native';

export default function ProductScreen() {

        const [qty, setQty] = useState(1);
        const [productDetails, setProductDetails] = useState({});
        const [urlImages, setUrlImages]= useState([]);
        const [imagePrincipal,setImagePrincipal] =useState(null);
        const [noImagePrincipal, setNoImagePrincipal] = useState([]);


          const getProductDetailsById = () => {
            productService
                .getProductDetailsById(1)
                .then((res) => {
                    setProductDetails(res.data);
                    setUrlImages(res.data.urlImages);
                    let imgTab =[];
                    let firstImg = null;
                    for( let item of res.data.urlImages){
                        console.log(item);
                        imgTab.push(item.url);
                        console.log(imgTab);

                        if (item.principal){
                            firstImg = item.url;
                            setImagePrincipal(firstImg);
                            console.log(firstImg);
                        }
                    };
                    setNoImagePrincipal(imgTab) ;

                    console.log(res.data);
                })
                .catch(err => console.log(err))
        }
        useEffect(() => {
            getProductDetailsById();
        }, []);

    return (

        <SafeAreaView style={styles.container}>
                    <View style={{flexDirection:"row"}}>
                        <View style={styles.images}>
                            {noImagePrincipal.map((img, index)=>(
                                <Image source={img} key={index} style={{ width: '100%', height: 400/noImagePrincipal.length}} alt="productImage"/>
                            ))}
                        </View>
                       <View style={styles.imagePrincipal}>
                            <Image source={imagePrincipal}style={{height: 400+ 5*(noImagePrincipal.length-1), width: '100%'}} alt="principal"/>
                        </View>
                    </View>

                    <Text style={styles.text}>{productDetails.label}</Text>
                                <Text style={styles.text}>Origin : {productDetails.origin}</Text>
                        <Text style={styles.text}>Material : {productDetails.composition}</Text>
                            <Text style={styles.text}>{productDetails.usage_ && (<Text>Model d'emploi : {productDetails.usage_}</Text>)}
                            </Text>
                        <Text  style={styles.text}>{productDetails.price} € </Text>
                            <Text style={{color: productDetails.quantity > 0 ? 'green' : 'red'}}>
                                Status :{''}
                                {productDetails.quantity > 0 ? 'disponible' : 'épuisé'}
                            </Text>

                    <Text style={{color: '#003B49'}}>
                        Quantité :{''}
                        <select data={qty}
                                onChange={(e) => {
                                    setQty(e.target.value);
                                }
                                } style={{width:100, borderRadius:2, marginLeft:40}} >
                            {[...Array(productDetails.quantity).keys()].map((x) => (
                                <option key={x + 1} value={x + 1}> {x + 1} </option>))}
                        </select>

                            {productDetails.quantity > 0 && (
                                <Button icon="cart" mode="contained" style={{width: '110px', height: '25px', backgroundColor:
                                    '#003B49',marginLeft: '20px'}} labelStyle={{color:'#F4D19E' , fontSize: '10px',marginTop:'7px'}} onPress={() => console.log('Pressed')}
                                        >
                                    Ajouter
                                </Button>)}
                    </Text>

            <Text  style={styles.text}>{productDetails.description && (<Text> Description : {productDetails.description}</Text>)}
            </Text>

            <Text  style={styles.text}>{productDetails.history && (<Text> Histoire : {productDetails.history}</Text>)}
            </Text>
        </SafeAreaView>
        )
};

const styles = StyleSheet.create({

    container: {
        backgroundColor: '#fff',
        flexDirection: "column",
                        margin:0,
                        flex: 1,
    },
    text: {
        color:'#003B49',
        fontWeight: 'bold',
    },
    imagesContainer:{
        padding: 0,
    },
    images:{
    height: 65,
    width: '30%' ,
    alignItems:'center',
    gap: 5,
    },
    imagePrincipal :{
    width: '70%',
    marginLeft: 5,
    },
});
