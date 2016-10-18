'use strict';

const React = require('react');
const ReactDOM = require('react-dom');
const Router = require('react-router').Router;
const Route = require('react-router').Route;
const browserHistory = require('react-router').browserHistory;
const Main = require('./component/main');

ReactDOM.render(
  <Router history={browserHistory}>
    <Route path="/" component={Main}/>
  </Router>,
  document.getElementById('react')
);
