# Pilhas (Stack)

São estruturas lineares que operam segundo a política F.I.L.O. (Fist In, Last Out), ou seja, o primeiro elemento que é inserido na estrutura será o último a ser removido.

Seu funcionamento pode ser explicado informalmente através de uma analogia com um *pilha de caixas*. Nela temos:
- os elementos são empilhados um em cima do outro.
- há uma caixa que ocupa a última posição da pilha, ao alto, a quem podemos dizer ser o "caixa no topo".
- sempre que uma nova caixa precisa ser adicionada a pilha é colocada no topo, acima da última.
- de igual maneira, sempre que precisamos remover uma caixa, o fazemos retirando a que está no topo para que a pilha não se desestruture e caia.   

### Operações:

- *inserção (push)*: insere um novo elemento na pilha
- *remoção (pop)*: remove o elemento do topo
- *topo (get)*: retorna o elemento do topo, sem removê-lo