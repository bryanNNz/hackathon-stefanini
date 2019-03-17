import { inherit } from "@uirouter/core";

export default class ComputadorController {

  constructor(computadorService) {
    var vm = this;
    this.name = 'Computadores';

    init();

    function init(){
      computadorService.getComputadores().then(function abc(resp) {
        vm.computadores = resp.data;
      });
    }
  }
  
  updateComputador(id){
	  console.log(id);
  }
  
  deleteComputador(id){
	  console.log(id)
  }
}
ComputadorController.$inject = ['computadorService'];
