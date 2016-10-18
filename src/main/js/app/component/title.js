'use strict';

const React = require('react');

const styles = {
  title: {
    display: 'flex',
    flexDirection: 'row',
    alignItems: 'baseline',
    alignContent: 'stretch',
    justifyContent: 'center',
    flexWrap: 'nowrap',
    padding: '1rem',
    backgroundColor: '#cf4646',
    color: 'white'
  },
  h1: {
    fontWeight: 300,
    fontSize: '4rem',
    margin: '1rem'
  }
};

module.exports = class Title extends React.Component {
  render() {
    return (
      <div style={styles.title}>
        <img src="img/hello-kitty1.jpg" alt="Hello Kitty 1" height="150" width="150"/>
        <h1 style={styles.h1}>Hello Offer Manager!</h1>
        <img src="img/hello-kitty2.jpg"  alt="Hello Kitty 2" height="150" width="150"/>
      </div>
    );
  }
};
