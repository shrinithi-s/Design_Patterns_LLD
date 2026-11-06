package DesignPattern.CreationalDesignPattern.FactoryPattern;

import java.util.List;
import java.util.ArrayList;


abstract class Module{ //Modules
    public abstract void displayModule();
}

//Concrete Modules
class IntroductionModule extends Module {
    @Override
    public void displayModule() {
        System.out.println("Introduction Module");
    }
}

class ConceptModule extends Module {
    @Override
    public void displayModule() {
        System.out.println("Concept Module");
    }
}

class DemoModule extends Module {
    @Override
    public void displayModule() {
        System.out.println("Demo Module");
    }
}

class ExerciseModule extends Module {
    @Override
    public void displayModule() {
        System.out.println("Exercise Module");
    }
}

class SummaryModule extends Module {
    @Override
    public void displayModule() {
        System.out.println("Summary Module");
    }
}

abstract class Course{ //course
    protected  List<Module> modules=new ArrayList<>();

    public Course(){
        this.createdCourse();
    }

    public void displayModules() {
        for (Module module : modules) {
            module.displayModule();
        }
        System.out.println("*******");
    }

    public abstract void createdCourse();
}

//concrete courses

class HLD extends Course{
    @Override 
    public void createdCourse(){
        modules.add(new IntroductionModule());
        modules.add(new ConceptModule());
        modules.add(new ExerciseModule());
        modules.add(new SummaryModule());
    }
}

class LLD extends Course{
    @Override 
    public void createdCourse(){
        modules.add(new DemoModule());
        modules.add(new IntroductionModule());
        modules.add(new ConceptModule());
        modules.add(new ExerciseModule());
        modules.add(new SummaryModule());
    }
}

public class CourseFactory { //simple factory- violated ocp principle
    public static Course getCourse(String type) {
        if (type.equalsIgnoreCase("HLD")) {
            return new HLD();
        }

        if (type.equalsIgnoreCase("LLD")) {
            return new LLD();
        }
        return null;
    }
}

//Abstract CourseFactory
interface CourseFactory2{
    Course createCourse();
}

class HLDFactory implements  CourseFactory2{
    public Course createCourse(){
        return new HLD();
    }
}

class LLDFactory implements  CourseFactory2{
    public Course createCourse(){
        return new LLD();
    }
}


class MyCourse{
    public static void main(String[] args) {
        Course hldCourse=CourseFactory.getCourse("HLD");
        hldCourse.displayModules();

        CourseFactory2 factory=new LLDFactory();
        Course course=factory.createCourse();
        course.displayModules();
    }
    
}