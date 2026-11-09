package DesignPattern.BehavioralDesignPattern.TemplatePattern;

abstract class OrderProcessingTemplate{
    public void processOrder(){
        verify();
        assignDeliveryPartner();
        trackDelivery();
    }

    abstract void verify();
    abstract void assignDeliveryPartner();
    abstract void trackDelivery();
}

class LocalOrderProcessing extends OrderProcessingTemplate{
    @Override
    public void verify() {
        System.out.println("Verifying local order");
    }

    @Override
    public void assignDeliveryPartner() {
        System.out.println("Assigning local Delivery Partner");
    }
    @Override
    public void trackDelivery() {
        System.out.println("Tracking local Delivery Partner");
    }
}

class InternationalOrderProcessing extends OrderProcessingTemplate{
    @Override
    public void verify() {
        System.out.println("Verifying international order");
    }

    @Override
    public void assignDeliveryPartner() {
        System.out.println("Assigning international Delivery Partner");
    }
    @Override
    public void trackDelivery() {
        System.out.println("Tracking international Delivery Partner");
    }
}

public class OrderProcess {
    public static void main(String[] args) {
        OrderProcessingTemplate local=new LocalOrderProcessing();
        OrderProcessingTemplate international=new InternationalOrderProcessing();

        local.processOrder();
        international.processOrder();
    }
}
