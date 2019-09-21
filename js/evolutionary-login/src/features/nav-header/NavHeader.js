import React, {Component} from 'react';
import PropTypes from 'prop-types';
import {bindActionCreators} from 'redux';
import {connect} from 'react-redux';
import * as actions from './redux/actions';
import {Link} from 'react-router-dom';
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
                    <Link className="app-nav-bar-login" to="/login">登录/注册</Link>
                    <div className="app-navbar-collapse">
                        <Link to="/" className="app-nav-item active">Home</Link>
                        <Link to="/" className="app-nav-item">About</Link>
                        <Link to="/" className="app-nav-item">Works</Link>
                        <Link to="/" className="app-nav-item">Staff</Link>
                        <Link to="/" className="app-nav-item">Contact</Link>
                    </div>
                </header>
                <button onClick={this.props.actions.toggleHeader}><Icon type="up" /></button>

            </div>
        );
    }
    hidenHeader(){
        return (
            <div>
            </div>
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
