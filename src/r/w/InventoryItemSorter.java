package r.w;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class InventoryItemSorter {

    //Initialisierung Liste Inventory
    private List< Item0 > Inventory = new ArrayList< Item0 >();

    //Konstruktor InventoryItemSorter
    public InventoryItemSorter(List< Item0 > Inventory) {
        this.Inventory = Inventory;
    }

    //Methoden zum Sortieren basierend auf Class Item Comparator Methoden
    public List< Item0 > getSortedItemsByIdDescending (){
        Collections.sort(Inventory, Item0.idComparatorDecending);
        return Inventory;
    }

    public List< Item0 > getSortedItemsByNameDescending (){
        Collections.sort(Inventory, Item0.nameComparatorDecending );
        return Inventory;
    }

    public List< Item0 > getSortedItemsByAmountDescending (){
        Collections.sort(Inventory, Item0.amountComparatorDecending );
        return Inventory;
    }
    public List< Item0 > getSortedItemsByIDAscending (){
        Collections.sort(Inventory, Item0.idComparatorAscending);

        return Inventory;
    }
    public List< Item0 > getSortedItemsByNameAscending (){
        Collections.sort(Inventory, Item0.nameComparatorAscending );
        return Inventory;
    }

    public List< Item0 > getSortedItemsByAmountAscending (){
        Collections.sort(Inventory, Item0.amountComparatorAscending );
        return Inventory;
    }
}
