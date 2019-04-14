import React, {PureComponent} from 'react';
import PropTypes from "prop-types";
import './TabSelector.css'


class AdvanceTabSelector extends PureComponent {
    static propTypes = {
        value: PropTypes.string,
        options: PropTypes.array,
        onChange: PropTypes.func,
        children: PropTypes.func

    }

    static defaultProps = {
        value: null,
        options: [],
        onChange: () => {},
        children: () => {}
    };

    render() {
        const {value, options, onChange} = this.props || AdvanceTabSelector.defaultProps;
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
                <br />
                <br />
                {this.props.value && this.props.children(this.props.value)}

            </div>
        );
    }
}

export default AdvanceTabSelector;

const options = [
    {name: "Red", value: "red"},
    {name: "Blue", value: "blue"},
    {name: "Orange", value: "orange"}
];


export class AdvanceTabSelectorSample extends PureComponent {
    state = {
        color: null
    };

    render() {
        return (
            <div>
                Select color:{this.state.color}
                <AdvanceTabSelector
                    options={options}
                    value={this.state.color}
                    onChange={c => this.setState({color: c})}>
                    {color => (
                        <span
                            style={{
                                display: "inline-block",
                                backgroundColor: color,
                                width: "40px",
                                height: "40px"
                            }}
                        />
                    )}
                </AdvanceTabSelector>
            </div>
        )
    }

}