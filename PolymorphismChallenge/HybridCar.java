public class HybridCar extends Car{

    private double avgKmPerLitre;
    private int batterySize;
    private int cylinders;

    public HybridCar(String description, double avgKmPerLitre, int batterySize, int cylinders) {
        super(description);
        this.avgKmPerLitre = avgKmPerLitre;
        this.batterySize = batterySize;
        this.cylinders = cylinders;
    }

    public HybridCar(double avgKmPerLitre, int batterySize, int cylinders) {
        this.avgKmPerLitre = avgKmPerLitre;
        this.batterySize = batterySize;
        this.cylinders = cylinders;
    }

    public void startEngine() {
        super.startEngine();
        System.out.println("Starting engine on hybrid car");
    }

    @Override
    public void drive() {
        super.drive();
        System.out.println("Acceleration is unreal when running on electricity in this hybrid car");
    }

    @Override
    protected void runEngine() {
        super.runEngine();
        System.out.println("Why not get the best of both worlds?");
    }

    public void refuelAndRecharge(){
        System.out.println("Refueling and recharging...");
    }
}
