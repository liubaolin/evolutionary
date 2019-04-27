import React, { Component } from 'react';
import './Menu.css';


class MenuItem extends Component {


    render() {
        return (
            <div className="menu-item" onClick={() => this.props.onClick(this.props.value)}>
                {this.props.value}
            </div>
        );
    }
}

export default MenuItem;