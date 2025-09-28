import java.util.*;

/**
 * ===================================================================
 * ATIVIDADE UNIDADE 3 - ALGORITMOS E ESTRUTURA DE DADOS
 * ===================================================================
 */

// Classe para representar a entidade principal da nossa Árvore Binária (Questão 1)
class Livro implements Comparable<Livro> {
    int id;
    String titulo;

    public Livro(int id, String titulo) {
        this.id = id;
        this.titulo = titulo;
    }

    @Override
    public String toString() {
        return "ID: " + id + ", Título: '" + titulo + "'";
    }

    // O método compareTo é essencial para que a Árvore Binária de Busca (BST)
    // saiba como ordenar os livros, neste caso, pelo ID.
    @Override
    public int compareTo(Livro outro) {
        return Integer.compare(this.id, outro.id);
    }
}

// Classe que representa cada nó da nossa árvore (Questões 1, 2, 8)
class NoArvore {
    Livro livro;
    NoArvore esquerda, direita;

    public NoArvore(Livro livro) {
        this.livro = livro;
        this.esquerda = null;
        this.direita = null;
    }
}

/**
 * 1 - Implementação da Árvore Binária para uma Biblioteca.
 * Esta classe gerencia a estrutura da árvore, inserindo livros e permitindo
 * diferentes formas de visualizá-los através dos percursos.
 */
class ArvoreBinariaBiblioteca {
    NoArvore raiz;

    public ArvoreBinariaBiblioteca() {
        this.raiz = null;
    }

    // Método público para iniciar a inserção a partir da raiz.
    public void inserir(Livro livro) {
        raiz = inserirRecursivo(raiz, livro);
    }

    // Inserir um novo livro (nó) na árvore.
    // A lógica aqui é para uma Árvore Binária de Busca (BST), que já organiza os livros por ID.
    private NoArvore inserirRecursivo(NoArvore noAtual, Livro livro) {
        // Se a árvore (ou sub-árvore) estiver vazia, este livro será o novo nó.
        if (noAtual == null) {
            return new NoArvore(livro);
        }

        // Para manter a ordem, se o ID do novo livro for menor, ele vai para a esquerda.
        if (livro.id < noAtual.livro.id) {
            noAtual.esquerda = inserirRecursivo(noAtual.esquerda, livro);
        // Se for maior, vai para a direita.
        } else if (livro.id > noAtual.livro.id) {
            noAtual.direita = inserirRecursivo(noAtual.direita, livro);
        }

        // Retornamos o nó (com a nova inserção feita em algum lugar abaixo dele).
        return noAtual;
    }

    // --- MÉTODOS DE PERCURSO ---

    // 1. Percurso em Pré-Ordem (Raiz, Esquerda, Direita)
    public void percorrerPreOrdem() {
        System.out.println("\n--- Percurso em Pré-Ordem ---");
        percorrerPreOrdemRecursivo(raiz);
        System.out.println();
    }

    private void percorrerPreOrdemRecursivo(NoArvore no) {
        if (no != null) {
            System.out.print(no.livro.titulo + " | "); // Visita a raiz primeiro
            percorrerPreOrdemRecursivo(no.esquerda); // Depois a sub-árvore esquerda
            percorrerPreOrdemRecursivo(no.direita);  // Por fim, a sub-árvore direita
        }
    }

    // 2. Percurso Em Ordem (Esquerda, Raiz, Direita) - Lista os livros em ordem crescente de ID!
    public void percorrerEmOrdem() {
        System.out.println("\n--- Percurso Em Ordem (In-Order) ---");
        percorrerEmOrdemRecursivo(raiz);
        System.out.println();
    }

    private void percorrerEmOrdemRecursivo(NoArvore no) {
        if (no != null) {
            percorrerEmOrdemRecursivo(no.esquerda); // Visita a sub-árvore esquerda
            System.out.print(no.livro.titulo + " | "); // Visita a raiz
            percorrerEmOrdemRecursivo(no.direita);  // Visita a sub-árvore direita
        }
    }

    // 3. Percurso em Pós-Ordem (Esquerda, Direita, Raiz)
    public void percorrerPosOrdem() {
        System.out.println("\n--- Percurso em Pós-Ordem ---");
        percorrerPosOrdemRecursivo(raiz);
        System.out.println();
    }

