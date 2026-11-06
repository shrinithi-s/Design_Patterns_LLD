package DesignPattern.CreationalDesignPattern.BuilderPattern;

public class Desktop {
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

//Abstract Builder
abstract class DesktopBuilder{
    protected Desktop desktop=new Desktop();

    public abstract void buildMotherboard();
    public abstract void buildProcessor();
    public abstract void buildMemory();
    public abstract void buildStorage();
    public abstract void buildGraphicsCard();

    Desktop getDesktop(){
        return desktop;
    }
}

//concrete Builders
class DellDesktopBuilder extends DesktopBuilder{
    @Override
    public void buildMotherboard() {
        desktop.setMotherboard("Dell Motherboard");
    }
    @Override
    public void buildProcessor() {
        desktop.setProcessor("Dell Processor");
    }

    @Override
    public void buildMemory() {
        desktop.setMemory("32GB DDR4 RAM");
    }

    @Override
    public void buildStorage() {
        desktop.setStorage("1TB SSD + 2TB HDD");
    }

    @Override
    public void buildGraphicsCard() {
        desktop.setGraphicsCard("NVIDIA RTX 3080");
    }
}

class HpDesktopBuilder extends DesktopBuilder {
    public void buildMotherboard() {
        desktop.setMotherboard("HP Motherboard");
    }

    public void buildProcessor() {
        desktop.setProcessor("Intel Core i5");
    }

    public void buildMemory() {
        desktop.setMemory("16GB DDR4 RAM");
    }

    public void buildStorage() {
        desktop.setStorage("512GB SSD");
    }

    public void buildGraphicsCard() {
        desktop.setGraphicsCard("Integrated Graphics");
    }
}

class Director{
    public Desktop buildDesktop(DesktopBuilder builder){
        builder.buildMotherboard();
        builder.buildProcessor();
        builder.buildMemory();
        builder.buildStorage();
        builder.buildGraphicsCard();
        return builder.getDesktop();
    }
}

class Main{
    public static void main(String[] args) {
        DesktopBuilder builder=new DellDesktopBuilder();
        Director director=new Director();
        Desktop desktop=director.buildDesktop(builder);
        desktop.display();
    }
}