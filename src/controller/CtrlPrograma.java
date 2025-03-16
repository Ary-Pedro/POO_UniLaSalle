package controller;

import viewer.JanelaPrincipal;

public class CtrlPrograma extends CtrlAbstrato{

	//
	// ATRIBUTOS DE RELACIONAMENTO
	//
	// O CtrlPrograma deve ter um atributo para referenciar a janela
	// com o menu principal do sistema e um atributo para cada caso de
	// uso que o usuário puder disparar a partir desse menu.
	//
	private JanelaPrincipal janela;
	private CtrlIncluirPessoa 			ctrlIncluirPessoa;
	private CtrlIncluirContaBancaria 	ctrlIncluirContaBancaria;
	private CtrlIncluirAgenciaBancaria 	ctrlIncluirAgenciaBancaria;

	//
	// MÉTODOS
	//
	public CtrlPrograma() {
		// chamada ao construtor da superclasse (CtrlAbstrato). No
		// caso do CtrlPrograma, ele não tem um CtrlPai.
		super(null);
		this.janela = new JanelaPrincipal(this);
		this.ctrlIncluirPessoa = null;
		this.ctrlIncluirContaBancaria = null;
		this.ctrlIncluirAgenciaBancaria = null;
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

	public void iniciarIncluirContaBancaria() {
		// Verificando se o caso de uso não está em execução
		if (this.ctrlIncluirContaBancaria == null)
			// Se não estiver, inicio a execução do caso de uso
			this.ctrlIncluirContaBancaria = new CtrlIncluirContaBancaria(this);
		else
			// Se já estou executando o caso de uso, aviso que a funcionalidade está rodando
			this.janela.notificar("Você já iniciou a funcionalidade de Incluir Conta Bancária");
	}

	public void iniciarIncluirAgenciaBancaria() {
		// Verificando se o caso de uso não está em execução
		if (this.ctrlIncluirAgenciaBancaria == null)
			// Se não estiver, inicio a execução do caso de uso
			this.ctrlIncluirAgenciaBancaria = new CtrlIncluirAgenciaBancaria(this);
		else
			// Se já estou executando o caso de uso, aviso que a funcionalidade está rodando
			this.janela.notificar("Você já iniciou a funcionalidade de Incluir Agência Bancária");
	}

	public void ctrlFilhoFinalizado(ICtrl ctrlFilho) {
		if(ctrlFilho instanceof CtrlIncluirPessoa)			
			this.ctrlIncluirPessoa = null;
		else if(ctrlFilho instanceof CtrlIncluirContaBancaria)
			this.ctrlIncluirContaBancaria = null;
		else if(ctrlFilho instanceof CtrlIncluirAgenciaBancaria)
			this.ctrlIncluirAgenciaBancaria = null;
	}

	/**
	 * Implementação do método presente em ICtrl. 
	 * Fará a finalização do programa
	 */
	public void finalizar() {
		this.janela.notificar("Encerrando o programa!");
		this.janela.finalizar();
		System.exit(0);
	}

	/**
	 * Implementação do método herdado de ICtrl. Neste caso,
	 * como é o controlador do programa, não há bem tangível
	 */
	public Object getBemTangivel() {
		return null;
	}
	
	public static void main(String[] args) {
		new CtrlPrograma();
	}
}
