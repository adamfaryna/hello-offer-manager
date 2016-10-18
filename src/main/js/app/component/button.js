'use strict';

const React = require('react');

module.exports = class Button extends React.Component {
  static get propTypes() {
    return {
      action: React.PropTypes.func.isRequired
    }
  }

  render() {
    return (
      <button onClick={this.props.action}>{this.props.children}</button>
    );
  }
};
