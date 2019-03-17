routing.$inject = ['$stateProvider', '$urlRouterProvider'];

export default function routing($stateProvider, $urlRouterProvider) {
    let homeState = {
        name: 'home',
        url: '/home',
        templateUrl: './modulos/home/home.view.html',
        controller: 'HomeController',
        controllerAs: 'vm'
      }
      $stateProvider.state(homeState);
      
      let donoState = {
        name: 'dono',
        url: '/dono',
        templateUrl: './modulos/dono/dono.view.html',
        controller: 'DonoController',
        controllerAs: 'vm'
      }
      $stateProvider.state(donoState);
      
      let computadorState = {
        name: 'computador',
        url: '/computador',
        templateUrl: './modulos/computador/computador.view.html',
        controller: 'ComputadorController',
        controllerAs: 'vm'
      }
      $stateProvider.state(computadorState);
      
      $urlRouterProvider.otherwise('/home')  
}