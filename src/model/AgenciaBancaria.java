package model;

public class AgenciaBancaria {

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
	final public static int VALOR_MAX_NUMERO_AGENCIA = 10000; 
	final public static int TAM_MAX_ENDERECO = 80; 
	final public static int TAM_MAX_CIDADE = 25; 

	//
	// ATRIBUTOS
	// 
	private int    numero;
	private String endereco;
	private String cidade;
	
	//
	// MÉTODOS
	//
	public AgenciaBancaria(int numero, 
			               String endereco, 
			               String cidade) throws ModelException {
		super();
		this.setNumero(numero);
		this.setEndereco(endereco);
		this.setCidade(cidade);
	}

	public int getNumero() {
		return this.numero;
	}

	public void setNumero(int numero) throws ModelException{
		AgenciaBancaria.validarNumero(numero);
		this.numero = numero;
	}

	public String getEndereco() {
		return this.endereco;
	}

	public void setEndereco(String endereco) throws ModelException{
		AgenciaBancaria.validarEndereco(endereco);
		this.endereco = endereco;
	}

	public String getCidade() {
		return this.cidade;
	}

	public void setCidade(String cidade) throws ModelException {
		AgenciaBancaria.validarCidade(cidade);
		this.cidade = cidade;
	}
	
	//
	// Métodos de Validação
	//	
	public static void validarNumero(int numero) throws ModelException {
		if(numero < 0 || numero > VALOR_MAX_NUMERO_AGENCIA)
			throw new ModelException("Número da Agência é Inválido: " + numero);
	}

	public static void validarEndereco(String endereco) throws ModelException {
		if(endereco == null || endereco.length() == 0)
			throw new ModelException("O endereco da agência não pode ser nulo!");
		if(endereco.length() > TAM_MAX_ENDERECO)
			throw new ModelException("O endereço da agência deve ter até " + 
		                             TAM_MAX_ENDERECO + " caracteres!");		
	}

	public static void validarCidade(String cidade) throws ModelException {
		if(cidade == null || cidade.length() == 0)
			throw new ModelException("A cidade da agência não pode ser nula!");
		if(cidade.length() > TAM_MAX_CIDADE)
			throw new ModelException("A cidade da agência deve ter até " + 
		                             TAM_MAX_CIDADE + " caracteres!");		
	}
}


