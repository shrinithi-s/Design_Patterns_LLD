package DesignPattern.BehavioralDesignPattern.StrategyPattern;

//Strategy or Different Algos
interface PaymentStrategy {
    void processPayment(double amount);
}

//concrete Strategy
class CreditCardPayment implements PaymentStrategy {
    @Override
    public void processPayment(double amount) {
        System.out.println("Credit Card Payment - $" + amount);
    }
}

class PayPalPayment implements PaymentStrategy {
    @Override
    public void processPayment(double amount) {
        System.out.println("PayPal Payment - $" + amount);
    }
}

class CryptoPayment implements PaymentStrategy {
    @Override
    public void processPayment(double amount) {
        System.out.println("Crypto Payment - $" + amount);
    }
}

//context
class PaymentProcessor{
    private PaymentStrategy paymentStrategy;

    public PaymentProcessor() {
        paymentStrategy=null;
    }

    public void  setPaymentStrategy(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }

    public void processPayment(double amount) {
        paymentStrategy.processPayment(amount);
    }
}

public class Payment {
    public static void main(String[] args) {
        PaymentProcessor paymentProcessor = new PaymentProcessor();
        PaymentStrategy paymentStrategy = new CreditCardPayment();
        paymentProcessor.setPaymentStrategy(paymentStrategy);
        paymentProcessor.processPayment(3500.0);

    }
}
