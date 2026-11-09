package DesignPattern.BehavioralDesignPattern.IteratorPattern;
import java.util.*;

//The Iterator Pattern separates how a collection is traversed from how the collection is stored.
// Your Inventory exposes an iterator interface rather than exposing its traversal logic to the client.

//client->creates products->put in inventory->creates a iterator
class Product{
    private String name;
    private int price;

    public Product(String name,int price){
        this.name=name;
        this.price=price;
    }

    public String getName(){
        return name;
    }

    public int getPrice(){
        return price;
    }
}

interface ProductIteratorInterface{
    Product next();
    boolean hasNext();
}

class ProductIterator implements ProductIteratorInterface{

    private List<Product> products;
    private int current;
    
    public ProductIterator(List<Product> products){
        this.products=products;
        this.current=0;
    }

    public Product next(){
        if(hasNext()){
            return products.get(current++);
        }
        return null;
    }

    public boolean hasNext(){
        return current<products.size();
    }

}

class Inventory{
    List<Product> products=new ArrayList<>();  //product can exist without inventory - aggregation

    public void addProduct(Product product){
        products.add(product);
    }

    public ProductIteratorInterface createIterator(){
        return new ProductIterator(products);
    }
}

public class AmazonInventory {
    public static void main(String[] args) {
        Product product1=new Product("Laptop", 60000);
        Product product2=new Product("Headphones", 2000);
        Product product3=new Product("Phone", 22000);

        Inventory inventory=new Inventory();
        inventory.addProduct(product1);
        inventory.addProduct(product2);
        inventory.addProduct(product3);

        ProductIteratorInterface iterator=inventory.createIterator();

        
        while(iterator.hasNext()){
            Product currentProduct=iterator.next();
            System.out.println("Product: " + currentProduct.getName() + ", Price: ₹" + currentProduct.getPrice());
        }
    }
}
