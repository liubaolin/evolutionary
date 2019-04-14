import React, {PureComponent} from 'react';
import PropTypes from "prop-types";
import './TabSelector.css'


class TabSelector extends PureComponent {
    static propTypes = {
        value: PropTypes.string,
        options: PropTypes.array,
        onChange: PropTypes.func

    }

    static defaultProps = {
        value: null,
        options: [],
        onChange: () => {
        }
    };

    render() {
        const {value, options, onChange} = this.props || TabSelector.defaultProps;
        return (
            <div className="tab-selector">
                <ul>
                    {options.map(opt => (
                        <li key={opt.value}
                            className={`tab-item ${opt.value === this.props.value ? "selected" : ""}`}
                            onClick={() => this.props.onChange(opt.value)}
                        >
                            {opt.name}
                        </li>
                    ))}
                </ul>

            </div>
        );
    }
}

export default TabSelector;

const options = [
    {name: "Red", value: "red"},
    {name: "Blue", value: "blue"},
    {name: "Orange", value: "orange"}
];


export class TabSelectorSample extends PureComponent {
    state = {
        color: null
    };

    render() {
        return (
            <div>
                Select color:{this.state.color}
                <TabSelector
                    options={options}
                    value={this.state.color}
                    onChange={c => this.setState({color: c})}/>
            </div>
        )
    }

}