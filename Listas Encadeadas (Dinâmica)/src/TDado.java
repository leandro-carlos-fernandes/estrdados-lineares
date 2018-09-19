
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
	
}
