# Listas (List)

S�o estruturas lineares que operam segundo de maneira bastante flex�vel, permitindo inser��es e remo��es de elementos em qualquer posi��o l�gica da estrutura (inicio, fim ou entre dois elementos).

### Opera��es:

- *inser��o (add)*: insere um novo elemento numa determinada posi��o da Lista.
- *remo��o (pop)*: remove um elemento em particular ou o elemento que encontra-se numa determinada posi��o da Lista.

### Implementa��o:

Por se tratar de uma estrutura linear � comum usarmos um vetor para armazenar os dados, j� disp�em de v�rias posi��es para guardar as informa��es; e s�o lineares por sua pr�pria concep��o.
� necess�rio manter a informa��o armazenada de forma coesa e evitar "espa�os vazios" no vetor, assim � preciso que:
- a cada inser��o um novo espa�o seja providenciado antes de que o elemento seja de fato adicionado; e
- em cada remo��o, os elementos sejam reposicionados de modo a suprimir o espa�o vazio deixado pela aus�ncia daquele removido.

Nesta vers�o definimos:

- um vetor, chamado *dados*, para armazenar os dados; e
- uma vari�vel *qtdeDeElementos* que nos informa a quantidade de dados que est�o armazenadas na estrutura naquele momento. 