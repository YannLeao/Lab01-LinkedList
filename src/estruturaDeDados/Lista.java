package estruturaDeDados;

public class Lista {

    Node head;
    int size;

    public Lista() {
        this.head = null;
        this.size = 0;
    }

    public void insereInicio(int i) {
        Node newNode = new Node(i);
        newNode.next = head;
        head = newNode;
        size++;
    }

    public boolean buscaElemento(int i) {
        if (head == null) {
            return false;
        }
        
        Node actual = head;
        while(actual != null) {
            if (actual.value == i) {
                return true;
            }
            actual = actual.next;
        }
        return false;
    }

    public Object buscaIndice(int index) {
        if (index < 0 || index > size ) {
            return null;
        }

        Node actual = head;
        for (int i = 0; i < index ; i++){
            actual = actual.next;
        }
        return actual;
    }

    public void insereFim(int i) {
        Node newNode = new Node(i);

        if (head == null) {
            head = newNode;
        } else {
            Node actual = head;

            while (actual.next != null) {
                actual = actual.next;
            }
            actual.next = newNode;
        }
        size++;
    }

    public void removeInicio() {
        if (size == 0) {
            head = null;
            return;
        }
        head = head.next;
        size--;
    }

    public void removeFim() {
        if (head == null) return;
        if (head.next == null) {
            head = null;
        } else {
            Node actual = head;
            while (actual.next != null) {
                actual = actual.next;
            }
            actual = null;
        }
        size --;
    }

    public void removeIndice(int index) {
        if (index < 0 || index > size) return;
        if (index == 0) removeInicio();

        Node previous = head;
        for (int i = 0; i < index - 1; i++) {
            previous = previous.next;
        }
        previous.next = previous.next.next;
        size--;

    }

    public void insereElementoPosicao(int index, int value) {
        if (index < 0 || index > size) return;
        if (index == 0) {
            insereInicio(value);
            return;
        }
        if (index == size) {
            insereFim(value);
            return;
        }

        Node newNode = new Node(value);
        Node previous = head;

        for (int i = 0; i < index - 1; i++) {
            previous = previous.next;
        }

        newNode.next = previous.next;
        previous.next = newNode;


    }
    
}
