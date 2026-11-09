package DesignPattern.BehavioralDesignPattern.ObserverPattern;


import java.util.*;

//Observer
interface NotificationObserver {
    void notify(String orderId, String status);
}

class SMSNotification implements NotificationObserver {
    private String phone;

    public SMSNotification(String phone) {
        this.phone = phone;
    }

    public void notify(String orderId, String status) {
        System.out.println("SMS to " + phone + ": Order " + orderId + " is " + status);
    }
}

class EmailNotification implements NotificationObserver {
    private String email;

    public EmailNotification(String email) {
        this.email = email;
    }

    public void notify(String orderId, String status) {
        System.out.println("Email to " + email + ": Order " + orderId + " is " + status);
    }
}

//Subject
class OrderStatus {

    private String orderId;
    private String status;

    private Map<String, List<NotificationObserver>> observers = new HashMap<>(); //Name and Different NOtification

    public OrderStatus(String orderId) {
        this.orderId = orderId;
    }

    public void subscribe(String user, NotificationObserver observer) {
        observers.computeIfAbsent(user, k -> new ArrayList<>()).add(observer);
    }

    public void unsubscribe(String user, NotificationObserver observer) {
        List<NotificationObserver> list = observers.get(user);

        if (list != null) {
            list.remove(observer);
            if (list.isEmpty()) observers.remove(user);

        }
    }

    public void updateStatus(String status) {
        this.status = status;
        System.out.println("\nOrder status changed: " + status);
        notifyAllObservers();
    }

    public void notifyAllObservers() {
        for (List<NotificationObserver> list : observers.values()) {
            for (NotificationObserver observer : list) {
                observer.notify(orderId, status);
            }
        }
    }
}

class Order {

    private String orderId;
    private String userId;
    private List<String> products;
    private OrderStatus orderStatus;

    public Order(String orderId, String userId, List<String> products) {
        this.orderId = orderId;
        this.userId = userId;
        this.products = products;
        this.orderStatus = new OrderStatus(orderId);
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }
}



public class OrderNotifier {
    public static void main(String[] args) {
        Order order1 = new Order("ORD101", "Shrinith", Arrays.asList("iPhone", "Sony Headphones"));
        OrderStatus status1 = order1.getOrderStatus();
        status1.subscribe("Shrinith", new SMSNotification("9876543210"));
        status1.subscribe("Shrinith", new EmailNotification("shri@gmail.com"));
        status1.updateStatus("SHIPPED");
        status1.updateStatus("DELIVERED");

    }
}
