/**
 * Representa uma estrutura linear do tipo Lista, ou seja, armazena seus
 * elementos oferecendo uma organiza��o l�gica tal que para todo elemento
 * haja um predecessor e um sucessor (exceto para o primeiro e o �ltimo
 * elementos).
 * Nesta vers�o os elementos s�o encadeados dinamicamente, ou seja, n�o h�
 * uma reserva pr�via de espa�o, mas sim, a aloca��o e posicionamento dentro
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
		// Inicialmente n�o h� qualquer elemento na lista, ent�o o primeiro aponta para NULO.
		primeiro = null;
		// .. e a quantidade de elementos armazenados na estrutura
		qtdeDeElementos = 0;
	}
	
	/**
	 * Verifica o estado da estrutura quanto a estar vazia (sem elementos) 
	 * @return verdadeiro quando n�o h� qualquer elemento armazenado
	 */
	public boolean estaVazia() {
		return (qtdeDeElementos == 0) ? true : false;
	}
	
	/**
	 * Insere um novo elemento na estrutura de dados na posi��o indicada.
	 * @param elemento corresponde ao elemento a ser inserido na lista
	 * @param posicao corresponde a posi��o ordinal que o elemento assumir� na lista (ex: 1a., 2a. ou n-�sina posi��o)
	 * @return verdadeiro caso tenha sucesso na inser��o ou falso em caso contr�rio
	 */
	public boolean insere(TDado elemento, int posicao) {
	
		// A posi��o informada � inv�lida?
		if ((posicao <= 0) || (posicao > qtdeDeElementos + 1))
			return false;		
		
		// Devemos criar um novo n� para armazenar o dado na estrutura, de modo
		// que seja possivel referenciar tamb�m o encadeamento (ref. ao pr�ximo)
		// elemento da estrutura.
		TNo novoElemento = new TNo();
		novoElemento.setDado( elemento );			
		
		// Devemos encade�-lo dentro da estrutura de modo que ocupe a posi��o desejada.
		if (posicao == 1) {
			// Se for a 1a-poisi��o, devemos atualizar a nossa refer�ncia sobre que �
			// o primeiro elemento da lista. Vale lembrar que o antigo primeiro agora
			// ser� o segundo elemento da lista.
			novoElemento.setProximo( primeiro );
			primeiro = novoElemento;
		}
		else {
			// Por sua vez, se n�o � a primeira posi��o da lista, ent�o devemos encontrar
			// a referencia para o elemento anterior a posi��o desejada, pois � ele quem
			// encadear� o novo elemento na estrutura (ou seja, armazenar� a referencia
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
		
		// Devemos desencade�-lo da estrutura de modo que o elemento anterior passe a
		// referenciar o sucessor do elemento que ser� removido, isto �, o pr�ximo do pr�ximo.
		if (posicao == 1) {
			// Se for a 1a-poisi��o, teremos um novo primeiro elemento. Assim devemos atualizar
			// a refer�ncia sobre que � o primeiro elemento da lista.
			primeiro = primeiro.getProximo();
		}
		else {
			// Por sua vez, se n�o � a primeira posi��o da lista, ent�o devemos encontrar
			// a referencia para o elemento anterior � posi��o desejada, pois � ele quem
			// encadear� o sucessor do elemento que est� sendo removido.
			int i = 1;
			TNo anterior = primeiro;			
			
			while ((anterior != null) && (i < posicao - 1)) {
				anterior = anterior.getProximo();
				i++;
			}
			
			// Suponha a sequencia: anterior -> a ser removido -> sucessor
			// Se o objeto anteior referencia o n� imediatamente anterior ao n� que deve ser removido,
			// ent�o o comando "anterior.getProximo()" retornar� a referencia para o n� a ser removido.
			// Por sua vez, o comando "anterior.getProximo().getProximo" retornar� o pr�ximo do pr�cimo,
			// ou seja, a referencia para o n� sucessor.
			anterior.setProximo( anterior.getProximo().getProximo() );
		}
		
		// Por fim atualizamos a quantidade de elementos da lista
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
		
		// Para remov�-lo, devemos inicialmente localiz�-lo dentro da estrutura.
		if ( primeiro.getDado().equals(elemento) ) {
			// Se o elemento a ser removido for o primeiro, basta atualizar o objeto
			// primeiro para referenciar o segundo n� da estrutura. 
			primeiro = primeiro.getProximo();
		}
		else {
			
			// Ent�o o elemento a ser removido deve ser algum outro que n�o o primeiro.
			// Deste modo, devemos procur�-lo dentro da estrutura, lembrando de armazenar
			// tamb�m a referencia para o n� anterior, j� que ele dever� ser atualizado
			// ap�s a remo��o do elemento desejado.
			TNo anterior = primeiro;
			TNo auxiliar = primeiro;
			while ((auxiliar != null) && (!auxiliar.getDado().equals(elemento))) {
				anterior = auxiliar;				// o anterior referenciar� o n� atual enqto
				auxiliar = auxiliar.getProximo();	// auxiliar se mover� para o pr�ximo n�
			}
			
			// Devemos verificar qual foi o motivo que interrompeu o la�o anterior. Se for por
			// conta da primeira cl�ulula (ou seja, o auxiliar for igual a null), significa que
			// percorremos toda a estrutura e o elemento n�o foi encontrado. Por outro lado, se
			// o la�o tiver terminado em decorrencia da segunda cl�usula � porque auxiliar est�
			// referenciando o elemento que deve ser removido e anterior referencia o n� imedia-
			// -tamente antes do n� que ser� removido.
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
	 * Retorna o elemento armazenado na i-�sima posi��o da estrutura
	 * @param posicao corresponde ao i-�simo elemento da lista
	 * @return o elemento armazenado na lista na posi��o informada
	 */
	public TDado getElementoDaPosicao(int posicao) {
		
		// A posi��o informada � inv�lida?
		if ((posicao <= 0) || (posicao > qtdeDeElementos))
			return null;

		// Partindo de que a posi��o � v�lida, ent�o basta percorrer a lista a partir do
		// primeiro n� e devolver o elemento da posi��o desejada.
		int i = 1;
		TNo aux = primeiro;			
		while ((aux != null) && (i < posicao)) {
			aux = aux.getProximo();
			i++;
		}
		// Ao terminar o la�o, o objeto referncia o n� na posi��o dada como par�metro 
		return aux.getDado();
		
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
