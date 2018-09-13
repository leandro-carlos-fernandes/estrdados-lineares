# Pilhas (Stack)

S�o estruturas lineares que operam segundo a pol�tica F.I.L.O. (Fist In, Last Out), ou seja, o primeiro elemento que � inserido na estrutura ser� o �ltimo a ser removido.

Seu funcionamento pode ser explicado informalmente atrav�s de uma analogia com um *pilha de caixas*. Nela temos:
- os elementos s�o empilhados um em cima do outro.
- h� uma caixa que ocupa a �ltima posi��o da pilha, ao alto, a quem podemos dizer ser o "caixa no topo".
- sempre que uma nova caixa precisa ser adicionada a pilha � colocada no topo, acima da �ltima.
- de igual maneira, sempre que precisamos remover uma caixa, o fazemos retirando a que est� no topo para que a pilha n�o se desestruture e caia.   

### Opera��es:

- *inser��o (push)*: insere um novo elemento na pilha
- *remo��o (pop)*: remove o elemento do topo
- *topo (get)*: retorna o elemento do topo, sem remov�-lo