'use strict';

import angular from 'angular'
import uirouter from 'angular-ui-router';
var blockUI = require('angular-block-ui');

import 'bootstrap';
import './scss/app.scss';

import routing from './app.config';

import home from './modulos/home/home.js';
import computador from './modulos/computador/computador.js';

angular
.module('myApp', [
  uirouter,
  blockUI,
  computador, 
  home
])
.config(routing);