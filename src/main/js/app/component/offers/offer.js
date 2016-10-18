'use strict';

const React = require('react');

var styles = {
  offer: {
    height: '15rem',
    width: '18rem',
    border: '1px solid lightgray',
    borderRadius: '1rem',
    margin: '1rem',
    padding: '1rem'
  },
  h3: {
    fontSize: '1.5rem',
    margin: '0 0 2rem 0'
  }
};


module.exports = class extends React.Component {
  static get propTypes() {
    return {
      offer: React.PropTypes.object.isRequired
    }
  }

  render() {
    return (
      <div style={styles.offer}>
        <h3 style={styles.h3}>
          Id: {this.props.offer.id}
        </h3>
        <p>Name: {this.props.offer.name}</p>
        <p>Description: {this.props.offer.description}</p>
        <p>Price: {this.props.offer.price} {this.props.offer.currency}</p>
      </div>
    );
  }
};
