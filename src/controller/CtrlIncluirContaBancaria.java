package controller;

import model.AgenciaBancaria;
import model.ContaBancaria;
import model.ModelException;
import model.Pessoa;
import model.dao.DaoAgenciaBancaria;
import model.dao.DaoContaBancaria;
import model.dao.DaoPessoa;
import viewer.JanelaContaBancaria;

public class CtrlIncluirContaBancaria extends CtrlAbstrato {
	//
	// ATRIBUTOS
	//
	// Todo Controlador deve ter um atributo para guardar a referência
	// para o objeto viewer com quem se relaciona.
	//
	private JanelaContaBancaria janela;
	private ContaBancaria contaBancariaCriada;
	// Como teremos uma relação entre o caso de uso "Incluir Conta Bancária"
	// com "Incluir Pessoa", então precisamos colocar esse atributo para
	// disparar a execução desse caso de uso <<include>>
	private CtrlIncluirPessoa ctrlIncluirPessoa;
	private Pessoa            correntista;
	// Como teremos uma relação entre o caso de uso "Incluir Conta Bancária"
	// com "Incluir Agência Bancária", então precisamos colocar esse atributo para
	// disparar a execução desse caso de uso <<include>>
	private CtrlIncluirAgenciaBancaria ctrlIncluirAgenciaBancaria;
	private AgenciaBancaria agencia;
	
	//
	// MÉTODOS
	//
	public CtrlIncluirContaBancaria(CtrlPrograma c) {
		super(c);
		this.ctrlIncluirPessoa = null;
		this.ctrlIncluirAgenciaBancaria = null;
		this.contaBancariaCriada = null;
		DaoPessoa daoPessoas = new DaoPessoa();
		DaoAgenciaBancaria daoAgenciaBancaria = new DaoAgenciaBancaria();
		
		this.janela = new JanelaContaBancaria(this, 
				                              daoPessoas.consultarTodos(), 
				 							  daoAgenciaBancaria.consultarTodos());
		this.janela.apresentar();
	}

	/**
	 * Método usado pelo viewer para indicar que o usuário quer executar o
	 * caso de uso "Incluir Pessoa" (relacionamento de <<extend>>)
	 */
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
	 * Método usado pelo viewer para indicar que o usuário quer executar o
	 * caso de uso "Incluir Agência Bancária" (relacionamento de <<extend>>)
	 */
	public void iniciarIncluirAgenciaBancaria() {
		// Verificando se o caso de uso não está em execução
		if (this.ctrlIncluirAgenciaBancaria == null)
			// Se não estiver, inicio a execução do caso de uso
			this.ctrlIncluirAgenciaBancaria = new CtrlIncluirAgenciaBancaria(this);
		else
			// Se já estou executando o caso de uso, aviso que a funcionalidade está rodando
			this.janela.notificar("Você já iniciou a funcionalidade de Incluir Agência Bancária");
	}

	@Override
	public void ctrlFilhoFinalizado(ICtrl ctrlFilho) {
		if (ctrlFilho instanceof CtrlIncluirPessoa) {			
			this.correntista = (Pessoa)this.ctrlIncluirPessoa.getBemTangivel();
			if(this.correntista != null)
				this.janela.atualizarCorrentista(this.correntista);
		} else if (ctrlFilho instanceof CtrlIncluirAgenciaBancaria) {			
			this.agencia = (AgenciaBancaria)this.ctrlIncluirAgenciaBancaria.getBemTangivel();
			if(this.agencia != null)
				this.janela.atualizarAgencia(this.agencia);
		}
	}

	public void efetuarInclusao(int numero, double limite, double saldo, 
			                    Pessoa correntista, AgenciaBancaria agencia) {
		try {
			if(correntista == null) {
				this.janela.notificar("Você ainda não definiu o correntista");
				return;
			}
			if(agencia == null) {
				this.janela.notificar("Você ainda não definiu a agência");
				return;
			}
			this.contaBancariaCriada = new ContaBancaria(numero, limite, saldo,  
					                                     correntista, agencia);
		} catch (ModelException e1) {
			this.janela.notificar("Erro: " + e1);
			return;
		}
		DaoContaBancaria dao = new DaoContaBancaria();
		dao.incluir(this.contaBancariaCriada);
		this.finalizar();
	}

	public void finalizar() {
		this.janela.finalizar();
		this.getCtrlPai().ctrlFilhoFinalizado(this);
	}

	/**
	 * Retorna a referência para a conta bancária gerada (se tudo ocorreu
	 * corretamente) ou null (se o caso de uso não terminou ou se houve falha na
	 * execução)
	 */
	public Object getBemTangivel() {
		return this.contaBancariaCriada;
	}
}
