package model;

public class ContaBancaria {

	//
	// LEMBRE-SE! 'this' é a referência para o objeto que estiver
	//            executando o método em questão. 
	//
	//            Se o método é NÃO ESTÁTICO, então sempre tem um 
	//            objeto responsável pela execução do método.
	//
	
	
	//
	// CONSTANTES
	//
	final public static int VALOR_MIN_NUM_CONTA = 1000; 
	final public static int VALOR_MAX_NUM_CONTA = 99999; 
	final public static double VALOR_MAX_LIMITE = 30000.00; 

	//
	// ATRIBUTOS
	// 
	private int    numContaCorrente;
	private double limiteChequeEspecial;
	private double saldo;
	
	//
	// MÉTODOS
	//
	public ContaBancaria(int numContaCorrente, 
			             double limiteChequeEspecial, 
			             double saldo) throws ModelException {
		super();
		this.setNumContaCorrente(numContaCorrente);
		this.setLimiteChequeEspecial(limiteChequeEspecial);
		this.setSaldo(saldo);
	}

	public int getNumContaCorrente() {
		return this.numContaCorrente;
	}

	public void setNumContaCorrente(int numContaCorrente) throws ModelException{
		ContaBancaria.validarNumContaCorrente(numContaCorrente);
		this.numContaCorrente = numContaCorrente;
	}

	public double getLimiteChequeEspecial() {
		return this.limiteChequeEspecial;
	}

	public void setLimiteChequeEspecial(double limiteChequeEspecial) throws ModelException{
		ContaBancaria.validarLimiteChequeEspecial(limiteChequeEspecial);
		this.limiteChequeEspecial = limiteChequeEspecial;
	}

	public double getSaldo() {
		return this.saldo;
	}

	public void setSaldo(double saldo) throws ModelException {
		ContaBancaria.validarSaldo(saldo, this.limiteChequeEspecial);
		this.saldo = saldo;
	}
	
	//
	// Métodos de Validação
	//	
	public static void validarNumContaCorrente(int numero) throws ModelException {
		if(numero < VALOR_MIN_NUM_CONTA|| numero > VALOR_MAX_NUM_CONTA)
			throw new ModelException("Número de Conta Inválido: " + numero);
	}

	public static void validarLimiteChequeEspecial(double limite) throws ModelException {
		if(limite < 0 || limite > VALOR_MAX_LIMITE)
			throw new ModelException("Valor Inválido para o limite: " + limite);
	}

	public static void validarSaldo(double saldo, double limite) throws ModelException {
		if(saldo < -VALOR_MAX_LIMITE)
			throw new ModelException("O saldo (" + saldo + ") não pode ser menor que valor do limite da conta: " + limite);
	}
}


