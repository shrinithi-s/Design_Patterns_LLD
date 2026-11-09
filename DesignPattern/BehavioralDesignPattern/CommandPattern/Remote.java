package DesignPattern.BehavioralDesignPattern.CommandPattern;

//Reciever
class TV{
    public void turnon(){
        System.out.println("TV turning on");
    }

    public void turnoff(){
        System.out.println("TV turning off");
    }
}

//Command
interface TVCommand {
    void execute();
}

//Concrete command
class TurnOn implements TVCommand {
    private TV tv;

    public TurnOn(TV tv) {
        this.tv = tv;
    }

    @Override
    public void execute() {
        tv.turnon();
    }
}

class TurnOff implements TVCommand {
    private TV tv;

    public TurnOff(TV tv) {
        this.tv = tv;
    }

    @Override
    public void execute() {
       tv.turnoff();
    }
}



//Invoker
public class Remote {
    private TVCommand command;

    public void setCommand(TVCommand command) {
        this.command = command;
    }

    public void execute() {
        command.execute();
    }
}

class Main {
    public static void main(String[] args) {
        TV tv = new TV();
        TVCommand turnOn=new TurnOn(tv);
        TVCommand turnOff=new TurnOff(tv);

        Remote remote=new Remote();

        remote.setCommand(turnOn);
        remote.execute();

        remote.setCommand(turnOff);
        remote.execute();

    }
}


// Client -> Invoker(Remote) -> Concrete Command ->Receiver