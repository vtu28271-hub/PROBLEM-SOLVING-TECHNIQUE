class MyHashSet {

    private static final int SIZE = 1000;
    private Node[] buckets;

    private static class Node {
        int key;
        Node next;

        Node(int key) {
            this.key = key;
            this.next = null;
        }
    }

    public MyHashSet() {
        buckets = new Node[SIZE];
    }

    private int hash(int key) {
        return key % SIZE;
    }

    public void add(int key) {
        int index = hash(key);

        Node current = buckets[index];

        // Check if key already exists
        while (current != null) {
            if (current.key == key) {
                return;
            }
            current = current.next;
        }

        // Add new key
        Node newNode = new Node(key);
        newNode.next = buckets[index];
        buckets[index] = newNode;
    }

    public void remove(int key) {
        int index = hash(key);

        Node current = buckets[index];
        Node previous = null;

        while (current != null) {

            if (current.key == key) {

                // Removing first node
                if (previous == null) {
                    buckets[index] = current.next;
                } 
                // Removing middle/last node
                else {
                    previous.next = current.next;
                }

                return;
            }

            previous = current;
            current = current.next;
        }
    }

    public boolean contains(int key) {
        int index = hash(key);

        Node current = buckets[index];

        while (current != null) {
            if (current.key == key) {
                return true;
            }

            current = current.next;
        }

        return false;
    }
}
