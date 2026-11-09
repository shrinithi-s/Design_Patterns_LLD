package DesignPattern.BehavioralDesignPattern.StatePattern;

interface ATMMachineState{
    void enterCard(ATMMachine atm);
    void enterPin(ATMMachine atm,int pin);
    void checkBalance(ATMMachine atm);
    void withdraw(ATMMachine atm,int amount);
    void ejectCard(ATMMachine atm);
}

class IDLEState implements ATMMachineState{

    @Override
    public void enterCard(ATMMachine atm){
        System.out.println("Card inserted");
        atm.setState(new HasCardState());
    }

    @Override
    public void enterPin(ATMMachine atm,int pin){
        System.out.println("Insert card first");
    }

    @Override
    public void checkBalance(ATMMachine atm){
        System.out.println("Please Authenticate");
    }
    
    @Override
    public void withdraw(ATMMachine atm,int amount){
        System.out.println("Insert card first");
    }
    
    @Override
    public void ejectCard(ATMMachine atm){
        System.out.println("No card to eject");
    }
}

class HasCardState implements ATMMachineState{

    @Override
    public void enterCard(ATMMachine atm){
        System.out.println("Card already inserted");
    }

    @Override
    public void enterPin(ATMMachine atm,int pin){
        if(pin==123){
            System.out.println("Pin is correct");
            atm.setState(new AuthState());
        }else{
            System.out.println("Pin is incorrect");
        }
    }

    @Override
    public void checkBalance(ATMMachine atm){
        System.out.println("Please Authenticate");
    }

    @Override
    public void withdraw(ATMMachine atm,int amount){
        System.out.println("Please Authenticate");
    }

    @Override
    public void ejectCard(ATMMachine atm){
        System.out.println("Card ejected");
        atm.setState(new IDLEState());
    }

}

class AuthState implements ATMMachineState{

    @Override
    public void enterCard(ATMMachine atm){
        System.out.println("Card already inserted");
    }

    @Override
    public void enterPin(ATMMachine atm,int pin){
        System.out.println("Authentication already completed");
    }

    @Override
    public void checkBalance(ATMMachine atm){
        System.out.println("Here this is your Balance :"+atm.getBalance());

    }

    @Override
    public void withdraw(ATMMachine atm,int amount){
        if (amount > 0 && atm.getBalance() >= amount) {
            atm.deductBalance(amount);
            System.out.println("Dispensing cash: " + amount);
            System.out.println("Your remaining balance is " + atm.getBalance());
        } else {
            System.out.println("Insufficient balance or invalid amount");
        }
    }

    @Override
    public void ejectCard(ATMMachine atm){
        System.out.println("Card ejected");
        atm.setState(new IDLEState());
    }

}

public class ATMMachine {
    private ATMMachineState state;
    private int balance;

    ATMMachine(int balance){
        this.balance = balance;
        state=new IDLEState();
    }

    public void insertCard(){
        state.enterCard(this);
    }

    public void enterPin(int pin){
        state.enterPin(this,pin);
    }

    public void setState(ATMMachineState state){
        this.state=state;
    }

    public int getBalance(){
        return balance;
    }

    public void deductBalance(int amount){
        balance-=amount;
    }

    public void checkBalance(){
        state.checkBalance(this);
    }

    public void withdraw(int amount){
        state.withdraw(this,amount);
    }

    public void ejectCard(){
        state.ejectCard(this);
    }

}

class Main{
    public static void main(String[] args) {
        ATMMachine atm=new ATMMachine(1000);
        atm.insertCard();
        atm.enterPin(123);
        atm.checkBalance();
        atm.withdraw(200);
        atm.ejectCard();
    }
}
