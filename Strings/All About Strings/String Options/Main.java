//the main differnece between string and stringbuilder is that
//with string wee need to assign the manipulation to a variable, whereas
//with stringbuilder we don't have to do that => stringbuilder is really a self-reference
//string methods and their use are derived from their name so no need for further explanation

public class Main {
    public static void main(String[] args) {
        String helloWorld = "Hello" + " World";
        helloWorld.concat(" and goodbye"); //this will not work because we didn't assign it to any variable

        StringBuilder helloWorldBuilder = new StringBuilder("Hello" + " World");
        helloWorldBuilder.append(" and goodbye");

        printInformation(helloWorld);
        printInformation(helloWorldBuilder);

        StringBuilder emptyStart = new StringBuilder();
        emptyStart.append("a".repeat(57));
        StringBuilder emptyStart32 = new StringBuilder(32);
        emptyStart32.append("a".repeat(17));

        printInformation(emptyStart);
        printInformation(emptyStart32);

        StringBuilder builderPlus = new StringBuilder("Hello" + " World");
        builderPlus.append(" and goodbye");

        builderPlus.deleteCharAt(16).insert(16, 'G');
        System.out.println(builderPlus);

        builderPlus.replace(16, 17, "g");
        System.out.println(builderPlus);

        builderPlus.reverse().setLength(7); //reverses the string and truncates the string to contain only the first 7 characters (in this example goodbye spelled backwards)
        System.out.println(builderPlus);
    }

    public static void printInformation(String string){
        System.out.println("String = " + string);
        System.out.println("Length = " + string.length());
    }

    public static void printInformation(StringBuilder builder){
        System.out.println("StringBuilder = " + builder);
        System.out.println("Length = " + builder.length());
        System.out.println("Capacity = " + builder.capacity());  //capacity is determined by JVM and it is dynamic(it changes based on how large the string is)
    }
}
