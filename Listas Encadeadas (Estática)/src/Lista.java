/**
 * Representa uma estrutura linear do tipo Lista, ou seja, armazena seus
 * elementos oferecendo uma organiza��o l�gica tal que para todo elemento haja
 * um predecessor e um sucessor (exceto para o primeiro e o �ltimo elementos)
 * 
 * @author Leandro C. Fernandes
 *
 */
public class Lista {

	private static final int FIM_DA_LISTA = -1;	/* sinalizador de fim de lista */
	private static final int SLOT_VAZIO = -2;	/* sinalizador de posi��o vazia */

	private TDado[] dados;			/* Armazena os dados dentro da estrutura. */
	private int indicePrimeiro;		/* Indica a posi��o do primeiro elemento. */
	private int[] proximos;			/* Indica a posi��o do pr�ximo elemento, mas
									   tamb�m � utilizado no controle de vazios.*/
	private int tamanhoDaEstrutura;	/* Capacidade m�xima de armazenagem */
	private int qtdeDeElementos;	/* Quantidade de elementos armazenados */

	/**
	 * Cria uma estrutura de dados do tipo Lista.
	 * 
	 * @param qtdeMaximaDeArmazenamento equivale a capacidade m�xima de
	 *                                  armazenamento da estrutura oferecer�.
	 */
	public Lista(int qtdeMaximaDeArmazenamento) {
		// Alocamos o espa�o necess�rio para armazenar cada um dos elementos
		dados = new TDado[qtdeMaximaDeArmazenamento];
		proximos = new int[qtdeMaximaDeArmazenamento];

		// Registramos que todas as posi��es est�o vazias
		for (int i = 0; i < proximos.length; i++)
			proximos[i] = SLOT_VAZIO;

		// Indicamos que n�o h� um primeiro elemento na estrutura ainda.
		indicePrimeiro = FIM_DA_LISTA;

		// .. e inicializamos os demais atributos da classe
		tamanhoDaEstrutura = qtdeMaximaDeArmazenamento;
		qtdeDeElementos = 0;
	}

	/**
	 * Este m�todo representa uma forma derivada de determinar a quantidade de
	 * elementos armazenados na estrutura, sem a necessidade expl�cita de criar um
	 * atributo para este prop�sito.
	 * 
	 * @return a quantidade de elementos armazenados na estrutura.
	 */
	public int getQtdeDeElementos() {
		// Assumimos por hip�tese que inicialmente n�o h� qualquer elemento armazenado
		int cont = 0;

		// Usaremos um auxiliar para percorrer a estrutura na ordem informada pelo
		// vetor de sucessores at� encontrarmos o �ltimo elemento (aquele identificado
		// pelo valor -1), tendo como ponto de partida o primeiro.
		int aux = indicePrimeiro;
		// Enquanto tivermos um valor que seja v�lido, isto �, um valor correspondente
		// a um �ndice qualquer do vetor de dados, continuamos a contagem.
		while (aux != FIM_DA_LISTA) {
			cont++; 			 // contamos +1 elemento encontrado e
			aux = proximos[aux]; // seguimos para a pr�xima posi��o.
		}
		
		// Agora basta retornar o contador
		return cont;
	}

	/**
	 * Relativo ao estado da estrutura quanto a estar ou n�o vazia (sem elementos)
	 * 
	 * @return verdadeiro quando n�o h� qualquer elemento armazenado
	 */
	public boolean estaVazia() {
		return (qtdeDeElementos == 0) ? true : false;
	}

	/**
	 * Relativo ao estado da estrutura quanto a estar ou n�o cheia (capacidade de
	 * armazenamento esgotada)
	 * 
	 * @return verdadeiro quando todas as posi��es est�o ocupadas e n�o h� mais
	 *         espa�o para armazenamento.
	 */
	public boolean estaCheia() {
		return (qtdeDeElementos == tamanhoDaEstrutura) ? true : false;
	}

