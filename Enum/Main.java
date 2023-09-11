package dev.lpa;

import java.util.Random;

public class Main {
    public static void main(String[] args) {

        DayOfTheWeek weekDay = DayOfTheWeek.TUESDAY; //assigns the value TUESDAY to weekday
        System.out.println(weekDay);

        System.out.printf("Name is %s, Ordinal Value is %d%n", weekDay.name(), weekDay.ordinal());

        for(int i = 0; i < 10; i++){
            weekDay = getRandomDay();
//            System.out.println(weekDay);
//            if (weekDay == DayOfTheWeek.FRIDAY){
//                System.out.println("Yay, it is Friday");
//            }
            switchDayOfTheWeek(weekDay);
        }

        for (Topping topping : Topping.values()){
            System.out.println(topping.name() + " is going to add an extra $" + topping.getPrice()
                    + " to your total");
        }
    }

    public static DayOfTheWeek getRandomDay(){
        int weekDay = new Random().nextInt(7);  //directly assigning a random value 0-6 to weekDay
        var allDays = DayOfTheWeek.values();

        return allDays[weekDay];
    }

    public static void switchDayOfTheWeek(DayOfTheWeek weekDay){
        switch(weekDay){
            case MONDAY -> System.out.println("It is Monday");
            case TUESDAY -> System.out.println("It is Tuesday");
            default -> System.out.println("It is " + weekDay.name().charAt(0) +
                    weekDay.name().substring(1).toLowerCase()); //this default case covers all other weekdays
        }
    }
}
