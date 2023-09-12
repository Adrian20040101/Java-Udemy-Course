public class Main {
    public static void main(String[] args) {

        Printer printer1 = new Printer(78, false);
        System.out.println("Toner level after addition is " + printer1.addToner(22));
        System.out.println("Total pages printed = " + printer1.printPages(34));

        Printer printer2 = new Printer(111, true);
        System.out.println("Toner level after addition is " + printer2.addToner(23));
        System.out.println("Total pages printed = " + printer2.printPages(34));
    }
}
