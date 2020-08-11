package r.w;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class InventoryItemSorter {

    //Initialisierung Liste Inventory
    private List<Item> Inventory = new ArrayList<Item>();

    //Konstruktor InventoryItemSorter
    public InventoryItemSorter(List<Item> Inventory) {
        this.Inventory = Inventory;
    }

    //Methoden zum Sortieren basierend auf Class Item Comparator Methoden
    public List<Item> getSortedItemsByIdDescending (){
        Collections.sort(Inventory, Item.idComparatorDecending);
        return Inventory;
    }

    public List<Item> getSortedItemsByNameDescending (){
        Collections.sort(Inventory, Item.nameComparatorDecending );
        return Inventory;
    }

    public List<Item> getSortedItemsByAmountDescending (){
        Collections.sort(Inventory, Item.amountComparatorDecending );
        return Inventory;
    }
    public List<Item> getSortedItemsByIDAscending (){
        Collections.sort(Inventory, Item.idComparatorAscending);

        return Inventory;
    }
    public List<Item> getSortedItemsByNameAscending (){
        Collections.sort(Inventory, Item.nameComparatorAscending );
        return Inventory;
    }

    public List<Item> getSortedItemsByAmountAscending (){
        Collections.sort(Inventory, Item.amountComparatorAscending );
        return Inventory;
    }
}
