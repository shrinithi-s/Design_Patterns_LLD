package DesignPattern.IteratorPattern;
import java.util.*;

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

interface Iterator{
    Product next();
    boolean hasNext();
}

class ProductIterator implements Iterator{

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
    List<Product> products=new ArrayList<>();

    public void addProduct(Product product){
        products.add(product);
    }

    public Iterator createIterator(){
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

        Iterator iterator=inventory.createIterator();

        
        while(iterator.hasNext()){
            Product currentProduct=iterator.next();
            System.out.println("Product: " + currentProduct.getName() + ", Price: ₹" + currentProduct.getPrice());
        }
    }
}
