
public class TDado {

	private int valor;
	
	public void setValor(int valor) {
		this.valor = valor;
	}
	
	public int getValor() {
		return valor;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + valor;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TDado other = (TDado) obj;
		if (valor != other.valor)
			return false;
		return true;
	}

	/**
	 * Este método cria uma cópia idêntica da instância atual em uma nova
	 * instância, de modo a permitir que as informações sejam devolvidas
	 * mas sem que entidades externas tenhamos acesso a referência atual
	 * (e consequentemente possam manipulá-lo diretamente).
	 */
	public TDado clone() {
		TDado temp = new TDado();	// Criamos uma nova instância,
		temp.valor = this.valor;	// Copiamos os valores de cada um de seus atributos
		return temp;				// e com isso retornamos uma cópia identica (clone)
	}
}
