import React, {useState,useEffect} from 'react';
import { View, Text,ScrollView,SafeAreaView } from 'react-native';
import {SearchItem} from '../../components/searchItem';
import {ProductItem} from '../../components/productItem';
import {productService} from '../../services/productService';

export default function SearchScreen({navigation}) {

    const [products, setProducts] = useState([]);
    const [searchFail, setSearchFail] = useState(false);
    const [keyword, setKeyword] = useState('');

    const getProducts = () => {
        console.log(keyword);
        productService
            .getProductsBySearch(keyword)
            .then((res) => {
                setProducts(res.data);
                console.log(res.data);
            })
            .catch(err => console.log(err))
    };
    useEffect(() => {
        getProducts();
    }, [keyword])

    useEffect(() => {
        if (products && products.length < 1) {
            setSearchFail(true);
        } else setSearchFail(false);
    }, [products]);

    return(
       <SafeAreaView>
       <ScrollView>
           <View>
            <SearchItem setKeyword={setKeyword}/>
            { products ?
                <View>
                    {products.map(product => (
                        <ProductItem navigation={navigation} key={product.id} product={product}/>))}
                </View>  :
                <Text>Oops! no products found!</Text>}

        </View>
       </ScrollView>
       </SafeAreaView>

    );
};