package r.w;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class InventoryItemSorter {

    //Initialisierung Liste Inventory
    private List< Item0 > Inventory;

    //Konstruktor InventoryItemSorter
    public InventoryItemSorter(List< Item0 > Inventory) {
        this.Inventory = Inventory;
    }

    //Methoden zum Sortieren basierend auf Class Item Comparator Methoden
    public List< Item0 > getSortedItemsByIdDescending (){
        Inventory.sort(Item0.idComparatorDecending);
        return Inventory;
    }

    public List< Item0 > getSortedItemsByNameDescending (){
        Inventory.sort(Item0.nameComparatorDecending);
        return Inventory;
    }

    public List< Item0 > getSortedItemsByAmountDescending (){
        Inventory.sort(Item0.amountComparatorDecending);
        return Inventory;
    }
    public List< Item0 > getSortedItemsByIDAscending (){
        Inventory.sort(Item0.idComparatorAscending);

        return Inventory;
    }
    public List< Item0 > getSortedItemsByNameAscending (){
        Inventory.sort(Item0.nameComparatorAscending);
        return Inventory;
    }

    public List< Item0 > getSortedItemsByAmountAscending (){
        Inventory.sort(Item0.amountComparatorAscending);
        return Inventory;
    }
}
