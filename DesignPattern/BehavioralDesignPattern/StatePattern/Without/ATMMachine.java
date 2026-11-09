package DesignPattern.BehavioralDesignPattern.StatePattern.Without;

public class ATMMachine {

    private String state; //IDLE,HAS_CARD,AUTHENTICATED
    private int balance;

    public ATMMachine(int balance) {
        this.state = "IDLE";
        this.balance = balance;
    }

    public void insertCard(){
        if(state == "IDLE"){
            System.out.println("Card inserted");
            state = "HAS_CARD";
        }else{
            System.out.println("Card already inserted");
        }

    }

    public void enterPin(int pin){
        if(state.equals("HAS_CARD")){
            if(pin == 2104){
                System.out.println("PIN Correct");
                state = "AUTHENTICATED";
            }
        }else if(state.equals("IDLE")){
            System.out.println("Insert car first");
        }else{
            System.out.println("Already Authenticated");
        }
    }

    public void checkBalance(){
        if(state.equals("AUTHENTICATED")){
            System.out.println("Available Balance "+this.balance);
        }else{
            System.out.println("Please Authenticate");
        }
    }

    public void widthdraw(int amount){
        if(state.equals("AUTHENTICATED")){
            if(balance >= amount){
                balance -= amount;
                System.out.println("Dispensing cash: "+amount);
                System.out.println("Your remaining cash is "+balance);
            }else{
                System.out.println("Insufficient balance");
            }
        }else if(state.equals("IDLE")){
            System.out.println("Insert Card first");
        }else{
            System.out.println("Please authenticate first");
        }
    }

    public void ejectCard(){
        if(state.equals("HAS_CARD")||state.equals("AUTHENTICATED")){
            System.out.println("Card ejected");
            state = "IDLE";
        }else{
            System.out.println("No card to edject");
        }
    }

}
//IDLE- go insert card
//HAS CARD-pls authenticate
//AUTHENTICATED- go a head and check balance,widthdraw

class Main{
    public static void main(String[] args) {
        ATMMachine atm=new ATMMachine(500);
        atm.insertCard();
        atm.enterPin(2104);
        atm.checkBalance();
        atm.widthdraw(210);
        atm.ejectCard();
    }
}