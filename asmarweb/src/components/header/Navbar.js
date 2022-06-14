import React, {Component} from 'react';
import './Navbar.css';
import {Link} from "react-router-dom";
import logo from "../../assets/asmar_logo.png"
import { FaSearch, FaUser } from "react-icons/fa";
import { MdShoppingBasket} from "react-icons/all";
import 'font-awesome/css/font-awesome.min.css';


export default class Navbar extends Component{
    state = { clicked: false, icon: "fa fa-bars"}


    render() {
        const { clicked } = this.state;
    return (
        <nav className="NavBarItems">
            <Link className="logo" to="/"><img width="60px" src={logo} /></Link>
            <div className="Menu-icon" onClick={this.handleClick}>
                <i className={clicked ? "fa fa-times": "fa fa-bars"}/>
            </div>
            <ul className={clicked ? 'nav-menu active': 'nav-menu'} >

                    <Link to="/" onClick={this.handleClick}>
                        <li>NOUVEAUTE</li>
                    </Link>
                    <Link to="/categories/3" onClick={this.handleClick}>
                        <li>VISAGE</li>
                    </Link>
                    <Link to="/categories/5" onClick={this.handleClick}>
                        <li>CHEVEAUX</li>
                    </Link>
                    <Link to="/categories/4" onClick={this.handleClick}>
                        <li>CORP</li>
                    </Link>
                    <Link to="/categories/1" onClick={this.handleClick}>
                        <li>PARFUM</li>
                    </Link>
                    <Link to="/categories/2" onClick={this.handleClick}>
                        <li>VÊTEMENTS</li>
                    </Link>

                    <Link to="/search" onClick={this.handleClick}>
                        <li><FaSearch /></li>
                    </Link>
                    <Link to="/profile" onClick={this.handleClick}>
                        <li><FaUser /></li>
                    </Link>
                    <Link to="/shopping-cart" onClick={this.handleClick}>
                        <li><MdShoppingBasket /></li>
                    </Link>
                </ul>
        </nav>

    );
    }

    handleClick = ()=> {
        //this.setState({clicked: !this.state.clicked});
        //this.setState(prevState => ({ clicked: !prevState.clicked }));
        this.setState((state) => ({
            clicked: !state.clicked
        }));
    }

    IconHeader = (clicked)=> {
        return (clicked) ? <i className='fa fa-times'/> : <i className='fa fa-bars'/>;
    }

    getIconClassNames(clicked) {
      return (clicked) ? 'fa fa-times' : 'fa fa-bars';
    }
}

