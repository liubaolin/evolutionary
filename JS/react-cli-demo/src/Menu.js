import React, {Component} from 'react';
import './Menu.css';
import MenuItem from './MenuItem';


class Menu extends Component {


    render() {
        return (
            <div className="menu">
                {this.props.menuItems.map(menuItem => (
                    <MenuItem key={menuItem} value={menuItem} onClick={() => this.props.onClick(menuItem)}/>
                ))}
            </div>
        );
    }
}

export default Menu;