package DesignPattern.CreationalDesignPattern.PrototypePattern;

interface Button extends Cloneable{
    Button clone();
    void display();
}

class UIbutton implements Button{
    private String color;
    private String text;
    private int width;

    public UIbutton(String color, String text, int width) {
        this.color = color;
        this.text = text;
        this.width = width;
    }
    @Override
    public Button clone(){
        return new UIbutton(color, text, width);
    }

    @Override
    public void display() {
        System.out.println(text + " | " + color + " | " + width);
    }
}
public class ButtonPrototype {
    public static void main(String[] args) {
        Button og=new UIbutton("Blue","Submit",120);

        Button clone1=og.clone();
        Button clone2=og.clone();

        System.out.println(clone1.equals(clone2));
        clone1.display();
    }
}
