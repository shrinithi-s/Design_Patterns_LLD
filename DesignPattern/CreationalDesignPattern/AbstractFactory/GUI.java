package DesignPattern.CreationalDesignPattern.AbstractFactory;

interface IButton{
    void press();
}

interface ITextBox{
    void setText();
}

class MacButton implements IButton{
    public void press(){
        System.out.println("Mac Button pressed");
    }
}

class WindowsButton implements IButton{
    public void press(){
        System.out.println("Windows Button pressed");
    }
}

class MacTextBox implements ITextBox{
    public void setText(){
        System.out.println("Setting Button in Mac Text box");
    }
}

class WindowsTextBox implements ITextBox{
    public void setText(){
        System.out.println("Setting Button in Windows Text box");
    }
}

interface IFactory{
    IButton createButton();
    ITextBox createTextBox();
}

class MacFactory implements IFactory{
    public IButton createButton(){
        return new MacButton();
    }

    public ITextBox createTextBox(){
        return new MacTextBox();
    }
}

class WindowsFactory implements IFactory{
    public IButton createButton(){
        return new WindowsButton();
    }

    public ITextBox createTextBox(){
        return new WindowsTextBox();
    }
}

class GUIFactory{
    public static IFactory createFactory(String osType){
        osType=osType.toLowerCase();
        
        if(osType.equals("windows")){
            return new WindowsFactory();
        }

        if(osType.equals("mac")){
            return new MacFactory();
        }

        return null;
    }
}


public class GUI {
    public static void main(String[] args) {
        IFactory factory=GUIFactory.createFactory("Windows");

        if(factory!=null){
            IButton button=factory.createButton();
            button.press();
        
            ITextBox textBox=factory.createTextBox();
            textBox.setText(); 
        }
    }
}
