package DesignPattern.BehavioralDesignPattern.ObserverPattern;

import java.util.ArrayList;
import java.util.List;

//Observer
interface Observer{
    void notify(String productName);
}

//concrete Observer
class EmailObserver implements Observer{
    private String email;

    public EmailObserver(String email) {
        this.email = email;
    }
    @Override
    public void notify(String productName) {
        System.out.println("Email sent to " + email + ": " + productName + " launched!");
    }
}

//concrete Observer
class SMSObserver implements Observer{
    private String phone;

    public SMSObserver(String phone) {
        this.phone = phone;
    }

    @Override
    public void notify(String productName) {
        System.out.println("SMS sent to " + phone + ": " + productName + " launched!");
    }
}

//Subject
interface Product{
    void subscribe(Observer observer);
    void unsubscribe(Observer observer);
    void notifyAllObservers();
}

class NewProduct implements Product{
    private List<Observer> observers=new ArrayList<>();
    private String productName;

    public NewProduct(String productName) {
        this.productName = productName;
    }

    @Override
    public void subscribe(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void unsubscribe(Observer observer) {
        observers.remove(observer);
    }

    public void launch() {
        System.out.println(productName + " launched!");
        notifyAllObservers();
    }

    @Override
    public void notifyAllObservers() {
        for(Observer observer:observers){
            observer.notify(productName);
        }
    }
}

public class NewLaunch {
    public static void main(String[] args) {
        NewProduct iphone=new NewProduct("IPhone 18");
        // Customer A
        iphone.subscribe(new EmailObserver("johhnydep@gmail.com"));
        iphone.subscribe(new SMSObserver("912343253"));
        iphone.subscribe(new EmailObserver("brittanysnow@gmail.com"));

        iphone.launch();
    }
}
