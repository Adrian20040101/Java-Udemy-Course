public class Main {
    public static void main(String[] args) {

        SalariedEmployee semployee = new SalariedEmployee("John", "12/02/2000",
                "13/12/2021", 8338720, "2019", 20000, false);
        System.out.println(semployee.name + " is " + semployee.getAge());
        System.out.println(semployee.name + "'s paycheck = " + semployee.collectPay() + "$ every two weeks");
        semployee.retire();
        System.out.println(semployee.name + "'s pension paycheck = " + semployee.collectPay() + "$ every two weeks");

        System.out.println("---------------------------");

        HourlyEmployee hemployee = new HourlyEmployee("Joe", "23/03/1985",
                "11/10/2002", 8338723, "1999", 6.43);
        System.out.println(hemployee.name + " is " + hemployee.getAge());
        System.out.println(hemployee.name + "'s paycheck = " + hemployee.collectPay() + "$ per day");
        System.out.println(hemployee.name + " has worked overtime resulting in " + hemployee.getDoublePay() + "$ extra");
    }
}
