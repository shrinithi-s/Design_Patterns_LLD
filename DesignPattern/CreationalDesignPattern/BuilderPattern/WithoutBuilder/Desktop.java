package DesignPattern.CreationalDesignPattern.BuilderPattern.WithoutBuilder;

public class Desktop {

    // Required parameters
    private String RAM;
    private String CPU;
    private String DISK;
    private String STORAGE;

    // Optional parameters
    private String GPU;
    private String OS;
    private boolean bluetooth;
    private boolean wifi;

    // Constructor with only required parameters
    public Desktop(String RAM, String CPU, String DISK, String STORAGE) {
        this.RAM = RAM;
        this.CPU = CPU;
        this.DISK = DISK;
        this.STORAGE = STORAGE;
    }

    // Setters for optional parameters
    public void setGPU(String GPU) {
        this.GPU = GPU;
    }

    public void setOS(String OS) {
        this.OS = OS;
    }

    public void setBluetooth(boolean bluetooth) {
        this.bluetooth = bluetooth;
    }

    public void setWifi(boolean wifi) {
        this.wifi = wifi;
    }
}

//Telescoping Constructors:
//As the number of parameters increases, especially optional ones, the number of constructor combinations grows
// exponentially. This leads to multiple constructors with varying parameter lists,
// making the code harder to maintain and understand.

class Main {
    public static void main(String[] args) {
        Desktop d1 = new Desktop("16GB", "Intel i7", "SSD", "1TB");
        d1.setGPU("NVIDIA RTX 4060");
        d1.setOS("Ubuntu");

        Desktop d2 = new Desktop("8GB", "Intel i5", "HDD", "512GB");
        d2.setWifi(true);
    }
}

