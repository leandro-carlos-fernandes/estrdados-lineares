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
		int opcao;				// armazena a op��o do menu escolhida
		int confirmaEncerrar; 	// armazena a resposta sobre o encerramento do programa 
		String entrada;			// guarda a informa��o fornecida pelo usu�rio
		
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
						+ "Qual op��o deseja?",
						"Pilha (Stacks)", JOptionPane.PLAIN_MESSAGE);
			opcao = Integer.parseInt(entrada);
			
			// Tratamento das op��es
			switch (opcao) {
			
			case 1: // 1. Criar uma pilha
				entrada = JOptionPane.showInputDialog(null,
						"Qual a quantidade m�xima de elementos que a estrutura dever� comportar?",
						"Criar pilha", JOptionPane.PLAIN_MESSAGE);
				pilha = new Pilha( Integer.parseInt(entrada) );
				JOptionPane.showMessageDialog(null,
						"Pilha criada com sucesso!\nNela ser� poss�vel armazenar at� " + entrada + " elementos.",
						"Criar pilha", JOptionPane.INFORMATION_MESSAGE);
				break;
				
			case 2: //2. Inserir um elemento na pilha
				if ( pilha == null) {
					JOptionPane.showMessageDialog(null,
							"Nenhuma pilha foi criada ainda, voc� ter� que fazer isso antes de poder us�-la.",
							"Ops ...", JOptionPane.WARNING_MESSAGE);
				}
				else if ( pilha.estaCheia()) {
					JOptionPane.showMessageDialog(null,
							"A pilha est� cheia, n�o h� espa�o para inserir novos elementos.",
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
							"Inser��o realizada com sucesso!\nO elemento " + elem.getValor() + " foi inserido na pilha",
							"Inserir na pilha", JOptionPane.INFORMATION_MESSAGE);
				}
				break;
				
			case 3: // 3. Remover o elemento da pilha
				if ( pilha == null) {
					JOptionPane.showMessageDialog(null,
							"Nenhuma pilha foi criada ainda, voc� ter� que fazer isso antes de poder us�-la.",
							"Ops ...", JOptionPane.WARNING_MESSAGE);
				}
				else if ( pilha.estaVazia()) {
					JOptionPane.showMessageDialog(null,
							"A pilha est� vazia, n�o h� elementos para serem removidos.",
							"Remover da pilha", JOptionPane.WARNING_MESSAGE);
				}
				else {				
					elem = pilha.desempilha();
					JOptionPane.showMessageDialog(null,
							"Remo��o realizada com sucesso!\nO elemento " + elem.getValor() + " foi removido da pilha.",
							"Remover da pilha", JOptionPane.INFORMATION_MESSAGE);
				}
				break;
				
			case 4: // 4. etornar o elemento do topo da pilha
				if ( pilha == null) {
					JOptionPane.showMessageDialog(null,
							"Nenhuma pilha foi criada ainda, voc� ter� que fazer isso antes de poder us�-la.",
							"Ops ...", JOptionPane.WARNING_MESSAGE);
				}
				else if ( pilha.estaVazia()) {
					JOptionPane.showMessageDialog(null,
							"A pilha est� vazia, n�o h� elementos para serem consultados.",
							"Consultar elemento do topo", JOptionPane.WARNING_MESSAGE);
				}
				else {
					elem = pilha.topo();
					JOptionPane.showMessageDialog(null,
							"O elemento armazenado no topo da pilha � " + elem.getValor() + ".",
							"Consultar elemento do topo", JOptionPane.INFORMATION_MESSAGE);
				}
				break;
				
			case 5: // 5. Retornar todos os elementos da pilha
				if ( pilha == null) {
					JOptionPane.showMessageDialog(null,
							"Nenhuma pilha foi criada ainda, voc� ter� que fazer isso antes de us�-la.",
							"Ops ...", JOptionPane.WARNING_MESSAGE);
				}
				else if ( pilha.estaVazia()) {
					JOptionPane.showMessageDialog(null,
							"A pilha est� vazia, n�o h� elementos a serem exibidos.",
							"Conte�do da pilha", JOptionPane.PLAIN_MESSAGE);
				}
				else {
					String msg = "Os elementos armazenados s�o:\n";
					TDado[] conteudoDaPilha = pilha.conteudo();
					for (int i = 0; i < conteudoDaPilha.length; i++) {
						msg += conteudoDaPilha[i].getValor() + " ";
					}
					JOptionPane.showMessageDialog(null, msg,
							"Conte�do da pilha", JOptionPane.PLAIN_MESSAGE);
				}
				break;
				
			case 6: // 6. Encerrar o programa
				confirmaEncerrar = JOptionPane.showConfirmDialog(null,
						"Voc� deseja mesmo encerrar o programa?",
						"Encerrar", JOptionPane.OK_CANCEL_OPTION);
				break;
				
			default: // .. e caso n�o seja nenhuma da op��es oferecidas 
				JOptionPane.showMessageDialog(null,
						"Op��o inv�lida, voc� ter� que inform�-la novamente.",
						"Ops ...", JOptionPane.WARNING_MESSAGE);
			}
			
		} while (confirmaEncerrar != JOptionPane.OK_OPTION);
		System.exit(0);
	}

}