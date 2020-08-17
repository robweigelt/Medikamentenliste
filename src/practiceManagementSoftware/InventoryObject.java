package practiceManagementSoftware;

//Code Hannes Kukulenz -- Design Hannes Kukulenz-- Exception Handling and Code Review Robert Weigelt
public class InventoryObject {

    //Atribute Item Objekt
    private int id;
    private String name;
    private int amount;

    //Konstruktor Item Objekt
    InventoryObject(int id, String name, int amount) {
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
}

