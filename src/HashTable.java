public class HashTable {
    private Node[] table;

    private static class Node {
        int value;
        Node next;

        Node(int value) {
            this.value = value;
        }
    }

    public HashTable(int capacity) {
        table = new Node[capacity];
    }

    private int hash(int value) {
        int index = value % table.length;
        if (index < 0) {
            index += table.length;
        }
        return index;
    }

    public void insert(int value) {
        int index = hash(value);
        Node current = table[index];
        while (current != null) {
            if (current.value == value) {
                return;
            }
            current = current.next;
        }
        Node newNode = new Node(value);
        newNode.next = table[index];
        table[index] = newNode;
    }

    public boolean search(int value) {
        int index = hash(value);
        Node current = table[index];
        while (current != null) {
            if (current.value == value) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    public void delete(int value) {
        int index = hash(value);
        Node current = table[index];
        Node previous = null;
        while (current != null) {
            if (current.value == value) {
                if (previous == null) {
                    table[index] = current.next;
                } else {
                    previous.next = current.next;
                }
                return;
            }
            previous = current;
            current = current.next;
        }
    }
}
