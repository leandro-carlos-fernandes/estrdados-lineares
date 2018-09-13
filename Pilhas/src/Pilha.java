/**
 * Esta classe representa uma estrutura do tipo Pilha. Isto �, uma forma de
 * organiza��o linear e cuja pol�tica de opera��o atente ao crit�rio F.I.L.O.
 * (Fisrt In, Last Out). Em termos pr�ticos seu funcionamento faz alus�o ao
 * comportamento de uma pilha de caixas, na qual cada elemento encontra-se
 * empilhado um sobre o outro. Todo novo elemento � acrescentado logo acima do
 * que encontra-se no topo.
 * 
 * @author Leandro C. Fernandes
 *
 */
public class Pilha {

	// -----------------------
	// ------ Atributos ------
	// -----------------------

	private TDado[] dados;	// Armazena os elementos da estrutura.
	private int tamanho; 	// Equivale a capacidade m�xima de armazenamento.
	private int topo; 		// Serve para indexar o vetor na posi��o correspondente ao
							// topo da pilha; assim como, para indicar a quantidade de
							// elementos armazenados na estrutura.

	// -----------------------
	// ------- M�todos -------
	// -----------------------

	/**
	 * Cria uma estrutura de dados do tipo Pilha
	 * 
	 * @param tamanho equivale a capacidade m�xima de armazenamento da estrutura.
	 */
	public Pilha(int tamanho) {
		// Alocamos o espa�o necess�rio para armazenar cada um dos elementos
		dados = new TDado[tamanho];
		// .. e inicializamos os demais atributos da classe
		this.tamanho = tamanho;
		this.topo = 0;
	}

	/**
	 * Cria uma estrutura de dados do tipo Pilha com capacidade padr�o para
	 * armazenar at� 10 elementos.
	 */
	public Pilha() {
		this(10); // Ao inv�s de duplicarmos o c�digo do 1o construtor (anterior),
					// podemos simplesmente invoc�-lo informando tamanho desejado como
					// par�metro, que neste caso � igual a 10
	}

	/**
	 * Verifica se a estrutura n�o cont�m elementos armazenados (se est� vazia).
	 * 
	 * @return verdadeiro quando n�o h� qualquer elemento armazenado
	 */
	public boolean estaVazia() {
		return (topo == 0) ? true : false;
	}

	/**
	 * Verifica se a estrutura est� com sua capacidade de armazenamento esgotada (se
	 * est� cheia)
	 * 
	 * @return verdadeiro quando n�o h� mais espa�o para armazenamento.
	 */
	public boolean estaCheia() {
		return (topo == tamanho) ? true : false;
	}

	/**
	 * Insere (push) um elemento no topo da estrutura de dados.
	 * 
	 * @param elemento corresponde ao elemento a ser armazenado.
	 */
	public boolean empilha(TDado elemento) {
		// H� espa�o para uma nova inser��o?
		if (estaCheia())
			return false;

		// Dado que a pilha tem espa�o suficiente para a inser��o basta colocar
		// o elemento na posi��o corrente indicada pelo topo (uma vez que topo,
		// al�m de informar a qde de elementos, tamb�m indica a pr�xima posi��o
		// livre no vetor)
		dados[topo] = elemento;
		// ..e contamos mais um elemento, incrementando o atributo topo.
		topo++;

		return true;
	}

	/**
	 * Retira (pop) o elemento que est� no topo da estrutura e devolve a inst�ncia.
	 * 
	 * @return o elemento removido.
	 */
	public TDado desempilha() {
		// H� ao menos um elemento na pilha para a remo��o?
		if (estaVazia())
			return null;

		// O elemento que deve ser removido est� armazenado no vetor uma posi��o abaixo
		// da que � indicada autalmente pelo topo (lembrando que topo indica a pr�xi-
		// -ma posi��o livre para inser��o). Antes de atribuir null para a posi��o, pre-
		// -cisamos guardar a refer�ncia deste elemento para que ela possa ser retornada
		// depois, ao t�rmino da execu��o do m�todo.
		TDado temp = dados[topo - 1];
		dados[topo - 1] = null;
		// ..e diminuimos a quantidade de elementos, decrementando o atributo topo.
		topo--;

		return temp;
	}

	/**
	 * Consulta o elemento que est� no topo da estrutura sem remov�-lo.
	 * 
	 * @return retorna o objeto que est� no topo da pilha.
	 */
	public TDado topo() {
		// Temp representar� o elemento a ser retornado. A princ�pio n�o temos nada
		// a ser devolvido, pois nem sabemos se h� ou n�o elementos armazenados na
		// estrutura.
		TDado temp = null;

		// Se n�o estiver vazia ...
		if (!estaVazia()) {
			// Importate: Devemos criar um "clone" do nosso objeto ao inv�s de re-
			// -tornarmos a referencia diretamente, pois isso impede que os dados
			// sejam alterados por meio de algum objeto externo a estrutura de dados.
			// Trata-se de uma quest�o de seguran�a.
			temp = new TDado();
			temp.setValor(dados[topo - 1].getValor());
		}

		// .. e devolvemos o objeto temp, quer seja ele igual null ou uma c�pia do
		// elemento armazenado no topo da esturura.
		return temp;
	}

	/**
	 * Retorna uma c�pia de todos os elementos da estrutura, sem remov�-los.
	 * 
	 * @return um vetor com todos os objetos que est�o armazenados.
	 */
	public TDado[] conteudo() {
		// Neste m�todos temp representar� uma cole��o de elementos a serem retorna-
		// -dos. A princ�pio n�o sabemos se h� ou n�o elementos armazenados na estru-
		// -tura, ent�o vamos supor a cole��o como sendo completamente vazia (null).
		TDado[] temp = null;

		// Se a estrutura n�o estiver vazia ...
		if (!estaVazia()) {
			// Nossa cole��o tem o tamanho da quantidade de elementos da estrutura,
			// ou seja, valor igual ao armazenado no atributo topo.
			temp = new TDado[topo];
			// Para cada posi��o do vetor temp teremos uma c�pia (clone) do elemento
			// armazenado na posi��o correspondente do vetor que representa a estrutura
			for (int i = 0; i < topo; i++) {
				// Importante: Devemos criar "clones" dos objetos internos ao inv�s de re-
				// -tornarmos suas referencias para impedir que algum objeto externo a
				// estrutura possam manipul�-los diretamente (quest�o de seguran�a).
				temp[i] = new TDado();
				temp[i].setValor(dados[i].getValor());
			}
		}

		// Por fim devolvemos o objeto temp, seja ele null ou uma cole��o de c�pias
		// dos elementos armazenados na estrutura.
		return temp;
	}

}
