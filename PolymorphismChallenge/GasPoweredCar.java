public class GasPoweredCar extends Car{

    private double avgKmPerLitre;
    private int cylinders;

    public GasPoweredCar(String description, double avgKmPerLitre, int cylinders) {
        super(description);
        this.avgKmPerLitre = avgKmPerLitre;
        this.cylinders = cylinders;
    }

    public GasPoweredCar(double avgKmPerLitre, int cylinders){
        this.avgKmPerLitre = avgKmPerLitre;
        this.cylinders = cylinders;
    }

    @Override
    public void startEngine() {
        super.startEngine();
        System.out.println("V12 sounds amazing!");
    }

    @Override
    public void drive() {
        super.drive();
        System.out.println("Driving gas powered cars is more fun");
    }

    @Override
    protected void runEngine() {
        super.runEngine();
        System.out.println("Powerful engines are found in gas powered cars");
    }

    public void refuel(){
        System.out.println("Refueling... I wish the gas prices were lower");
    }
}
