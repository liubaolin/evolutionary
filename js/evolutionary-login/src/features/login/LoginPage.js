import React, {Component} from 'react';
import PropTypes from 'prop-types';
import {bindActionCreators} from 'redux';
import {connect} from 'react-redux';
import * as actions from './redux/actions';
import {default as NavHeader} from '../nav-header/NavHeader'
import {
    //BrowserRouter as Router,
    HashRouter as Router,
    Route,
    Link,
    NavLink,
    Switch
} from "react-router-dom";
import {Icon} from 'antd';

const foo = () => {

}

export const CommonLoginForm = ({match}) => {

    if (match.params.type === 'common') {
        return <form className="login-form" action="http://localhost:8080/authentication/form" method="post">
            <div className="login-form-item">
                <input className="input-prepend" type="text" name="username" placeholder="手机号或邮箱"/>

            </div>
            <div className="login-form-item">
                <input className="input-middle" type="password" name="password" placeholder="密码"/>
            </div>
            <div className="login-form-item">
                <input className="input-postpend input-check-code" type="text" name="imageCode" placeholder="验证码"/>
                <img className="img-checkcode" src="http://localhost:8080/code/image"/>
            </div>
            <div className="remember-btn">
                {/*这里的name必须是remember-me*/}
                <input type="checkbox" name="remember-me" value="true"/>
                <span>记住我</span>
            </div>
            <div className="login-problem">
                <NavLink to="/LoginForm/mobile">短信快捷登录</NavLink>
            </div>
            <button className="login-btn" type="submit">登录</button>
            <div className="more-signin">
                <h6 className="more-signin-title">社交帐号登录</h6>
                <ul>
                    <li>
                        <Link to="/WeCatLogin"><Icon type="wechat"/></Link>
                    </li>
                    <li>
                        <Link to="/WeCatLogin"><Icon type="qq"/></Link>
                    </li>
                </ul>
            </div>
        </form>
    } else {
        return <form action="/authentication/mobile" method="post">
            <table>
                <tr>
                    <td>手机号：</td>
                    <td><input type="text" name="mobile" value="13500010001"/></td>
                </tr>

                <tr>
                    <td>验证码</td>
                    <td>
                        <input type="text" name="smsCode"/>
                        <a href="/code/sms?mobile=13500010001">发送验证码</a>
                    </td>
                </tr>
                <tr>
                    <td colspan="2">
                        <button type="submit">登录</button>
                    </td>
                </tr>
            </table>
        </form>;
    }

}


export const MobileCodeLogin = () =>
    <form action="/authentication/mobile" method="post">
        <table>
            <tr>
                <td>手机号：</td>
                <td><input type="text" name="mobile" value="13500010001"/></td>
            </tr>

            <tr>
                <td>验证码</td>
                <td>
                    <input type="text" name="smsCode"/>
                    <a href="/code/sms?mobile=13500010001">发送验证码</a>
                </td>
            </tr>
            <tr>
                <td colspan="2">
                    <button type="submit">登录</button>
                </td>
            </tr>
        </table>
    </form>;


export const WeCatLogin = () =>
    <div>
        {/*/auth 是SocialAuthenticationFilter中拦截连接的前缀，可在配置中配置*/}
        {/*qq 是第三方个应用服务id,即providerId,是我们自定义的，也是可配置的*/}
        <a href="/auth/qq">QQ登录</a>
        <a href="/qqLogin/weixin">微信登录</a>
    </div>;

export const RegistForm = () =>
    <div>
        <h3>Not Implement yet.</h3>
    </div>


export class LoginPage extends Component {
    static propTypes = {
        login: PropTypes.object.isRequired,
        actions: PropTypes.object.isRequired,
    };

    render() {
        return (
            <div className="login-page">
                <NavHeader/>
                <div className="login-box">
                    <h4 className="login-type-title">
                        <NavLink to="/LoginForm/common" className="login-title-item"
                                 activeClassName="active">登录</NavLink>
                        <span className="login-item-separator">·</span>
                        <NavLink to="/RegistForm" className="login-title-item"
                                 activeClassName="active">注册</NavLink>
                    </h4>

                    <Route path="/LoginForm/:type" component={CommonLoginForm}/>
                    <Route path="/WeCatLogin" component={WeCatLogin}/>
                    <Route path="/RegistForm" component={RegistForm}/>
                </div>
                <div className="login-bottom">

                </div>
            </div>
        );
    }
}

/* istanbul ignore next */
function mapStateToProps(state) {
    return {
        login: state.login,
    };
}

/* istanbul ignore next */
function mapDispatchToProps(dispatch) {
    return {
        actions: bindActionCreators({...actions}, dispatch)
    };
}


export default connect(
    mapStateToProps,
    mapDispatchToProps
)(LoginPage);


