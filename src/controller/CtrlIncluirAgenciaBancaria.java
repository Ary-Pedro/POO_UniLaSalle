package controller;

import model.AgenciaBancaria;
import model.ModelException;
import model.dao.DaoAgenciaBancaria;
import viewer.JanelaAgenciaBancaria;

public class CtrlIncluirAgenciaBancaria extends CtrlAbstrato {
	
	private JanelaAgenciaBancaria viewer;
	private AgenciaBancaria agencia;
	
	public CtrlIncluirAgenciaBancaria(ICtrl c) {
		// Chamando o construtor da superclasse. Irá guardar a 
		// informação que o CtrlPrograma é o pai desse controlador.
		super(c);		
		this.viewer = new JanelaAgenciaBancaria(this);
		this.viewer.apresentar();
	}
	
	public void efetuarInclusao(int numero, String endereco, String cidade) {		
		try {
			this.agencia = new AgenciaBancaria(numero, endereco, cidade);
		}
		catch(ModelException me) {
			this.viewer.notificar(me.getMessage());
			return;
		}		
		DaoAgenciaBancaria dao = new DaoAgenciaBancaria();
		dao.incluir(this.agencia);		
		this.finalizar();		
	}

	@Override
	public void finalizar() {
		this.viewer.finalizar();
		this.getCtrlPai().ctrlFilhoFinalizado(this);
	}

	@Override
	public Object getBemTangivel() {		
		return this.agencia;
	}

}
