import React, { useEffect, useState } from 'react';
import { productService } from '../../services/productService';
import { Button } from 'react-native-paper';
import {StyleSheet, Text, View, Image, SafeAreaView} from 'react-native';
import {GET_JWT_TOKEN, userInfo} from "../../services/userService";




const ProductDetailsScreen = () =>{

        const [productDetails, setProductDetails] = useState([]);
        const [urlImages, setUrlImages]= useState([]);
        const [imagePrincipal,setImagePrincipal] =useState(null);
        const [noImagePrincipal, setNoImagePrincipal] = useState([]);


    const getProductDetailsById = () => {
        productService
            .getProductDetailsById(1)
            .then((res) => {
                setProductDetails(res);
                console.log(res);
                setUrlImages(res.urlImages);
               let imgTab = [];
                let firstImg = null;
                for (let item of res.urlImages) {
                    console.log(item);
                    imgTab.push(item.url);
                    console.log(imgTab);

                    if (item.principal) {
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
/*    const renderUrlImages =() => (

                    <View>
                        {noImagePrincipal.map((img,i)=> (
                        <View style={styles.images}>
                                <Image source={img} key={i}
                                       style={{width: '100%', height: 100 / noImagePrincipal.length}}
                                       alt="productImage"/>
                        </View>
                            ))}
                        <View style={styles.imagePrincipal}>
                            <Image source={imagePrincipal}
                                   style={{height: 100 + 5 * (noImagePrincipal.length - 1), width: '100%'}}
                                   alt="principal"/>
                        </View>
                    </View>
    );*/


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
                    style={{width:100
                        , height: 30, backgroundColor:
                            '#003B49', padding: 0}} labelStyle={{color:'#F4D19E' , fontSize: 10,marginTop: 7}}
                    onPress={() => { addToCarts();}}>
                Ajouter
            </Button>
        )};

            return (
                <>
                    <SafeAreaView style={styles.container}>
            <View style={{padding: 50,
                          flexDirection: "row"}} >
                {/*{(renderUrlImages())}*/}
            </View>

                <View style={styles.images}>
                    {noImagePrincipal.map((img, index)=>(
                        <Image source={img} key={index} style={{ width: '100%', height: 40/noImagePrincipal.length}} alt="productImage"/>
                    ))}
                </View>
                <View style={styles.imagePrincipal}>
                    <Image source={imagePrincipal}style={{height: 40+ 5*(noImagePrincipal.length-1), width: '100%'}} alt="principal"/>
                </View>

                        <View>
                            <Text style={styles.text}>{productDetails.label}</Text>

                            <Text style={styles.text}>Origin : {productDetails.origin}</Text>
                            <Text style={styles.text}>Material : {productDetails.composition}</Text>
                            <Text style={styles.text}>{productDetails.usage_ ? (
                                <Text>Model d'emploi : {productDetails.usage_}</Text>) : null}
                            </Text>
                            <Text style={styles.text}>{productDetails.price ? (
                                <Text>Price : {productDetails.price}</Text>) : null} € </Text>
                        </View>
                    <View>

                            <Text style={{color: productDetails.quantity > 0 ? 'green' : 'red'}}>
                                Status :{''}
                                {productDetails.quantity > 0 ? 'disponible' : 'épuisé'}
                            </Text>
                    </View>
                     <View style={{marginTop: 5, color: '#003B49', marginLeft: 5}}>
                        {/* Quantité :{''}
                         <select value={selectedQty}
                                 onChange={(e) => {
                                     setSelectedQty(e.target.value);
                                 }
                                 } style={{width: 100, borderRadius: 2, marginLeft: 40}}>
                             {[...Array(productDetails.quantity).keys()].map((x) => (
                                 <option key={x + 1} value={x + 1}> {x + 1} </option>))}
                         </select>*/}
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
                                    {/* <style type="text/css">
                                         {`
                              .btn-flat {
                               background-color: darkGreen;
                               color: lightYellow;
                               border-radius:3rem;
                               margin-top: 1rem;
                              }

                               .btn-xxl {
                                padding: 0.5rem 2rem;
                                 font-size: 1rem;
                               }
                               `}
                                     </style>*/}



                                {/*  {productDetails.quantity > 0 && (
                        <Button icon="cart" mode="contained" style={{width: 110, height: 25, backgroundColor:
                                '#003B49',marginLeft: 20}} labelStyle={{color:'#F4D19E' , fontSize: 10,marginTop: 7}} onPress={() => console.log('Pressed')}
                        >
                            Ajouter
                        </Button>)}
*/}

                            {(renderButton())}
                     </View>

                            <Text  style={styles.text}>Description:{productDetails.description ? (<Text> Description : {productDetails.description}</Text>): null}
                            </Text>

                            <Text  style={styles.text}>Histoire:{productDetails.history ? (<Text> Histoire : {productDetails.history}</Text>): null}
                            </Text>


                    </SafeAreaView>
                    </>
            );
};


{/*            <View style={{flexDirection:"row"}}>
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
            <Text style={styles.text}>{productDetails.usage_  ? (<Text>Model d'emploi : {productDetails.usage_}</Text>): null }
            </Text>
            <Text  style={styles.text}>{productDetails.price ? (<Text>Price : {productDetails.price}</Text>): null} € </Text>
            <Text style={{color: productDetails.quantity > 0 ? 'green' : 'red'}}>
                Status :{''}
                {productDetails.quantity > 0 ? 'disponible' : 'épuisé'}
            </Text>
            <View>
                <Text style={{color: '#003B49'}}>
                    Quantité :{''}
                    <Picker
                        selectedValue={qty}
                        onValueChange={handleValueChange}
                        style={{width:100, borderRadius:2, marginLeft:40}}>


                        {[...Array(productDetails.quantity).keys()].map((x) => (<Picker.Item key={x+1} label={x} value={x+1}/>))}


                    </Picker>


                    {productDetails.quantity > 0 && (
                        <Button icon="cart" mode="contained" style={{width: 110, height: 25, backgroundColor:
                                '#003B49',marginLeft: 20}} labelStyle={{color:'#F4D19E' , fontSize: 10,marginTop: 7}} onPress={() => console.log('Pressed')}
                        >
                            Ajouter
                        </Button>)}
                </Text>
            </View>

            <Text  style={styles.text}>{productDetails.description ? (<Text> Description : {productDetails.description}</Text>): null}
            </Text>

            <Text  style={styles.text}>{productDetails.history ? (<Text> Histoire : {productDetails.history}</Text>): null}
            </Text>
        </View>
        </>
    </SafeAreaView>
        </ScrollView>*/}


export default ProductDetailsScreen;
const styles = StyleSheet.create({

    container: {
        flex:1,
        paddingTop: 40,
    },
 /*   images:{
        height: 65,
        width: '30%' ,
        alignItems:'center',
    },
    imagePrincipal :{
        width: '70%',
        marginLeft: 5,
    },*/
    text: {
        color:'#003B49',
        fontWeight: 'bold',
    },
});

/*

,
text: {
    color:'#003B49',
        fontWeight: 'bold',
},
imagesContainer:{
    padding: 0,
},
*/

