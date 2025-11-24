//Problem 2. Dynamic Online Marketplace

import java.util.ArrayList;
import java.util.List;

interface ProductCategory {
}

class BookCategory implements ProductCategory {
    private String genre;

    public BookCategory(String genre) {
        this.genre = genre;
    }

    public String getGenre() {
        return genre;
    }
}

class ClothingCategory implements ProductCategory {
    private String type;

    public ClothingCategory(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
}

class GadgetCategory implements ProductCategory {
    private String brand;

    public GadgetCategory(String brand) {
        this.brand = brand;
    }

    public String getBrand() {
        return brand;
    }
}

class Product<T extends ProductCategory> {
    private String name;
    private double price;
    private T category;

    public Product(String name, double price, T category) {
        this.name = name;
        this.price = price;
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public T getCategory() {
        return category;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void showProductDetails() {
        System.out.println(name + " - Rs." + price + " | Category: " + category.getClass().getSimpleName());
    }
}

class Catalog {
    private List<Product<? extends ProductCategory>> products = new ArrayList<>();

    public <T extends ProductCategory> void addProduct(Product<T> product) {
        products.add(product);
        System.out.println(product.getName() + " added to catalog.");
    }

    public void showAllProducts() {
        System.out.println("\nAll Products in Catalog:");
        for (Product<? extends ProductCategory> p : products) {
            p.showProductDetails();
        }
    }

    public static <T extends Product<?>> void applyDiscount(T product, double percentage) {
        double newPrice = product.getPrice() * (1 - percentage / 100);
        product.setPrice(newPrice);
        System.out.println("Discount applied on " + product.getName() + ": New Price = Rs." + newPrice);
    }
}

public class OnlineMarketPlace {
    public static void main(String[] args) {
        Catalog catalog = new Catalog();

        Product<BookCategory> book1 = new Product<>("Java Programming", 1200, new BookCategory("Programming"));
        Product<BookCategory> book2 = new Product<>("Data Science Guide", 1500, new BookCategory("Data Science"));

        Product<ClothingCategory> shirt = new Product<>("Casual Shirt", 799, new ClothingCategory("Shirt"));
        Product<ClothingCategory> jeans = new Product<>("Blue Jeans", 1299, new ClothingCategory("Jeans"));

        Product<GadgetCategory> smartphone = new Product<>("Smartphone", 25000, new GadgetCategory("Samsung"));
        Product<GadgetCategory> laptop = new Product<>("Laptop", 55000, new GadgetCategory("Dell"));

        catalog.addProduct(book1);
        catalog.addProduct(book2);
        catalog.addProduct(shirt);
        catalog.addProduct(jeans);
        catalog.addProduct(smartphone);
        catalog.addProduct(laptop);

        catalog.showAllProducts();

    
        System.out.println("\nApplying discounts: ");
        Catalog.applyDiscount(book1, 10);
        Catalog.applyDiscount(shirt, 15);
        Catalog.applyDiscount(smartphone, 5);

        System.out.println();
        System.out.println("\nAfter Applying discounts: ");
        catalog.showAllProducts();
    }
}
