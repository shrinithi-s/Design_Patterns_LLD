package DesignPattern.CreationalDesignPattern.SingletonPattern.EagerInitialization;

public class DatabaseManager {
    private static DatabaseManager instance=new DatabaseManager();

    private DatabaseManager() {
        System.out.println("Database Manager Created");
    }

    public static DatabaseManager getInstance() {
        return instance;
    }
}

class Main{
    public static void main(String[] args) {
        DatabaseManager db1=DatabaseManager.getInstance();
        DatabaseManager db2=DatabaseManager.getInstance();
        System.out.println(db1.equals(db2));
    }
}