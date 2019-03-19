import { inherit } from "@uirouter/core";

export default class ComputadorController {
	
  constructor(computadorService) {
    let vm = this;
    
    this.name = 'Computadores';
    
    this.monitor1 = {nome: ""}
    
    this.monitor2 = {nome: ""}
    
    this.cp = {
      		nome: "",
      		monitores: []
    }
    
    this.deleteComputador =   function deleteComputador(id){
  	  if(computadorService.deleteComputador(id)){
  		setTimeout("location.reload(true);", 4500);  		  
  	  }
    }
    
    this.updateComputador = function updateComputador(computador){
  	  computadorService.updateComputador(computador);
    }
    
    this.saveComputador =  function saveComputador(){
    	if(this.monitor1.nome != ""){
    		this.cp.monitores.push(this.monitor1);
    	}
    	if(this.monitor2.nome != ""){
    		this.cp.monitores.push(this.monitor2);
    	}
    	
    	computadorService.saveComputador(this.cp);
    	
    	setTimeout("location.reload(true);", 4500);
    }
    
    this.aux;
    this.modal = function modal(computador){
    	this.aux = computador;
    }
    
    init();

    function init(){
      computadorService.getComputadores().then(function abc(resp) {
        vm.computadores = resp.data;
      });
    }
  }


}
ComputadorController.$inject = ['computadorService'];
