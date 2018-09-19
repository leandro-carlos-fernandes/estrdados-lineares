/**
 * Representa uma estrutura linear do tipo Lista, ou seja, armazena seus
 * elementos oferecendo uma organização lógica tal que para todo elemento haja
 * um predecessor e um sucessor (exceto para o primeiro e o último elementos)
 * 
 * @author Leandro C. Fernandes
 *
 */
public class Lista {

	private static final int FIM_DA_LISTA = -1;	/* sinalizador de fim de lista */
	private static final int SLOT_VAZIO = -2;	/* sinalizador de posição vazia */

	private TDado[] dados;			/* Armazena os dados dentro da estrutura. */
	private int indicePrimeiro;		/* Indica a posição do primeiro elemento. */
	private int[] proximos;			/* Indica a posição do próximo elemento, mas
									   também é utilizado no controle de vazios.*/
	private int tamanhoDaEstrutura;	/* Capacidade máxima de armazenagem */
	private int qtdeDeElementos;	/* Quantidade de elementos armazenados */

	/**
	 * Cria uma estrutura de dados do tipo Lista.
	 * 
	 * @param qtdeMaximaDeArmazenamento equivale a capacidade máxima de
	 *                                  armazenamento da estrutura oferecerá.
	 */
	public Lista(int qtdeMaximaDeArmazenamento) {
		// Alocamos o espaço necessário para armazenar cada um dos elementos
		dados = new TDado[qtdeMaximaDeArmazenamento];
		proximos = new int[qtdeMaximaDeArmazenamento];

		// Registramos que todas as posições estão vazias
		for (int i = 0; i < proximos.length; i++)
			proximos[i] = SLOT_VAZIO;

		// Indicamos que não há um primeiro elemento na estrutura ainda.
		indicePrimeiro = FIM_DA_LISTA;

		// .. e inicializamos os demais atributos da classe
		tamanhoDaEstrutura = qtdeMaximaDeArmazenamento;
		qtdeDeElementos = 0;
	}

	/**
	 * Este método representa uma forma derivada de determinar a quantidade de
	 * elementos armazenados na estrutura, sem a necessidade explícita de criar um
	 * atributo para este propósito.
	 * 
	 * @return a quantidade de elementos armazenados na estrutura.
	 */
	public int getQtdeDeElementos() {
		// Assumimos por hipótese que inicialmente não há qualquer elemento armazenado
		int cont = 0;

		// Usaremos um auxiliar para percorrer a estrutura na ordem informada pelo
		// vetor de sucessores até encontrarmos o último elemento (aquele identificado
		// pelo valor -1), tendo como ponto de partida o primeiro.
		int aux = indicePrimeiro;
		// Enquanto tivermos um valor que seja válido, isto é, um valor correspondente
		// a um índice qualquer do vetor de dados, continuamos a contagem.
		while (aux != FIM_DA_LISTA) {
			cont++; 			 // contamos +1 elemento encontrado e
			aux = proximos[aux]; // seguimos para a próxima posição.
		}
		
		// Agora basta retornar o contador
		return cont;
	}

	/**
	 * Relativo ao estado da estrutura quanto a estar ou não vazia (sem elementos)
	 * 
	 * @return verdadeiro quando não há qualquer elemento armazenado
	 */
	public boolean estaVazia() {
		return (qtdeDeElementos == 0) ? true : false;
	}

	/**
	 * Relativo ao estado da estrutura quanto a estar ou não cheia (capacidade de
	 * armazenamento esgotada)
	 * 
	 * @return verdadeiro quando todas as posições estão ocupadas e não há mais
	 *         espaço para armazenamento.
	 */
	public boolean estaCheia() {
		return (qtdeDeElementos == tamanhoDaEstrutura) ? true : false;
	}

	/**
	 * Localiza uma posição física livre para armazenamento
	 * 
	 * @return índice do vetor no qual podemos guardar um elemento
	 */
	private int encontrarSlotVazio() {
		if (estaCheia())
			return FIM_DA_LISTA;
		else {
			int i = 0;
			while (proximos[i] != SLOT_VAZIO)
				i++;
			return i;
		}
	}

	/**
	 * Insere um novo elemento na estrutura de dados na posição indicada.
	 * 
	 * @param elemento corresponde ao elemento a ser inserido na lista
	 * @param posicao  corresponde a posição ordinal que o elemento assumirá na
	 *                 lista (ex: 1a., 2a. ou n-ésina posição)
	 * @return verdadeiro caso tenha sucesso na inserção ou falso em caso contrário
	 */
	public boolean insere(TDado elemento, int posicao) {

		// Há espaço na estrutura para inserir um novo elemento?
		if (estaCheia())
			throw new RuntimeException("Lista cheia, impossível inserir.");

		// A posição informada é inválida?
		if ((posicao <= 0) || (posicao > qtdeDeElementos + 1))
			throw new RuntimeException("Posição inválida: " + posicao);

		// Localizamos um slot vazio e armazenamos o novo elemento na estrutura.
		int i = encontrarSlotVazio();
		dados[i] = elemento.clone();

		// Agora é necessário manter o encadeamento lógico entre os elementos,
		// então devemos verificar se o novo elemento será o 1o ou qualquer um
		// dos outros n elementos que estão na lista.
		if (posicao == 1) {
			proximos[i] = indicePrimeiro; // o seu sucessor será o antigo primeiro,
			indicePrimeiro = i; 		  // e o slot corrente será o primeiro.
		}
		else {
			// Começando a análise do inicio e contando cada posição que passarmos,
			int j = indicePrimeiro;		  
			int contPosicoes = 1;
			// devemos determinar o índice (j) do elemento imediatamente anterior a
			// posição desejada (parâmetro posicao).
			while (contPosicoes < posicao - 1) {
				j = proximos[j];
				contPosicoes++;
			}
			// Neste momento, as variáveis i e j fazem referência, respectivamente,  
			// aos índices físicos do novo elemento (n-ésima posição lógica) e do
			// elemento antecessor a esta posição lógica.
			// Assim basta atualizarmos as referências de cada um dos participantes
			// neste processo de inserção, ou seja, o novo elemento deverá informar
			// quem é o seu próximo e o elemento anterior a posição informada deve
			// ter o novo elemento como o seu sucessor.
			proximos[i] = proximos[j];
			proximos[j] = i;
		}

		// Por fim, devemos adicionar +1 ao contador de elementos na estrutura.
		qtdeDeElementos++;

		return true;
	}

