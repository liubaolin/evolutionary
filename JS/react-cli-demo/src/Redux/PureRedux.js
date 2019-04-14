import React from "react";

import {
    createStore,
    combineReducers,
    bindActionCreators
} from "redux";

function run() {

    //Store initial state
    const initState = {count: 0};

    //recuder need state and action
    const counter = (state = initState, action) => {
        switch (action.type) {
            case "PLUS_ONE":
                return {count: state.count + 1};
            case "MINUS_ONE":
                return {count: state.count - 1};
            case "CUSTOM_COUNT":
                return {count: state.count + action.payload.count};
            default:
                break
        }
        return state;
    }

    const todos = (state = {}) => state;

    //Create Store need a Reducer
    //使用combineReducers将多个reducer封装成一个
    const store = createStore(combineReducers({
        counter,
        todos
    }))

    //Action creator
    function plusOne() {
        //action
        return {type: "PLUS_ONE"};
    }

    function minusOne() {
        return {type: "MINUS_ONE"};
    }

    function customCount(count) {
        return {type: "CUSTOM_COUNT", payload: {count}};
    }

    //使用bindActionCreators封装
    plusOne = bindActionCreators(plusOne, store.dispatch);

    store.subscribe(() => console.log(store.getState()))
    //store.dispatch(plusOne());
    plusOne();
    store.dispatch(minusOne());
    store.dispatch(customCount(5));
}

export default () => (
    <div>
        <button onClick={run}>Run</button>
        <p>打开控制台查看运行结果</p>
    </div>
)