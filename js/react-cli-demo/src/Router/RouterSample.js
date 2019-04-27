import React from "react";
import {
    //BrowserRouter as Router,
    HashRouter as Router,
    Route,
    Link,
    NavLink,
    Prompt,
    Redirect,
    Switch
} from "react-router-dom";

import {MemoryRouter} from "react-router";

import "./RouterSample.css";


const ReactPage = () => <h1>ReactPage</h1>;
const AngularPage = () => <h1>AngularPage</h1>;
const VuePage = () => <h1>VuePage</h1>;
const NavLinkPage = () => <h1>NavLinkPage</h1>;
const LoginPage = () => <h1>LoginPage</h1>;
const HomePage = () => <h1>HomePage</h1>;
const SwitchPage1 = () => <h1>SwitchPage1</h1>;
const SwitchPage2 = () => <h1>SwitchPage2</h1>;



export default class RouterSample extends React.PureComponent {
    render() {
        let formIsHalfFielledOut = true;
        let loggedIn = true;

        return (
            <Router>
                <div>
                    <ul id="menu">
                        <li>
                            <Link to="/LoginPage">LoginPage</Link>
                        </li>
                        <li>
                            <Link to="/ReactPage">ReactPage</Link>
                        </li>
                        <li>
                            <Link to="/AngularPage">AngularPage</Link>
                        </li>
                        <li>
                            <Link to="/VuePage">VuePage</Link>
                        </li>
                        <li>
                            <NavLink to="/NavLinkPage" activeClassName="selected">NavLinkPage</NavLink>
                        </li>
                        <li>
                            <Link to="/LoginPage" >LoginPage</Link>
                        </li>
                        <li>
                            <Link to="/SwitchPage" >SwitchPage</Link>
                        </li>
                    </ul>
                    {/*<Prompt to="/PromptPage" when={formIsHalfFielledOut} message="确定要离开吗？" />*/}


                    <div id="page-container">
                        <Route path="/ReactPage" component={ReactPage}/>
                        <Route path="/AngularPage" component={AngularPage}/>
                        <Route path="/VuePage" component={VuePage}/>
                        <Route path="/NavLinkPage" component={NavLinkPage}/>
                        <Route exact path="/LoginPage" render={() => (
                            loggedIn
                                ? (<Redirect to="/ReactPage"/>)
                                :(<HomePage/>)

                        )}/>
                       <Switch>
                           <Route path="/SwitchPage" component={SwitchPage1}/>
                           <Route path="/SwitchPage" component={SwitchPage2}/>
                       </Switch>


                    </div>
                </div>
            </Router>
        );
    }
}

