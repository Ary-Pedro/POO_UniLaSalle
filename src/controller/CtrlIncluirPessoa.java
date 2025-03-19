package controller;

import model.ModelException;
import model.Pessoa;
import model.dao.DaoPessoa;
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
		// experimente trocar por 
		// this.meuViewer = new ConsolePessoa(this);
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
		DaoPessoa dao = new DaoPessoa();
		dao.incluir(this.pessoaCriada);
		this.finalizar();
	}
	
	public void finalizar() {
		this.meuViewer.finalizar();
		this.getCtrlPai().ctrlFilhoFinalizado(this);
	}
	
	public Object getBemTangivel() {
		return this.pessoaCriada;
	}

}