    private void percorrerPosOrdemRecursivo(NoArvore no) {
        if (no != null) {
            percorrerPosOrdemRecursivo(no.esquerda); // Visita a sub-árvore esquerda
            percorrerPosOrdemRecursivo(no.direita);  // Visita a sub-árvore direita
            System.out.print(no.livro.titulo + " | "); // Por último, visita a raiz
        }
    }

    /**
     * 2 - Validação de BST (Árvore Binária de Busca).
     * Este método verifica se a árvore atual segue as regras de uma BST.
     */
    public boolean ehBST() {
        // Para verificar, usamos limites. A raiz pode ter qualquer valor (null, null).
        return ehBSTRecursivo(raiz, null, null);
    }

    // O truque aqui é garantir que cada nó esteja dentro de um intervalo válido (min, max).
    private boolean ehBSTRecursivo(NoArvore no, Integer min, Integer max) {
        // Uma árvore vazia é, por definição, uma BST.
        if (no == null) {
            return true;
        }

        // Se o valor do nó estiver fora dos limites esperados, a árvore não é uma BST.
        if ((min != null && no.livro.id <= min) || (max != null && no.livro.id >= max)) {
            return false;
        }

        // Verificamos recursivamente:
        // - Para a esquerda, o valor máximo agora é o valor do nó atual.
        // - Para a direita, o valor mínimo agora é o valor do nó atual.
        return ehBSTRecursivo(no.esquerda, min, no.livro.id) &&
               ehBSTRecursivo(no.direita, no.livro.id, max);
    }
    
    /**
     * 8 - Encontrar o valor mínimo em uma BST.
     * Em uma BST, o menor valor está sempre no nó mais à esquerda.
     */
    public Livro encontrarMenorValor() {
        if (raiz == null) {
            return null; // A árvore está vazia.
        }
        
        NoArvore noAtual = raiz;
        // Simplesmente navegamos para a esquerda até não poder mais.
        while (noAtual.esquerda != null) {
            noAtual = noAtual.esquerda;
        }
        
        return noAtual.livro;
    }
}


/**
 * Classe com métodos estáticos para os algoritmos de busca (Questões 3 e 4).
 */
class MetodosDeBusca {

    /**
     * 3 - Busca Linear.
     * Percorre a lista item por item, como se estivesse procurando um nome em uma
     * lista de chamada, um por um.
     */
    public static int buscaLinear(int[] contatos, int numeroBuscado) {
        // Vamos olhar cada contato na agenda, um de cada vez.
        for (int i = 0; i < contatos.length; i++) {
            // Se o contato atual for o que estamos procurando...
            if (contatos[i] == numeroBuscado) {
                // ...encontramos! Retornamos sua posição.
                return i;
            }
        }
        // Se olharmos toda a lista e não acharmos, retornamos -1.
        return -1;
    }

    /**
     * 4 - Busca Binária.
     * Um método muito mais esperto, mas que exige que a lista esteja ordenada.
     * Funciona como procurar uma palavra em um dicionário: você abre no meio e
     * decide se vai para a primeira ou segunda metade.
     */
    public static int buscaBinaria(int[] dadosOrdenados, int elementoBuscado) {
        int esquerda = 0;
        int direita = dadosOrdenados.length - 1;

        // Enquanto ainda houver uma parte da lista para procurar...
        while (esquerda <= direita) {
            // ...achamos o "meio" da parte que estamos olhando.
            int meio = esquerda + (direita - esquerda) / 2;

            // Se o elemento do meio for o que queremos, bingo!
            if (dadosOrdenados[meio] == elementoBuscado) {
                return meio;
            }

            // Se o nosso número for menor, só precisamos procurar na metade da esquerda.
            if (dadosOrdenados[meio] > elementoBuscado) {
                direita = meio - 1;
            // Se for maior, só precisamos procurar na metade da direita.
            } else {
                esquerda = meio + 1;
            }
        }
        // Se a busca terminar e não encontrarmos nada, ele não está na lista.
        return -1;
    }
}


/**
 * 5 - Representação de Grafos.
 * Esta classe representa um mapa de locais (vértices) e as rotas (arestas) entre eles.
 * Usamos uma Lista de Adjacências, que é ótima para mapas onde nem todos os
 * locais se conectam diretamente.
 */
class GrafoRoteamento {
    // Usamos um Map para associar cada local (String) a uma lista de seus vizinhos.
    private Map<String, List<String>> listaAdjacencia = new HashMap<>();

