import { inherit } from "@uirouter/core";

export default class ComputadorController {
  constructor(computadorService) {
    var vm = this;
    this.name = 'Computadores';
    this.cp = {
      		nome: "",
      		monitores: [{
      			monitor1: {
      				nome: ""
      			},
      			
      			monitor2: {
      				nome: ""
      			},
			    monitor3: {
					nome: ""
				}
      		}]
        }
    
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
	  console.log(id);
  }
  
  teste(){
	  console.log(this.cp);
	  console.log(JSON.stringify(this.cp));
  }
}
ComputadorController.$inject = ['computadorService'];
