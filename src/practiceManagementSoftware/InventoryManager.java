package practiceManagementSoftware;

import java.io.*;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.Scanner;

//Code Tobias Vogt -- Design Hannes Kukulenz-- Exception Handling and Code Review Robert Weigelt
class InventoryManager {

    //Dateipfad für Praxis_Inventur.csv
    private final String filepath = Paths.get("").toAbsolutePath().toString()+ "/Praxis_Inventur.csv";
    //Liste Inventory
    private final List<InventoryObject> Inventory = new ArrayList<>();

    //Clearen von Inventory und einlesen aller Daten aus der CSV in Inventory als Item Objekte
    public void readCSV(){

        Inventory.clear();

        //Liste welche Strings pro Zeile der CSV enthält
        List<String> FormatHelp = new ArrayList<>();

        File f = new File(filepath);

        //Lesen der CSV, aus jeder Zeile ein String, Strings in Liste FormatHelp
        try(Scanner scCSV = new Scanner(f)) {
            while(scCSV.hasNextLine()) {
                FormatHelp.add(scCSV.nextLine());
            }
        } catch(FileNotFoundException e) {
            e.printStackTrace();
        }

        //Erstellen von Item Obj. und hinzufügen zur Liste Inventory solange bis Ende von FormatHelp erreicht
        for (String s : FormatHelp) {
            //Item Dumb zur befüllung durch CSV
            InventoryObject dumbIt = new InventoryObject(0, null, 0);

            //Aufsplitten der einzelnen Strings in FormatHelp Anhand von ;
            String[] parts = s.split(";");

            //Mappen der Einzelnen Atribute aus der CSV mit denen des dumb Items
            dumbIt.setId(Integer.parseInt(parts[0]));
            dumbIt.setName(parts[1]);
            dumbIt.setAmount(Integer.parseInt(parts[2]));

            //dumb Item zur Liste Inventory
            Inventory.add(dumbIt);
        }
    }

    //Methode zum ausgeben des Inventars
    public void printInventory() {


        String leftAlignFormat = "| %-4d | %-6d | %-20s |%n";

        System.out.format("+------+--------+----------------------+%n");
        System.out.format("| ID   | Amount | Item name            |%n");
        System.out.format("+------+--------+----------------------+%n");

        //Vom jedem Obj. Item in Liste Inventory  werden Atribute in Konsole ausgegeben
        for(InventoryObject inventoryObject : Inventory) {
            System.out.format(leftAlignFormat, inventoryObject.getId(), inventoryObject.getAmount(), inventoryObject.getName());
        }

        System.out.format("+------+--------+----------------------+%n");


    }

    //Methode zum erstellen von Item Obj. und hinzufügen zur Liste Inventory
    //Methode müssen Werte für Obj. übergeben werden
    public void addItem(int id, String name, int amount){
        try {
            InventoryObject it = new InventoryObject(id,name,amount);
            Inventory.add(it);
            System.out.println("Items are saved!");
        } catch (Exception e) {
            System.out.println("An error occured while saving the file!");
        }
    }

    //Methode zum löschen eines Item Obj. aus der Liste Inventory
    //Benötigt Item Obj. welches entfernt werden soll (geliefert durch z.B. Such Methoden)
    public void deleteItem(InventoryObject foundInventoryObject){
        try{
            Inventory.remove(foundInventoryObject);
            System.out.println("Them item " + foundInventoryObject.getName() + " was succesfully deleted!");
        } catch (Exception e) {
            System.out.println("Item konnte nicht entfernt werden!");
        }
    }

    //Methode zum Suchen eines Item Obj. in Liste Inventory anhand seines Namens
    //Benötigt zu Suchenden Namen als String
    public InventoryObject searchItemByName(String itemName){

        for (InventoryObject foundInventoryObject : Inventory) {
            if(foundInventoryObject.getName().equals(itemName))
                return foundInventoryObject;
        }


        return null;
    }

    //Methode zum Suchen eines Item Obj. in Liste Inventory anhand seiner ID
    //Benötigt zu Suchende ID als Integer
    public boolean checkIfIDExists(int id) {
        for(InventoryObject inventoryObject : Inventory) {
            if(inventoryObject.getId()==id)
                return true;
        }

        return false;
    }
    public boolean checkIfNameExists(String name) {
        for(InventoryObject inventoryObject : Inventory) {
            if(inventoryObject.getName().equals(name))
                return true;
        }
        return false;
    }

    public InventoryObject searchItemByID(int itemId){

        for (InventoryObject foundInventoryObject : Inventory) {

            if(foundInventoryObject.getId() == itemId) {
                return foundInventoryObject;
            }
        }
        return null;
    }

    //Hinzufügen einer durch int amountToAdd übergebenden Menge eines Item Obj.
    //Benötigt Item Obj. dessen Menge erhöht werden soll (geliefert durch z.B. Such Methoden)
    public void addAmount(InventoryObject foundInventoryObject, int amountToAdd){
        int currentAmount = foundInventoryObject.getAmount();
        int newAmount = currentAmount + amountToAdd;
        foundInventoryObject.setAmount(newAmount);
    }
    //Verringer einer durch int amountToReduce übergebenden Menge eines Item Obj.
    //Benötigt Item Obj. dessen Menge vermindert werden soll (geliefert durch z.B. Such Methoden)
    public void reduceAmount(InventoryObject foundInventoryObject, int amountToReduce){
        int currentAmount = foundInventoryObject.getAmount();
        foundInventoryObject.setAmount(currentAmount - amountToReduce);
    }

    //Schreibt alle Item Obj. der aktuellen Inventory Liste in CSV Datei
    //Erstellt dabei Temp-Datei, löscht alte Praxis_Inventur.csv und setzt Datei Temp mit gleichem Namen wieder ein
    public void writeInventoryToCSV() {

        //Iterator für Liste Inventory
        ListIterator<InventoryObject> lItr = Inventory.listIterator();

        //Pfad für Temp-File und erstellen der Temp-File
        String tempFile = "temp.csv";
        File newFile = new File(tempFile);
        File oldFile = new File(filepath);

        try {

            //File Writer wird auf tempFile gesetzt und Buffered- und PritWriter werden initalisiert
            FileWriter fw = new FileWriter(tempFile, true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw);

            //Erstes Item aus Inventory Liste wird in inventoryIt1 gespeichert
            //Erstes Item vor Schleife, aufgrund von Formatierung durch \n
            InventoryObject inventoryIt1 = lItr.next();
            //inventoryIt1 wird in Temp-File geschrieben
            pw.print(inventoryIt1.getId()+";"+inventoryIt1.getName()+";"+inventoryIt1.getAmount());

            //Solange Listen Iterator neue Datensätze in Liste Inventory findet werden Atribute der Obj. in Temp-File geschrieben
            while(lItr.hasNext()) {
                InventoryObject inventoryIt = lItr.next();
                pw.print("\n"+inventoryIt.getId()+";"+inventoryIt.getName()+";"+inventoryIt.getAmount());
            }

            pw.flush();
            pw.close();

            //löschen der alten Praxis_Inventur.csv
            boolean wasSuccessfull =oldFile.delete();
            //dump File für Praxis_Inventur.csv Pfad
            File dump = new File(filepath);
            //Umbennenen der Temp-File zu Praxis_Inventur.csv
            boolean wasAlsoSuccessfull =newFile.renameTo(dump);
            if(wasAlsoSuccessfull&&wasSuccessfull){
                System.out.println("Inventory was succesfully saved!");
            }

        } catch(Exception e) {
            System.out.println("An error occured while saving the file!");
        }

    }

}

