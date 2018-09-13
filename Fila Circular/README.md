# Filas (Queue)

São estruturas lineares que operam segundo a política F.I.F.O. (Fist In, First Out), ou seja, o primeiro elemento inserido na estrutura também é o primeiro a ser removido dela.

Seu funcionamento pode ser explicado informalmente através de uma analogia com uma *fila de banco*. Nela temos:
- as pessoas se organizam uma atrás das outras, de maneira linear. 
- sempre que uma nova pessoa entra na fila, posiciona-se logo depois do último da fila.
- o caixa do banco atende a pessoa que está a frente da fila (o primeiro), então podemos dizer que o caixa sempre retira o primeiro indivíduo da fila.

### Operações:

- *inserção (queue)*: insere um novo elemento na fila, posicionado-o ao final da sequência de elementos armazenados.
- *remoção (dequeue)*: remove o elemento que está no início da fila.
- *inicio (front)*: retorna o elemento do início da fila, porém sem removê-lo.

### Implementação:

Implementar filas usando um vetor para armazenar os dados pode ser uma forma conveniente. Entretanto, dependendo da forma como os dados são trabalhados no vetor, implicará numa grande movimentação de informações para manter a coesão da estrutura. Por exemplo, se estabelecermos que o elemento do início sempre estará posicionado no índice 0 do vetor, a cada remoção todos os dados deverão ser movimentados uma posição (assim como nós quando caminhamos dentro da fila).

Este problema pode ser facilmente resolvido através de uma *implementação circular*, em que o final do vetor é virtualmente transposto para o seu início, tal como se estivessem colados um no outro e formando um anel. 

O vetor é trabalhado em duas seções: uma contendo dados, dado pelo área identificada entre o início e o fim; e outra contendo as posições vazias (livres), que são dadas pelos índices entre os controles de fim e início.

Nesta implementação definimos:

- um vetor, chamado *dados*, para armazenar os dados;
- uma variável *inicio* que contém o índice do vetor correspondente ao primeiro elemento da fila num dado momento;
- uma variável *fim* que contém o índice do vetor correspondente ao último elemento da fila num dado momento;
- a quantidade de elementos armazenados foi trabalhada como um informação derivada, computada a partir dos dois controles: *inicio* e *fim*.