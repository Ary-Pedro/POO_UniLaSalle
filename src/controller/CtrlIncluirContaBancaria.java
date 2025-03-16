package controller;

import model.ContaBancaria;
import model.ModelException;
import model.Pessoa;
import viewer.JanelaContaBancaria;

public class CtrlIncluirContaBancaria {
	//
	// ATRIBUTOS 
	// 
	// Todo Controlador deve ter um atributo para guardar a referência
	// para o objeto viewer com quem se relaciona.
	//
	private JanelaContaBancaria janela;
	private CtrlPrograma        ctrlPai;
	
	//
	// MÉTODOS
	//
	public CtrlIncluirContaBancaria(CtrlPrograma c) {
		this.ctrlPai = c;
		this.janela = new JanelaContaBancaria(this);
	}
	
	public void efetuarInclusao(int numero, double limite, double saldo) {
		try {
			ContaBancaria conta = new ContaBancaria(numero, limite, saldo);
		} catch (ModelException e1) {
			this.janela.notificar("Erro: " + e1);
			return;
		}
		// TODO Fazer os procedimentos de persistência
		
		this.finalizar();
	}
	
	public void finalizar() {
		this.janela.fechar();
		this.ctrlPai.finalizarIncluirContaBancaria();
	}

}
