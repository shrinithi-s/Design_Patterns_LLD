package DesignPattern.CreationalDesignPattern.FactoryPattern.SimpleFactory;
//Product Interface
interface Food{
    void createFood();
}

//concreate products
class Pizza implements Food{
    public void createFood(){
        System.out.println("Pizza is created");
    }
}

class Burger implements Food{
    public void createFood(){
        System.out.println("Burger is created");
    }
}

class Pasta implements Food{
    public void createFood(){
        System.out.println("Pasta is created");
    }
}

//Factory class
class FoodFactory{ //here it still violated open and closed principle
    public static Food getFood(String type){
        if(type.equals("Pizza")){
            return new Pizza();
        }
        
        if(type.equals("Burger")){
            return new Burger();
        }
        
        if(type.equals("Pasta")){
            return new Pasta();
        }
        return null;
    }
}

//client code
class Main {
    public static void main(String[] args) {
        Food food=FoodFactory.getFood("Pizza");
        food.createFood();
    }
}
public class SimpleFactory {
    
}