    // Adiciona um novo local ao nosso mapa.
    public void adicionarLocal(String local) {
        listaAdjacencia.putIfAbsent(local, new ArrayList<>());
    }

    // Cria uma rota de mão dupla entre dois locais.
    public void adicionarRota(String localA, String localB) {
        // Garante que ambos os locais existam no mapa.
        listaAdjacencia.putIfAbsent(localA, new ArrayList<>());
        listaAdjacencia.putIfAbsent(localB, new ArrayList<>());

        // Adiciona a rota de A para B e de B para A.
        listaAdjacencia.get(localA).add(localB);
        listaAdjacencia.get(localB).add(localA);
    }
    
    public List<String> getVizinhos(String local) {
        return listaAdjacencia.getOrDefault(local, Collections.emptyList());
    }
    
    public Set<String> getLocais() {
        return listaAdjacencia.keySet();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (String local : listaAdjacencia.keySet()) {
            sb.append(local).append(" -> ").append(listaAdjacencia.get(local)).append("\n");
        }
        return sb.toString();
    }
    
    /**
     * 6 - BFS em Grafos (Busca em Largura).
     * Ideal para encontrar o caminho mais curto em termos de "número de paradas".
     * Ele explora o mapa em camadas: primeiro os vizinhos, depois os vizinhos dos vizinhos...
     */
    public List<String> bfsCaminhoMaisCurto(String inicio, String fim) {
        Queue<String> fila = new LinkedList<>();
        Map<String, String> predecessores = new HashMap<>();
        Set<String> visitados = new HashSet<>();
        
        fila.add(inicio);
        visitados.add(inicio);
        
        while (!fila.isEmpty()) {
            String atual = fila.poll();
            
            if (atual.equals(fim)) {
                // Chegamos ao destino! Agora, vamos reconstruir o caminho.
                List<String> caminho = new LinkedList<>();
                String passo = fim;
                while (passo != null) {
                    caminho.add(0, passo); // Adiciona no início para inverter a ordem
                    passo = predecessores.get(passo);
                }
                return caminho;
            }
            
            for (String vizinho : getVizinhos(atual)) {
                if (!visitados.contains(vizinho)) {
                    visitados.add(vizinho);
                    predecessores.put(vizinho, atual); // Guarda de onde viemos
                    fila.add(vizinho);
                }
            }
        }
        
        return Collections.emptyList(); // Não encontrou caminho
    }

    /**
     * 7 - DFS em Grafos (Busca em Profundidade).
     * Explora um caminho até o fim antes de tentar outro. É como explorar um labirinto,
     * sempre seguindo em frente por um corredor até bater numa parede, para depois voltar e tentar outro.
     */
    public void dfsExibirRotas(String inicio) {
        Set<String> visitados = new HashSet<>();
        System.out.println("\n--- Exploração de Rotas via DFS a partir de '" + inicio + "' ---");
        dfsRecursivo(inicio, visitados);
        System.out.println();
    }
    
    private void dfsRecursivo(String atual, Set<String> visitados) {
        visitados.add(atual);
        System.out.print(atual + " -> ");
        
        for (String vizinho : getVizinhos(atual)) {
            if (!visitados.contains(vizinho)) {
                dfsRecursivo(vizinho, visitados);
            }
        }
    }
}

/**
 * Classe para as questões 9 e 10, que exigem um grafo mais complexo (direcionado e ponderado).
 */
class GrafoAvancado {
    
    // Classe interna para representar uma rota com seu destino e custo (distância).
    static class Rota {
        String destino;
        int distancia;

        Rota(String destino, int distancia) {
            this.destino = destino;
            this.distancia = distancia;
        }
    }
    
    private final Map<String, List<Rota>> listaAdjacencia = new HashMap<>();

    public void adicionarLocal(String local) {
        listaAdjacencia.putIfAbsent(local, new ArrayList<>());
    }

    // Adiciona uma rota ponderada e direcionada (só de ida).
    public void adicionarRota(String origem, String destino, int distancia) {
        this.adicionarLocal(origem);
        this.adicionarLocal(destino);
        listaAdjacencia.get(origem).add(new Rota(destino, distancia));
    }

