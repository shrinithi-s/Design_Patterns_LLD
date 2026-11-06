package DesignPattern.CreationalDesignPattern.AbstractFactory;

interface Payment {
    String processPayment(String orderId, double amount);
}

interface Refund {
    void processRefund(String paymentId, double amount);
}

interface WebhookHandler {
    void handleWebhook(String event);
}

//concreate products
class RazorpayPayment implements Payment {

    @Override
    public String processPayment(String orderId, double amount) {
        System.out.println(
            "Processing payment through Razorpay: " + amount
        );

        return "rzp_pay_101";
    }
}

class RazorpayRefund implements Refund {

    @Override
    public void processRefund(String paymentId, double amount) {
        System.out.println(
            "Refunding " + amount + " through Razorpay for " + paymentId
        );
    }
}

class RazorpayWebhookHandler implements WebhookHandler {

    @Override
    public void handleWebhook(String event) {
        System.out.println(
            "Razorpay webhook received: " + event
        );
    }
}

//concrete products
class StripePayment implements Payment {

    @Override
    public String processPayment(String orderId, double amount) {
        System.out.println(
            "Processing payment through Stripe: " + amount
        );

        return "stripe_pay_101";
    }
}

class StripeRefund implements Refund {

    @Override
    public void processRefund(String paymentId, double amount) {
        System.out.println(
            "Refunding " + amount + " through Stripe for " + paymentId
        );
    }
}

class StripeWebhookHandler implements WebhookHandler {

    @Override
    public void handleWebhook(String event) {
        System.out.println(
            "Stripe webhook received: " + event
        );
    }
}

interface PaymentFactory { //factory

    Payment createPayment();

    Refund createRefund();

    WebhookHandler createWebhookHandler();
}

//concrete factory

class RazorpayFactory implements PaymentFactory {

    @Override
    public Payment createPayment() {
        return new RazorpayPayment();
    }

    @Override
    public Refund createRefund() {
        return new RazorpayRefund();
    }

    @Override
    public WebhookHandler createWebhookHandler() {
        return new RazorpayWebhookHandler();
    }
}

//concrete factory
class StripeFactory implements PaymentFactory {

    @Override
    public Payment createPayment() {
        return new StripePayment();
    }

    @Override
    public Refund createRefund() {
        return new StripeRefund();
    }

    @Override
    public WebhookHandler createWebhookHandler() {
        return new StripeWebhookHandler();
    }
}

class PaymentService {

    private PaymentFactory factory;

    public PaymentService(PaymentFactory factory) {
        this.factory = factory;
    }

    public String checkout(String orderId, double amount) {

        Payment payment = factory.createPayment();

        return payment.processPayment(orderId, amount);
    }

    public void refundOrder(String paymentId, double amount) {

        Refund refund = factory.createRefund();

        refund.processRefund(paymentId, amount);
    }

    public void receiveWebhook(String event) {

        WebhookHandler handler = factory.createWebhookHandler();

        handler.handleWebhook(event);
    }
}

public class EcomPayment {
    public static void main(String[] args) {
        PaymentFactory factory = new RazorpayFactory();
        PaymentService paymentService=new PaymentService(factory);
        paymentService.checkout("123", 100);
        paymentService.refundOrder("123", 100);
        paymentService.receiveWebhook("123"); //Razorpay or Stripe notifies your e-commerce application about a payment event.

    }
}
