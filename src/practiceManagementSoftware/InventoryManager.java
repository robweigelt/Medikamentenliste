package practiceManagementSoftware;

import java.io.*;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.Scanner;

class InventoryManager {

    //Dateipfad f�r Praxis_Inventur.csv
    private final String filepath = Paths.get("").toAbsolutePath().toString()+ "/Praxis_Inventur.csv";
    //Liste Inventory
    private final List<InventoryObject> Inventory = new ArrayList<>();

    //Clearen von Inventory und einlesen aller Daten aus der CSV in Inventory als Item Objekte
    public void readCSV(){

        Inventory.clear();

        //Liste welche Strings pro Zeile der CSV enth�lt
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

        //Erstellen von Item Obj. und hinzuf�gen zur Liste Inventory solange bis Ende von FormatHelp erreicht
        for (String s : FormatHelp) {
            //Item Dumb zur bef�llung durch CSV
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

        //Vom jedem Obj. Item in Liste Inventory  werden Atribute in Konsole ausgegeben
        for(InventoryObject inventoryObject : Inventory) {
            System.out.println(inventoryObject.getId()+"\t"+ inventoryObject.getName()+"\t"+ inventoryObject.getAmount());
        }
    }

    //Methode zum erstellen von Item Obj. und hinzuf�gen zur Liste Inventory
    //Methode m�ssen Werte f�r Obj. �bergeben werden
    public void addItem(int id, String name, int amount){
        try {
            InventoryObject it = new InventoryObject(id,name,amount);
            Inventory.add(it);
            System.out.println("Item erfolgreich gespeichert!");
        } catch (Exception e) {
            System.out.println("Item konnte nicht gespeichert werden!");
        }
    }

    //Methode zum l�schen eines Item Obj. aus der Liste Inventory
    //Ben�tigt Item Obj. welches entfernt werden soll (geliefert durch z.B. Such Methoden)
    public void deleteItem(InventoryObject foundInventoryObject){
        try{
            Inventory.remove(foundInventoryObject);
            System.out.println("Das Item " + foundInventoryObject.getName() + " wurde erfolgreich entfernt!");
        } catch (Exception e) {
            System.out.println("Item konnte nicht entfernt werden!");
        }
    }

    //Methode zum Suchen eines Item Obj. in Liste Inventory anhand seines Namens
    //Ben�tigt zu Suchenden Namen als String
    public InventoryObject searchItemByName(String itemName){

        for (InventoryObject foundInventoryObject : Inventory) {
            if(foundInventoryObject.getName().equals(itemName))
                return foundInventoryObject;
        }


        return null;
    }

    //Methode zum Suchen eines Item Obj. in Liste Inventory anhand seiner ID
    //Ben�tigt zu Suchende ID als Integer
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

    //Hinzuf�gen einer durch int amountToAdd �bergebenden Menge eines Item Obj.
    //Ben�tigt Item Obj. dessen Menge erh�ht werden soll (geliefert durch z.B. Such Methoden)
    public void addAmount(InventoryObject foundInventoryObject, int amountToAdd){
        int currentAmount = foundInventoryObject.getAmount();
        int newAmount = currentAmount + amountToAdd;
        foundInventoryObject.setAmount(newAmount);
    }
    //Verringer einer durch int amountToReduce �bergebenden Menge eines Item Obj.
    //Ben�tigt Item Obj. dessen Menge vermindert werden soll (geliefert durch z.B. Such Methoden)
    public void reduceAmount(InventoryObject foundInventoryObject, int amountToReduce){
        int currentAmount = foundInventoryObject.getAmount();
        foundInventoryObject.setAmount(currentAmount - amountToReduce);
    }

    //Schreibt alle Item Obj. der aktuellen Inventory Liste in CSV Datei
    //Erstellt dabei Temp-Datei, l�scht alte Praxis_Inventur.csv und setzt Datei Temp mit gleichem Namen wieder ein
    public void writeInventoryToCSV() {

        //Iterator f�r Liste Inventory
        ListIterator<InventoryObject> lItr = Inventory.listIterator();

        //Pfad f�r Temp-File und erstellen der Temp-File
        String tempFile = "temp.csv";

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

            //Solange Listen Iterator neue Datens�tze in Liste Inventory findet werden Atribute der Obj. in Temp-File geschrieben
            while(lItr.hasNext()) {
                InventoryObject inventoryIt = lItr.next();
                pw.print("\n"+inventoryIt.getId()+";"+inventoryIt.getName()+";"+inventoryIt.getAmount());
            }

            pw.flush();
            pw.close();
            System.out.println("Inventar wurde erfolgreich in CSV geschrieben!");

            //l�schen der alten Praxis_Inventur.csv

            //dump File f�r Praxis_Inventur.csv Pfad
            //Umbennenen der Temp-File zu Praxis_Inventur.csv


        } catch(Exception e) {
            System.out.println("Inventar konnte nicht in CSV geschrieben werden!");
        }

    }
    public void getSortedItemsByAmountDescending(){
        Inventory.sort(InventoryObject.amountComparatorDecending);
    }

}

