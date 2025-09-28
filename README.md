# Projeto de Conclusão da Unidade III - Algoritmos e Estrutura de Dados

- **Aluno:** William Brito
- **Curso:** Análise e Desenvolvimento de Sistemas
- **Disciplina:** Algoritmos e Estrutura de Dados

### 📚 Descrição do Projeto

Este repositório contém a resolução dos 10 exercícios práticos propostos na **Unidade III** da disciplina. O foco desta unidade é a implementação e aplicação de estruturas de dados não lineares e algoritmos de busca mais avançados em Java.

As atividades exploram temas essenciais como a construção e manipulação de **Árvores Binárias** e **Árvores Binárias de Busca (BSTs)**, a diferença prática entre **Busca Linear e Binária**, e a representação e travessia de **Grafos** com os algoritmos **BFS** (Busca em Largura) e **DFS** (Busca em Profundidade). Por fim, os desafios combinam esses conceitos para resolver problemas mais complexos, como encontrar o caminho mais curto em um mapa com distâncias (Dijkstra) e ordenar tarefas com dependências (Ordenação Topológica).

### 🚀 Tecnologias e Conceitos Utilizados

-   **Linguagem:** Java
-   **JDK (Java Development Kit):** 11 ou superior.
-   **Estruturas de Dados Implementadas:**
    -   Árvore Binária de Busca (`ArvoreBinariaBiblioteca`)
    -   Grafo com Lista de Adjacências (`GrafoRoteamento`)
    -   Grafo Ponderado e Direcionado (`GrafoAvancado`)
-   **Algoritmos Aplicados:**
    -   Busca Linear e Binária
    -   Percursos em Árvore (Pré-Ordem, Em Ordem, Pós-Ordem)
    -   Busca em Largura (BFS)
    -   Busca em Profundidade (DFS)
    -   Algoritmo de Dijkstra
    -   Ordenação Topológica (Algoritmo de Kahn)

### ⚙️ Como Compilar e Executar

O projeto foi estruturado de forma coesa, com todas as classes interagindo a partir de um ponto de entrada único. Para executar, siga os passos abaixo em um terminal.

1.  **Compilação:**
    Certifique-se de que todos os arquivos `.java` (`Main.java`, `Livro.java`, `NoArvore.java`, etc.) estejam na mesma pasta. Em seguida, compile a classe principal:
    ```bash
    javac Main.java
    ```

2.  **Execução:**
    Após a compilação bem-sucedida, execute o programa principal que irá demonstrar todas as atividades:
    ```bash
    java Main
    ```

### 📂 Detalhamento dos Exercícios

A seguir, uma descrição da lógica e dos conceitos aplicados em cada atividade.

#### **Árvore Binária e BST (Árvore Binária de Busca)**

**1 - Implementação da Árvore Binária**
* **Descrição:** Simula um sistema de biblioteca criando uma Árvore Binária para armazenar e organizar livros.
* **Conceitos Aplicados:** Criação de classes `No` e `Livro`, inserção recursiva de elementos e implementação dos três métodos de percurso: pré-ordem, em-ordem (que lista os livros ordenadamente por ID) e pós-ordem.

**2 - Validação de BST**
* **Descrição:** Verifica se uma árvore de categorias de produtos segue as regras de uma Árvore Binária de Busca (BST).
* **Conceitos Aplicados:** Método recursivo que valida se cada nó está dentro de um intervalo de valores (mínimo e máximo), garantindo a propriedade fundamental da BST.

**8 - Mínimo de uma BST**
* **Descrição:** Encontra o produto mais barato (menor valor) em uma BST.
* **Conceitos Aplicados:** Exploração da propriedade da BST onde o menor valor está sempre localizado no nó mais à esquerda da árvore, acessado por um simples laço iterativo.

#### **Busca Linear e Binária**

**3 - Busca Linear**
* **Descrição:** Encontra a posição de um número de telefone em uma agenda de contatos.
* **Conceitos Aplicados:** Algoritmo sequencial que percorre um array do início ao fim, comparando cada elemento. Simples, mas com complexidade de tempo O(n).

**4 - Busca Binária**
* **Descrição:** Localiza um elemento de forma eficiente em uma grande lista de dados já ordenados.
* **Conceitos Aplicados:** Algoritmo de "dividir para conquistar", que reduz o espaço de busca pela metade a cada passo, alcançando uma complexidade de tempo O(log n).

#### **Grafos, BFS e DFS**

**5 - Representação de Grafos**
* **Descrição:** Cria um mapa de conexões entre locais para um aplicativo de navegação.
* **Conceitos Aplicados:** Implementação de um Grafo utilizando **Lista de Adjacências** com um `HashMap`, onde cada chave é um local e seu valor é uma lista de locais vizinhos.

**6 - BFS em Grafos**
* **Descrição:** Encontra a rota com o menor número de paradas entre dois pontos em um mapa não ponderado.
* **Conceitos Aplicados:** **Busca em Largura (BFS)**, que utiliza uma `Queue` (Fila) para explorar o grafo em camadas, garantindo a descoberta do caminho mais curto.

**7 - DFS em Grafos**
* **Descrição:** Exibe todas as rotas possíveis a partir de um ponto de origem, explorando cada caminho até o seu final.
* **Conceitos Aplicados:** **Busca em Profundidade (DFS)**, implementada de forma recursiva para visitar os nós de maneira profunda, ideal para visualizar a topologia do grafo.

#### **Aplicações e Desafios Combinados**

**9 - Caminho Mais Curto em Grafo Ponderado**
* **Descrição:** Calcula a rota mais eficiente entre dois pontos, desta vez considerando as distâncias (pesos) de cada trecho.
* **Conceitos Aplicados:** **Algoritmo de Dijkstra**, que utiliza uma `PriorityQueue` para otimizar a busca pelo caminho de menor custo total em um grafo ponderado.

**10 - Ordenação de Grafos**
* **Descrição:** Organiza um conjunto de tarefas que possuem dependências entre si (ex: uma tarefa deve ser feita antes de outra).
* **Conceitos Aplicados:** **Ordenação Topológica** (usando o Algoritmo de Kahn), que organiza os vértices de um Grafo Acíclico Direcionado (DAG) em uma sequência linear válida.

