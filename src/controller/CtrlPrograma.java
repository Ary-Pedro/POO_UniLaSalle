package controller;

import viewer.JanelaPrincipal;

public class CtrlPrograma {

	//
	// ATRIBUTOS DE RELACIONAMENTO
	//
	// O CtrlPrograma deve ter um atributo para referenciar a janela
	// com o menu principal do sistema e um atributo para cada caso de
	// uso que o usuário puder disparar a partir desse menu.
	//
	private JanelaPrincipal janela;
	private CtrlIncluirPessoa ctrlIncluirPessoa;
	private CtrlIncluirContaBancaria ctrlIncluirContaBancaria;

	//
	// MÉTODOS
	//
	public CtrlPrograma() {
		this.janela = new JanelaPrincipal(this);
		this.ctrlIncluirPessoa = null;
		this.ctrlIncluirContaBancaria = null;
	}

	public void iniciarIncluirPessoa() {
		// Verificando se o caso de uso não está em execução
		if (this.ctrlIncluirPessoa == null)
			// Se não estiver, inicio a execução do caso de uso
			this.ctrlIncluirPessoa = new CtrlIncluirPessoa(this);
		else
			// Se já estou executando o caso de uso, aviso que a funcionalidade está rodando
			this.janela.notificar("Você já iniciou a funcionalidade de Incluir Pessoa");
	}

	public void finalizarIncluirPessoa() {
		this.ctrlIncluirPessoa = null;
	}

	public void iniciarIncluirContaBancaria() {
		// Verificando se o caso de uso não está em execução
		if (this.ctrlIncluirContaBancaria == null)
			// Se não estiver, inicio a execução do caso de uso
			this.ctrlIncluirContaBancaria = new CtrlIncluirContaBancaria(this);
		else
			// Se já estou executando o caso de uso, aviso que a funcionalidade está rodando
			this.janela.notificar("Você já iniciou a funcionalidade de Incluir Conta Bancária");
	}

	public void finalizarIncluirContaBancaria() {
		this.ctrlIncluirContaBancaria = null;
	}

	public void encerrarPrograma() {
		this.janela.notificar("Encerrando o programa!");
		this.janela.fechar();
		System.exit(0);
	}

	public static void main(String[] args) {
		new CtrlPrograma();
	}
}
