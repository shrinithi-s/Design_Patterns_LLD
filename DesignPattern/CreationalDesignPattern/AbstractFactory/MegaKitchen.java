package DesignPattern.CreationalDesignPattern.AbstractFactory;

interface Istarter{
    void createStarter();
}

interface Imain{
    void createMain();
}

interface Idessert{
    void createDessert();
}

class vegStarter implements Istarter{
    public void createStarter(){
        System.out.println("veg starter created");
    }
}

class nonvegStarter implements Istarter{
    public void createStarter(){
        System.out.println("non veg starter created");
    }
}

class vegMain implements Imain{
    public void createMain(){
        System.out.println("veg main course created");
    }
}

class nonvegMain implements Imain{
    public void createMain(){
        System.out.println("nonveg main course created");
    }
}

class vegDessert implements Idessert{
    public void createDessert(){
        System.out.println("veg dessert created");
    }
}

class nonvegDessert implements Idessert{
    public void createDessert(){
        System.out.println("nonveg dessert created");
    }
}

interface ICusineFactory{
    Istarter starter();
    Imain mainCourse();
    Idessert dessert();
}

class vegFactory implements ICusineFactory{
    public Istarter starter(){
        return new vegStarter();
    }

    public Imain mainCourse(){
        return new vegMain();
    }

    public Idessert dessert(){
        return new vegDessert();
    }
}

class nonvegFactory implements ICusineFactory{
    public Istarter starter(){
        return new nonvegStarter();
    }

    public Imain mainCourse(){
        return new nonvegMain();
    }

    public Idessert dessert(){
        return new nonvegDessert();
    }
}


class CusineFactory{
    public static ICusineFactory createFactory(String type){
        if(type.equals("veg")){
            return new vegFactory();
        }
        if(type.equals("nonveg")){
            return new nonvegFactory();
        }
        return null;
    }
}



public class MegaKitchen {
    public static void main(String[] args) {
        ICusineFactory factory=CusineFactory.createFactory("veg");

        if(factory!=null){
            Istarter starter=factory.starter();
            Imain mainCourse=factory.mainCourse();
            Idessert dessert=factory.dessert();

            starter.createStarter();
            mainCourse.createMain();
            dessert.createDessert();
        }
    }
}
