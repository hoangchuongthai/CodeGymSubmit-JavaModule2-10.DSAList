import src.MyList;

public class MyListTest {
    public static void main(String[] args) {

        MyList<Integer> list = new MyList<>();

        // Add elements
        list.add(10);
        list.add(20);
        list.add(30);

        // Insert at index
        list.add(1, 99); // 10, 99, 20, 30

        // Print list
        for (int i = 0; i < list.size(); i++) {
            System.out.println("list[" + i + "] = " + list.get(i));
        }

        // Test contains & indexOf
        System.out.println("Contains 20: " + list.contains(20));
        System.out.println("Index of 30: " + list.indexOf(30));

        // Remove element
        int removed = list.remove(1);
        System.out.println("Removed: " + removed);

        // Clone list
        MyList<Integer> cloned = list.clone();
        System.out.println("Cloned size: " + cloned.size());

        // Clear list
        list.clear();
        System.out.println("Size after clear: " + list.size());
    }
}
