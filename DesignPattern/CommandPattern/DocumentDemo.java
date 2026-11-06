package DesignPattern.CommandPattern;

import java.util.List;
import java.util.ArrayList;


interface Commands{ //command
    void execute();
}

class DocumentOpen implements Commands{ //concreate commant
    Document doc;

    public DocumentOpen(Document doc){
        this.doc=doc;
    }
    public void execute(){
        doc.open();
    }
}

class DocumentWrite implements Commands{ //concreate commant
    Document doc;

    public DocumentWrite(Document doc){
        this.doc=doc;
    }
    public void execute(){
        doc.write();
    }
}

class DocumentClose implements Commands{ //concreate commant
    Document doc;

    public DocumentClose(Document doc){
        this.doc=doc;
    }
    public void execute(){
        doc.close();
    }
}

class Document{ //reciever - we can even extend this like keeping interface 
    public void open(){
        System.out.println("Document is opened");
    }

    public void write(){
        System.out.println("written in the Document");
    }

    public void close(){
        System.out.println("Document is closed");
    }
}

//we can even extend the reciever like google docs or Ms word
// interface Doc{
//     void open();
//     void write();
//     void close();
// }

class MenuOption{ //Invoker

    List<Commands> commandsList=new ArrayList<>();

    public void addCommands(Commands command){
        commandsList.add(command);
    }

    public void executeCommands(){
        for(Commands command:commandsList){
            command.execute();
        }
    }
}
public class DocumentDemo {
    public static void main(String[] args) {
        Document doc=new Document();

        Commands docOpen=new DocumentOpen(doc);
        Commands docWrite=new DocumentWrite(doc);
        Commands docClose=new DocumentClose(doc);

        MenuOption menu=new MenuOption();
        menu.addCommands(docOpen);
        menu.addCommands(docWrite);
        menu.addCommands(docClose);

        menu.executeCommands();
    }

}
