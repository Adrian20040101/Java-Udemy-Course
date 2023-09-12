public class Main {
    public static void main(String[] args) {

        Car car = Car.getCarType("Hybrid");
        car.drive();
        System.out.println(car.getClass().getSimpleName());
        //car.refuelAndRecharge()   -> even though car is of type HybridCar, the method specific for HybridCar is still not callable; casting solves this issue as seen in the lines below
        HybridCar hybridCar = (HybridCar) car;
        hybridCar.refuelAndRecharge();

        var unknown = Car.getCarType("Electric");
        unknown.runEngine();
        System.out.println(unknown.getClass().getSimpleName());
        //unknown.recharge()   -> even though unknown is of type ElectricCar, the method specific for ElectricCar is still not callable; casting solves this issue as seen in the lines below
        ElectricCar electricCar = (ElectricCar) unknown;
        electricCar.recharge();

        Object something = Car.getCarType("GasPowered");
        if (something.getClass().getSimpleName().equals("GasPoweredCar")){
            GasPoweredCar gasPoweredCar = (GasPoweredCar) something;
            gasPoweredCar.startEngine();
            System.out.println(gasPoweredCar.getClass().getSimpleName());
            //gasPoweredCar.recharge   -> we cannot call recharge on this object because recharge can only be called on objects of type ElectricCar
            gasPoweredCar.refuel();  //this is allowed
        }
    }
}
