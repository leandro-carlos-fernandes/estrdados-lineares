# Listas Encadeadas (Linked List) - Implementação Estática

São estruturas lineares que operam segundo de maneira bastante flexível, permitindo inserções e remoções de elementos em qualquer posição lógica da estrutura (inicio, fim ou entre dois elementos).

### Operações:

- *inserção (add)*: insere um novo elemento numa determinada posição da Lista.
- *remoção (pop)*: remove um elemento em particular ou o elemento que encontra-se numa determinada posição da Lista.

### Implementação:

Para evitar a movimentação de dados que acontece quando implementamos Listas em vetores, nesta versão tornaremos a ordem (sequência lógica) dos elementos determinada por um controle separado. Isto é, utilizaremos uma forma independente do índice do vetor para registrar de qual é o sucessor de cada elemento. 

Nesta versão definimos:

- um vetor, chamado *dados*, para armazenar os dados; e
- um vetor chamado *proximos* para registrar qual é o sucessor do elemento corrente;
- uma variável *indiceDoPrimeiro*, para indicar a localização do primeiro elemento da Lista no vetor de dados, e  
- uma variável *qtdeDeElementos* que nos informa a quantidade de dados que estão armazenadas na estrutura naquele momento. 