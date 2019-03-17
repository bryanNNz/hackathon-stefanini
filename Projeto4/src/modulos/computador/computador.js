import angular from 'angular';
import uirouter from 'angular-ui-router';

import ComputadorController from './computador.controller';

import computadorService from '../../servicos/computador.service';

export default angular.module('myApp.computador', [uirouter, computadorService])
  .controller('ComputadorController', ComputadorController)
  .name;

  