/**
 * Representa uma estrutura linear do tipo Lista, ou seja, armazena seus
 * elementos oferecendo uma organização lógica tal que para todo elemento
 * haja um predecessor e um sucessor (exceto para o primeiro e o último
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
	 * @param qtdeMaximaDeArmazenamento equivale a capacidade máxima de armazenamento da estrutura oferecerá.
	 */
	public Lista(int qtdeMaximaDeArmazenamento) {
		// Alocamos o espaço necessário para armazenar cada um dos elementos
		dados = new TDado[qtdeMaximaDeArmazenamento];
		// .. e inicializamos os demais atributos da classe
		tamanhoDaEstrutura = qtdeMaximaDeArmazenamento;
		qtdeDeElementos = 0;
	}
	
	/**
	 * Relativo ao estado da estrutura quanto a estar ou não vazia (sem elementos) 
	 * @return verdadeiro quando não há qualquer elemento armazenado
	 */
	public boolean estaVazia() {
		return (qtdeDeElementos == 0) ? true : false;
	}
	
	/**
	 * Relativo ao estado da estrutura quanto a estar ou não cheia (capacidade de armazenamento esgotada) 
	 * @return verdadeiro quando todas as posições estão ocupadas e não há mais espaço para armazenamento.
	 */
	public boolean estaCheia() {
		return (qtdeDeElementos == tamanhoDaEstrutura) ? true : false;
	}
	
	/**
	 * Insere um novo elemento na estrutura de dados na posição indicada.
	 * @param elemento corresponde ao elemento a ser inserido na lista
	 * @param posicao corresponde a posição ordinal que o elemento assumirá na lista (ex: 1a., 2a. ou n-ésina posição)
	 * @return verdadeiro caso tenha sucesso na inserção ou falso em caso contrário
	 */
	public boolean insere(TDado elemento, int posicao) {

		// Há espaço na estrutura para inserir um novo elemento?
		if (estaCheia())
			return false;
		
		// A posição informada é inválida?
		if ((posicao <= 0) || (posicao > qtdeDeElementos + 1))
			return false;		
		
		// Devemos criar uma nova instância (cópia) para que a estrutura
		// não referencie elementos externos e, assim, protejamos os dados
		// da estrutura de alterações externas.
		TDado novoElemento = new TDado();
		novoElemento.setValor( elemento.getValor() );
		
		// Abrindo espaço para o novo elemento, se necessário
		for (int indice = qtdeDeElementos; indice >= posicao; indice--) {
			dados[indice] = dados[indice - 1];
		}
		
		// Inserimos o elemento na posição informada (Lembre-se que o
		// vetor é indexado a partir de zero, por isso subtraímos 1) e
		// atualizamos a quantidade de elementos. 
		dados[posicao - 1] = novoElemento;
		qtdeDeElementos++;
		
		return true;
	}
	
	/**
	 * Remove o elemento na n-ésima posição da lista
	 * @param posicao corresponde a posição ordinal do elemento a ser removido (ex: 1a., 2a. ou n-ésina posição)
	 * @return verdadeiro caso tenha sucesso na remoção ou falso em caso contrário
	 */
	public boolean remove(int posicao) {
		
		// Há algum elemento na estrutura para ser removido?
		if (estaVazia())
			return false;
		
		// A posição informada é inválida?
		if ((posicao <= 0) || (posicao > qtdeDeElementos))
			return false;
		
		// Como o vetor não pode apresentar "bolhas" na área dos
		// dados, precisamos movimentar os elementos de modo a 
		// eliminar o espaço deixado pelo elemento que removido.
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
	 * @return verdadeiro caso tenha sucesso na remoção ou falso em caso contrário
	 */
	public boolean remove(TDado elemento) {
		
		// Há algum elemento na estrutura para ser removido?
		if (estaVazia())
			return false;
		
		// Para removê-lo, devemos inicialmente procurá-lo e 
		// localizá-lo dentro do vetor de dados.
		int posicao = 0;
		while ( (posicao < qtdeDeElementos) && (dados[posicao].getValor() != elemento.getValor()) )
			posicao++;
		
		// Se o índice alcançar o final da área de dados do vetor
		// significa que o elemento que estamos procurando não está
		// armazenado na estrutura.
		if (posicao == qtdeDeElementos)
			return false;
		
		// Porém se o o motivo da interrupção do laço se deu pela
		// segunda cláusula, então posição contém a posição exata do
		// elemento que deverá ser removido.
		for (int indice = posicao; indice < qtdeDeElementos - 1; indice++) {
			dados[indice] = dados[indice + 1];
		}
		
		// Por fim atualizamos a quantidade de elementos da lista
		qtdeDeElementos--;
		
		return true;
	}
	
	/**
	 * Retorna o elemento localizado na n-ésima posição dentro da estrutura
	 * @return retorna uma cópia do elemento armazenado
	 */
	public TDado getElementoDaPosicao(int posicao) {
		TDado elem = null;
		
		// A posição informada é válida?
		if ((posicao > 0) && (posicao < qtdeDeElementos)) {
			elem = new TDado();
			elem.setValor( dados[posicao-1].getValor() );
		}
		
		return elem;
	}
	
	/**
	 * Retorna todos os elementos armazenados na estrutura
	 * @return retorna um vetor contendo cada um dos elementos armazenados ou um vetor nulo quanto a lista está vazia
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
