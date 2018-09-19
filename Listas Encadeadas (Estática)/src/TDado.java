
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
	 * Este m�todo cria uma c�pia id�ntica da inst�ncia atual em uma nova
	 * inst�ncia, de modo a permitir que as informa��es sejam devolvidas
	 * mas sem que entidades externas tenhamos acesso a refer�ncia atual
	 * (e consequentemente possam manipul�-lo diretamente).
	 */
	public TDado clone() {
		TDado temp = new TDado();	// Criamos uma nova inst�ncia,
		temp.valor = this.valor;	// Copiamos os valores de cada um de seus atributos
		return temp;				// e com isso retornamos uma c�pia identica (clone)
	}
}
