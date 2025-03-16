package controller;

import model.ModelException;
import model.Pessoa;
import viewer.JanelaPessoa;

public class CtrlIncluirPessoa {
	//
	// ATRIBUTOS 
	// 
	// Todo Controlador deve ter um atributo para guardar a referência
	// para o objeto viewer com quem se relaciona.
	//
	private JanelaPessoa janela;
	private CtrlPrograma ctrlPai;
	
	//
	// MÉTODOS
	//
	public CtrlIncluirPessoa(CtrlPrograma c) {
		this.ctrlPai = c;
		this.janela = new JanelaPessoa(this);
	}
	
	public void efetuarInclusao(String cpf, String nome, int idade) {
		try {
			Pessoa p = new Pessoa(cpf, nome, idade);
		} catch (ModelException e1) {
			this.janela.notificar("Erro: " + e1);
			return;
		}
		// TODO Fazer os procedimentos de persistência
		
		this.finalizar();
	}
	
	public void finalizar() {
		this.janela.fechar();
		this.ctrlPai.finalizarIncluirPessoa();
	}

}
