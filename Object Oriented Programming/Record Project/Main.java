public class Main {
    public static void main(String[] args) {

        for (int i = 1; i <= 5; i++){
            Student student = new Student ("9DMN12STUD" + i,
                    switch(i) {
                        case 1 -> "John";
                        case 2 -> "Lily";
                        case 3 -> "Arnold";
                        case 4 -> "Jack";
                        case 5 -> "Mary";
                        default -> "Anonymous";
                    },
                    switch(i){
                        case 1 -> "10/05/2000";
                        case 2 -> "23/02/2003";
                        case 3 -> "20/10/2004";
                        case 4 -> "12/06/1999";
                        case 5 -> "30/12/2002";
                        default -> "not specified";
                    },
                    "Java Programming Masterclass");
            System.out.println(student);
        }
        Student pojoStudent = new Student("9DMN12STUD6", "Taylor", "13/11/2001",
                "Java Programming Masterclass");
        LPAStudent recordStudent = new LPAStudent("9DMN12STUD7", "Tyler", "11/12/2000",
                "Java Programming Masterclass");
        System.out.println(pojoStudent);
        System.out.println(recordStudent);

        //if we try to print some attributes, we need to use getters, and that's where we see some syntax differences
        System.out.println(pojoStudent.getName() + " is taking the course " + pojoStudent.getClassList());
        System.out.println(recordStudent.name() + " is taking the course " + recordStudent.classList());

        //setters only work with POJO classes, since records are designed to be immutable
        pojoStudent.setClassList("C++ Programming Masterclass"); //compiles fine
        //recordStudent.setClassList("C++ Programming Masterclass"); //raises an error

        System.out.println(pojoStudent.getName() + " is taking the course " + pojoStudent.getClassList());
    }
}
