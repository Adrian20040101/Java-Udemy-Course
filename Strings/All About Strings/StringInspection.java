public class StringInspection {
    public static void main(String[] args) {

        //These are called String Inspection Methods

        displayInformation("Hello World");
        emptyOrBlankStrings("");
        emptyOrBlankStrings("\t     \n");

    }

    public static void displayInformation(String string){
        int length = string.length();
        System.out.printf("The length of the given string is %d %n", length);
        System.out.printf("The first character in the given word is %c %n ", string.charAt(0));
        System.out.printf("The last character in the given word is %c %n ", string.charAt(length - 1));

        //we can also search for the position of a specific character or the beginning character of a word

        System.out.printf("The letter r can be found at position %d %n", string.indexOf('r'));
        System.out.printf("The word World can be found at position %d %n", string.indexOf("World"));

        //we can pass additional arguments to tell the compiler from which position onwards to search

        System.out.printf("The letter l can be found at position %d %n", string.indexOf('l'));
        System.out.printf("The last letter l can be found at position %d %n", string.lastIndexOf('l'));
        System.out.printf("The second l can be found at position %d %n", string.indexOf('l', 3));

    }

    public static void emptyOrBlankStrings(String string){
        //we can also add checks if string is empty or is blank
        //empty means that the string is ""
        //blank means there is no actual content in the string, but it can contain tabs, newlines etc.

        if (string.isEmpty()){ System.out.println("String is empty");
            return;}
        if (string.isBlank()) System.out.println("String is blank");
    }
}
