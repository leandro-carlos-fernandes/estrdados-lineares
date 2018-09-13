# Pilhas (Stack)

S�o estruturas lineares que operam segundo a pol�tica F.I.L.O. (Fist In, Last Out), ou seja, o primeiro elemento que � inserido na estrutura ser� o �ltimo a ser removido.

Seu funcionamento pode ser explicado informalmente atrav�s de uma analogia com um *pilha de caixas*. Nela temos:
- os elementos s�o empilhados um em cima do outro.
- h� uma caixa que ocupa a �ltima posi��o da pilha, ao alto, a quem podemos dizer ser o "caixa no topo".
- sempre que uma nova caixa precisa ser adicionada a pilha � colocada no topo, acima da �ltima.
- de igual maneira, sempre que precisamos remover uma caixa, o fazemos retirando a que est� no topo para que a pilha n�o se desestruture e caia.   

### Opera��es:

- *inser��o (push)*: insere um novo elemento na pilha.
- *remo��o (pop)*: remove o elemento que est� no topo.
- *topo (get)*: retorna o elemento do topo, sem remov�-lo.

### Implementa��o:

A forma mais conveniente de implementar pilhas � usando um vetor para armazenar os dados, haja vista que: j� prov�em v�rias posi��es para guardar as informa��es; e s�o lineares por sua pr�pria concep��o. Assim, fica restando apenas elaborar uma forma de referenciar qual elemento est� no topo da estrutura.

Nesta vers�o definimos:

- um vetor, chamado *dados*, para armazenar os dados; e
- uma vari�vel *topo* que, al�m de conter o �ndice do vetor correspondente ao elemento armazenado no topo da pilha, tamb�m nos informa a quantidade de dados que est�o armazenadas na estrutura naquele momento. 