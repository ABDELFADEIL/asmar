import logo from './logo.svg';
import './App.css';
import Navbar from "./components/header/Navbar";
import React, { Fragment, useEffect, useState } from "react";
import 'bootstrap/dist/css/bootstrap.min.css';
import {
    BrowserRouter as Router,
    Route,
    Routes,
    Navigate,
    BrowserRouter
} from "react-router-dom";
import HomeScreen from "./screens/home/home";
import ProfileScreen from "./screens/profile/profile";
import ProductScreen from "./screens/product/product";
import {SearchScreen} from "./screens/search/search";
import LoginScreen from "./screens/autentication/login";
import SignUpScreen from "./screens/autentication/signUp";
import CategoriesScreen from "./screens/categories/categories";
import ShoppingCartScreen from "./screens/shoppingCart/ShoppingCartScreen";
import Footer from "./components/footer/Footer";
import OrderScreen from './screens/order/order';


const App = () => {
    return (
        <Fragment>
            <BrowserRouter>
                <div className="App">
                    <Navbar/>
                    <div className="Main">
                        <Routes>
                            <Route path="/home" element={<HomeScreen/>}/>
                            <Route path="/" element={<Navigate replace to="/home" />} />
                            <Route path="/categories" element={<CategoriesScreen/>}/>
                            <Route path="/categories/:id" element={<CategoriesScreen/>}/>
                            <Route path="/search" element={<SearchScreen/>}/>
                            <Route path="/product-details/:productId" element={<ProductScreen/>}/>
                            <Route path="/profile" element={<ProfileScreen/>}/>
                            <Route path="/login" element={<LoginScreen/>}/>
                            <Route path="/signup" element={<SignUpScreen/>}/>
                            <Route path="/shopping-cart" element={<ShoppingCartScreen/>}/>
                            <Route path="/order" element={<OrderScreen/>}/>
                        </Routes>
                    </div>
                    <Footer/>
                </div>
            </BrowserRouter>
        </Fragment>
    );
}

export default App;

