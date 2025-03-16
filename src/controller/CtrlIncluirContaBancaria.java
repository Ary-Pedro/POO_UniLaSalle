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
	// ATRIBUTOS DE RELACIONAMENTO
	//
	private CtrlIncluirPessoa	ctrlIncluirPessoa;
	private Pessoa				pessoaCorrentista;
	
	//
	// MÉTODOS
	//
	public CtrlIncluirContaBancaria(CtrlPrograma c) {
		super(c);
		this.contaBancariaCriada = null;
		this.janela = new JanelaContaBancaria(this);
		this.ctrlIncluirPessoa = null;
		this.pessoaCorrentista = null;
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
	
	/**
	 * Método que o CtrlIncluirPessoa irá usar para informar que ele terminou
	 */
	public void ctrlFilhoFinalizado(ICtrl ctrlFilho) {
		CtrlIncluirPessoa ctrlIncluirPessoa = (CtrlIncluirPessoa)ctrlFilho;
		this.pessoaCorrentista = (Pessoa)ctrlIncluirPessoa.getBemTangivel();
		this.janela.indicarCorrentista(this.pessoaCorrentista);
		this.ctrlIncluirPessoa = null;		
	}
	
	public void efetuarInclusao(int numero, double limite, double saldo) {
		try {
			this.contaBancariaCriada = new ContaBancaria(numero, limite, saldo, this.pessoaCorrentista);
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
