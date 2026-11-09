package DesignPattern.BehavioralDesignPattern.CommandPattern;

class RapidoService{ //Reciever
    public void book(String name,String src,String des){
        System.out.println("Booking ride for "+name+" from "+src+" to "+des);
    }

    public void cancel(String name){
        System.out.println("Ride cancelled for "+name);
    }
}

interface Command{ //commands
    void execute();
}

class RapidoBook implements Command{ //concrete commands

    private RapidoService rapidoService;
    private String name;
    private String src;
    private String des;

    public RapidoBook(RapidoService rapidoService,String name,String src,String des){
        this.rapidoService=rapidoService;
        this.name=name;
        this.src=src;
        this.des=des;
    }

    @Override
    public void execute(){
        rapidoService.book(name, src, des);
    }
}

class RapidoCancel implements Command{ //concrete commands

    private RapidoService rapidoService;
    private String name;


    public RapidoCancel(RapidoService rapidoService,String name){
        this.rapidoService=rapidoService;
        this.name=name;
    }

    @Override
    public void execute(){
        rapidoService.cancel(name);
    }
}

class RapidoRideInvoker{ //Invoker
    public void executeCommands(Command command){
        command.execute();
    }
}

public class RapidoDemo {
    
    public static void main(String[] args) {
        RapidoService service=new RapidoService();

        Command commandBook=new RapidoBook(service,"Shrinith","Thanjavur","Papanasam");
        Command commandCancel=new RapidoCancel(service,"Shrinith");

        RapidoRideInvoker invoker=new RapidoRideInvoker();
        invoker.executeCommands(commandBook);
        invoker.executeCommands(commandCancel);
    }
}
