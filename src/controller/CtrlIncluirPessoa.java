package controller;

import model.ModelException;
import model.Pessoa;
import viewer.IViewer;
import viewer.JanelaPessoa;

public class CtrlIncluirPessoa extends CtrlAbstrato {
	//
	// ATRIBUTOS 
	// 
	// Todo Controlador deve ter um atributo para guardar a referência
	// para o objeto viewer com quem se relaciona.
	//
	private IViewer      meuViewer;
	private Pessoa       pessoaCriada;
	
	//
	// MÉTODOS
	//
	public CtrlIncluirPessoa(ICtrl c) {
		super(c);
		this.meuViewer = new JanelaPessoa(this);
		this.pessoaCriada = null;
		this.meuViewer.apresentar();
	}
	
	public void efetuarInclusao(String cpf, String nome, int idade) {
		try {
			this.pessoaCriada = new Pessoa(cpf, nome, idade);
		} catch (ModelException e1) {
			this.meuViewer.notificar("Erro: " + e1);
			return;
		}
		
		// TODO Fazer os procedimentos de persistência
		
		this.finalizar();
	}
	
	public void finalizar() {
		// Fecho a apresentação do viewer
		this.meuViewer.finalizar();
		// Notifica ao caso de uso "pai" que o caso de uso "incluir pessoa" terminou!
		this.getCtrlPai().ctrlFilhoFinalizado(this);
	}
	
	public Object getBemTangivel() {
		return this.pessoaCriada;
	}

}
