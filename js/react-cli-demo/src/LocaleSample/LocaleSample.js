import React from "react";

const enStrings = {
    submit: "Submit",
    cancel: "Cancel"
};

const cnStrings = {
    submit: "提交",
    cancel: "取消"
};

//创建一个上下文
const LocaleContext = React.createContext(enStrings);


class LocaleProvider extends React.Component{
    state = {
        locale: cnStrings
    };

    toggleLocale  = () => {
        const locale =
            this.state.locale === enStrings
                ? cnStrings
                : enStrings;
        this.setState({ locale });
    }

    render(){
        return (
            <LocaleContext.Provider value={this.state.locale}>
                <button onClick={this.toggleLocale}>切换语言</button>
                {this.props.children}

            </LocaleContext.Provider>

    );
    }
}

class LocaleButtons extends React.Component{
    render(){
        return (
            <LocaleContext.Consumer>
                {locale => (
                    <div>
                        <button>{locale.submit}</button>
                        <button>{locale.cancel}</button>
                    </div>
                )}
            </LocaleContext.Consumer>
        );
    }
}

export default () => (
    <div>
        <LocaleProvider>
            <div>
                <br />
                <LocaleButtons />
            </div>
        </LocaleProvider>
    </div>
)
