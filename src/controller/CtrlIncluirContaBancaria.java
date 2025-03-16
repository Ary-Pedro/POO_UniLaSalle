package controller;

import model.ContaBancaria;
import model.ModelException;
import model.Pessoa;
import viewer.JanelaContaBancaria;

public class CtrlIncluirContaBancaria extends CtrlAbstrato {
	//
	// ATRIBUTOS 
	// 
	// Todo Controlador deve ter um atributo para guardar a referência
	// para o objeto viewer com quem se relaciona.
	//
	private JanelaContaBancaria janela;	
	private ContaBancaria       contaBancariaCriada;
	
	//
	// MÉTODOS
	//
	public CtrlIncluirContaBancaria(CtrlPrograma c) {
		super(c);
		this.contaBancariaCriada = null;
		this.janela = new JanelaContaBancaria(this);
	}
	
	public void efetuarInclusao(int numero, double limite, double saldo) {
		try {
			this.contaBancariaCriada = new ContaBancaria(numero, limite, saldo);
		} catch (ModelException e1) {
			this.janela.notificar("Erro: " + e1);
			return;
		}
		// TODO Fazer os procedimentos de persistência
		
		this.finalizar();
	}
	
	public void finalizar() {
		this.janela.finalizar();
		this.getCtrlPai().ctrlFilhoFinalizado(this);
	}

	/**
	 * Retorna a referência para a conta bancária gerada (se tudo 
	 * ocorreu corretamente) ou null (se o caso de uso não terminou
	 * ou se houve falha na execução)
	 */
	public Object getBemTangivel() {
		return this.contaBancariaCriada;
	}
}
