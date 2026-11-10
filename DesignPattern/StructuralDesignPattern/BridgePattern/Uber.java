package DesignPattern.StructuralDesignPattern.BridgePattern;

//Implementation layer
interface NavigationImplementation{
    void navigateTo(String destination);
}

//Concrete implementation
class GoogleMaps implements NavigationImplementation{
    @Override
    public void navigateTo(String destination) {
        System.out.println("Google Maps");
    }
}

class AppleMaps implements NavigationImplementation{
    @Override
    public void navigateTo(String destination) {
        System.out.println("Apple Maps");
    }
}

//Abstration
interface NavigationSystem{
    void navigateTo(String destination);
    void setNavigationImpl(NavigationImplementation impl);
}

//Concrete abstration
class UberRide implements NavigationSystem{

    private String driverName;
    private NavigationImplementation navigationImpl;

    public UberRide(String driverName) {
        this.driverName = driverName;
    }

    @Override
    public void setNavigationImpl(NavigationImplementation impl) {
        this.navigationImpl = impl;
    }

    @Override
    public void navigateTo(String destination) {
        System.out.print("Uber ride with " + driverName + " to " + destination + " using ");
        navigationImpl.navigateTo(destination);
    }
}

class UberEats implements NavigationSystem{

    private String restaurantName;
    private NavigationImplementation navigationImpl;

    public UberEats(String restaurantName) {
        this.restaurantName = restaurantName;
    }
    @Override
    public void setNavigationImpl(NavigationImplementation impl) {
        this.navigationImpl = impl;
    }

    @Override
    public void navigateTo(String destination) {
        System.out.print("Uber Eats delivery from " + restaurantName + " to " + destination + " using ");
        navigationImpl.navigateTo(destination);
    }
}

public class Uber {
    public static void main(String[] args) {
        NavigationSystem uberRide = new UberRide("Kumar Raj");
        NavigationImplementation googleMaps = new GoogleMaps();
        uberRide.setNavigationImpl(googleMaps);
        uberRide.navigateTo("Sarjapura");

    }
}