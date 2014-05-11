package t6.parte1;
/**
 * Classe abstrata que representa um vagão
 *
 */
public abstract class Vagao extends Carro {

	/**
	 * Construtor da classe.
	 * @param codigo Código do vagão 
	 */
	public Vagao(String codigo) {
		super(codigo);
	}
	
	/**
	 * Use para obter a capacidade do vagão.
	 * @return Capacidade do vagão.
	 */
	public abstract int getCapacidade ();
}
