'use strict';

const React = require('react');

const styles = {
  footer: {
    padding: '0.5rem',
    fontSize: '1rem',
    backgroundColor: '#1f1f1f',
    textAlign: 'center',
    color: 'white'
  }
};

module.exports = class Footer extends React.Component {
  render() {
    return (
      <footer style={styles.footer}>
        &copy; Adam Faryna <a href="http://appdy.net">appdy.net</a>
      </footer>
    );
  }
};
