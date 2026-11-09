package DesignPattern.BehavioralDesignPattern.StrategyPattern.StrategyAndFactory;

//Strategy
interface PaymentStrategy {
    void processPayment(double amount);
}

//Concrete Strategy
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

    public void  setPaymentStrategy(String paymentMethod) {
        this.paymentStrategy = PaymentStrategyFactory.createPaymentStrategy(paymentMethod);
    }

    public void processPayment(double amount) {
        paymentStrategy.processPayment(amount);
    }
}

//Simple Factory
class PaymentStrategyFactory {
    public static PaymentStrategy createPaymentStrategy(String paymentMethod) {
        if (paymentMethod.equals("Credit Card")) {
            return new CreditCardPayment();
        } else if (paymentMethod.equals("PayPal")) {
            return new PayPalPayment();
        } else if (paymentMethod.equals("Crypto currency")) {
            return new CryptoPayment();
        } else {
            // Default to CreditCardPayment
            return new CreditCardPayment();
        }
    }
}
public class Payment {
    public static void main(String[] args) {
        PaymentProcessor paymentProcessor = new PaymentProcessor();

        paymentProcessor.setPaymentStrategy("Credit Card");
        paymentProcessor.processPayment(3500.0);

    }
}
