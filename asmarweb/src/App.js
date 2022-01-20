import logo from './logo.svg';
import './App.css';
import Navbar from "./components/header/Navbar";
import React, {Fragment} from "react";
import 'bootstrap/dist/css/bootstrap.min.css';
import {Router, Switch, Route, Routes, BrowserRouter} from "react-router-dom";

import HomeScreen from "./screens/home/home";
import ProfileScreen from "./screens/profile/profile";
import ProductScreen from "./screens/product/product";
import SearchScreen from "./screens/search/search";
import LoginScreen from "./screens/autentication/login";
import SignUpScreen from "./screens/autentication/signUp";
import CategoriesScreen from "./screens/categories/categories";
import ShoppingCartScreen from "./screens/shoppingCart/shopping_cart";
import Footer from "./components/footer/Footer";

function App() {
    return (
        <Fragment>
            <BrowserRouter>
                <div className="App">
                    <Navbar/>
                    <div className="Main">
                        <Routes>
                            <Route exact path="/" element={<HomeScreen/>}/>
                            <Route path="/categories" element={<CategoriesScreen/>}/>
                            <Route path="/search" element={<SearchScreen/>}/>
                            <Route path="/product-details" element={<ProductScreen/>}/>
                            <Route path="/profile" element={<ProfileScreen/>}/>
                            <Route path="/login" element={<LoginScreen/>}/>
                            <Route path="/signup" element={<SignUpScreen/>}/>
                            <Route path="/shopping-cart" element={<ShoppingCartScreen/>}/>
                        </Routes>
                    </div>
                    <Footer/>
                </div>
            </BrowserRouter>
        </Fragment>
    );
}

export default App;