    /**
     * 9 - Caminho Mais Curto em Grafo Ponderado (Algoritmo de Dijkstra).
     * Uma evolução do BFS que leva em conta a "distância" ou "custo" de cada rota.
     */
    public List<String> dijkstraCaminhoMaisCurto(String inicio, String fim) {
        Map<String, Integer> distancias = new HashMap<>();
        Map<String, String> predecessores = new HashMap<>();
        // Fila de prioridade para sempre escolher o caminho mais curto até agora.
        PriorityQueue<String> fila = new PriorityQueue<>(Comparator.comparingInt(distancias::get));
        
        for(String local : listaAdjacencia.keySet()) {
            distancias.put(local, Integer.MAX_VALUE);
        }
        distancias.put(inicio, 0);
        fila.add(inicio);
        
        while (!fila.isEmpty()) {
            String atual = fila.poll();
            
            if(atual.equals(fim)) break; // Otimização: para se já achamos o destino

            for (Rota rota : listaAdjacencia.getOrDefault(atual, Collections.emptyList())) {
                int novaDistancia = distancias.get(atual) + rota.distancia;
                if (novaDistancia < distancias.get(rota.destino)) {
                    distancias.put(rota.destino, novaDistancia);
                    predecessores.put(rota.destino, atual);
                    fila.add(rota.destino);
                }
            }
        }

        // Reconstrói o caminho, assim como no BFS.
        List<String> caminho = new LinkedList<>();
        String passo = fim;
        if(distancias.get(passo) == Integer.MAX_VALUE) return Collections.emptyList(); // Caminho não encontrado

        while(passo != null) {
            caminho.add(0, passo);
            passo = predecessores.get(passo);
        }
        System.out.println("Distância total: " + distancias.get(fim));
        return caminho;
    }
    
    /**
     * 10 - Ordenação Topológica (Algoritmo de Kahn).
     * Organiza tarefas que têm dependências. Ex: "Você precisa colocar a meia antes do sapato".
     * Só funciona para Grafos Acíclicos Direcionados (DAGs).
     */
    public List<String> ordenacaoTopologica() {
        Map<String, Integer> grauEntrada = new HashMap<>();
        for (String local : listaAdjacencia.keySet()) {
            grauEntrada.put(local, 0);
        }
        for (List<Rota> rotas : listaAdjacencia.values()) {
            for (Rota rota : rotas) {
                grauEntrada.put(rota.destino, grauEntrada.get(rota.destino) + 1);
            }
        }
        
        Queue<String> fila = new LinkedList<>();
        for (String local : grauEntrada.keySet()) {
            if (grauEntrada.get(local) == 0) {
                fila.add(local);
            }
        }
        
        List<String> ordenacao = new ArrayList<>();
        while (!fila.isEmpty()) {
            String atual = fila.poll();
            ordenacao.add(atual);
            
            for (Rota rota : listaAdjacencia.getOrDefault(atual, Collections.emptyList())) {
                grauEntrada.put(rota.destino, grauEntrada.get(rota.destino) - 1);
                if (grauEntrada.get(rota.destino) == 0) {
                    fila.add(rota.destino);
                }
            }
        }
        
        // Se a ordenação não inclui todos os locais, há um ciclo no grafo!
        if (ordenacao.size() != listaAdjacencia.size()) {
            System.out.println("Erro: O grafo contém um ciclo e não pode ser ordenado topologicamente.");
            return Collections.emptyList();
        }
        
        return ordenacao;
    }
}

