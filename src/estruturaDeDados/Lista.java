package estruturaDeDados;

public class Lista {

    Node head;
    int size;

    public static class Node {
        int valor;
        Node prox;

        Node(int valor) {
            this.valor = valor;
            this.prox = null;
        }
    }    

    public Lista() {
        this.head = null;
        this.size = 0;
    }

    public void insereInicio(int i) {
        Node newNode = new Node(i);
        newNode.prox = head;
        head = newNode;
        size++;
    }

    public boolean buscaElemento(int i) {
        if (head == null) {
            return false;
        }
        
        Node actual = head;
        while(actual != null) {
            if (actual.valor == i) {
                return true;
            }
            actual = actual.prox;
        }
        return false;
    }

    public Object buscaIndice(int index) {
        Node actual = head;

        for (int i = 0; i < index ; i++){
            actual = actual.prox;
        }
        
        return actual;
    }

    public void insereFim(int i) {
        Node newNode = new Node(i);
        Node actual = head;

        while(actual.prox != null) {
            actual = actual.prox;
        }
        actual.prox = newNode;
        size++;
    }

    public void removeInicio() {
        if (size == 0) return;
        head.prox = head;
        size--;
    }

    public void removeFim() {
        if (size == 0) return;

        Node actual = head;
        while (actual.prox == null) {
            actual = actual.prox;
        }
        actual = null;
        size --;
    }

    public void removeIndice(int index) {
        if (size < index) return;

        Node actual = head;
        for (int i = 0; i < index; i++) {
            actual = actual.prox;
        }
        actual= null;
        size --;
    }

    public void insereElementoPosicao(int index, int value) {
        
        if (size == 0) {
            insereInicio(value);
        }
        
        Node actual = head;
        Node ant = null;
        
        for (int i = 0; i < index; i++) {
            actual = actual.prox;
            for (int j = 0; j < index; j++) {
                if (i == 0) {
                    ant = head;
                } else {
                    ant = ant.prox;
                }
                
            }
            
        }

        Node newNode = new Node(value);
        newNode.prox = actual;
        ant.prox = newNode;        
        
    }
    
}