	/**
	 * Localiza uma posi��o f�sica livre para armazenamento
	 * 
	 * @return �ndice do vetor no qual podemos guardar um elemento
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
	 * Insere um novo elemento na estrutura de dados na posi��o indicada.
	 * 
	 * @param elemento corresponde ao elemento a ser inserido na lista
	 * @param posicao  corresponde a posi��o ordinal que o elemento assumir� na
	 *                 lista (ex: 1a., 2a. ou n-�sina posi��o)
	 * @return verdadeiro caso tenha sucesso na inser��o ou falso em caso contr�rio
	 */
	public boolean insere(TDado elemento, int posicao) {

		// H� espa�o na estrutura para inserir um novo elemento?
		if (estaCheia())
			throw new RuntimeException("Lista cheia, imposs�vel inserir.");

		// A posi��o informada � inv�lida?
		if ((posicao <= 0) || (posicao > qtdeDeElementos + 1))
			throw new RuntimeException("Posi��o inv�lida: " + posicao);

		// Localizamos um slot vazio e armazenamos o novo elemento na estrutura.
		int i = encontrarSlotVazio();
		dados[i] = elemento.clone();

		// Agora � necess�rio manter o encadeamento l�gico entre os elementos,
		// ent�o devemos verificar se o novo elemento ser� o 1o ou qualquer um
		// dos outros n elementos que est�o na lista.
		if (posicao == 1) {
			proximos[i] = indicePrimeiro; // o seu sucessor ser� o antigo primeiro,
			indicePrimeiro = i; 		  // e o slot corrente ser� o primeiro.
		}
		else {
			// Come�ando a an�lise do inicio e contando cada posi��o que passarmos,
			int j = indicePrimeiro;		  
			int contPosicoes = 1;
			// devemos determinar o �ndice (j) do elemento imediatamente anterior a
			// posi��o desejada (par�metro posicao).
			while (contPosicoes < posicao - 1) {
				j = proximos[j];
				contPosicoes++;
			}
			// Neste momento, as vari�veis i e j fazem refer�ncia, respectivamente,  
			// aos �ndices f�sicos do novo elemento (n-�sima posi��o l�gica) e do
			// elemento antecessor a esta posi��o l�gica.
			// Assim basta atualizarmos as refer�ncias de cada um dos participantes
			// neste processo de inser��o, ou seja, o novo elemento dever� informar
			// quem � o seu pr�ximo e o elemento anterior a posi��o informada deve
			// ter o novo elemento como o seu sucessor.
			proximos[i] = proximos[j];
			proximos[j] = i;
		}

		// Por fim, devemos adicionar +1 ao contador de elementos na estrutura.
		qtdeDeElementos++;

		return true;
	}

	/**
	 * Remove o elemento na n-�sima posi��o da lista
	 * 
	 * @param posicao corresponde a posi��o ordinal do elemento a ser removido (ex:
	 *                1a., 2a. ou n-�sina posi��o)
	 * @return verdadeiro caso tenha sucesso na remo��o ou falso em caso contr�rio
	 */
	public boolean remove(int posicao) {

		// H� algum elemento na estrutura para ser removido?
		if (estaVazia())
			throw new RuntimeException("Lista vazia, imposs�vel remover.");

		// A posi��o informada � inv�lida?
		if ((posicao <= 0) || (posicao > qtdeDeElementos))
			throw new RuntimeException("Posi��o inv�lida: " + posicao);

		// Devemos localizar o �ndice f�sico que seja correspondente a posi��o
		// l�gica desejada (par�metro posicao).
		int i = indicePrimeiro;		// �ndice do elemento a ser removido
		int j = indicePrimeiro;		// �ndice de seu antecessor
		int contPosicoes = 1;		// contador de posi��es
		
		while (contPosicoes < posicao) {
			j = i;
			i = proximos[i];
			contPosicoes++;
		}
		
		// Atualizando as refer�ncias dos sucessores para os elementos
		// envolvidos no processo de remo��o.
		if (posicao == 1)
			indicePrimeiro = proximos[indicePrimeiro]; 
		else {
			proximos[j] = proximos[i];
		}
		
		// Independente da situa��o, para remover o elemento precisamos alterar
		// o conte�do do vetor "proximos" para SLOT_VAZIO no slot correspondente
		// ao �ndice i e, por se tratar de objetos, liberar o elemento fazendo
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
	 * @return verdadeiro caso tenha sucesso na remo��o ou falso em caso contr�rio
	 */
	public boolean remove(TDado elemento) {

		// H� algum elemento na estrutura para ser removido?
		if (estaVazia())
			throw new RuntimeException("Lista vazia, imposs�vel remover.");

		// Para remover, devemos procurar e localizar o elemento no vetor de dados.
		int i = indicePrimeiro;
		while ((i != FIM_DA_LISTA) && (!dados[i].equals(elemento)))
			i = proximos[i];

		// Se o �ndice alcan�ar o final da �rea de dados do vetor significa
		// que o elemento que estamos procurando n�o est� na estrutura.
		if (i == FIM_DA_LISTA)
			return false;
		// Por�m se o o motivo da interrup��o do la�o se deu pela segunda
		// cl�usula, ent�o i cont�m a posi��o exata do elemento que dever� 
		// ser removido.
		else
			// .. ent�o basta realizar uma remo��o do elemento da posi��o i.
			return remove(i);
		
	}

	/**
	 * Retorna o elemento armazenado na n-�sima posi��o l�gica da estrutura.
	 * 
	 * @param posicao n�mero ordinal que representa a posi��o desejada (1a, 2a, etc).
	 * @return o elemento armazenado na n-�sima posi��o da lista.
	 */
	public TDado getElementoDaPosicao(int posicao) {

		// A posi��o informada � inv�lida?
		if ((posicao <= 0) || (posicao > qtdeDeElementos))
			throw new RuntimeException("Posi��o inv�lida: " + posicao);
		
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
	 *         vetor nulo quanto a lista est� vazia
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
