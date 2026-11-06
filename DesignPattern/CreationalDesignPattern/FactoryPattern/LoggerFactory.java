package DesignPattern.CreationalDesignPattern.FactoryPattern;

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


interface ILoggerFactory{
    ILogger createLogger();
}

class DebugLoggerFactory implements ILoggerFactory{
    public ILogger createLogger(){
        return new DebugLogger();
    }
} 

class ErrorLoggerFactory implements ILoggerFactory{
    public ILogger createLogger(){
        return new ErrorLogger();
    }
}

class InfoLoggerFactory implements ILoggerFactory{
    public ILogger createLogger(){
        return new InfoLogger();
    }
}


public class LoggerFactory {
    public static void main(String[] args) {
        ILoggerFactory factory= new DebugLoggerFactory();
        ILogger logger=factory.createLogger();
        logger.log();
    }
}
