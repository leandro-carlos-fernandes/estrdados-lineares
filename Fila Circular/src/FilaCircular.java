/**
 * Esta classe representa uma estrutura de dados do tipo FILA. Isto significa
 * que que armazena seus elementos de maneira seq�encial (linear), atendendo a
 * pol�ticas de opera��o tal que o primeiro elemento a ser inserido na estrutura
 * tamb�m ser� o primeiro a ser removido (F.I.F.O. - First In, First Out). Esta
 * vers�o em particular, trata-se de uma implementa��o dita circular, pois a
 * distribui��o l�gica dos dados dentro do vetor est�tico � dada em duas
 * regi�es: uma que cont�m os dados e outra que cont�m posi��es livres; como se
 * estivessem virtualmente ligadas uma a outro (com o fim colado no inicio,
 * formando um c�rculo).
 * 
 * @author Leandro
 *
 */
public class FilaCircular {

	// -----------------------
	// ------ Atributos ------
	// -----------------------
	private TDado dados[];	// Vetor respons�vel por reter (armazenar) os
							// elementos dentro da estrutura de dados.

	private int inicio; 	// Indica o in�cio da �rea de dados do vetor. Seu
							// valor indica a posi��o do vetor onde est�
							// armazenado o primeiro elemento da estrutura em
							// cada instante.

	private int fim; 		// Indica o t�rmino da �rea de dados do vetor. Seu
							// valor indica a posi��o do vetor onde ser�
							// armazenado o pr�ximo elemento na estrutura.

	private int tamanho;	// Corresponde a capacidade m�xima de armazenagem.

	
	// -----------------------
	// ------- M�todos -------
	// -----------------------

	/**
	 * Cria uma estrutura de dados do tipo Fila
	 * 
	 * @param tamanho equivale a capacidade m�xima de armazenamento da estrutura
	 *                oferecer�.
	 */
	public FilaCircular(int tamanho) {
		dados = new TDado[tamanho];
		this.tamanho = tamanho;
		inicio = 0;
		fim = 0;
	}

	public FilaCircular() {
		this(10); // Ao inv�s de duplicarmos o c�digo do 1o construtor (anterior),
					// podemos simplesmente invoc�-lo informando tamanho desejado como
					// par�metro, que neste caso � igual a 10
	}

	/*------------------------------------
	 * Opera��es auxiliares da fila
	 *-----------------------------------*/

	/**
	 * Retorna a quantidade de elementos armazenados na estrutura
	 * 
	 * @return quantidade de elementos
	 */
	public int getQtdeElementos() {
		// Neste tipo de estrutura, a quantidade de elementos armazenadas � derivada
		// em fun��o dos atributos in�cio e fim. A quantidade � dada pela diferen�a
		// entre fim e in�cio, somando o tamanho m�ximo de armazenamento e calculando
		// o resto da divis�o.
		return (tamanho + fim - inicio) % tamanho;
	}

	/**
	 * Verifica se a estrutura n�o cont�m elementos armazenados
	 * 
	 * @return verdadeiro quando n�o h� qualquer elemento armazenado
	 */
	public boolean estaVazia() {
		return (this.getQtdeElementos() == 0) ? true : false;
	}

	/**
	 * Verifica se a estrutura est� com sua capacidade de armazenamento esgotada
	 * 
	 * @return verdadeiro quando n�o h� mais espa�o para armazenamento.
	 */
	public boolean estaCheia() {
		return (this.getQtdeElementos() == tamanho) ? true : false;
	}

	/**
	 * Retorna a capacidade m�xima de armazenamento da Fila
	 * 
	 * @return valor correspondente a capacidade m�xima de armazenamento.
	 */
	public int capacidadeTotal() {
		return tamanho;
	}

	/**
	 * Insere (enqueue) um novo elemento na fila (enqueue)
	 * 
	 * @param elemento corresponde ao elemento a ser inserido na estrutura
	 * @return verdadeiro caso haja sucesso na opera��o e falso em caso contr�rio
	 */
	public boolean inserir(TDado elemento) {
		// H� espa�o para uma nova inser��o?
		if (estaCheia())
			return false;

		// Clona o objeto informado, armazena uma c�pia dele dentro da estrutura na
		// posi��o indicada pelo "fim da fila" e recalcula a nova posi��o que ser�
		// considerada como fim.
		dados[fim] = elemento.clone();
		fim = (fim + 1) % tamanho;

		// .. e sinaliza que houve sucesso na opera��o
		return true;
	}

	/**
	 * Remove (dequeue) o elemento que est� a frente da fila.
	 * 
	 * @return o elemento que foi removido da estrutura.
	 */
	public TDado remover() {
		TDado temp = null;
		if (!estaVazia()) {
			// Aqui n�o h� a necessidade de clonar pois o elemento ser� efetivamente
			// removido da estrutura, ent�o n�o h� qualquer problema em devolver a
			// refer�ncia do objeto.
			temp = dados[inicio];
			// Liberamos o "slot" vetor e recalcularmos o novo in�cio da fila
			dados[inicio] = null;
			inicio = (inicio + 1) % tamanho;
		}
		return temp;
	}

	/**
	 * Consulta o elemento que est� na frente da estrutura sem remov�-lo.
	 * 
	 * @return retorna o elemento que est� a frente na fila.
	 */
	public TDado frente() {
		return (estaVazia()) ? null : dados[inicio].clone();
	}

	/**
	 * Retorna uma c�pia de todos os elementos da estrutura, sem remov�-los.
	 * @return um vetor com todos os objetos que est�o armazenados na fila.
	 */
	public TDado[] conteudo() {
		// Neste m�todo temp representar� uma cole��o de elementos a serem retorna-
		// -dos. A princ�pio n�o sabemos se h� ou n�o elementos armazenados na estru-
		// -tura, ent�o vamos supor a cole��o como sendo completamente vazia (null).
		TDado[] temp = null;

		// Se a estrutura n�o estiver vazia ...
		if (!estaVazia()) {
			// Nossa cole��o tem o tamanho da quantidade de elementos da estrutura,
			// ent�o vamos criar um vetor deste tamanho.
			temp = new TDado[getQtdeElementos()];

			// Para cada posi��o do vetor temp teremos uma c�pia (clone) do elemento
			// armazenado na posi��o correspondente do vetor que representa a estrutura
			int posicao = inicio;
			for (int i = 0; i < getQtdeElementos(); i++) {
				temp[posicao] = dados[posicao].clone();
				posicao = (posicao + 1) % tamanho;
			}
		}

		// Por fim devolvemos o objeto temp, seja ele null ou uma cole��o de c�pias
		// dos elementos armazenados na estrutura
		return temp;
	}

}