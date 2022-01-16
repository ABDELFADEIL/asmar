import React from 'react';
import './Navbar.css';
import {Link} from "react-router-dom";

export default function Navbar({title, navigation}) {

    return (
        <nav>
            <Link to="/"><h3 className="logo">logo</h3></Link>
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
                        <li>Chercher</li>
                    </Link>
                    <Link to="/profile">
                        <li>User</li>
                    </Link>
                    <Link to="/chopping-cart">
                        <li>Panier</li>
                    </Link>
                </ul>
            </div>
        </nav>

    );
}

