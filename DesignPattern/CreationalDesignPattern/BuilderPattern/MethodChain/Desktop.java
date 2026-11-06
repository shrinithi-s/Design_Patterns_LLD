package DesignPattern.CreationalDesignPattern.BuilderPattern.MethodChain;

//with method chaining
public class Desktop{
    private String motherboard;
    private String processor;
    private String memory;
    private String storage;
    private String graphicsCard;

    public String getMotherboard() {
        return motherboard;
    }

    public void setMotherboard(String motherboard) {
        this.motherboard = motherboard;
    }

    public String getProcessor() {
        return processor;
    }

    public void setProcessor(String processor) {
        this.processor = processor;
    }

    public String getMemory() {
        return memory;
    }

    public void setMemory(String memory) {
        this.memory = memory;
    }

    public String getStorage() {
        return storage;
    }

    public void setStorage(String storage) {
        this.storage = storage;
    }

    public String getGraphicsCard() {
        return graphicsCard;
    }

    public void setGraphicsCard(String graphicsCard) {
        this.graphicsCard = graphicsCard;
    }

    public void display() {
        System.out.println("Desktop Specs:");
        System.out.println("Motherboard: " + motherboard);
        System.out.println("Processor: " + processor);
        System.out.println("Memory: " + memory);
        System.out.println("Storage: " + storage);
        System.out.println("Graphics Card: " + graphicsCard);
    }
}

abstract class DesktopBuilder{
    Desktop desktop=new Desktop();

    public abstract DesktopBuilder buildMotherboard();
    public abstract DesktopBuilder buildProcessor();
    public abstract DesktopBuilder buildMemory();
    public abstract DesktopBuilder buildStorage();
    public abstract DesktopBuilder buildGraphicsCard();

    Desktop getDesktop(){
        return desktop;
    }
}

class DellDesktopBuilder extends DesktopBuilder{

    public DesktopBuilder buildMotherboard() {
        desktop.setMotherboard("Dell Motherboard");
        return this;
    }

    public DesktopBuilder buildProcessor() {
        desktop.setProcessor("Dell Processor");
        return this;
    }

    public DesktopBuilder buildMemory() {
        desktop.setMemory("32GB DDR4 RAM");
        return this;
    }

    public DesktopBuilder buildStorage() {
        desktop.setStorage("1TB SSD + 2TB HDD");
        return this;
    }

    public DesktopBuilder buildGraphicsCard() {
        desktop.setGraphicsCard("NVIDIA RTX 3080");
        return this;
    }

}

class HpDesktopBuilder extends DesktopBuilder {
    public DesktopBuilder buildMotherboard() {
        desktop.setMotherboard("HP Motherboard");
        return this;
    }

    public DesktopBuilder buildProcessor() {
        desktop.setProcessor("Intel Core i5");
        return this;
    }

    public DesktopBuilder buildMemory() {
        desktop.setMemory("16GB DDR4 RAM");
        return this;
    }

    public DesktopBuilder buildStorage() {
        desktop.setStorage("512GB SSD");
        return this;
    }

    public DesktopBuilder buildGraphicsCard() {
        desktop.setGraphicsCard("Integrated Graphics");
        return this;
    }
}

class DesktopDirector{
    public Desktop buildDesktop(DesktopBuilder builder){
        builder.buildMotherboard()
                .buildProcessor()
                .buildMemory()
                .buildStorage()
                .buildGraphicsCard();
        return builder.getDesktop(); //method chaining
    }
}

class Main {
    public static void main(String[] args) {
        DesktopBuilder builder=new DellDesktopBuilder();

        DesktopDirector director=new DesktopDirector();
        Desktop desktop=director.buildDesktop(builder);
        desktop.display();
    }
}
