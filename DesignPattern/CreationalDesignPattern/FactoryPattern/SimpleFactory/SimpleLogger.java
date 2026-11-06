package DesignPattern.CreationalDesignPattern.FactoryPattern.SimpleFactory;

interface ILogger{
    void log();
}

class DebugLogger implements ILogger{
    public void log(){
        System.out.println("This is Debug Logger");
    }
}

class InfoLogger implements ILogger{
    public void log(){
        System.out.println("This is Info Logger");
    }
}

class ErrorLogger implements ILogger{
    public void log(){
        System.out.println("This is Error Logger");
    }
}

enum LogLevel {
    DEBUG, 
    ERROR, 
    INFO
}

class LoggerFactory{
    public static ILogger createLogger(LogLevel level){
        switch(level) {
            case DEBUG:
                return new DebugLogger();
            case ERROR:
                return new ErrorLogger();
            case INFO:
                return new InfoLogger();
            default:
                return null;
        } 
    }
}


public class SimpleLogger { //Main
    public static void main(String[] args) {
        ILogger logger=LoggerFactory.createLogger(LogLevel.DEBUG);
        logger.log();
    }
}
