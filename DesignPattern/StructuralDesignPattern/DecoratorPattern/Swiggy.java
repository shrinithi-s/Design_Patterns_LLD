package DesignPattern.StructuralDesignPattern.DecoratorPattern;

interface FoodItem{ //
    String getDescription();
    double getPrice();
}

// Concrete component
class Pizza implements FoodItem {
    public String getDescription() {
        return "Pizza";
    }

    public double getPrice() {
        return 200.0;
    }
}

class Burger implements FoodItem {
    public String getDescription() {
        return "Burger";
    }

    public double getPrice() {
        return 100.0;
    }
}

//Decorator
abstract class FoodDecorator implements FoodItem{
    protected FoodItem foodItem;

    public FoodDecorator(FoodItem foodItem) {
        this.foodItem = foodItem;
    }
}

//Concrete Decorator
class ExtraCheeseDecorator extends FoodDecorator{
    private double extraCheesePrice;

    public ExtraCheeseDecorator(FoodItem foodItem, double extraCheesePrice) {
        super(foodItem);
        this.extraCheesePrice = extraCheesePrice;
    }

    public String getDescription() {
        return foodItem.getDescription()+" with extra cheese";
    }

    public double getPrice() {
        return foodItem.getPrice() + extraCheesePrice;
    }
}

class ExtraToppingsDecorator extends FoodDecorator{
    private double extraToppingsPrice;

    public ExtraToppingsDecorator(FoodItem foodItem, double extraToppingsPrice) {
        super(foodItem);
        this.extraToppingsPrice = extraToppingsPrice;
    }

    public String getDescription() {
        return foodItem.getDescription()+" with extra toppings";
    }

    public double getPrice() {
        return foodItem.getPrice() + extraToppingsPrice;
    }
}

public class Swiggy {
    public static void main(String[] args) {
        FoodItem pizzaOrder=new Pizza();

        pizzaOrder=new ExtraCheeseDecorator(pizzaOrder,10);
        pizzaOrder=new ExtraToppingsDecorator(pizzaOrder,5);

        System.out.println("Description of pizza order is " + pizzaOrder.getDescription());
        System.out.println("Price of pizza order is: " + pizzaOrder.getPrice());
    }
}
