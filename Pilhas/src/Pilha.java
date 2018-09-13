/**
 * Esta classe representa uma estrutura do tipo Pilha. Isto é, uma forma de
 * organização linear e cuja política de operação atente ao critério F.I.L.O.
 * (Fisrt In, Last Out). Em termos práticos seu funcionamento faz alusão ao
 * comportamento de uma pilha de caixas, na qual cada elemento encontra-se
 * empilhado um sobre o outro. Todo novo elemento é acrescentado logo acima do
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
	private int tamanho; 	// Equivale a capacidade máxima de armazenamento.
	private int topo; 		// Serve para indexar o vetor na posição correspondente ao
							// topo da pilha; assim como, para indicar a quantidade de
							// elementos armazenados na estrutura.

	// -----------------------
	// ------- Métodos -------
	// -----------------------

	/**
	 * Cria uma estrutura de dados do tipo Pilha
	 * 
	 * @param tamanho equivale a capacidade máxima de armazenamento da estrutura.
	 */
	public Pilha(int tamanho) {
		// Alocamos o espaço necessário para armazenar cada um dos elementos
		dados = new TDado[tamanho];
		// .. e inicializamos os demais atributos da classe
		this.tamanho = tamanho;
		this.topo = 0;
	}

	/**
	 * Cria uma estrutura de dados do tipo Pilha com capacidade padrão para
	 * armazenar até 10 elementos.
	 */
	public Pilha() {
		this(10); // Ao invés de duplicarmos o código do 1o construtor (anterior),
					// podemos simplesmente invocá-lo informando tamanho desejado como
					// parâmetro, que neste caso é igual a 10
	}

	/**
	 * Verifica se a estrutura não contém elementos armazenados (se está vazia).
	 * 
	 * @return verdadeiro quando não há qualquer elemento armazenado
	 */
	public boolean estaVazia() {
		return (topo == 0) ? true : false;
	}

	/**
	 * Verifica se a estrutura está com sua capacidade de armazenamento esgotada (se
	 * está cheia)
	 * 
	 * @return verdadeiro quando não há mais espaço para armazenamento.
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
		// Há espaço para uma nova inserção?
		if (estaCheia())
			return false;

		// Dado que a pilha tem espaço suficiente para a inserção basta colocar
		// o elemento na posição corrente indicada pelo topo (uma vez que topo,
		// além de informar a qde de elementos, também indica a próxima posição
		// livre no vetor)
		dados[topo] = elemento;
		// ..e contamos mais um elemento, incrementando o atributo topo.
		topo++;

		return true;
	}

	/**
	 * Retira (pop) o elemento que está no topo da estrutura e devolve a instância.
	 * 
	 * @return o elemento removido.
	 */
	public TDado desempilha() {
		// Há ao menos um elemento na pilha para a remoção?
		if (estaVazia())
			return null;

		// O elemento que deve ser removido está armazenado no vetor uma posição abaixo
		// da que é indicada autalmente pelo topo (lembrando que topo indica a próxi-
		// -ma posição livre para inserção). Antes de atribuir null para a posição, pre-
		// -cisamos guardar a referência deste elemento para que ela possa ser retornada
		// depois, ao término da execução do método.
		TDado temp = dados[topo - 1];
		dados[topo - 1] = null;
		// ..e diminuimos a quantidade de elementos, decrementando o atributo topo.
		topo--;

		return temp;
	}

	/**
	 * Consulta o elemento que está no topo da estrutura sem removê-lo.
	 * 
	 * @return retorna o objeto que está no topo da pilha.
	 */
	public TDado topo() {
		// Temp representará o elemento a ser retornado. A princípio não temos nada
		// a ser devolvido, pois nem sabemos se há ou não elementos armazenados na
		// estrutura.
		TDado temp = null;

		// Se não estiver vazia ...
		if (!estaVazia()) {
			// Importate: Devemos criar um "clone" do nosso objeto ao invés de re-
			// -tornarmos a referencia diretamente, pois isso impede que os dados
			// sejam alterados por meio de algum objeto externo a estrutura de dados.
			// Trata-se de uma questão de segurança.
			temp = new TDado();
			temp.setValor(dados[topo - 1].getValor());
		}

		// .. e devolvemos o objeto temp, quer seja ele igual null ou uma cópia do
		// elemento armazenado no topo da esturura.
		return temp;
	}

	/**
	 * Retorna uma cópia de todos os elementos da estrutura, sem removê-los.
	 * 
	 * @return um vetor com todos os objetos que estão armazenados.
	 */
	public TDado[] conteudo() {
		// Neste métodos temp representará uma coleção de elementos a serem retorna-
		// -dos. A princípio não sabemos se há ou não elementos armazenados na estru-
		// -tura, então vamos supor a coleção como sendo completamente vazia (null).
		TDado[] temp = null;

		// Se a estrutura não estiver vazia ...
		if (!estaVazia()) {
			// Nossa coleção tem o tamanho da quantidade de elementos da estrutura,
			// ou seja, valor igual ao armazenado no atributo topo.
			temp = new TDado[topo];
			// Para cada posição do vetor temp teremos uma cópia (clone) do elemento
			// armazenado na posição correspondente do vetor que representa a estrutura
			for (int i = 0; i < topo; i++) {
				// Importante: Devemos criar "clones" dos objetos internos ao invés de re-
				// -tornarmos suas referencias para impedir que algum objeto externo a
				// estrutura possam manipulá-los diretamente (questão de segurança).
				temp[i] = new TDado();
				temp[i].setValor(dados[i].getValor());
			}
		}

		// Por fim devolvemos o objeto temp, seja ele null ou uma coleção de cópias
		// dos elementos armazenados na estrutura.
		return temp;
	}

}
