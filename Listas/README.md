# Listas (List)

São estruturas lineares que operam segundo de maneira bastante flexível, permitindo inserções e remoções de elementos em qualquer posição lógica da estrutura (inicio, fim ou entre dois elementos).

### Operações:

- *inserção (add)*: insere um novo elemento numa determinada posição da Lista.
- *remoção (pop)*: remove um elemento em particular ou o elemento que encontra-se numa determinada posição da Lista.

### Implementação:

Por se tratar de uma estrutura linear é comum usarmos um vetor para armazenar os dados, já dispõem de várias posições para guardar as informações; e são lineares por sua própria concepção.
É necessário manter a informação armazenada de forma coesa e evitar "espaços vazios" no vetor, assim é preciso que:
- a cada inserção um novo espaço seja providenciado antes de que o elemento seja de fato adicionado; e
- em cada remoção, os elementos sejam reposicionados de modo a suprimir o espaço vazio deixado pela ausência daquele removido.

Nesta versão definimos:

- um vetor, chamado *dados*, para armazenar os dados; e
- uma variável *qtdeDeElementos* que nos informa a quantidade de dados que estão armazenadas na estrutura naquele momento. 