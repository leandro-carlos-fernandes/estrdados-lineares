# Filas (Queue)

S�o estruturas lineares que operam segundo a pol�tica F.I.F.O. (Fist In, First Out), ou seja, o primeiro elemento inserido na estrutura tamb�m � o primeiro a ser removido dela.

Seu funcionamento pode ser explicado informalmente atrav�s de uma analogia com uma *fila de banco*. Nela temos:
- as pessoas se organizam uma atr�s das outras, de maneira linear. 
- sempre que uma nova pessoa entra na fila, posiciona-se logo depois do �ltimo da fila.
- o caixa do banco atende a pessoa que est� a frente da fila (o primeiro), ent�o podemos dizer que o caixa sempre retira o primeiro indiv�duo da fila.

### Opera��es:

- *inser��o (queue)*: insere um novo elemento na fila, posicionado-o ao final da sequ�ncia de elementos armazenados.
- *remo��o (dequeue)*: remove o elemento que est� no in�cio da fila.
- *inicio (front)*: retorna o elemento do in�cio da fila, por�m sem remov�-lo.

### Implementa��o:

Implementar filas usando um vetor para armazenar os dados pode ser uma forma conveniente. Entretanto, dependendo da forma como os dados s�o trabalhados no vetor, implicar� numa grande movimenta��o de informa��es para manter a coes�o da estrutura. Por exemplo, se estabelecermos que o elemento do in�cio sempre estar� posicionado no �ndice 0 do vetor, a cada remo��o todos os dados dever�o ser movimentados uma posi��o (assim como n�s quando caminhamos dentro da fila).

Este problema pode ser facilmente resolvido atrav�s de uma *implementa��o circular*, em que o final do vetor � virtualmente transposto para o seu in�cio, tal como se estivessem colados um no outro e formando um anel. 

O vetor � trabalhado em duas se��es: uma contendo dados, dado pelo �rea identificada entre o in�cio e o fim; e outra contendo as posi��es vazias (livres), que s�o dadas pelos �ndices entre os controles de fim e in�cio.

Nesta implementa��o definimos:

- um vetor, chamado *dados*, para armazenar os dados;
- uma vari�vel *inicio* que cont�m o �ndice do vetor correspondente ao primeiro elemento da fila num dado momento;
- uma vari�vel *fim* que cont�m o �ndice do vetor correspondente ao �ltimo elemento da fila num dado momento;
- a quantidade de elementos armazenados foi trabalhada como um informa��o derivada, computada a partir dos dois controles: *inicio* e *fim*.