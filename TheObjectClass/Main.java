//Object is a class from the package java.lang and is the main superclass in Java. Every other class
//inherits from it.
//we can also define and implement classes in the same java file, as seen below

public class Main extends Object{
    public static void main(String[] args) {
        Student student = new Student("Max", 21);
        PrimarySchoolStudent psstudent = new PrimarySchoolStudent("Jimmy", 8, "Carol");
        System.out.println(student);  //if we run it while using the call from the commented toString method, we will not get the name and age of the student. Instead, we will get the class name followed by an @ and an address, known as hashcode
        System.out.println(psstudent);
    }
}

class Student {

    private String name;
    private int age;

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    //@Override
    //public String toString() {
    //    return super.toString();
    //}


    //we can return whatever we want, not necessarily the default option that Java provides
    @Override
    public String toString() {
        /* return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';  */
        return name + " is " + age + " years old";
    }
}

//we can even create subclasses here and use inheritance

class PrimarySchoolStudent extends Student {

    private String parentName;

    public PrimarySchoolStudent(String name, int age, String parentName) {
        super(name, age);
        this.parentName = parentName;
    }

    @Override
    public String toString() {
        return parentName + "'s child, " + super.toString();
    }
}
