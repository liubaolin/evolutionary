import React from "react";

export default class Clock extends React.Component {

    constructor(props) {
        super(props);
        console.log("Clock consructed");
        this.state = {date: new Date()};
    }

    componentDidMount() {
        console.log("Clock did mount");
        this.timerID = setInterval(() => this.tick(), 1000);
    }

    componentWillUnmount() {
        console.log("Clock will unmount");
        clearInterval(this.timerID);
    }

    componentDidUpdate() {
        console.log("Clock did update");
    }


    tick() {
        this.setState({
            date: new Date()
        });
    }


    render() {
        return (
            <div>
                <h1>时钟</h1>
                <h2>时间：{this.state.date.toLocaleTimeString()}</h2>
            </div>
        )

    }


}