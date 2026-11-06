package DesignPattern.CreationalDesignPattern.SingletonPattern.LazyInitialization;

public class DatabaseManager {
    private static DatabaseManager instance;

    private DatabaseManager() {
        System.out.println("Database Manager Created");
    }

    public static DatabaseManager getInstance() {
        if(instance==null){
            instance=new DatabaseManager();
        }
        return instance;
    }
}
