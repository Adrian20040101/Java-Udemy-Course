//here we are implementing a record. It is also called "plain data carrier". It reduces boilerplate code
//that appears in POJOs and is more restrictive
//the record contains data, that is not meant to be altered (it seeks to achieve immutability)
//therefore, it doesn't contain any setters and getters are accessed using 'object.attribute'
//records only contain fundamental methods, such as constructors and accessors (only getters in this case)
//it is recommended to use records when working with code that is not meant to be modified, like databases
//it doesn't require the programmer to write any code

public record LPAStudent(String id, String name, String dateOfBirth, String classList) {
}
