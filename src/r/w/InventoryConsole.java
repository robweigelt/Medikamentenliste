package r.w;

import java.io.IOException;
import java.util.Scanner;

/** @noinspection ALL*/
class InventoryConsole {

    private final Scanner sc;
    private final InventoryManager im;

    public InventoryConsole() {
        this.sc = new Scanner(System.in);
        this.im = new InventoryManager();
    }

    private int menu() {
        System.out.println("__________________________________________");
        System.out.println("Main Menu");
        System.out.println("⌞ Inventory Menu");
        System.out.println("");
        System.out.println("[1] Add item");
        System.out.println("[2] Delete item");
        System.out.println("[3] Edit item amount");
        System.out.println("[4] Show inventory");
        System.out.println("[5] Save inventory to csv");
        System.out.println("[-]");
        System.out.println("[0] Return");
        System.out.println("");
        System.out.print("Enter choice here: ");
        return readInt(0,5);
    }

    public void start() throws IOException, CloneNotSupportedException {
        im.readCSV();
        while(true) {
            int choice = menu();
            switch(choice) {
                case 0:
                    Controller.Menu();

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
                case 6:


                default:
                    throw new AssertionError();
            }
        }
    }

    private void showAll() {
        System.out.println("----| Current inventory |----");
        System.out.println("ID\tName\tAmount");
        im.printInventory();
        sortInventory();
    }

    private void sortInventory() {
        System.out.println("Sort inventory?\n1 -> Yes\n0 -> No");
        int choice = readInt(0,1);
        if(choice == 1) {
            System.out.println("----| Sort inventory |----");
            System.out.println("[1] Descending by id");
            System.out.println("[2] Ascending by id");
            System.out.println("[3] Descending by name");
            System.out.println("[4] Ascending by name");
            System.out.println("[5] Descending by amount");
            System.out.println("[6] Ascending by amount");
            int choice2 = readInt(1,6);
            switch(choice2) {
                case 1:
                    im.getSortedItemsByAmountDescending();
                    im.printInventory();
                case 2:

                    im.printInventory();
            }
        }
    }

    private void setAmount() {
        Item0 foundItem;
        System.out.println("----| Edit item amount |----");
        System.out.println("Enter name or id:");
        if(sc.hasNextInt()) {
            int itemId = readInt(0, Integer.MAX_VALUE);
            foundItem = im.searchItemByID(itemId);
        } else {
            String itemName = sc.nextLine();
            foundItem = im.searchItemByName(itemName);
        }
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

    private void deleteItem() {
        System.out.println("----| Delete item |----");
        System.out.println("Enter name or id:");
        if(sc.hasNextInt()) {
            int itemId = readInt(0, Integer.MAX_VALUE);
            Item0 foundItem0 = im.searchItemByID(itemId);
            im.deleteItem(foundItem0);
        } else {
            String itemName = sc.nextLine();
            Item0 foundItem0 = im.searchItemByName(itemName);
            im.deleteItem(foundItem0);
        }
    }

    private void addItem() {
        System.out.println("----| Add item |----");
        System.out.println("Enter id:");
        int id = readInt(0, Integer.MAX_VALUE);
        while(im.checkIfIDExists(id)) {
            System.out.println("Id already exists, please try a new one:");
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
