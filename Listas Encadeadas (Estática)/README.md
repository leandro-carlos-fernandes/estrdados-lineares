# Listas Encadeadas (Linked List) - Implementa��o Est�tica

S�o estruturas lineares que operam segundo de maneira bastante flex�vel, permitindo inser��es e remo��es de elementos em qualquer posi��o l�gica da estrutura (inicio, fim ou entre dois elementos).

### Opera��es:

- *inser��o (add)*: insere um novo elemento numa determinada posi��o da Lista.
- *remo��o (pop)*: remove um elemento em particular ou o elemento que encontra-se numa determinada posi��o da Lista.

### Implementa��o:

Para evitar a movimenta��o de dados que acontece quando implementamos Listas em vetores, nesta vers�o tornaremos a ordem (sequ�ncia l�gica) dos elementos determinada por um controle separado. Isto �, utilizaremos uma forma independente do �ndice do vetor para registrar de qual � o sucessor de cada elemento. 

Nesta vers�o definimos:

- um vetor, chamado *dados*, para armazenar os dados; e
- um vetor chamado *proximos* para registrar qual � o sucessor do elemento corrente;
- uma vari�vel *indiceDoPrimeiro*, para indicar a localiza��o do primeiro elemento da Lista no vetor de dados, e  
- uma vari�vel *qtdeDeElementos* que nos informa a quantidade de dados que est�o armazenadas na estrutura naquele momento. 