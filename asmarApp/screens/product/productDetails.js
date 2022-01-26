import React, { useEffect, useState } from 'react';
import { StyleSheet, Text, View } from "react-native";
import { productService } from '../../services/productService';



export default function ProductScreen({ navigation }) {
    const [qty, setQty] = useState(1);
    const [productDetails, setProductDetails] = useState({});
    const [urlImages, setUrlImages]= useState([]);
    const [imagePrincipal,setImagePrincipal] =useState(null);
    const [noImagePrincipal, setNoImagePrincipal] = useState([]);

    let ajouterPanier = () => {
    }

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

    return(
        <View style={{ flex: 1, alignItems: "center", justifyContent: "center"}}>
            <Text style={{ fontSize: 26, fontWeight: "bold"}}>Product Screen (Cheyu)</Text>
        </View>
    );

}



/*const styles = StyleSheet.create({});*/
