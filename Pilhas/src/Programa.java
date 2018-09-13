import javax.swing.JOptionPane;

/**
 * Este programa cria e opera um estrutura de dados do tipo pilha,
 * com o objetivo de mostrar e testar suas funcionalidades.
 * 
 * @author Leandro
 *
 */
public class Programa {
	
	public static void main(String[] args) {
		
		Pilha pilha;			// ref. pilha de dados do nosso programa
		TDado elem; 			// ref. elemento que desejamos inserir, remover ou pesquisar
		int opcao;				// armazena a opção do menu escolhida
		int confirmaEncerrar; 	// armazena a resposta sobre o encerramento do programa 
		String entrada;			// guarda a informação fornecida pelo usuário
		
		pilha = null;
		confirmaEncerrar = JOptionPane.NO_OPTION;
		
		do {
			// Menu principal
			entrada = JOptionPane.showInputDialog(null,
						"Menu principal:\n\n"
						+ "1. Criar uma pilha\n"
						+ "2. Inserir um elemento na pilha\n"
						+ "3. Remover um elemento da pilha\n"
						+ "4. Retornar o elemento do topo da pilha\n"
						+ "5. Retornar todos os elementos da pilha\n"
						+ "6. Encerrar o programa.\n\n"
						+ "Qual opção deseja?",
						"Pilha (Stacks)", JOptionPane.PLAIN_MESSAGE);
			opcao = Integer.parseInt(entrada);
			
			// Tratamento das opções
			switch (opcao) {
			
			case 1: // 1. Criar uma pilha
				entrada = JOptionPane.showInputDialog(null,
						"Qual a quantidade máxima de elementos que a estrutura deverá comportar?",
						"Criar pilha", JOptionPane.PLAIN_MESSAGE);
				pilha = new Pilha( Integer.parseInt(entrada) );
				JOptionPane.showMessageDialog(null,
						"Pilha criada com sucesso!\nNela será possível armazenar até " + entrada + " elementos.",
						"Criar pilha", JOptionPane.INFORMATION_MESSAGE);
				break;
				
			case 2: //2. Inserir um elemento na pilha
				if ( pilha == null) {
					JOptionPane.showMessageDialog(null,
							"Nenhuma pilha foi criada ainda, você terá que fazer isso antes de poder usá-la.",
							"Ops ...", JOptionPane.WARNING_MESSAGE);
				}
				else if ( pilha.estaCheia()) {
					JOptionPane.showMessageDialog(null,
							"A pilha está cheia, não há espaço para inserir novos elementos.",
							"Inserir na pilha", JOptionPane.WARNING_MESSAGE);
				}
				else {
					entrada = JOptionPane.showInputDialog(null,
							"Qual valor que deseja armazenar?",
							"Inserir na pilha", JOptionPane.PLAIN_MESSAGE);
					elem = new TDado();
					elem.setValor( Integer.parseInt(entrada) );
									
					pilha.empilha(elem);
					JOptionPane.showMessageDialog(null,
							"Inserção realizada com sucesso!\nO elemento " + elem.getValor() + " foi inserido na pilha",
							"Inserir na pilha", JOptionPane.INFORMATION_MESSAGE);
				}
				break;
				
			case 3: // 3. Remover o elemento da pilha
				if ( pilha == null) {
					JOptionPane.showMessageDialog(null,
							"Nenhuma pilha foi criada ainda, você terá que fazer isso antes de poder usá-la.",
							"Ops ...", JOptionPane.WARNING_MESSAGE);
				}
				else if ( pilha.estaVazia()) {
					JOptionPane.showMessageDialog(null,
							"A pilha está vazia, não há elementos para serem removidos.",
							"Remover da pilha", JOptionPane.WARNING_MESSAGE);
				}
				else {				
					elem = pilha.desempilha();
					JOptionPane.showMessageDialog(null,
							"Remoção realizada com sucesso!\nO elemento " + elem.getValor() + " foi removido da pilha.",
							"Remover da pilha", JOptionPane.INFORMATION_MESSAGE);
				}
				break;
				
			case 4: // 4. etornar o elemento do topo da pilha
				if ( pilha == null) {
					JOptionPane.showMessageDialog(null,
							"Nenhuma pilha foi criada ainda, você terá que fazer isso antes de poder usá-la.",
							"Ops ...", JOptionPane.WARNING_MESSAGE);
				}
				else if ( pilha.estaVazia()) {
					JOptionPane.showMessageDialog(null,
							"A pilha está vazia, não há elementos para serem consultados.",
							"Consultar elemento do topo", JOptionPane.WARNING_MESSAGE);
				}
				else {
					elem = pilha.topo();
					JOptionPane.showMessageDialog(null,
							"O elemento armazenado no topo da pilha é " + elem.getValor() + ".",
							"Consultar elemento do topo", JOptionPane.INFORMATION_MESSAGE);
				}
				break;
				
			case 5: // 5. Retornar todos os elementos da pilha
				if ( pilha == null) {
					JOptionPane.showMessageDialog(null,
							"Nenhuma pilha foi criada ainda, você terá que fazer isso antes de usá-la.",
							"Ops ...", JOptionPane.WARNING_MESSAGE);
				}
				else if ( pilha.estaVazia()) {
					JOptionPane.showMessageDialog(null,
							"A pilha está vazia, não há elementos a serem exibidos.",
							"Conteúdo da pilha", JOptionPane.PLAIN_MESSAGE);
				}
				else {
					String msg = "Os elementos armazenados são:\n";
					TDado[] conteudoDaPilha = pilha.conteudo();
					for (int i = 0; i < conteudoDaPilha.length; i++) {
						msg += conteudoDaPilha[i].getValor() + " ";
					}
					JOptionPane.showMessageDialog(null, msg,
							"Conteúdo da pilha", JOptionPane.PLAIN_MESSAGE);
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