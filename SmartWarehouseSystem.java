//Problem 1. Smart Warehouse Management System

import java.util.*;

abstract class WarehouseItem {
    String name;

    WarehouseItem(String name) {
        this.name = name;
    }

    public void showItem() {
        System.out.println("Item: " + name);
    }
}

class Electronics extends WarehouseItem {
    Electronics(String name) {
        super(name);
    }
}

class Groceries extends WarehouseItem {
    Groceries(String name) {
        super(name);
    }
}

class Furniture extends WarehouseItem {
    Furniture(String name) {
        super(name);
    }
}

class Storage<T extends WarehouseItem> {

    private List<T> items = new ArrayList<>();

    public void addItem(T item) {
        items.add(item);
    }

    public List<T> getItems() {
        return items;
    }
}

class WarehouseUtil {
    public static void displayAll(List<? extends WarehouseItem> itemList) {
        for (WarehouseItem item : itemList) {
            item.showItem();
        }
    }
}

public class SmartWarehouseSystem {
    public static void main(String[] args) {

        Storage<Electronics> electronicsStorage = new Storage<>();
        electronicsStorage.addItem(new Electronics("Laptop"));
        electronicsStorage.addItem(new Electronics("Mobile"));

        Storage<Groceries> groceryStorage = new Storage<>();
        groceryStorage.addItem(new Groceries("Rice"));
        groceryStorage.addItem(new Groceries("Milk"));

        Storage<Furniture> furnitureStorage = new Storage<>();
        furnitureStorage.addItem(new Furniture("Chair"));
        furnitureStorage.addItem(new Furniture("Table"));

        System.out.println("Electronics:");
        WarehouseUtil.displayAll(electronicsStorage.getItems());

        System.out.println("\nGroceries:");
        WarehouseUtil.displayAll(groceryStorage.getItems());

        System.out.println("\nFurniture:");
        WarehouseUtil.displayAll(furnitureStorage.getItems());
    }
}
