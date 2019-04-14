import React, {Component} from 'react';
import './Demo.css';
import Menu from './Menu';

import Hello from './Hello';
import CommentBox from './CommentBox/CommentBox';
import {TabSelectorSample} from './TabSelector/TabSelector';
import {AdvanceTabSelectorSample} from './TabSelector/AdvanceTabSelector';
import Clock from './Clock/Clock';
import SnapshotSample from './SnapshotSample/SnapshotSample';
import WithTimerTabSelector from './HOC/WithTimerTabSelector'
import LocaleSample from './LocaleSample/LocaleSample'


const routeMap = {
    "comment-box": CommentBox,
    "tab-selector": TabSelectorSample,
    "advance-tab-selector": AdvanceTabSelectorSample,
    "with-timer-tab-selector": WithTimerTabSelector,
    "clock": Clock,
    "snapshot-sample": SnapshotSample,
    "locale-sample": LocaleSample
};


class Demo extends Component {

    menuClick = key => {
        window.history.pushState(null, "", `/#/${key}`);
        this.forceUpdate();
    }


    render() {

        const currentPage = document.location.hash.replace(/#\/?/, "");
        let CurrentPage = routeMap[currentPage] || Hello;
        let menuItems = Object.keys(routeMap) || [];

        console.log("currentPage:" + currentPage);

        return (
            <div className="Demo">
                <div className="demo-header">
                    <img src="http://blog-pic-1254088127.picsh.myqcloud.com/wechatavatar.jpeg" className="demo-logo"
                         alt="logo"/>
                    <span className="header-title">React demo 代码片段演示项目</span>
                </div>

                <div className="demo-body">
                    <Menu menuItems={menuItems} onClick={(menuItem) => this.menuClick(menuItem)}/>
                    <div className="current-page">
                        <CurrentPage/>
                    </div>
                </div>
            </div>
        );
    }
}

export default Demo;
