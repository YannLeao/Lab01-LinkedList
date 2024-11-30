package estruturaDeDados;

public class ListaCircular {
    Node root;
    int size;

    public ListaCircular() {
        root = null;
        size = 0;
    }

    public void insereInicio(int i) {
    Node newNode = new Node(i);
    if (size ==  0) {
        root = newNode;
        root.next = root;
        size++;
        return;
    }
    newNode.next = root.next;
    root.next = newNode;
    size++;
    return;

    }

    public boolean buscaElemento(int i) {
       if (size == 0) return false;

       Node actual = root;
       do {
           if (actual.value == i) return true;
           actual = actual.next;

       } while (actual == root);

       return false;
    }

    public Object buscaIndice(int index) {
        if (index <= 0) return null;

        Node actual = root;
        for (int i = 0; i < index % size; i++) {
            actual = actual.next;
        }
        return actual;
    }

    public void insereFim(int i) {
        Node newNode = new Node(i);
        if (size ==  0) {
            root = newNode;
            root.next = root;
            size++;
            return;
        }
        newNode.next = root.next;
        root.next = newNode;
        root = newNode;
        size++;
        return;
    }

    public void removeInicio() {
        if (size == 0) return;
        if (size == 1) {
            root = null;
            size--;
            return;
        }
        root.next = root.next.next;
        size--;
        return;
    }

    public void removeFim() {
        if (size == 0) return;
        if (size == 1) {
            root = null;
            size--;
            return;
        }
        Node previous = root.next;

        while (previous.next != root) {
            previous = previous.next;
        }
        previous.next = root.next;
        root = previous;
        size--;
        return;
    }

    public void removeIndice(int index) {
        if (size == 0) return;
        if (size == 1) {
            root = null;
            size--;
            return;
        }
        Node previous = root;
        for (int i = 0; i < index % size - 1; i++) {
            previous = previous.next;
        }
        previous.next = previous.next.next;
        size--;
        return;
    }

    public void insereElementoPosicao(int index, int value) {
        if (index < 0) return;
        Node newNode = new Node(value);
        if (size ==  0) {
            root = newNode;
            root.next = root;
            size++;
            return;
        }
        Node previous = root;
        for (int i = 0; i < index % size - 1; i++) {
            previous = previous.next;
        }
        newNode.next = previous.next;
        previous.next = newNode;
        size++;
        return;

    }
}
