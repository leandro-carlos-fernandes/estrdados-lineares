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
		int posicao;			// armazena a posi��o ordinal dentro da estrutura
		int opcao;				// armazena a op��o do menu escolhida
		int confirmaEncerrar; 	// armazena a resposta sobre o encerramento do programa 
		String entrada;			// guarda a informa��o fornecida pelo usu�rio
		
		lst = null;
		confirmaEncerrar = JOptionPane.NO_OPTION;
		
		do {
			// Menu principal
			entrada = JOptionPane.showInputDialog(null,
						"Menu principal:\n\n"
						+ "1. Criar uma lista\n"
						+ "2. Inserir um elemento E na P-�sima posi��o\n"
						+ "3. Remover o elemento da P-�sima posi��o\n"
						+ "4. Remover o elemento E da lista\n"
						+ "5. Retornar o elemento da P-�sima posi��o\n"
						+ "6. Retornar todos os elementos da lista\n"
						+ "7. Encerrar o programa.\n\n"
						+ "Qual op��o deseja?",
						"Lista linear", JOptionPane.PLAIN_MESSAGE);
			opcao = Integer.parseInt(entrada);
			
			// Tratamento das op��es
			switch (opcao) {
			
			case 1: // 1. Criar uma lista
				entrada = JOptionPane.showInputDialog(null,
						"Qual a quantidade m�xima de elementos que a estrutura dever� comportar?",
						"Criar lista", JOptionPane.PLAIN_MESSAGE);
				lst = new Lista( Integer.parseInt(entrada) );
				JOptionPane.showMessageDialog(null,
						"Lista criada com sucesso!\nNela ser� poss�vel armazenar at� " + entrada + " elementos.",
						"Criar lista", JOptionPane.INFORMATION_MESSAGE);
				break;
				
			case 2: //2. Inserir um elemento E na P-�sima posi��o
				if ( lst == null) {
					JOptionPane.showMessageDialog(null,
							"Nenhuma lista foi criada ainda, voc� ter� que fazer isso antes de poder us�-la.",
							"Ops ...", JOptionPane.WARNING_MESSAGE);
				}
				else if ( lst.estaCheia()) {
					JOptionPane.showMessageDialog(null,
							"A lista est� cheia, n�o h� espa�o para inserir novos elementos.",
							"Inserir na lista", JOptionPane.WARNING_MESSAGE);
				}
				else {
					entrada = JOptionPane.showInputDialog(null,
							"Qual valor que deseja armazenar?",
							"Inserir na lista", JOptionPane.PLAIN_MESSAGE);
					elem = new TDado();
					elem.setValor( Integer.parseInt(entrada) );
					
					entrada = JOptionPane.showInputDialog(null,
							"Em qual posi��o da lista?",
							"Inserir na lista", JOptionPane.PLAIN_MESSAGE);
					posicao = Integer.parseInt(entrada);
					
					if ( lst.insere(elem, posicao) )
						JOptionPane.showMessageDialog(null,
								"Inser��o realizada com sucesso!\nO elemento " + elem.getValor() + " foi inserido na " + posicao + "� posi��o",
								"Inserir na lista", JOptionPane.INFORMATION_MESSAGE);
					else
						JOptionPane.showMessageDialog(null,
								"Falha no processo de inser��o, opera��o n�o realizada!\nVerifique se lista n�o est� cheia ou se a posi��o informada � inv�lida, depois tente novamente.",
								"Inserir na lista", JOptionPane.ERROR_MESSAGE);
				}
				break;
				
			case 3: // 3. Remover o elemento da P-�sima posi��o
				if ( lst == null) {
					JOptionPane.showMessageDialog(null,
							"Nenhuma lista foi criada ainda, voc� ter� que fazer isso antes de poder us�-la.",
							"Ops ...", JOptionPane.WARNING_MESSAGE);
				}
				else if ( lst.estaVazia()) {
					JOptionPane.showMessageDialog(null,
							"A lista est� vazia, n�o h� elementos para serem removidos.",
							"Remover da lista", JOptionPane.WARNING_MESSAGE);
				}
				else {				
					entrada = JOptionPane.showInputDialog(null,
							"Qual a posi��o do elemento que deseja remover?",
							"Remover da lista", JOptionPane.PLAIN_MESSAGE);
					posicao = Integer.parseInt(entrada);
					
					if ( lst.remove(posicao) )
						JOptionPane.showMessageDialog(null,
								"Remo��o realizada com sucesso!\nO elemento da " + posicao + "� posi��o foi removido da lista.",
								"Remover da lista", JOptionPane.INFORMATION_MESSAGE);
					else
						JOptionPane.showMessageDialog(null,
								"Falha no processo de remo��o, opera��o n�o realizada!\nVerifique se a posi��o informada cont�m um elemento e depois tente novamente.",
								"Remover da lista", JOptionPane.ERROR_MESSAGE);
				}
				break;
				
			case 4: // 4. Remover o elemento E da lista
				if ( lst == null) {
					JOptionPane.showMessageDialog(null,
							"Nenhuma lista foi criada ainda, voc� ter� que fazer isso antes de poder us�-la.",
							"Ops ...", JOptionPane.WARNING_MESSAGE);
				}
				else if ( lst.estaVazia()) {
					JOptionPane.showMessageDialog(null,
							"A lista est� vazia, n�o h� elementos para serem removidos.",
							"Remover da lista", JOptionPane.WARNING_MESSAGE);
				}
				else {
					entrada = JOptionPane.showInputDialog(null,
							"Qual � o valor que deseja remover da estrutura?",
							"Remover da lista", JOptionPane.PLAIN_MESSAGE);
					elem = new TDado();
					elem.setValor( Integer.parseInt(entrada) );
					
					if ( lst.remove(elem) )
						JOptionPane.showMessageDialog(null,
								"Remo��o realizada com sucesso!\nO elemento " + elem.getValor() + " foi removido da lista.",
								"Remover da lista", JOptionPane.INFORMATION_MESSAGE);
					else
						JOptionPane.showMessageDialog(null,
								"Falha no processo de remo��o, opera��o n�o realizada!\nVerifique se o elemento informado est� na lista e tente novamente.",
								"Remover da lista", JOptionPane.ERROR_MESSAGE);
				}
				break;
				
			case 5: // 5. Retornar o elemento da P-�sima posi��o
				if ( lst == null) {
					JOptionPane.showMessageDialog(null,
							"Nenhuma lista foi criada ainda, voc� ter� que fazer isso antes de us�-la.",
							"Ops ...", JOptionPane.WARNING_MESSAGE);
				}
				else if ( lst.estaVazia()) {
					JOptionPane.showMessageDialog(null,
							"A lista est� vazia, n�o h� elementos a serem exibidos.",
							"Listar um elemento", JOptionPane.PLAIN_MESSAGE);
				}
				else {
					entrada = JOptionPane.showInputDialog(null,
							"De qual posi��o da lista deseja recuperar a informa��o?",
							"Listar um elemento", JOptionPane.PLAIN_MESSAGE);
					posicao = Integer.parseInt(entrada);
					
					elem = lst.getElementoDaPosicao(posicao);
					
					if (elem == null) {
						JOptionPane.showMessageDialog(null,
								"Falha no processo de recupera��o!\nVerifique se a posi��o informada � v�lida e tente novamente.",
								"Listar um elemento", JOptionPane.ERROR_MESSAGE);
					}
					else {
						JOptionPane.showMessageDialog(null,
								"Na " + posicao + "� posi��o est� armazenado o elemento " + elem.getValor(),
								"Listar um elemento", JOptionPane.PLAIN_MESSAGE);
					}
				}
				break;
				
			case 6: // 6. Retornar todos os elementos da lista
				if ( lst == null) {
					JOptionPane.showMessageDialog(null,
							"Nenhuma lista foi criada ainda, voc� ter� que fazer isso antes de us�-la.",
							"Ops ...", JOptionPane.WARNING_MESSAGE);
				}
				else if ( lst.estaVazia()) {
					JOptionPane.showMessageDialog(null,
							"A lista est� vazia, n�o h� elementos a serem exibidos.",
							"Listar conte�do", JOptionPane.PLAIN_MESSAGE);
				}
				else {
					String msg = "Os elementos armazenados s�o:\n";
					TDado[] conteudoDaLista = lst.listaTodos();
					for (int i = 0; i < conteudoDaLista.length; i++) {
						msg += conteudoDaLista[i].getValor() + " ";
					}
					JOptionPane.showMessageDialog(null, msg,
							"Listar conte�do", JOptionPane.PLAIN_MESSAGE);
				}
				break;
				
			case 7: // 7. Encerrar o programa
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
