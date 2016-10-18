'use strict';

const React = require('react');
const Footer = require('./footer');
const Title = require('./title');
const Offers = require('./offers/offers');
const ActionBar = require('./actionBar');

const styles = {
  container: {
    display: 'flex',
    flexDirection: 'column',
    minHeight: '100%'
  },
  main: {
    flex: 1,
    display: 'flex',
    flexDirection: 'column'
  }
};

module.exports = class extends React.Component {
  render() {
    return (
      <div style={styles.container}>
        <main style={styles.main}>
          <Title/>
          <ActionBar/>
          <Offers/>
        </main>
        <Footer/>
      </div>
    );
  }
};
