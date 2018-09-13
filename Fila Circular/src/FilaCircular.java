/**
 * Esta classe representa uma estrutura de dados do tipo FILA. Isto significa
 * que que armazena seus elementos de maneira seqüencial (linear), atendendo a
 * políticas de operação tal que o primeiro elemento a ser inserido na estrutura
 * também será o primeiro a ser removido (F.I.F.O. - First In, First Out). Esta
 * versão em particular, trata-se de uma implementação dita circular, pois a
 * distribuição lógica dos dados dentro do vetor estático é dada em duas
 * regiões: uma que contém os dados e outra que contém posições livres; como se
 * estivessem virtualmente ligadas uma a outro (com o fim colado no inicio,
 * formando um círculo).
 * 
 * @author Leandro
 *
 */
public class FilaCircular {

	// -----------------------
	// ------ Atributos ------
	// -----------------------
	private TDado dados[];	// Vetor responsável por reter (armazenar) os
							// elementos dentro da estrutura de dados.

	private int inicio; 	// Indica o início da área de dados do vetor. Seu
							// valor indica a posição do vetor onde está
							// armazenado o primeiro elemento da estrutura em
							// cada instante.

	private int fim; 		// Indica o término da área de dados do vetor. Seu
							// valor indica a posição do vetor onde será
							// armazenado o próximo elemento na estrutura.

	private int tamanho;	// Corresponde a capacidade máxima de armazenagem.

	
	// -----------------------
	// ------- Métodos -------
	// -----------------------

	/**
	 * Cria uma estrutura de dados do tipo Fila
	 * 
	 * @param tamanho equivale a capacidade máxima de armazenamento da estrutura
	 *                oferecerá.
	 */
	public FilaCircular(int tamanho) {
		dados = new TDado[tamanho];
		this.tamanho = tamanho;
		inicio = 0;
		fim = 0;
	}

	public FilaCircular() {
		this(10); // Ao invés de duplicarmos o código do 1o construtor (anterior),
					// podemos simplesmente invocá-lo informando tamanho desejado como
					// parâmetro, que neste caso é igual a 10
	}

	/*------------------------------------
	 * Operações auxiliares da fila
	 *-----------------------------------*/

	/**
	 * Retorna a quantidade de elementos armazenados na estrutura
	 * 
	 * @return quantidade de elementos
	 */
	public int getQtdeElementos() {
		// Neste tipo de estrutura, a quantidade de elementos armazenadas é derivada
		// em função dos atributos início e fim. A quantidade é dada pela diferença
		// entre fim e início, somando o tamanho máximo de armazenamento e calculando
		// o resto da divisão.
		return (tamanho + fim - inicio) % tamanho;
	}

	/**
	 * Verifica se a estrutura não contém elementos armazenados
	 * 
	 * @return verdadeiro quando não há qualquer elemento armazenado
	 */
	public boolean estaVazia() {
		return (this.getQtdeElementos() == 0) ? true : false;
	}

	/**
	 * Verifica se a estrutura está com sua capacidade de armazenamento esgotada
	 * 
	 * @return verdadeiro quando não há mais espaço para armazenamento.
	 */
	public boolean estaCheia() {
		return (this.getQtdeElementos() == tamanho) ? true : false;
	}

	/**
	 * Retorna a capacidade máxima de armazenamento da Fila
	 * 
	 * @return valor correspondente a capacidade máxima de armazenamento.
	 */
	public int capacidadeTotal() {
		return tamanho;
	}

	/**
	 * Insere (enqueue) um novo elemento na fila (enqueue)
	 * 
	 * @param elemento corresponde ao elemento a ser inserido na estrutura
	 * @return verdadeiro caso haja sucesso na operação e falso em caso contrário
	 */
	public boolean inserir(TDado elemento) {
		// Há espaço para uma nova inserção?
		if (estaCheia())
			return false;

		// Clona o objeto informado, armazena uma cópia dele dentro da estrutura na
		// posição indicada pelo "fim da fila" e recalcula a nova posição que será
		// considerada como fim.
		dados[fim] = elemento.clone();
		fim = (fim + 1) % tamanho;

		// .. e sinaliza que houve sucesso na operação
		return true;
	}

	/**
	 * Remove (dequeue) o elemento que está a frente da fila.
	 * 
	 * @return o elemento que foi removido da estrutura.
	 */
	public TDado remover() {
		TDado temp = null;
		if (!estaVazia()) {
			// Aqui não há a necessidade de clonar pois o elemento será efetivamente
			// removido da estrutura, então não há qualquer problema em devolver a
			// referência do objeto.
			temp = dados[inicio];
			// Liberamos o "slot" vetor e recalcularmos o novo início da fila
			dados[inicio] = null;
			inicio = (inicio + 1) % tamanho;
		}
		return temp;
	}

	/**
	 * Consulta o elemento que está na frente da estrutura sem removê-lo.
	 * 
	 * @return retorna o elemento que está a frente na fila.
	 */
	public TDado frente() {
		return (estaVazia()) ? null : dados[inicio].clone();
	}

	/**
	 * Retorna uma cópia de todos os elementos da estrutura, sem removê-los.
	 * @return um vetor com todos os objetos que estão armazenados na fila.
	 */
	public TDado[] conteudo() {
		// Neste método temp representará uma coleção de elementos a serem retorna-
		// -dos. A princípio não sabemos se há ou não elementos armazenados na estru-
		// -tura, então vamos supor a coleção como sendo completamente vazia (null).
		TDado[] temp = null;

		// Se a estrutura não estiver vazia ...
		if (!estaVazia()) {
			// Nossa coleção tem o tamanho da quantidade de elementos da estrutura,
			// então vamos criar um vetor deste tamanho.
			temp = new TDado[getQtdeElementos()];

			// Para cada posição do vetor temp teremos uma cópia (clone) do elemento
			// armazenado na posição correspondente do vetor que representa a estrutura
			int posicao = inicio;
			for (int i = 0; i < getQtdeElementos(); i++) {
				temp[posicao] = dados[posicao].clone();
				posicao = (posicao + 1) % tamanho;
			}
		}

		// Por fim devolvemos o objeto temp, seja ele null ou uma coleção de cópias
		// dos elementos armazenados na estrutura
		return temp;
	}

}