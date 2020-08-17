package practiceManagementSoftware;

import java.io.IOException;
import java.util.Scanner;

//Code Hannes Kukulenz -- Design Hannes Kukulenz-- Exception Handling and Code Review Robert Weigelt
class InventoryMenu {

    private final Scanner sc;
    private final InventoryManager im;

    public InventoryMenu() {
        this.sc = new Scanner(System.in);
        this.im = new InventoryManager();
    }

    private int menu() {
        System.out.println("__________________________________________");
        System.out.println("Main Menu");
        System.out.println("⌞ Inventory Menu");
        System.out.println();
        System.out.println("[1] Add item");
        System.out.println("[2] Delete item");
        System.out.println("[3] Edit item amount");
        System.out.println("[4] Show inventory");
        System.out.println("[5] Save inventory to csv");
        System.out.println("[-]");
        System.out.println("[0] Return");
        System.out.println();
        System.out.print("Enter choice here: ");
        return readInt(0,5);
    }

    public void start() throws IOException, CloneNotSupportedException {
        im.readCSV();
        //noinspection InfiniteLoopStatement
        while (true){
            try{
            int choice = menu();
            switch(choice) {
                case 0:
                    MainMenu.Menu();
                    break;
                case 1:
                    addItem();
                    break;
                case 2:
                    deleteItem();
                    break;
                case 3:
                    setAmount();
                    break;
                case 4:
                    showAll();
                    break;
                case 5:
                    im.writeInventoryToCSV();
                    break;
                default:
                    throw new AssertionError();
            }}
            catch (RuntimeException ignored){}
        }
    }

    private void showAll() {
        System.out.println("__________________________________________");
        System.out.println("Main Menu");
        System.out.println("⌞ Inventory Menu");
        System.out.println("  ⌞ Inventory");
        System.out.println();
        im.printInventory();

    }


    private void setAmount() {
        InventoryObject foundItem;
        System.out.println("__________________________________________");
        System.out.println("Main Menu");
        System.out.println("⌞ Inventory Menu");
        System.out.println("  ⌞ Edit item amount");
        System.out.println();
        System.out.println("Enter name or ID:");
        if(sc.hasNextInt()) {
            int itemId = readInt(0, Integer.MAX_VALUE);
            foundItem = im.searchItemByID(itemId);
        }
        else {
            String itemName = sc.nextLine();
            foundItem = im.searchItemByName(itemName);
        }
        if (foundItem != null){
        System.out.println("      [1] Increase amount");
        System.out.println("      [2] Decrease amount");
        int choice = readInt(1,2);
        if(choice == 1){
            System.out.println("Increase amount of "+foundItem.getName()+" by?");
            int amountToAdd = readInt(0,Integer.MAX_VALUE);
            im.addAmount(foundItem, amountToAdd);
        } else {
            System.out.println("Decrease amount of "+foundItem.getName()+" by?");
            int amountToReduce = readInt(0,Integer.MAX_VALUE);
            im.reduceAmount(foundItem, amountToReduce);
        }

    }
        else {
            System.out.println("Item was not found");
            menu();

        }
    }

    private void deleteItem() {
        System.out.println("__________________________________________");
        System.out.println("Main Menu");
        System.out.println("⌞ Inventory Menu");
        System.out.println("  ⌞ Delete item");
        System.out.println();
        System.out.println("Enter name or ID:");
        if(sc.hasNextInt()) {
            int itemId = readInt(0, Integer.MAX_VALUE);
            InventoryObject foundInventoryObject = im.searchItemByID(itemId);
            im.deleteItem(foundInventoryObject);
        } else {
            String itemName = sc.nextLine();
            InventoryObject foundInventoryObject = im.searchItemByName(itemName);
            im.deleteItem(foundInventoryObject);
        }
    }

    private void addItem() {
        System.out.println("__________________________________________");
        System.out.println("Main Menu");
        System.out.println("⌞ Inventory Menu");
        System.out.println("  ⌞ Add item");
        System.out.println();
        System.out.println("Enter ID:");
        int id = readInt(0, Integer.MAX_VALUE);
        while(im.checkIfIDExists(id)) {
            System.out.println("ID already exists, please try a new one:");
            id = readInt(0, Integer.MAX_VALUE);
        }
        System.out.println("Enter name:");
        String name = sc.nextLine();
        while(im.checkIfNameExists(name)) {
            System.out.println("Name already exists, please try a new one:");
            name = sc.nextLine();
        }
        System.out.println("Enter amount:");
        int amount = readInt(0, Integer.MAX_VALUE);
        im.addItem(id, name, amount);
    }


    private int readInt(int min, int max) {
        int choice;
        while (true) {
            try {
                choice = Integer.parseInt(sc.nextLine());
                if(choice >= min && choice <= max) {
                    break;
                }
            } catch (Exception e) {
                System.out.println("Please enter a number!");
            }
        }
        return choice;
    }

}
