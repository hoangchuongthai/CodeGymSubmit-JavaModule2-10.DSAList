import src.MyLinkedList;

public class MyLinkedListTest {
    public static void main(String[] args) {

        MyLinkedList<Integer> list = new MyLinkedList<>();

        list.add(10);
        list.add(20);
        list.add(30);

        list.addFirst(5);
        list.addLast(40);

        list.add(2, 99);

        System.out.println("List:");
        list.printList();

        System.out.println("Size: " + list.size());
        System.out.println("First: " + list.getFirst());
        System.out.println("Last: " + list.getLast());

        System.out.println("Contains 20: " + list.contains(20));
        System.out.println("Index of 99: " + list.indexOf(99));

        System.out.println("Removed at index 2: " + list.remove(2));
        list.printList();

        list.remove(Integer.valueOf(20));
        list.printList();

        MyLinkedList<Integer> cloned = list.clone();
        System.out.println("Cloned list:");
        cloned.printList();

        list.clear();
        System.out.println("Size after clear: " + list.size());
    }
}
