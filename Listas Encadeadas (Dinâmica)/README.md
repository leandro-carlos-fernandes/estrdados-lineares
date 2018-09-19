# Listas Encadeadas (Linked List) - Implementa��o Din�mica

S�o estruturas lineares que operam segundo de maneira bastante flex�vel, permitindo inser��es e remo��es de elementos em qualquer posi��o l�gica da estrutura (inicio, fim ou entre dois elementos).

### Opera��es:

- *inser��o (add)*: insere um novo elemento numa determinada posi��o da Lista.
- *remo��o (pop)*: remove um elemento em particular ou o elemento que encontra-se numa determinada posi��o da Lista.

### Implementa��o:

Para evitar a movimenta��o de dados que acontece quando implementamos Listas em vetores, nesta vers�o tornaremos a ordem (sequ�ncia l�gica) dos elementos determinada pelo pr�prio encadeamento de seus elemento. Isto �, cada dado que � armazenado na estrutura tamb�m deve fazer refer�ncia ao seu sucessor. 

Nesta vers�o definimos:

- uma classe chamado *TNo* que representa um n� da Lista, respons�vel por armazenar o dado e tamb�m referenciar o seu sucessor;
- um objeto identificado por *primeiro*, que referencia o primeiro elemento da Lista, e  
- uma vari�vel *qtdeDeElementos* que nos informa a quantidade de dados que est�o armazenadas na estrutura naquele momento. 