// This is the JSON way to define React Router rules in a Rekit app.
// Learn more from: http://rekit.js.org/docs/routing.html

import {
  LoginPage,
} from './';

export default {
  path: 'login',
  name: 'Login',
  childRoutes: [
    { path: 'login-page', name: 'Login page', component: LoginPage, isIndex: true },
  ],
};
