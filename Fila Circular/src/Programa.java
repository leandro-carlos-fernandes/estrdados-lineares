import javax.swing.JOptionPane;

/**
 * Este programa cria e opera um estrutura de dados do tipo fila,
 * com o objetivo de mostrar e testar suas funcionalidades.
 * 
 * @author Leandro
 *
 */
public class Programa {
	
	public static void main(String[] args) {
		
		FilaCircular fila;		// ref. fila de dados do nosso programa
		TDado elem; 			// ref. elemento que desejamos inserir, remover ou pesquisar
		int opcao;				// armazena a opção do menu escolhida
		int confirmaEncerrar; 	// armazena a resposta sobre o encerramento do programa 
		String entrada;			// guarda a informação fornecida pelo usuário
		
		fila = null;
		confirmaEncerrar = JOptionPane.NO_OPTION;
		
		do {
			// Menu principal
			entrada = JOptionPane.showInputDialog(null,
						"Menu principal:\n\n"
						+ "1. Criar uma nova fila\n"
						+ "2. Inserir um elemento na fila\n"
						+ "3. Remover um elemento da fila\n"
						+ "4. Retornar o elemento da frente da fila\n"
						+ "5. Retornar todos os elementos da fila\n"
						+ "6. Encerrar o programa.\n\n"
						+ "Qual opção deseja?",
						"Filas (impl. circular)", JOptionPane.PLAIN_MESSAGE);
			opcao = Integer.parseInt(entrada);
			
			// Tratamento das opções
			switch (opcao) {
			
			case 1: // 1. Criar uma fila
				entrada = JOptionPane.showInputDialog(null,
						"Qual a quantidade máxima de elementos que a estrutura deverá comportar?",
						"Criar fila", JOptionPane.PLAIN_MESSAGE);
				fila = new FilaCircular( Integer.parseInt(entrada) );
				JOptionPane.showMessageDialog(null,
						"Fila criada com sucesso!\nNela será possível armazenar até " + entrada + " elementos.",
						"Criar fila", JOptionPane.INFORMATION_MESSAGE);
				break;
				
			case 2: //2. Inserir um elemento na fila
				if ( fila == null) {
					JOptionPane.showMessageDialog(null,
							"Nenhuma fila foi criada ainda, você terá que fazer isso antes de poder usá-la.",
							"Ops ...", JOptionPane.WARNING_MESSAGE);
				}
				else if ( fila.estaCheia()) {
					JOptionPane.showMessageDialog(null,
							"A fila está cheia, não há espaço para inserir novos elementos.",
							"Inserir na fila", JOptionPane.WARNING_MESSAGE);
				}
				else {
					entrada = JOptionPane.showInputDialog(null,
							"Qual valor que deseja armazenar?",
							"Inserir na fila", JOptionPane.PLAIN_MESSAGE);
					elem = new TDado();
					elem.setValor( Integer.parseInt(entrada) );
									
					fila.inserir(elem);
					JOptionPane.showMessageDialog(null,
							"Inserção realizada com sucesso!\nO elemento " + elem.getValor() + " foi inserido na fila",
							"Inserir na fila", JOptionPane.INFORMATION_MESSAGE);
				}
				break;
				
			case 3: // 3. Remover o elemento da fila
				if ( fila == null) {
					JOptionPane.showMessageDialog(null,
							"Nenhuma fila foi criada ainda, você terá que fazer isso antes de poder usá-la.",
							"Ops ...", JOptionPane.WARNING_MESSAGE);
				}
				else if ( fila.estaVazia()) {
					JOptionPane.showMessageDialog(null,
							"A fila está vazia, não há elementos para serem removidos.",
							"Remover da fila", JOptionPane.WARNING_MESSAGE);
				}
				else {				
					elem = fila.remover();
					JOptionPane.showMessageDialog(null,
							"Remoção realizada com sucesso!\nO elemento " + elem.getValor() + " foi removido da fila.",
							"Remover da fila", JOptionPane.INFORMATION_MESSAGE);
				}
				break;
				
			case 4: // 4. Retornar o elemento da frente da fila
				if ( fila == null) {
					JOptionPane.showMessageDialog(null,
							"Nenhuma fila foi criada ainda, você terá que fazer isso antes de poder usá-la.",
							"Ops ...", JOptionPane.WARNING_MESSAGE);
				}
				else if ( fila.estaVazia()) {
					JOptionPane.showMessageDialog(null,
							"A fila está vazia, não há elementos para serem consultados.",
							"Consultar elemento da frente", JOptionPane.WARNING_MESSAGE);
				}
				else {
					elem = fila.frente();
					JOptionPane.showMessageDialog(null,
							"O elemento armazenado no topo da fila é " + elem.getValor() + ".",
							"Consultar elemento da frente", JOptionPane.INFORMATION_MESSAGE);
				}
				break;
				
			case 5: // 5. Retornar todos os elementos da fila
				if ( fila == null) {
					JOptionPane.showMessageDialog(null,
							"Nenhuma fila foi criada ainda, você terá que fazer isso antes de usá-la.",
							"Ops ...", JOptionPane.WARNING_MESSAGE);
				}
				else if ( fila.estaVazia()) {
					JOptionPane.showMessageDialog(null,
							"A fila está vazia, não há elementos a serem exibidos.",
							"Conteúdo da fila", JOptionPane.PLAIN_MESSAGE);
				}
				else {
					String msg = "Os elementos armazenados são:\n";
					TDado[] conteudoDaFila = fila.conteudo();
					for (int i = 0; i < conteudoDaFila.length; i++) {
						msg += conteudoDaFila[i].getValor() + " ";
					}
					JOptionPane.showMessageDialog(null, msg,
							"Conteúdo da fila", JOptionPane.PLAIN_MESSAGE);
				}
				break;
				
			case 6: // 6. Encerrar o programa
				confirmaEncerrar = JOptionPane.showConfirmDialog(null,
						"Você deseja mesmo encerrar o programa?",
						"Encerrar", JOptionPane.OK_CANCEL_OPTION);
				break;
				
			default: // .. e caso não seja nenhuma da opções oferecidas 
				JOptionPane.showMessageDialog(null,
						"Opção inválida, você terá que informá-la novamente.",
						"Ops ...", JOptionPane.WARNING_MESSAGE);
			}
			
		} while (confirmaEncerrar != JOptionPane.OK_OPTION);
		System.exit(0);
	}

}
