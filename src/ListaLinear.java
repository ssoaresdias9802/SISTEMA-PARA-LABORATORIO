public class ListaLinear <T> {
    T[] A; // generico
    int capacity; // capacidade do vetor
    int size; // elementos no vetor,quant tem

    public ListaLinear (int capacity) {
        A = (T[]) new Object[capacity]; //flexibilidade 
        this.size = 0;
        this.capacity = capacity;
    }
    public boolean isEmpty() {
        // verificar se vetor está vazio
        if (size == 0) {
            return true;
        } else {
            return false;
        }
    }
    public int size() {
        // retorna quant de elem na lista, serve d limitador
       return size;
    }
    public T get(int i) throws Exception {
        // lança exception, mostra oq tem na posicao i
        if (i >= size) {
            throw new Exception ("Posição inválida");
            
        }
        return A[i];
        
    }
    public void set(int i, T n) throws Exception {
        // altera o conteudo da posicao i por n, substituicao
        if (i >= size) {
            throw new Exception ("Posição inválida");
            
        }
        A[i] = n;
    }
    public void add(int i, T n) throws Exception {
        // insere novo element na posicao esp
        if (size == capacity) {
            throw new Exception ("A lista está cheia!");
        }
        else if (i>size) {
            throw new Exception ("Posição de inseção Inválida!");
        }
        for (int z = size; z > i; z--) {
            A[z] = A[z-1];
        }
        A[i] = n;
        size++;

    }
    public void remove(int i) throws Exception {
        // remove conteudo posi i
        if (isEmpty()) {
            throw new Exception("A lista está vazia !");
        } else if (i >= size) {
            throw new Exception("Posição inválida");
        }
        for (int z = i; z < size-1; z++){
            A[z]=A[z+1];
        }
        size--;
    }
    public int search(T n) {
       for(int i =0; i<size; i++){
        // se o nome q ta no vetor é igual ao parametro
           if (A[i].equals(n)) { //generico
                return i;
            }
            
        }
        return -1;
    }
    /*public void mostrarLista() {
        System.out.println("\nElementos da lista");
        System.out.println("=================");
        for (int i =0; i<size; i++){
            Exame e = (Exame) A[i];
            System.out.println(e.abrev);
            System.out.println(e.nome);
            System.out.println(e.qtDias);
        }
    }*/
}