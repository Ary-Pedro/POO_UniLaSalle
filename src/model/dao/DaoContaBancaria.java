package model.dao;

import java.util.HashSet;
import java.util.Set;

import model.ContaBancaria;

public class DaoContaBancaria {
	//
	// ATRIBUTOS
	//
	private static Set<ContaBancaria> conjContasBancarias = new HashSet<ContaBancaria>();
	
	//
	// MÉTODOS
	//
	public DaoContaBancaria() {		
	}
	
	/**
	 * Método para darmos "persistência" a um novo objeto ContaBancaria
	 * @param p
	 * @return
	 */
	public boolean incluir(ContaBancaria p) {
		return DaoContaBancaria.conjContasBancarias.add(p);
	}
	
	public boolean alterar(ContaBancaria p) {
		return DaoContaBancaria.conjContasBancarias.add(p);
	}
	
	public boolean remover(ContaBancaria p) {
		return DaoContaBancaria.conjContasBancarias.remove(p);
	}
	
	public ContaBancaria consultarPorNumero(int numero) {
		for(ContaBancaria c : DaoContaBancaria.conjContasBancarias) 
			if(c.getNumContaCorrente() == numero)
				return c;
		return null;
	}
	
	public ContaBancaria[] consultarTodos() {
		int numElementos = DaoContaBancaria.conjContasBancarias.size();
		ContaBancaria[] arrayRetorno = new ContaBancaria[numElementos];
		int i = 0;
		for(ContaBancaria p : DaoContaBancaria.conjContasBancarias) 
			arrayRetorno[i++] = p;
		return arrayRetorno;
	}
}
