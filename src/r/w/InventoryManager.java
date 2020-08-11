package r.w;

import java.io.*;
import java.nio.file.Paths;
import java.util.*;

public class InventoryManager {

    //Dateipfad f�r Praxis_Inventur.csv
    private String filepath = Paths.get("").toAbsolutePath().toString()+ "/Praxis_Inventur.csv";
    //Liste Inventory
    private List< Item0 > Inventory = new ArrayList< Item0 >();

    //Clearen von Inventory und einlesen aller Daten aus der CSV in Inventory als Item Objekte
    public List< Item0 > readCSV(){

        Inventory.clear();

        //Liste welche Strings pro Zeile der CSV enth�lt
        List<String> FormatHelp = new ArrayList<String>();

        File f = new File(filepath);

        //Lesen der CSV, aus jeder Zeile ein String, Strings in Liste FormatHelp
        try(Scanner scCSV = new Scanner(f)) {
            while(scCSV.hasNextLine()) {
                FormatHelp.add(scCSV.nextLine());
            }
            scCSV.close();
        } catch(FileNotFoundException e) {
            e.printStackTrace();
        }

        //Erstellen von Item Obj. und hinzuf�gen zur Liste Inventory solange bis Ende von FormatHelp erreicht
        for(int i = 0; FormatHelp.size() > i; i++) {
            //Item Dumb zur bef�llung durch CSV
            Item0 dumbIt = new Item0(0, null,0);

            //Aufsplitten der einzelnen Strings in FormatHelp Anhand von ;
            String CSVline = FormatHelp.get(i);
            String[] parts = CSVline.split(";");

            //Mappen der Einzelnen Atribute aus der CSV mit denen des dumb Items
            dumbIt.setId(Integer.parseInt(parts[0]));
            dumbIt.setName(parts[1]);
            dumbIt.setAmount(Integer.parseInt(parts [2]));

            //dumb Item zur Liste Inventory
            Inventory.add(dumbIt);
        }
        return Inventory;
    }

    //Methode zum ausgeben des Inventars
    public void printInventory() {

        //Vom jedem Obj. Item in Liste Inventory  werden Atribute in Konsole ausgegeben
        for(Item0 item0 : Inventory) {
            System.out.println(item0.getId()+"\t"+ item0.getName()+"\t"+ item0.getAmount());
        }
    }

    //Methode zum erstellen von Item Obj. und hinzuf�gen zur Liste Inventory
    //Methode m�ssen Werte f�r Obj. �bergeben werden
    public List< Item0 > addItem(int id, String name, int amount){
        try {
            Item0 it = new Item0(id,name,amount);
            Inventory.add(it);
            System.out.println("Item erfolgreich gespeichert!");
        } catch (Exception e) {
            System.out.println("Item konnte nicht gespeichert werden!");
        }
        return Inventory;
    }

    //Methode zum l�schen eines Item Obj. aus der Liste Inventory
    //Ben�tigt Item Obj. welches entfernt werden soll (geliefert durch z.B. Such Methoden)
    public List< Item0 > deleteItem(Item0 foundItem0){
        try{
            Inventory.remove(foundItem0);
            System.out.println("Das Item " + foundItem0.getName() + " wurde erfolgreich entfernt!");
        } catch (Exception e) {
            System.out.println("Item konnte nicht entfernt werden!");
        }
        return Inventory;
    }

    //Methode zum Suchen eines Item Obj. in Liste Inventory anhand seines Namens
    //Ben�tigt zu Suchenden Namen als String
    public Item0 searchItemByName(String itemName){

        for (Item0 foundItem0 : Inventory) {
            if(foundItem0.getName().equals(itemName))
                return foundItem0;
        }


        return null;
    }

    //Methode zum Suchen eines Item Obj. in Liste Inventory anhand seiner ID
    //Ben�tigt zu Suchende ID als Integer
    public boolean checkIfIDExists(int id) {
        for(Item0 item0 : Inventory) {
            if(item0.getId()==id)
                return true;
        }

        return false;
    }
    public boolean checkIfNameExists(String name) {
        for(Item0 item0 : Inventory) {
            if(item0.getName().equals(name))
                return true;
        }
        return false;
    }

    public Item0 searchItemByID(int itemId){

        for (Item0 foundItem0 : Inventory) {

            if(foundItem0.getId() == itemId) {
                return foundItem0;
            }
        }
        return null;
    }

    //Hinzuf�gen einer durch int amountToAdd �bergebenden Menge eines Item Obj.
    //Ben�tigt Item Obj. dessen Menge erh�ht werden soll (geliefert durch z.B. Such Methoden)
    public void addAmount(Item0 foundItem0, int amountToAdd){
        int currentAmount = foundItem0.getAmount();
        int newAmount = currentAmount + amountToAdd;
        foundItem0.setAmount(newAmount);
    }
    //Verringer einer durch int amountToReduce �bergebenden Menge eines Item Obj.
    //Ben�tigt Item Obj. dessen Menge vermindert werden soll (geliefert durch z.B. Such Methoden)
    public void reduceAmount(Item0 foundItem0, int amountToReduce){
        int currentAmount = foundItem0.getAmount();
        foundItem0.setAmount(currentAmount - amountToReduce);
    }

    //Schreibt alle Item Obj. der aktuellen Inventory Liste in CSV Datei
    //Erstellt dabei Temp-Datei, l�scht alte Praxis_Inventur.csv und setzt Datei Temp mit gleichem Namen wieder ein
    public void writeInventoryToCSV() {

        //Iterator f�r Liste Inventory
        ListIterator< Item0 > lItr = Inventory.listIterator();

        //Pfad f�r Temp-File und erstellen der Temp-File
        String tempFile = "temp.csv";
        File newFile = new File(tempFile);

        //Erstellen einer neues File f�r Praxis_Inventur.csv Pfad
        File oldFile = new File(filepath);

        try {

            //File Writer wird auf tempFile gesetzt und Buffered- und PritWriter werden initalisiert
            FileWriter fw = new FileWriter(tempFile, true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw);

            //Erstes Item aus Inventory Liste wird in inventoryIt1 gespeichert
            //Erstes Item vor Schleife, aufgrund von Formatierung durch \n
            Item0 inventoryIt1 = lItr.next();
            //inventoryIt1 wird in Temp-File geschrieben
            pw.print(inventoryIt1.getId()+";"+inventoryIt1.getName()+";"+inventoryIt1.getAmount());

            //Solange Listen Iterator neue Datens�tze in Liste Inventory findet werden Atribute der Obj. in Temp-File geschrieben
            while(lItr.hasNext()) {
                Item0 inventoryIt = lItr.next();
                pw.print("\n"+inventoryIt.getId()+";"+inventoryIt.getName()+";"+inventoryIt.getAmount());
            }

            pw.flush();
            pw.close();
            System.out.println("Inventar wurde erfolgreich in CSV geschrieben!");

            //l�schen der alten Praxis_Inventur.csv
            oldFile.delete();
            //dump File f�r Praxis_Inventur.csv Pfad
            File dump = new File(filepath);
            //Umbennenen der Temp-File zu Praxis_Inventur.csv
            newFile.renameTo(dump);

        } catch(Exception e) {
            System.out.println("Inventar konnte nicht in CSV geschrieben werden!");
        }

    }
    public void getSortedItemsByAmountDescending(){
        Collections.sort(Inventory, Item0.amountComparatorDecending );
    }

}

