public class ElectricCar extends Car{

    private double avgKmPerCharge;
    private int batterySize;

    public ElectricCar(String description, double avgKmPerCharge, int batterySize) {
        super(description);
        this.avgKmPerCharge = avgKmPerCharge;
        this.batterySize = batterySize;
    }

    public ElectricCar(double avgKmPerCharge, int batterySize) {
        this.avgKmPerCharge = avgKmPerCharge;
        this.batterySize = batterySize;
    }

    public void startEngine() {
        super.startEngine();
        System.out.println("Did it actually start? I barely heard anything");
    }

    @Override
    public void drive() {
        super.drive();
        System.out.println("Driving... Hopefully I don't fall asleep");
    }

    @Override
    protected void runEngine() {
        super.runEngine();
        System.out.println("*Cricket Noises*");
    }

    public void recharge(){
        System.out.println("Recharging... I wish the battery would last longer");
    }
}
