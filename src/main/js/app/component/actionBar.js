'use strict';

const React = require('react');
const Button = require('./button');
const client = require('../service/client');
const OfferClient = require('../service/offerClient');

const styles = {
  wrapper: {
    display: 'flex',
    justifyContent: 'center',
    alignItems: 'baseline',
    flexDirection: 'row',
    flexWrap: 'nowrap'
  }
};

function refreshView() {
  location.reload();
}

function addRandomOffer() {
  OfferClient.addRandomOffer();
}

class ActionBar extends React.Component {
  render() {
    return (
      <div style={styles.wrapper}>
        <Button action={addRandomOffer}>Add Random Offer</Button>
        <Button action={refreshView}>Refresh View</Button>
      </div>
    );
  }
}

module.exports = ActionBar;
