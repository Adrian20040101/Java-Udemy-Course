public class StringComparison {
    public static void main(String[] args) {

        String string = "Hello World";
        String stringLower = string.toLowerCase();
        if (string.equals(stringLower)) System.out.println("Values match exactly");
        if (string.equalsIgnoreCase(stringLower)) System.out.println("Values match ignoring case");
        if (string.startsWith("Hello")) System.out.println("String starts with Hello");
        if (string.endsWith("World")) System.out.println("String ends with World");
        if (string.contains("Hello")) System.out.println("String contains Hello");
        if (string.contentEquals("Hello World")) System.out.println("Values match exactly");
    }
}
