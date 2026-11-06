package DesignPattern.CreationalDesignPattern.AbstractFactory;

interface Food{
    void createFood();
}

interface SideFood{
    void createFood();
    void refill();
}

class Pizza implements Food{
    public void createFood(){
        System.out.println("Pizza is created");
    }
}

class Bread implements SideFood{
    public void createFood(){
        System.out.println("Bread is created");
    }

    public void refill(){
        System.out.println("Bread is refilled");
    } 
}

class Burger implements Food{
    public void createFood(){
        System.out.println("Burger is created");
    }
}

class Fries implements SideFood{
    public void createFood(){
        System.out.println("Fries is created");
    }

    public void refill(){
        System.out.println("Fries is refilled");
    } 
}

class Pasta implements Food{
    public void createFood(){
        System.out.println("Pasta is created");
    }
}

class Parmesan implements SideFood{
    public void createFood(){
        System.out.println("Parmesan is created");
    }

    public void refill(){
        System.out.println("Parmesan is refilled");
    } 
}

interface FoodFactory{
    Food getMainFood();
    SideFood getSideFood();
}

class PizzaFactory implements FoodFactory{
    public Food getMainFood(){
        return new Pizza();
    }
    public SideFood getSideFood(){
        return new Bread();
    }
}

class BurgerFactory implements FoodFactory{
    public Food getMainFood(){
        return new Burger();
    }
    public SideFood getSideFood(){
        return new Fries();
    }
}

class PastaFactory implements FoodFactory{
    public Food getMainFood(){
        return new Pasta();
    }
     public SideFood getSideFood(){
        return new Parmesan();
    }
}

public class FoodAbstractFactory {
    public static void main(String[] args) {
        FoodFactory factory=new PizzaFactory();
        
        Food main=factory.getMainFood();
        SideFood side=factory.getSideFood();
        
        main.createFood();
        side.createFood();
        side.refill();
    }
}
