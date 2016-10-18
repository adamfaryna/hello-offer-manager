'use strict';

const React = require('react');

const styles = {
  header: {
    display: 'flex',
    alignItems: 'center',
    backgroundColor: '#1f1f1f'
  },
  title: {
    flex: 1,
    fontSize: '1.5rem',
    margin: '1rem'
  }
};

module.exports = class Header extends React.Component {
  render() {
    return (
      <header style={styles.header}>
        <p style={styles.title}>
          <a href="https://github.com/adamfaryna/Offer-Manager.git" target="_blank">
            Offer Manager
          </a>
        </p>
      </header>
    );
  }
};