	/**
	 * Remove o elemento na n-ésima posição da lista
	 * 
	 * @param posicao corresponde a posição ordinal do elemento a ser removido (ex:
	 *                1a., 2a. ou n-ésina posição)
	 * @return verdadeiro caso tenha sucesso na remoção ou falso em caso contrário
	 */
	public boolean remove(int posicao) {

		// Há algum elemento na estrutura para ser removido?
		if (estaVazia())
			throw new RuntimeException("Lista vazia, impossível remover.");

		// A posição informada é inválida?
		if ((posicao <= 0) || (posicao > qtdeDeElementos))
			throw new RuntimeException("Posição inválida: " + posicao);

		// Devemos localizar o índice físico que seja correspondente a posição
		// lógica desejada (parâmetro posicao).
		int i = indicePrimeiro;		// índice do elemento a ser removido
		int j = indicePrimeiro;		// índice de seu antecessor
		int contPosicoes = 1;		// contador de posições
		
		while (contPosicoes < posicao) {
			j = i;
			i = proximos[i];
			contPosicoes++;
		}
		
		// Atualizando as referências dos sucessores para os elementos
		// envolvidos no processo de remoção.
		if (posicao == 1)
			indicePrimeiro = proximos[indicePrimeiro]; 
		else {
			proximos[j] = proximos[i];
		}
		
		// Independente da situação, para remover o elemento precisamos alterar
		// o conteúdo do vetor "proximos" para SLOT_VAZIO no slot correspondente
		// ao índice i e, por se tratar de objetos, liberar o elemento fazendo
		// dados aprontar para nulo.
		dados[i] = null;
		proximos[i] = SLOT_VAZIO;

		// Por fim atualizamos a quantidade de elementos da lista
		qtdeDeElementos--;

		return true;
	}

	/**
	 * Remove um elemento que esteja na lista
	 * 
	 * @param elemento equivale ao elemento que deve ser removido
	 * @return verdadeiro caso tenha sucesso na remoção ou falso em caso contrário
	 */
	public boolean remove(TDado elemento) {

		// Há algum elemento na estrutura para ser removido?
		if (estaVazia())
			throw new RuntimeException("Lista vazia, impossível remover.");

		// Para remover, devemos procurar e localizar o elemento no vetor de dados.
		int i = indicePrimeiro;
		while ((i != FIM_DA_LISTA) && (!dados[i].equals(elemento)))
			i = proximos[i];

		// Se o índice alcançar o final da área de dados do vetor significa
		// que o elemento que estamos procurando não está na estrutura.
		if (i == FIM_DA_LISTA)
			return false;
		// Porém se o o motivo da interrupção do laço se deu pela segunda
		// cláusula, então i contém a posição exata do elemento que deverá 
		// ser removido.
		else
			// .. então basta realizar uma remoção do elemento da posição i.
			return remove(i);
		
	}

	/**
	 * Retorna o elemento armazenado na n-ésima posição lógica da estrutura.
	 * 
	 * @param posicao número ordinal que representa a posição desejada (1a, 2a, etc).
	 * @return o elemento armazenado na n-ésima posição da lista.
	 */
	public TDado getElementoDaPosicao(int posicao) {

		// A posição informada é inválida?
		if ((posicao <= 0) || (posicao > qtdeDeElementos))
			throw new RuntimeException("Posição inválida: " + posicao);
		
		int contPosicoes = 1;
		int i = indicePrimeiro;
		while (contPosicoes < posicao) {
			i = proximos[i];
			contPosicoes++;
		}

		return dados[i].clone();
	}

	/**
	 * Retorna todos os elementos armazenados na estrutura
	 * 
	 * @return retorna um vetor contendo cada um dos elementos armazenados ou um
	 *         vetor nulo quanto a lista está vazia
	 */
	public TDado[] listaTodos() {
		if (estaVazia())
			return null;
		else {
			TDado[] resultado = new TDado[qtdeDeElementos];

			int i = 0;
			int aux = indicePrimeiro;
			while (aux != FIM_DA_LISTA) {
				resultado[i] = dados[aux].clone();
				aux = proximos[aux];
				i++;
			}

			return resultado;
		}
	}

}
