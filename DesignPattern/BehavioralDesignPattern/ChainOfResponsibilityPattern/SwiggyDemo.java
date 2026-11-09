package DesignPattern.BehavioralDesignPattern.ChainOfResponsibilityPattern;

abstract class OrderHandler2{ //handler
    protected  OrderHandler2 nextHandler;
    
    public OrderHandler2(OrderHandler2 nextHandler){
        this.nextHandler=nextHandler;
    }

    public abstract void processOrder(String order);
}

class OrderValidationHandler extends OrderHandler2{ //concrete handler
    public OrderValidationHandler(OrderHandler2 nextHandler) {
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

class PaymentProcessHandler extends OrderHandler2{ //concrete handler
    public PaymentProcessHandler(OrderHandler2 nextHandler) {
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

class PrepareOrderHandler2 extends OrderHandler2{ //concrete handler
    public PrepareOrderHandler2(OrderHandler2 nextHandler) {
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

class DeliveryProcessHandler extends OrderHandler2{ //concrete handler
    public DeliveryProcessHandler(OrderHandler2 nextHandler) {
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

class OrderTrackerHandler extends OrderHandler2{ //concrete handler
    public OrderTrackerHandler(OrderHandler2 nextHandler) {
        super(nextHandler);
    }

    @Override
    public void processOrder(String order) {
        System.out.println("Tracking order: " + order);
    }
}

public class SwiggyDemo {
    public static void main(String[] args) {
        OrderHandler2 orderProcessingChain=new OrderValidationHandler(
            new PaymentProcessHandler(
                new PrepareOrderHandler2(
                    new DeliveryProcessHandler(
                        new OrderTrackerHandler(null)))));
        
        orderProcessingChain.processOrder("Chocolate cake");
    }
}
