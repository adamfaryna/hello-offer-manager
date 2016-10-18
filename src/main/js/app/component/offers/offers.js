f 'use strict';

const React = require('react');
const client = require('../../service/client');
const OfferClient = require('../../service/offerClient');
const Offer = require('./offer');

const styles = {
  container: {
    margin: '1rem'
  },
  h2: {
    fontWeight: 300,
    fontSize: '1.5rem'
  },
  offers: {
    display: 'flex',
    flexDirection: 'row',
    flexWrap: 'wrap',
    justifyContent: 'space-around'
  }
};

module.exports = class Offers extends React.Component {
  constructor(props) {
    super(props);
    this.state = { offers: [] };
  }

  fetchOffers() {
    client({method: 'GET', path: '/api/offers'})
      .then(response => {
        this.setState({ offers: response.entity ? response.entity : [] });
      }, console.log);
  }

  componentDidMount() {
    this.fetchOffers();
    OfferClient.bind('change', () => { this.fetchOffers(); } );
  }

  componentWillUnmount() {
    OfferClient.unbind('change');
  }

  render() {
    return (
      <div style={styles.container}>
        <h2 style={styles.h2}>
          All stored offers:
        </h2>
        <div style={styles.offers}>
          {this.state.offers.map(function (offer, i) {
            return <Offer key={i} offer={offer}/>;
          })}
        </div>
      </div>
    );
  }
}
