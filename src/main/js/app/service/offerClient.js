'use strict';

const MicroEvent = require('microevent-github');
const client = require('./client');
const currencies = require('../constans').currencies;

function genRandomOffer() {
  return {
    name: (Math.random() + 1).toString(36).substring(2, 5),
    description: (Math.random() + 1).toString(36).substring(2, 5),
    currency: currencies[Math.floor(Math.random() * currencies.length)],
    price: (Math.random() * 1000 + 1)|0
  };
}

const OfferClient =  {
  addRandomOffer: function() {
    const randomOffer = genRandomOffer();
    const self = this;

    client({method: 'POST', path: '/api/offers', entity: randomOffer})
      .then( () => {
        self.trigger('change');
      }, console.log);
  }
};

MicroEvent.mixin(OfferClient);

module.exports = OfferClient;
