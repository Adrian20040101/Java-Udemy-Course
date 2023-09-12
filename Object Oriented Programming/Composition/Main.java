public class Main {
    public static void main(String[] args) {

        Monitor monitor = new Monitor("2080", "Dell", 25, "2400x1580");
        Motherboard motherboard = new Motherboard("BJ-230", "Asus", 4, 8, "v2.56");
        ComputerCase computerCase = new ComputerCase("195", "Acer", "240");
        PersonalComputer pc = new PersonalComputer("2080", "Dell", computerCase, motherboard, monitor);

        //we cannot call these methods without having getters
//        pc.getMonitor().drawPixelAt(10, 20, "green");
//        System.out.println();
//        pc.getMotherboard().loadProgram("Windows OS");
//        System.out.println();
//        pc.getComputerCase().pressPowerButton();
//        System.out.println();

        //but we can make the PC do something, without having to know that each individual part of the PC exists. That is the advantage of composition

        pc.powerUp();

    }
}
