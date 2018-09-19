import javax.swing.JOptionPane;

/**
 * Este programa cria e opera um estrutura de dados do tipo lista,
 * com o objetivo de mostrar e testar suas funcionalidades.
 * @author Leandro
 *
 */
public class Programa {
	
	public static void main(String[] args) {
		
		Lista lst;				// ref. lista de dados do nosso programa
		TDado elem; 			// ref. elemento que desejamos inserir, remover ou pesquisar
		int posicao;			// armazena a posição ordinal dentro da estrutura
		int opcao;				// armazena a opção do menu escolhida
		int confirmaEncerrar; 	// armazena a resposta sobre o encerramento do programa 
		String entrada;			// guarda a informação fornecida pelo usuário
		
		lst = null;
		confirmaEncerrar = JOptionPane.NO_OPTION;
		
		do {
			// Menu principal
			entrada = JOptionPane.showInputDialog(null,
						"Menu principal:\n\n"
						+ "1. Criar uma lista\n"
						+ "2. Inserir um elemento E na P-ésima posição\n"
						+ "3. Remover o elemento da P-ésima posição\n"
						+ "4. Remover o elemento E da lista\n"
						+ "5. Retornar o elemento da P-ésima posição\n"
						+ "6. Retornar todos os elementos da lista\n"
						+ "7. Encerrar o programa.\n\n"
						+ "Qual opção deseja?",
						"Lista linear", JOptionPane.PLAIN_MESSAGE);
			opcao = Integer.parseInt(entrada);
			
			// Tratamento das opções
			switch (opcao) {
			
			case 1: // 1. Criar uma lista
				entrada = JOptionPane.showInputDialog(null,
						"Qual a quantidade máxima de elementos que a estrutura deverá comportar?",
						"Criar lista", JOptionPane.PLAIN_MESSAGE);
				lst = new Lista( Integer.parseInt(entrada) );
				JOptionPane.showMessageDialog(null,
						"Lista criada com sucesso!\nNela será possível armazenar até " + entrada + " elementos.",
						"Criar lista", JOptionPane.INFORMATION_MESSAGE);
				break;
				
			case 2: //2. Inserir um elemento E na P-ésima posição
				if ( lst == null) {
					JOptionPane.showMessageDialog(null,
							"Nenhuma lista foi criada ainda, você terá que fazer isso antes de poder usá-la.",
							"Ops ...", JOptionPane.WARNING_MESSAGE);
				}
				else if ( lst.estaCheia()) {
					JOptionPane.showMessageDialog(null,
							"A lista está cheia, não há espaço para inserir novos elementos.",
							"Inserir na lista", JOptionPane.WARNING_MESSAGE);
				}
				else {
					entrada = JOptionPane.showInputDialog(null,
							"Qual valor que deseja armazenar?",
							"Inserir na lista", JOptionPane.PLAIN_MESSAGE);
					elem = new TDado();
					elem.setValor( Integer.parseInt(entrada) );
					
					entrada = JOptionPane.showInputDialog(null,
							"Em qual posição da lista?",
							"Inserir na lista", JOptionPane.PLAIN_MESSAGE);
					posicao = Integer.parseInt(entrada);
					
					if ( lst.insere(elem, posicao) )
						JOptionPane.showMessageDialog(null,
								"Inserção realizada com sucesso!\nO elemento " + elem.getValor() + " foi inserido na " + posicao + "ª posição",
								"Inserir na lista", JOptionPane.INFORMATION_MESSAGE);
					else
						JOptionPane.showMessageDialog(null,
								"Falha no processo de inserção, operação não realizada!\nVerifique se lista não está cheia ou se a posição informada é inválida, depois tente novamente.",
								"Inserir na lista", JOptionPane.ERROR_MESSAGE);
				}
				break;
				
			case 3: // 3. Remover o elemento da P-ésima posição
				if ( lst == null) {
					JOptionPane.showMessageDialog(null,
							"Nenhuma lista foi criada ainda, você terá que fazer isso antes de poder usá-la.",
							"Ops ...", JOptionPane.WARNING_MESSAGE);
				}
				else if ( lst.estaVazia()) {
					JOptionPane.showMessageDialog(null,
							"A lista está vazia, não há elementos para serem removidos.",
							"Remover da lista", JOptionPane.WARNING_MESSAGE);
				}
				else {				
					entrada = JOptionPane.showInputDialog(null,
							"Qual a posição do elemento que deseja remover?",
							"Remover da lista", JOptionPane.PLAIN_MESSAGE);
					posicao = Integer.parseInt(entrada);
					
					if ( lst.remove(posicao) )
						JOptionPane.showMessageDialog(null,
								"Remoção realizada com sucesso!\nO elemento da " + posicao + "ª posição foi removido da lista.",
								"Remover da lista", JOptionPane.INFORMATION_MESSAGE);
					else
						JOptionPane.showMessageDialog(null,
								"Falha no processo de remoção, operação não realizada!\nVerifique se a posição informada contém um elemento e depois tente novamente.",
								"Remover da lista", JOptionPane.ERROR_MESSAGE);
				}
				break;
				
			case 4: // 4. Remover o elemento E da lista
				if ( lst == null) {
					JOptionPane.showMessageDialog(null,
							"Nenhuma lista foi criada ainda, você terá que fazer isso antes de poder usá-la.",
							"Ops ...", JOptionPane.WARNING_MESSAGE);
				}
				else if ( lst.estaVazia()) {
					JOptionPane.showMessageDialog(null,
							"A lista está vazia, não há elementos para serem removidos.",
							"Remover da lista", JOptionPane.WARNING_MESSAGE);
				}
				else {
					entrada = JOptionPane.showInputDialog(null,
							"Qual é o valor que deseja remover da estrutura?",
							"Remover da lista", JOptionPane.PLAIN_MESSAGE);
					elem = new TDado();
					elem.setValor( Integer.parseInt(entrada) );
					
					if ( lst.remove(elem) )
						JOptionPane.showMessageDialog(null,
								"Remoção realizada com sucesso!\nO elemento " + elem.getValor() + " foi removido da lista.",
								"Remover da lista", JOptionPane.INFORMATION_MESSAGE);
					else
						JOptionPane.showMessageDialog(null,
								"Falha no processo de remoção, operação não realizada!\nVerifique se o elemento informado está na lista e tente novamente.",
								"Remover da lista", JOptionPane.ERROR_MESSAGE);
				}
				break;
				
			case 5: // 5. Retornar o elemento da P-ésima posição
				if ( lst == null) {
					JOptionPane.showMessageDialog(null,
							"Nenhuma lista foi criada ainda, você terá que fazer isso antes de usá-la.",
							"Ops ...", JOptionPane.WARNING_MESSAGE);
				}
				else if ( lst.estaVazia()) {
					JOptionPane.showMessageDialog(null,
							"A lista está vazia, não há elementos a serem exibidos.",
							"Listar um elemento", JOptionPane.PLAIN_MESSAGE);
				}
				else {
					entrada = JOptionPane.showInputDialog(null,
							"De qual posição da lista deseja recuperar a informação?",
							"Listar um elemento", JOptionPane.PLAIN_MESSAGE);
					posicao = Integer.parseInt(entrada);
					
					elem = lst.getElementoDaPosicao(posicao);
					
					if (elem == null) {
						JOptionPane.showMessageDialog(null,
								"Falha no processo de recuperação!\nVerifique se a posição informada é válida e tente novamente.",
								"Listar um elemento", JOptionPane.ERROR_MESSAGE);
					}
					else {
						JOptionPane.showMessageDialog(null,
								"Na " + posicao + "ª posição está armazenado o elemento " + elem.getValor(),
								"Listar um elemento", JOptionPane.PLAIN_MESSAGE);
					}
				}
				break;
				
			case 6: // 6. Retornar todos os elementos da lista
				if ( lst == null) {
					JOptionPane.showMessageDialog(null,
							"Nenhuma lista foi criada ainda, você terá que fazer isso antes de usá-la.",
							"Ops ...", JOptionPane.WARNING_MESSAGE);
				}
				else if ( lst.estaVazia()) {
					JOptionPane.showMessageDialog(null,
							"A lista está vazia, não há elementos a serem exibidos.",
							"Listar conteúdo", JOptionPane.PLAIN_MESSAGE);
				}
				else {
					String msg = "Os elementos armazenados são:\n";
					TDado[] conteudoDaLista = lst.listaTodos();
					for (int i = 0; i < conteudoDaLista.length; i++) {
						msg += conteudoDaLista[i].getValor() + " ";
					}
					JOptionPane.showMessageDialog(null, msg,
							"Listar conteúdo", JOptionPane.PLAIN_MESSAGE);
				}
				break;
				
			case 7: // 7. Encerrar o programa
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
