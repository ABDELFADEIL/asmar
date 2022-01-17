import React from 'react';
import './Navbar.css';
import {Link} from "react-router-dom";
import logo from "../assets/asmar_logo.png"
import {FaSearch, FaShoppingBasket, FaUser, FaUserCircle} from "react-icons/fa";
import { FaHeart } from "react-icons/fa";
import {IoBasket, MdOutlineShoppingBasket, MdShoppingBasket} from "react-icons/all";



export default function Navbar({title, navigation}) {

    return (
        <nav>
            <Link to="/"><img src={logo} className="logo"/></Link>
            <div>
                <ul className="nav-links">
                    <Link to="/">
                        <li>NOUVEAUTE</li>
                    </Link>
                    <Link to="/categories">
                        <li>VISAGE</li>
                    </Link>
                    <Link to="/categories">
                        <li>CHEVEAUX</li>
                    </Link>
                    <Link to="/categories">
                        <li>CORP</li>
                    </Link>
                    <Link to="/categories">
                        <li>PARFUM</li>
                    </Link>
                    <Link to="/categories">
                        <li>VÊTEMENTS</li>
                    </Link>
                </ul>
            </div>
            <div>
                <ul className="nav-links nav-right">
                    <Link to="/search">
                        <li><FaSearch /></li>
                    </Link>
                    <Link to="/profile">
                        <li><FaUser /></li>
                    </Link>
                    <Link to="/chopping-cart">
                        <li><MdShoppingBasket /></li>
                    </Link>
                </ul>
            </div>
        </nav>

    );
}

