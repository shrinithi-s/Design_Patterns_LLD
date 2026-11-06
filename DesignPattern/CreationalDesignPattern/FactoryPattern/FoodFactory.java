package DesignPattern.CreationalDesignPattern.FactoryPattern;

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

interface FoodFactory{
    Food getFood();
}

class PizzaFactory implements FoodFactory{
    public Food getFood(){
        return new Pizza();
    }
}

class BurgerFactory implements FoodFactory{
    public Food getFood(){
        return new Burger();
    }
}

class PastaFactory implements FoodFactory{
    public Food getFood(){
        return new Pasta();
    }
}


//client code
class Main {
    public static void main(String[] args) {
        FoodFactory factory=new PastaFactory();
        Food food=factory.getFood();
        food.createFood();
        
    }
}


