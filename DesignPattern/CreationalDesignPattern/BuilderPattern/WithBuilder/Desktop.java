package DesignPattern.CreationalDesignPattern.BuilderPattern.WithBuilder;

public class Desktop {
    // Required parameters
    private final String RAM;
    private final String CPU;
    private final String DISK;
    private final String STORAGE;

    // Optional parameters
    private final String GPU;
    private final String OS;
    private final boolean bluetooth;
    private final boolean wifi;

    // Private constructor
    private Desktop(Builder builder) {
        this.RAM = builder.RAM;
        this.CPU = builder.CPU;
        this.DISK = builder.DISK;
        this.STORAGE = builder.STORAGE;

        this.GPU = builder.GPU;
        this.OS = builder.OS;
        this.bluetooth = builder.bluetooth;
        this.wifi = builder.wifi;

    }

    // Builder class
    public static class Builder {

        // Required parameters
        private final String RAM;
        private final String CPU;
        private final String DISK;
        private final String STORAGE;

        // Optional parameters
        private String GPU;
        private String OS;
        private boolean bluetooth;
        private boolean wifi;

        // Constructor for required parameters
        public Builder(String RAM, String CPU, String DISK, String STORAGE) {
            this.RAM = RAM;
            this.CPU = CPU;
            this.DISK = DISK;
            this.STORAGE = STORAGE;
        }

        // Optional parameter setters
        public Builder setGPU(String GPU) {
            this.GPU = GPU;
            return this;
        }

        public Builder setOS(String OS) {
            this.OS = OS;
            return this;
        }

        public Builder setBluetooth(boolean bluetooth) {
            this.bluetooth = bluetooth;
            return this;
        }

        public Builder setWifi(boolean wifi) {
            this.wifi = wifi;
            return this;
        }

        // Build method
        public Desktop build() {
            return new Desktop(this);
        }
    }

    class Main{
        public static void main(String[] args) {
            Desktop d1 = new Desktop.Builder("16GB", "Intel i7", "SSD", "1TB").setGPU("NVIDIA RTX 4060").build();
            Desktop d2 = new Desktop.Builder("32GB", "Intel i9", "SSD", "2TB")
                    .setGPU("NVIDIA RTX 5090")
                    .setOS("Ubuntu")
                    .setWifi(true)
                    .setBluetooth(true)
                    .build();
        }
    }

}
