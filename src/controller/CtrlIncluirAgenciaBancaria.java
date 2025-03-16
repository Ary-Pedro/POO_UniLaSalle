package controller;

import model.AgenciaBancaria;
import model.ContaBancaria;
import model.ModelException;
import viewer.JanelaAgenciaBancaria;

public class CtrlIncluirAgenciaBancaria extends CtrlAbstrato {
	//
	// ATRIBUTOS 
	// 
	// Todo Controlador deve ter um atributo para guardar a referência
	// para o objeto viewer com quem se relaciona.
	//
	private JanelaAgenciaBancaria janela;	
	private AgenciaBancaria       agenciaBancariaCriada;
	
	//
	// MÉTODOS
	//
	public CtrlIncluirAgenciaBancaria(CtrlPrograma c) {
		super(c);
		this.agenciaBancariaCriada = null;
		this.janela = new JanelaAgenciaBancaria(this);
	}
	
	public void efetuarInclusao(int numero, String endereco, String cidade) {
		try {
			this.agenciaBancariaCriada = new AgenciaBancaria(numero, endereco, cidade);
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
		return this.agenciaBancariaCriada;
	}
}