// Classe principal para testar todas as funcionalidades.
public class Main {
    public static void main(String[] args) {
        
        // --- Teste da Questão 1, 2 e 8: Árvore Binária e BST ---
        System.out.println("=================================================");
        System.out.println("EXERCÍCIOS 1, 2 E 8: ÁRVORE BINÁRIA E BST");
        System.out.println("=================================================");
        
        ArvoreBinariaBiblioteca biblioteca = new ArvoreBinariaBiblioteca();
        biblioteca.inserir(new Livro(50, "O Senhor dos Anéis"));
        biblioteca.inserir(new Livro(30, "O Hobbit"));
        biblioteca.inserir(new Livro(70, "Crônicas de Nárnia"));
        biblioteca.inserir(new Livro(20, "A Arte da Guerra"));
        biblioteca.inserir(new Livro(40, "1984"));
        biblioteca.inserir(new Livro(60, "O Guia do Mochileiro das Galáxias"));
        biblioteca.inserir(new Livro(80, "Duna"));

        biblioteca.percorrerEmOrdem();
        biblioteca.percorrerPreOrdem();
        biblioteca.percorrerPosOrdem();

        System.out.println("\n[QUESTÃO 2] A árvore da biblioteca é uma BST? " + biblioteca.ehBST());
        System.out.println("[QUESTÃO 8] O livro com menor ID (mais barato) é: " + biblioteca.encontrarMenorValor());


        // --- Teste da Questão 3 e 4: Buscas Linear e Binária ---
        System.out.println("\n=================================================");
        System.out.println("EXERCÍCIOS 3 E 4: BUSCA LINEAR E BINÁRIA");
        System.out.println("=================================================");
        
        int[] contatos = {99123456, 98876543, 99998888, 98123987};
        int[] dadosOrdenados = {10, 20, 30, 40, 50, 60, 70, 80, 90, 100};
        
        System.out.println("[QUESTÃO 3] Busca Linear por 99998888: Posição " + MetodosDeBusca.buscaLinear(contatos, 99998888));
        System.out.println("[QUESTÃO 4] Busca Binária por 70: Posição " + MetodosDeBusca.buscaBinaria(dadosOrdenados, 70));
        System.out.println("[QUESTÃO 4] Busca Binária por 75 (não existe): Posição " + MetodosDeBusca.buscaBinaria(dadosOrdenados, 75));


        // --- Teste da Questão 5, 6 e 7: Grafos, BFS e DFS ---
        System.out.println("\n=================================================");
        System.out.println("EXERCÍCIOS 5, 6 E 7: GRAFOS, BFS E DFS");
        System.out.println("=================================================");
        
        GrafoRoteamento mapa = new GrafoRoteamento();
        mapa.adicionarLocal("Casa");
        mapa.adicionarLocal("Trabalho");
        mapa.adicionarLocal("Academia");
        mapa.adicionarLocal("Mercado");
        mapa.adicionarLocal("Parque");
        
        mapa.adicionarRota("Casa", "Mercado");
        mapa.adicionarRota("Casa", "Parque");
        mapa.adicionarRota("Mercado", "Academia");
        mapa.adicionarRota("Academia", "Trabalho");
        mapa.adicionarRota("Parque", "Trabalho");
        
        System.out.println("[QUESTÃO 5] Representação do Grafo (Mapa):\n" + mapa);
        
        System.out.println("[QUESTÃO 6] Caminho mais curto (BFS) de Casa para Trabalho: " + mapa.bfsCaminhoMaisCurto("Casa", "Trabalho"));

        mapa.dfsExibirRotas("Casa");


        // --- Teste da Questão 9: Grafo Ponderado (Dijkstra) ---
        System.out.println("\n=================================================");
        System.out.println("EXERCÍCIO 9: CAMINHO MAIS CURTO PONDERADO");
        System.out.println("=================================================");
        GrafoAvancado mapaPonderado = new GrafoAvancado();
        mapaPonderado.adicionarRota("A", "B", 4);
        mapaPonderado.adicionarRota("A", "C", 2);
        mapaPonderado.adicionarRota("B", "C", 5);
        mapaPonderado.adicionarRota("B", "D", 10);
        mapaPonderado.adicionarRota("C", "E", 3);
        mapaPonderado.adicionarRota("E", "D", 4);
        mapaPonderado.adicionarRota("D", "F", 11);
        mapaPonderado.adicionarRota("E", "F", 12);
        
        System.out.println("Caminho mais curto de A para F (Dijkstra): " + mapaPonderado.dijkstraCaminhoMaisCurto("A", "F"));


        // --- Teste da Questão 10: Ordenação Topológica ---
        System.out.println("\n=================================================");
        System.out.println("EXERCÍCIO 10: ORDENAÇÃO TOPOLÓGICA");
        System.out.println("=================================================");
        GrafoAvancado tarefas = new GrafoAvancado();
        tarefas.adicionarRota("Vestir meias", "Vestir sapatos", 0);
        tarefas.adicionarRota("Vestir camisa", "Vestir casaco", 0);
        tarefas.adicionarRota("Vestir calça", "Vestir sapatos", 0);
        tarefas.adicionarRota("Vestir calça", "Colocar cinto", 0);
        
        System.out.println("Ordem correta para se vestir (Topológica): " + tarefas.ordenacaoTopologica());

    }
}