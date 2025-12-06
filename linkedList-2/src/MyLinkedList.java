package src;

public class MyLinkedList<E> {

    private Node head;
    private int numNodes = 0;

    // Default constructor
    public MyLinkedList() {
        head = null;
    }

    // Add element at specific index
    public void add(int index, E element) {
        checkIndexForAdd(index);

        if (index == 0) {
            addFirst(element);
        } else {
            Node prev = getNode(index - 1);
            Node newNode = new Node(element);
            newNode.next = prev.next;
            prev.next = newNode;
            numNodes++;
        }
    }

    // Add element at the beginning
    public void addFirst(E e) {
        Node newNode = new Node(e);
        newNode.next = head;
        head = newNode;
        numNodes++;
    }

    // Add element at the end
    public void addLast(E e) {
        if (head == null) {
            addFirst(e);
            return;
        }

        Node last = getNode(numNodes - 1);
        last.next = new Node(e);
        numNodes++;
    }

    // Add element (same as addLast)
    public boolean add(E e) {
        addLast(e);
        return true;
    }

    // Remove element at index
    @SuppressWarnings("unchecked")
    public E remove(int index) {
        checkIndex(index);

        if (index == 0) {
            Node removed = head;
            head = head.next;
            numNodes--;
            return (E) removed.data;
        }

        Node prev = getNode(index - 1);
        Node removed = prev.next;
        prev.next = removed.next;
        numNodes--;
        return (E) removed.data;
    }

    // Remove first occurrence of object
    public boolean remove(Object o) {
        if (head == null) return false;

        if (o == null ? head.data == null : o.equals(head.data)) {
            head = head.next;
            numNodes--;
            return true;
        }

        Node current = head;
        while (current.next != null) {
            if (o == null ? current.next.data == null : o.equals(current.next.data)) {
                current.next = current.next.next;
                numNodes--;
                return true;
            }
            current = current.next;
        }
        return false;
    }

    // Get element at index
    @SuppressWarnings("unchecked")
    public E get(int index) {
        checkIndex(index);
        return (E) getNode(index).data;
    }

    // Get first element
    @SuppressWarnings("unchecked")
    public E getFirst() {
        return head == null ? null : (E) head.data;
    }

    // Get last element
    @SuppressWarnings("unchecked")
    public E getLast() {
        if (head == null) return null;
        return (E) getNode(numNodes - 1).data;
    }

    // Return size of list
    public int size() {
        return numNodes;
    }

    // Check if list contains element
    public boolean contains(E o) {
        return indexOf(o) != -1;
    }

    // Get index of element
    public int indexOf(E o) {
        Node current = head;
        int index = 0;

        while (current != null) {
            if (o == null ? current.data == null : o.equals(current.data)) {
                return index;
            }
            current = current.next;
            index++;
        }
        return -1;
    }

    // Clear the list
    public void clear() {
        head = null;
        numNodes = 0;
    }

    // Clone the list
    public MyLinkedList<E> clone() {
        MyLinkedList<E> newList = new MyLinkedList<>();
        Node current = head;

        while (current != null) {
            newList.addLast((E) current.data);
            current = current.next;
        }
        return newList;
    }

    // Print all elements
    public void printList() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }

    // Get node at index
    private Node getNode(int index) {
        Node current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current;
    }

    // Index validation for get, remove
    private void checkIndex(int index) {
        if (index < 0 || index >= numNodes) {
            throw new IndexOutOfBoundsException("Index: " + index);
        }
    }

    // Index validation for add
    private void checkIndexForAdd(int index) {
        if (index < 0 || index > numNodes) {
            throw new IndexOutOfBoundsException("Index: " + index);
        }
    }
}
