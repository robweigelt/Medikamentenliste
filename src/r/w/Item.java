package r.w;

import java.util.Comparator;

public class Item {

    //Atribute Item Objekt
    private int id;
    private String name;
    private int amount;

    //Konstruktor Item Objekt
    public Item(int id, String name, int amount) {
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

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    //toString Methode
    @Override
    public String toString() {
        return "Item [Item ID: " + id + ", Item Name: " + name + ", Item Menge: " + amount + "]";
    }


    //Comparator Methoden f?r InventoryItemSorter
    public static Comparator<Item> idComparatorDecending  = new Comparator<Item>() {
        @Override
        public int compare(Item it1, Item it2) {
            return Integer.compare(it2.getId(),it1.getId());
        }
    };

    public static Comparator<Item> nameComparatorDecending = new Comparator<Item>() {
        @Override
        public int compare(Item it1, Item it2) {
            return (int) (it1.getName().compareTo(it2.getName()));
        }
    };
    public static Comparator<Item> amountComparatorDecending  = new Comparator<Item>() {
        @Override
        public int compare(Item it1, Item it2) {
            return Integer.compare(it2.getAmount(),it1.getAmount());
        }
    };
    public static Comparator<Item> idComparatorAscending  = new Comparator<Item>() {
        @Override
        public int compare(Item it1, Item it2) {
            return Integer.compare(it2.getId(),it1.getId())*-1;
        }
    };
    public static Comparator<Item> nameComparatorAscending = new Comparator<Item>() {
        @Override
        public int compare(Item it1, Item it2) {
            return (int) (it1.getName().compareTo(it2.getName()))*-1;
        }
    };
    public static Comparator<Item> amountComparatorAscending  = new Comparator<Item>() {
        @Override
        public int compare(Item it1, Item it2) {
            return Integer.compare(it2.getAmount(),it1.getAmount())*-1;
        }
    };
}

