package DesignPattern.StructuralDesignPattern.ProxyPattern;

interface Image{
    void display();
}

class ImageProxy implements Image{
    private Image realImage;
    private String fileName;
    public ImageProxy(String fileName) {
        this.fileName = fileName;
        this.realImage = null;
    }

    @Override
    public void display() {
        if(realImage == null){
            realImage = new RealImage(fileName);
        }
        realImage.display();
    }
}

class RealImage implements Image{
    private String fileName;

    public RealImage(String fileName) {
        this.fileName = fileName;
        loadFromDisk();
    }

    @Override
    public void display() {
        System.out.println("Displaying image: " + fileName);
    }

    private void loadFromDisk() {
        System.out.println("Loading image from disk: " + fileName);
    }

}
public class OpenImage {
    public static void main(String[] args) {
        Image proxy = new ImageProxy("high_res_image.jpg");
        proxy.display();
    }
}
