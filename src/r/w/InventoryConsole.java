package r.w;

import java.io.IOException;
import java.util.*;

public class InventoryConsole {

    private Scanner sc;
    private InventoryManager im;

    public InventoryConsole() {
        this.sc = new Scanner(System.in);
        this.im = new InventoryManager();
    }

    private int menu() {
        System.out.println("----| Inventar Menü |----");
        System.out.println("  1. Item hinzufügen");
        System.out.println("  2. Item entfernen");
        System.out.println("  3. Item Menge anpassen");
        System.out.println("  4. Inventar anzeigen");
        System.out.println("  5. Aktuelles Inventar in CSV speichern");

        System.out.println("  0. Exit ->");
        int choice = readInt(0,5);
        return choice;
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
        System.out.println("----| Aktuelles Inventar |----");
        System.out.println("ID\tName\tMenge");
        im.printInventory();
        sortInventory();
    }

    private void sortInventory() {
        System.out.println("Inventar Sortieren?\n1 -> Ja\n0 -> Nein");
        int choice = readInt(0,1);
        if(choice == 1) {
            System.out.println("----| Sortier Möglichkeiten |----");
            System.out.println("	1. Nach ID absteigend");
            System.out.println("	2. Nach ID aufsteigend");
            System.out.println("	3. Nach Name absteigend");
            System.out.println("	4. Nach Name aufsteigend");
            System.out.println("	5. Nach Menge absteigend");
            System.out.println("	6. Nach Menge aufsteigend");
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
        System.out.println("----| Item Menge anpassen |----");
        System.out.println("Geben Sie Namen oder ID an:");
        if(sc.hasNextInt()) {
            int itemId = readInt(0, Integer.MAX_VALUE);
            foundItem = im.searchItemByID(itemId);
        } else {
            String itemName = sc.nextLine();
            foundItem = im.searchItemByName(itemName);
        }
        System.out.println("      1 -> Menge erhöhen");
        System.out.println("      2 -> Menge vermindern");
        int choice = readInt(1,2);
        if(choice == 1){
            System.out.println("Um wie viel soll die Menge von "+foundItem.getName()+" erhöht werden?");
            int amountToAdd = readInt(0,Integer.MAX_VALUE);
            im.addAmount(foundItem, amountToAdd);
        } else {
            System.out.println("Um wie viel soll die Menge von "+foundItem.getName()+" vermindert werden?");
            int amountToReduce = readInt(0,Integer.MAX_VALUE);
            im.reduceAmount(foundItem, amountToReduce);
        }

    }

    private void deleteItem() {
        System.out.println("----| Item entfernen |----");
        System.out.println("Geben sie Namen oder ID an:");
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
        System.out.println("----| Item hinzufügen |----");
        System.out.println("Geben Sie eine ID an:");
        int id = readInt(0, Integer.MAX_VALUE);
        while(im.checkIfIDExists(id)) {
            System.out.println("ID bereits vergeben, probieren Sie eine neue:");
            int newID = readInt(0, Integer.MAX_VALUE);
            id = newID;
        }
        System.out.println("Geben Sie einen Namen an:");
        String name = sc.nextLine();
        while(im.checkIfNameExists(name)) {
            System.out.println("Name bereits vergeben, probieren Sie einen neuen:");
            String newName = sc.nextLine();
            name = newName;
        }
        System.out.println("Geben Sie eine Menge an:");
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
                System.out.println("Bitte geben Sie eine Zahl ein!");
            }
        }
        return choice;
    }

}
