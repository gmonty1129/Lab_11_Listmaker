import java.util.ArrayList;

public class ListManager {
    private static ArrayList<String> itemList = new ArrayList<>();

    public static void main(String[] args) {
        boolean done = false;

        while (!done) {
            displayList();
            showMenu();

            String choice = SafeInput.getRegExString("Choose an option: ", "[AaDdIiPpQq]").toUpperCase();

            switch (choice) {
                case "A":
                    addItem();
                    break;
                case "D":
                    deleteItem();
                    break;
                case "I":
                    insertItem();
                    break;
                case "P":
                    printList();
                    break;
                case "Q":
                    if (SafeInput.getYNConfirm("Are you sure you want to quit? (Y/N): ")) {
                        done = true;
                        System.out.println("Exiting the program. Goodbye!");
                    }
                    break;
            }
        }
    }


    private static void showMenu() {
        System.out.println("\n--- Menu Options ---");
        System.out.println("A – Add an item to the list");
        System.out.println("D – Delete an item from the list");
        System.out.println("I – Insert an item into the list");
        System.out.println("P – Print the list");
        System.out.println("Q – Quit the program");
        System.out.println("---------------------");
    }

    private static void addItem() {
        String item = SafeInput.getNonZeroLenString("Enter item to add: ");
        itemList.add(item);
        System.out.println("Item added.");
    }

    private static void deleteItem() {
        if (itemList.isEmpty()) {
            System.out.println("List is empty. Nothing to delete.");
            return;
        }

        displayNumberedList();
        int index = SafeInput.getRangedInt("Enter the number of the item to delete: ", 1, itemList.size()) - 1;
        String removed = itemList.remove(index);
        System.out.println("Deleted: " + removed);
    }

    private static void insertItem() {
        String item = SafeInput.getNonZeroLenString("Enter item to insert: ");
        int position = SafeInput.getRangedInt("Enter position to insert (1 to " + (itemList.size() + 1) + "): ", 1, itemList.size() + 1);
        itemList.add(position - 1, item);
        System.out.println("Item inserted.");
    }

    private static void printList() {
        System.out.println("\n--- Current List ---");
        for (String item : itemList) {
            System.out.println("- " + item);
        }
    }


    private static void displayList() {
        System.out.println("\n=== List ===");
        if (itemList.isEmpty()) {
            System.out.println("(empty)");
        } else {
            for (String item : itemList) {
                System.out.println("- " + item);
            }
        }
    }

    private static void displayNumberedList() {
        System.out.println("\n=== Numbered List ===");
        for (int i = 0; i < itemList.size(); i++) {
            System.out.printf("%d. %s\n", i + 1, itemList.get(i));
        }
    }
}

