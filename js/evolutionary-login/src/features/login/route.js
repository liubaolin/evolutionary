// This is the JSON way to define React Router rules in a Rekit app.
// Learn more from: http://rekit.js.org/docs/routing.html

import {LoginPage} from './';
import {CommonLoginForm} from './LoginPage';
import {WeCatLogin} from './LoginPage';
import {RegistForm} from './LoginPage';

export default {
    path: 'login',
    name: 'Login',
    childRoutes: [
        {path: 'login-page', name: 'Login page', component: LoginPage, isIndex: true},
        {path: 'LoginForm/:type', name: 'Login page', component: CommonLoginForm, isIndex: true},
        {path: 'WeCatLogin', name: 'Login page', component: WeCatLogin, isIndex: true},
        {path: 'RegistForm', name: 'Login page', component: RegistForm, isIndex: true},
    ]
};
