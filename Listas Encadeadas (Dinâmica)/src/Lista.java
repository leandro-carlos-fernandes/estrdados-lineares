/**
 * Representa uma estrutura linear do tipo Lista, ou seja, armazena seus
 * elementos oferecendo uma organização lógica tal que para todo elemento
 * haja um predecessor e um sucessor (exceto para o primeiro e o último
 * elementos).
 * Nesta versão os elementos são encadeados dinamicamente, ou seja, não há
 * uma reserva prévia de espaço, mas sim, a alocação e posicionamento dentro
 * da estrutura de acordo com a demanda de uso.
 * 
 * @author Leandro C. Fernandes
 *
 */
public class Lista {
	private TNo primeiro;
	private int qtdeDeElementos;
	
	/**
	 * Cria uma estrutura de dados do tipo Lista
	 */
	public Lista() {
		// Inicialmente não há qualquer elemento na lista, então o primeiro aponta para NULO.
		primeiro = null;
		// .. e a quantidade de elementos armazenados na estrutura
		qtdeDeElementos = 0;
	}
	
	/**
	 * Verifica o estado da estrutura quanto a estar vazia (sem elementos) 
	 * @return verdadeiro quando não há qualquer elemento armazenado
	 */
	public boolean estaVazia() {
		return (qtdeDeElementos == 0) ? true : false;
	}
	
	/**
	 * Insere um novo elemento na estrutura de dados na posição indicada.
	 * @param elemento corresponde ao elemento a ser inserido na lista
	 * @param posicao corresponde a posição ordinal que o elemento assumirá na lista (ex: 1a., 2a. ou n-ésina posição)
	 * @return verdadeiro caso tenha sucesso na inserção ou falso em caso contrário
	 */
	public boolean insere(TDado elemento, int posicao) {
	
		// A posição informada é inválida?
		if ((posicao <= 0) || (posicao > qtdeDeElementos + 1))
			return false;		
		
		// Devemos criar um novo nó para armazenar o dado na estrutura, de modo
		// que seja possivel referenciar também o encadeamento (ref. ao próximo)
		// elemento da estrutura.
		TNo novoElemento = new TNo();
		novoElemento.setDado( elemento );			
		
		// Devemos encadeá-lo dentro da estrutura de modo que ocupe a posição desejada.
		if (posicao == 1) {
			// Se for a 1a-poisição, devemos atualizar a nossa referência sobre que é
			// o primeiro elemento da lista. Vale lembrar que o antigo primeiro agora
			// será o segundo elemento da lista.
			novoElemento.setProximo( primeiro );
			primeiro = novoElemento;
		}
		else {
			// Por sua vez, se não é a primeira posição da lista, então devemos encontrar
			// a referencia para o elemento anterior a posição desejada, pois é ele quem
			// encadeará o novo elemento na estrutura (ou seja, armazenará a referencia
			// "proximo" para o elemento adicionado.
			int i = 1;
			TNo anterior = primeiro;
			
			while ((anterior != null) && (i < posicao - 1)) {
				anterior = anterior.getProximo();
				i++;
			}
			
			novoElemento.setProximo( anterior.getProximo() );
			anterior.setProximo( novoElemento );
		}
		
		// Por fim atualizamos a quantidade de elementos da lista
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
		
		// Devemos desencadeá-lo da estrutura de modo que o elemento anterior passe a
		// referenciar o sucessor do elemento que será removido, isto é, o próximo do próximo.
		if (posicao == 1) {
			// Se for a 1a-poisição, teremos um novo primeiro elemento. Assim devemos atualizar
			// a referência sobre que é o primeiro elemento da lista.
			primeiro = primeiro.getProximo();
		}
		else {
			// Por sua vez, se não é a primeira posição da lista, então devemos encontrar
			// a referencia para o elemento anterior à posição desejada, pois é ele quem
			// encadeará o sucessor do elemento que está sendo removido.
			int i = 1;
			TNo anterior = primeiro;			
			
			while ((anterior != null) && (i < posicao - 1)) {
				anterior = anterior.getProximo();
				i++;
			}
			
			// Suponha a sequencia: anterior -> a ser removido -> sucessor
			// Se o objeto anteior referencia o nó imediatamente anterior ao nó que deve ser removido,
			// então o comando "anterior.getProximo()" retornará a referencia para o nó a ser removido.
			// Por sua vez, o comando "anterior.getProximo().getProximo" retornará o próximo do prócimo,
			// ou seja, a referencia para o nó sucessor.
			anterior.setProximo( anterior.getProximo().getProximo() );
		}
		
		// Por fim atualizamos a quantidade de elementos da lista
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
		
		// Para removê-lo, devemos inicialmente localizá-lo dentro da estrutura.
		if ( primeiro.getDado().equals(elemento) ) {
			// Se o elemento a ser removido for o primeiro, basta atualizar o objeto
			// primeiro para referenciar o segundo nó da estrutura. 
			primeiro = primeiro.getProximo();
		}
		else {
			
			// Então o elemento a ser removido deve ser algum outro que não o primeiro.
			// Deste modo, devemos procurá-lo dentro da estrutura, lembrando de armazenar
			// também a referencia para o nó anterior, já que ele deverá ser atualizado
			// após a remoção do elemento desejado.
			TNo anterior = primeiro;
			TNo auxiliar = primeiro;
			while ((auxiliar != null) && (!auxiliar.getDado().equals(elemento))) {
				anterior = auxiliar;				// o anterior referenciará o nó atual enqto
				auxiliar = auxiliar.getProximo();	// auxiliar se moverá para o próximo nó
			}
			
			// Devemos verificar qual foi o motivo que interrompeu o laço anterior. Se for por
			// conta da primeira cláulula (ou seja, o auxiliar for igual a null), significa que
			// percorremos toda a estrutura e o elemento não foi encontrado. Por outro lado, se
			// o laço tiver terminado em decorrencia da segunda cláusula é porque auxiliar está
			// referenciando o elemento que deve ser removido e anterior referencia o nó imedia-
			// -tamente antes do nó que será removido.
			if (auxiliar == null)
				return false;
			else {
				anterior.setProximo( auxiliar.getProximo() );
			}
			
		}
		
		// Por fim atualizamos a quantide de elementos da lista
		qtdeDeElementos--;
		
		return true;
	}
	
	/**
	 * Retorna o elemento armazenado na i-ésima posição da estrutura
	 * @param posicao corresponde ao i-ésimo elemento da lista
	 * @return o elemento armazenado na lista na posição informada
	 */
	public TDado getElementoDaPosicao(int posicao) {
		
		// A posição informada é inválida?
		if ((posicao <= 0) || (posicao > qtdeDeElementos))
			return null;

		// Partindo de que a posição é válida, então basta percorrer a lista a partir do
		// primeiro nó e devolver o elemento da posição desejada.
		int i = 1;
		TNo aux = primeiro;			
		while ((aux != null) && (i < posicao)) {
			aux = aux.getProximo();
			i++;
		}
		// Ao terminar o laço, o objeto referncia o nó na posição dada como parâmetro 
		return aux.getDado();
		
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
			int i = 0;
			TNo aux = primeiro;
			while ((aux != null) && (i < qtdeDeElementos)) {
				resultado[i] = new TDado();
				resultado[i].setValor( aux.getDado().getValor() );
				aux = aux.getProximo();
				i++;
			}
			return resultado;
		}
	}

}
