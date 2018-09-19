# Listas Encadeadas (Linked List) - Implementação Dinâmica

São estruturas lineares que operam segundo de maneira bastante flexível, permitindo inserções e remoções de elementos em qualquer posição lógica da estrutura (inicio, fim ou entre dois elementos).

### Operações:

- *inserção (add)*: insere um novo elemento numa determinada posição da Lista.
- *remoção (pop)*: remove um elemento em particular ou o elemento que encontra-se numa determinada posição da Lista.

### Implementação:

Para evitar a movimentação de dados que acontece quando implementamos Listas em vetores, nesta versão tornaremos a ordem (sequência lógica) dos elementos determinada pelo próprio encadeamento de seus elemento. Isto é, cada dado que é armazenado na estrutura também deve fazer referência ao seu sucessor. 

Nesta versão definimos:

- uma classe chamado *TNo* que representa um nó da Lista, responsável por armazenar o dado e também referenciar o seu sucessor;
- um objeto identificado por *primeiro*, que referencia o primeiro elemento da Lista, e  
- uma variável *qtdeDeElementos* que nos informa a quantidade de dados que estão armazenadas na estrutura naquele momento. 