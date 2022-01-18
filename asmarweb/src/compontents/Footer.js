import React, {Component} from 'react';
import './footer.css';
import {Link} from "react-router-dom";
import logo from "../assets/asmar_logo.png"
import { FaSearch, FaUser } from "react-icons/fa";
import { MdShoppingBasket} from "react-icons/all";
import 'font-awesome/css/font-awesome.min.css';


export default class Footer extends Component{
    state = { clicked: false, icon: "fa fa-bars"}

    render() {
        const { clicked } = this.state;
    return (
        <nav className="FooterItems">
            <ul className='footer-menu' >

                    <Link to="/">
                        <li>A propos de nous</li>
                    </Link>
                    <Link to="/">
                        <li>Contact</li>
                    </Link>
                <Link to="/">
                    <li>Mentions légales</li>
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

