import angular from 'angular';

class ComputadorService {

    constructor($http) {
        this.$http = $http;
        //const apiBase = "http://localhost:9090/projeto/api";
        const apiBase = "http://localhost:8080";
        this.path =  apiBase + "/computador";
    }
    
    getComputadores() {
        return this.$http.get(this.path);
    }
}

export default angular.module('services.computador-service', [])
.service('computadorService', ComputadorService)
.name;