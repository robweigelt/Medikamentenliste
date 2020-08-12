package r.w;

import java.util.Comparator;

public class Item0 {

    //Atribute Item Objekt
    private int id;
    private String name;
    private int amount;

    //Konstruktor Item Objekt
    Item0(int id, String name, int amount) {
        super();
        this.id = id;
        this.name = name;
        this.amount = amount;
    }

    //Getter & Setter
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    int getAmount() {
        return amount;
    }

    void setAmount(int amount) {
        this.amount = amount;
    }

    //toString Methode
    @Override
    public String toString() {
        return "Item [Item ID: " + id + ", Item Name: " + name + ", Item Menge: " + amount + "]";
    }


    //Comparator Methoden f?r InventoryItemSorter
    public static final Comparator< Item0 > idComparatorDecending  = (it1, it2) -> Integer.compare(it2.getId(), it1.getId());

    static final Comparator< Item0 > nameComparatorDecending = (it1, it2) -> (int) (it1.getName().compareTo(it2.getName()));
    static final Comparator< Item0 > amountComparatorDecending  = (it1, it2) -> Integer.compare(it2.getAmount(),it1.getAmount());
    static final Comparator< Item0 > idComparatorAscending  = (it1, it2) -> Integer.compare(it2.getId(), it1.getId()) * -1;
    static final Comparator< Item0 > nameComparatorAscending = (it1, it2) -> (int) (it1.getName().compareTo(it2.getName())) * -1;
    static final Comparator< Item0 > amountComparatorAscending  = (it1, it2) -> Integer.compare(it2.getAmount(), it1.getAmount()) * -1;
}
