import React, {Component} from 'react';
import PropTypes from 'prop-types';
import {bindActionCreators} from 'redux';
import {connect} from 'react-redux';
import * as actions from './redux/actions';
import {BrowserRouter as Router,Link,NavLink} from 'react-router-dom';

import { Icon } from 'antd';

const headerLogoSrc = "http://blog-pic-1254088127.picsh.myqcloud.com/猪logo.jpg";

export class NavHeader extends Component {
    static propTypes = {
        actions: PropTypes.object.isRequired,
        navHeader: PropTypes.object.isRequired
    };


    rendeHeader() {
        let toggleHeader = this.props.navHeader.headerToggled;
        return toggleHeader ? this.showHeader() : this.hidenHeader();
    }

    showHeader() {
        return (
            <div className="nav-header-nav-header">
                <header className="app-header">
                    <img src={headerLogoSrc} className="app-logo" alt="logo"/>
                    <div>
                        <div className="app-navbar-collapse">
                            <NavLink to="/home" className="app-nav-item" activeClassName="active">Home</NavLink>
                            <NavLink to="/about" className="app-nav-item" activeClassName="active">About</NavLink>
                            <NavLink to="/works" className="app-nav-item" activeClassName="active">Works</NavLink>
                            <NavLink to="/staff" className="app-nav-item" activeClassName="active">Staff</NavLink>
                            <NavLink to="/contact" className="app-nav-item" activeClassName="active">Contact</NavLink>
                            <NavLink to="/login" className="app-nav-item" activeClassName="active" >登录/注册</NavLink>
                        </div>
                    </div>

                    {/*<div className="nav-header-toggle-btn" onClick={this.props.actions.toggleHeader}><Icon type="to-top" /></div>*/}

                </header>

            </div>
        );
    }
    hidenHeader(){
        return (
            <header className="app-header">
                {/*<div className="nav-header-toggle-btn" onClick={this.props.actions.toggleHeader}><Icon type="vertical-align-bottom" /></div>*/}
            </header>
        );
    }

    render() {
        return (
            <div>
                {this.rendeHeader()}
            </div>
        );
    }
}

/* istanbul ignore next */
function mapStateToProps(state) {
    return {
        navHeader: state.navHeader
    };
}


/* istanbul ignore next */
function mapDispatchToProps(dispatch) {
    return {
        actions: bindActionCreators({...actions}, dispatch)
    };
}

export default connect(mapStateToProps, mapDispatchToProps)(NavHeader);
