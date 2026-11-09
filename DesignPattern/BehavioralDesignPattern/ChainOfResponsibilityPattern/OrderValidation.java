package DesignPattern.BehavioralDesignPattern.ChainOfResponsibilityPattern;

//Authentication → Payment → Inventory

class OrderRequest{
    boolean authenticated;
    boolean paymentSuccessful;
    boolean productAvailable;

    public OrderRequest(boolean authenticated,boolean paymentSuccessful,boolean productAvailable){
        this.authenticated = authenticated;
        this.paymentSuccessful = paymentSuccessful;
        this.productAvailable = productAvailable;
    }
}

//Handler
abstract class OrderHandler{
    protected OrderHandler nextHandler;

    public void setNext(OrderHandler nextHandler) {
        this.nextHandler = nextHandler;
    }

    public boolean handle(OrderRequest request){
        if(!process(request))return false;

        if(nextHandler != null){
            return nextHandler.handle(request);
        }
        return true;
    }

    protected abstract boolean process(OrderRequest request);
}

//Concrete Handler

class AuthenticationHandler extends OrderHandler{

    protected boolean process(OrderRequest request) {
        if (!request.authenticated) {
            System.out.println("Authentication failed");
            return false;
        }

        System.out.println("Authentication successful");
        return true;
    }
}

class PaymentHandler extends OrderHandler {


    protected boolean process(OrderRequest request) {
        if (!request.paymentSuccessful) {
            System.out.println("Payment failed");
            return false;
        }

        System.out.println("Payment successful");
        return true;
    }
}

class InventoryHandler extends OrderHandler {


    protected boolean process(OrderRequest request) {
        if (!request.productAvailable) {
            System.out.println("Product out of stock");
            return false;
        }

        System.out.println("Product available");
        return true;
    }
}

public class OrderValidation {
    public static void main(String[] args) {
        OrderHandler auth=new AuthenticationHandler();
        OrderHandler payment=new PaymentHandler();
        OrderHandler inventory=new InventoryHandler();

        auth.setNext(payment);
        payment.setNext(inventory);

        OrderRequest request=new OrderRequest(true,true,true);
        auth.handle(request);
    }
}

//OrderHandler → OrderHandler	Self-association	Holds reference to next handler
//Some chains stop when a handler handles or rejects the request.
//Some chains pass the request through every handler.
//Some handlers may handle the request and still pass it forward.