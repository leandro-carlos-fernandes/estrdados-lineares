/**
 * Representa uma estrutura linear do tipo Lista, ou seja, armazena seus
 * elementos oferecendo uma organiza��o l�gica tal que para todo elemento
 * haja um predecessor e um sucessor (exceto para o primeiro e o �ltimo
 * elementos)
 * 
 * @author Leandro C. Fernandes
 *
 */
public class Lista {
	
	private TDado[] dados;
	private int tamanhoDaEstrutura;
	private int qtdeDeElementos;
	
	/**
	 * Cria uma estrutura de dados do tipo Lista
	 * @param qtdeMaximaDeArmazenamento equivale a capacidade m�xima de armazenamento da estrutura oferecer�.
	 */
	public Lista(int qtdeMaximaDeArmazenamento) {
		// Alocamos o espa�o necess�rio para armazenar cada um dos elementos
		dados = new TDado[qtdeMaximaDeArmazenamento];
		// .. e inicializamos os demais atributos da classe
		tamanhoDaEstrutura = qtdeMaximaDeArmazenamento;
		qtdeDeElementos = 0;
	}
	
	/**
	 * Relativo ao estado da estrutura quanto a estar ou n�o vazia (sem elementos) 
	 * @return verdadeiro quando n�o h� qualquer elemento armazenado
	 */
	public boolean estaVazia() {
		return (qtdeDeElementos == 0) ? true : false;
	}
	
	/**
	 * Relativo ao estado da estrutura quanto a estar ou n�o cheia (capacidade de armazenamento esgotada) 
	 * @return verdadeiro quando todas as posi��es est�o ocupadas e n�o h� mais espa�o para armazenamento.
	 */
	public boolean estaCheia() {
		return (qtdeDeElementos == tamanhoDaEstrutura) ? true : false;
	}
	
	/**
	 * Insere um novo elemento na estrutura de dados na posi��o indicada.
	 * @param elemento corresponde ao elemento a ser inserido na lista
	 * @param posicao corresponde a posi��o ordinal que o elemento assumir� na lista (ex: 1a., 2a. ou n-�sina posi��o)
	 * @return verdadeiro caso tenha sucesso na inser��o ou falso em caso contr�rio
	 */
	public boolean insere(TDado elemento, int posicao) {

		// H� espa�o na estrutura para inserir um novo elemento?
		if (estaCheia())
			return false;
		
		// A posi��o informada � inv�lida?
		if ((posicao <= 0) || (posicao > qtdeDeElementos + 1))
			return false;		
		
		// Devemos criar uma nova inst�ncia (c�pia) para que a estrutura
		// n�o referencie elementos externos e, assim, protejamos os dados
		// da estrutura de altera��es externas.
		TDado novoElemento = new TDado();
		novoElemento.setValor( elemento.getValor() );
		
		// Abrindo espa�o para o novo elemento, se necess�rio
		for (int indice = qtdeDeElementos; indice >= posicao; indice--) {
			dados[indice] = dados[indice - 1];
		}
		
		// Inserimos o elemento na posi��o informada (Lembre-se que o
		// vetor � indexado a partir de zero, por isso subtra�mos 1) e
		// atualizamos a quantidade de elementos. 
		dados[posicao - 1] = novoElemento;
		qtdeDeElementos++;
		
		return true;
	}
	
	/**
	 * Remove o elemento na n-�sima posi��o da lista
	 * @param posicao corresponde a posi��o ordinal do elemento a ser removido (ex: 1a., 2a. ou n-�sina posi��o)
	 * @return verdadeiro caso tenha sucesso na remo��o ou falso em caso contr�rio
	 */
	public boolean remove(int posicao) {
		
		// H� algum elemento na estrutura para ser removido?
		if (estaVazia())
			return false;
		
		// A posi��o informada � inv�lida?
		if ((posicao <= 0) || (posicao > qtdeDeElementos))
			return false;
		
		// Como o vetor n�o pode apresentar "bolhas" na �rea dos
		// dados, precisamos movimentar os elementos de modo a 
		// eliminar o espa�o deixado pelo elemento que removido.
		for (int indice = posicao; indice <= qtdeDeElementos - 1; indice++) {
			dados[indice - 1] = dados[indice];
		}
		
		// Por fim atualizamos a quantide de elementos da lista
		qtdeDeElementos--;
		
		return true;
	}
	
	/**
	 * Remove um elemento que esteja na lista
	 * @param elemento equivale ao elemento que deve ser removido
	 * @return verdadeiro caso tenha sucesso na remo��o ou falso em caso contr�rio
	 */
	public boolean remove(TDado elemento) {
		
		// H� algum elemento na estrutura para ser removido?
		if (estaVazia())
			return false;
		
		// Para remov�-lo, devemos inicialmente procur�-lo e 
		// localiz�-lo dentro do vetor de dados.
		int posicao = 0;
		while ( (posicao < qtdeDeElementos) && (dados[posicao].getValor() != elemento.getValor()) )
			posicao++;
		
		// Se o �ndice alcan�ar o final da �rea de dados do vetor
		// significa que o elemento que estamos procurando n�o est�
		// armazenado na estrutura.
		if (posicao == qtdeDeElementos)
			return false;
		
		// Por�m se o o motivo da interrup��o do la�o se deu pela
		// segunda cl�usula, ent�o posi��o cont�m a posi��o exata do
		// elemento que dever� ser removido.
		for (int indice = posicao; indice < qtdeDeElementos - 1; indice++) {
			dados[indice] = dados[indice + 1];
		}
		
		// Por fim atualizamos a quantidade de elementos da lista
		qtdeDeElementos--;
		
		return true;
	}
	
	/**
	 * Retorna o elemento localizado na n-�sima posi��o dentro da estrutura
	 * @return retorna uma c�pia do elemento armazenado
	 */
	public TDado getElementoDaPosicao(int posicao) {
		TDado elem = null;
		
		// A posi��o informada � v�lida?
		if ((posicao > 0) && (posicao < qtdeDeElementos)) {
			elem = new TDado();
			elem.setValor( dados[posicao-1].getValor() );
		}
		
		return elem;
	}
	
	/**
	 * Retorna todos os elementos armazenados na estrutura
	 * @return retorna um vetor contendo cada um dos elementos armazenados ou um vetor nulo quanto a lista est� vazia
	 */
	public TDado[] listaTodos() {
		if (estaVazia())
			return null;
		else {
			TDado[] resultado = new TDado[qtdeDeElementos];
			for (int i = 0; i < qtdeDeElementos; i++) {
				resultado[i] = new TDado();
				resultado[i].setValor( dados[i].getValor() );
			}
			return resultado;
		}
	}

}
