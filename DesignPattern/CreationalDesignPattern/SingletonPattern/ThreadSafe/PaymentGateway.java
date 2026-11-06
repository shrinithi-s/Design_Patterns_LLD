package DesignPattern.CreationalDesignPattern.SingletonPattern.ThreadSafe;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

//double checking locking
public class PaymentGateway {
    private static PaymentGateway instance;

    private static Lock mtx = new ReentrantLock();

    private PaymentGateway() {
        System.out.println("Payment Gateway Manager initialized.");
    }

    public static PaymentGateway getInstance() {
        if(instance==null){ //first check without locking bz lock is expensive
            mtx.lock();
            if(instance==null){
                instance = new PaymentGateway();
            }
            mtx.unlock();
        }
        return instance;
    }


}
