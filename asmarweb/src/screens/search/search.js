import React,{useState,useEffect} from "react";
import SearchItem from "../../components/SearchItem";
import {productService} from "../../services/productService";
import Row from "react-bootstrap/Row";
import ProductItem from "../../components/ProductItem";

export const SearchScreen = () => {

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

    return (
        <>
                    <div>
                        <main> <SearchItem setKeyword={setKeyword}/></main>
                 { products.length > 0 ?
                         <Row>
                             {products.map(product => (
                                 <ProductItem key={product.id} product={product}/>))}

                        </Row>  :
                            <h5 className="notfound">Oops! no products found!</h5>}

                    </div>
        </>
    );

};
