package DesignPattern.StructuralDesignPattern.AdapterPattern;

//Object Adapter Design Pattern

public class JSONAnalyticsTool { //Adaptee
    private String jsonData;

    public void setJsonData(String jsonData) {
        this.jsonData = jsonData;
    }

    public void analyseData(){
        if (jsonData.contains("json")) {
            System.out.println("Analyzing JSON Data - " + jsonData);
        } else {
            System.out.println("Not in the correct format. Can't analyze!");
        }
    }
}

interface AnalyticsTool{ //Adapter
    void analyseData();
}

//Concrete Adapters

class XMLToJSON implements AnalyticsTool{

    private JSONAnalyticsTool jsonAnalyticsTool;

    public XMLToJSON(String xmlData) {
        System.out.println("Converting the XML Data '" + xmlData + "' to JSON Data!");
        String newData = xmlData + " in json";
        jsonAnalyticsTool = new JSONAnalyticsTool();
        jsonAnalyticsTool.setJsonData(newData);
    }
    @Override
    public void analyseData() {
        jsonAnalyticsTool.analyseData();
    }
}

class Main{
    public static void main(String[] args) {
        String xmlData = "Blahh";
        AnalyticsTool tool = new XMLToJSON(xmlData);
        tool.analyseData();
    }
}

