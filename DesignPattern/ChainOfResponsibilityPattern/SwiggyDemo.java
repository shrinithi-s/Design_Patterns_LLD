package DesignPattern.ChainOfResponsibilityPattern;

abstract class OrderHandler{ //handler
    protected  OrderHandler nextHandler;
    
    public OrderHandler(OrderHandler nextHandler){
        this.nextHandler=nextHandler;
    }

    public abstract void processOrder(String order);
}

class OrderValidationHandler extends OrderHandler{ //concrete handler
    public OrderValidationHandler(OrderHandler nextHandler) {
        super(nextHandler);
    }

    @Override
    public void processOrder(String order) {
        System.out.println("Validating order: " + order);
        // order validaation logic

        // pass it to next handler
        if (nextHandler != null) {
            nextHandler.processOrder(order);
        }
    }
}

class PaymentProcessHandler extends OrderHandler{ //concrete handler
    public PaymentProcessHandler(OrderHandler nextHandler) {
        super(nextHandler);
    }

    @Override
    public void processOrder(String order) {
        System.out.println("Processing payment for order: " + order);
        // payment process logic

        // pass it to next handler
        if (nextHandler != null) {
            nextHandler.processOrder(order);
        }
    }
}

class PrepareOrderHandler extends OrderHandler{ //concrete handler
    public PrepareOrderHandler(OrderHandler nextHandler) {
        super(nextHandler);
    }

    @Override
    public void processOrder(String order) {
        System.out.println("Preparing order: " + order);
        // Preparing logic

        // pass it to next handler
        if (nextHandler != null) {
            nextHandler.processOrder(order);
        }
    }
}

class DeliveryProcessHandler extends OrderHandler{ //concrete handler
    public DeliveryProcessHandler(OrderHandler nextHandler) {
        super(nextHandler);
    }

    @Override
    public void processOrder(String order) {
        System.out.println("Assigning Delivery partner for order: " + order);
        // delivery logic

        // pass it to next handler
        if (nextHandler != null) {
            nextHandler.processOrder(order);
        }
    }
}

class OrderTrackerHandler extends OrderHandler{ //concrete handler
    public OrderTrackerHandler(OrderHandler nextHandler) {
        super(nextHandler);
    }

    @Override
    public void processOrder(String order) {
        System.out.println("Tracking order: " + order);
    }
}

public class SwiggyDemo {
    public static void main(String[] args) {
        OrderHandler orderProcessingChain=new OrderValidationHandler(
            new PaymentProcessHandler(
                new PrepareOrderHandler(
                    new DeliveryProcessHandler(
                        new OrderTrackerHandler(null)))));
        
        orderProcessingChain.processOrder("Chocolate cake");
    }
}
