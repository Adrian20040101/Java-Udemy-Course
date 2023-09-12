public class Worker {
    protected String name;
    private String birthDate;
    private String endDate;

    public Worker(String name, String birthDate, String endDate) {
        this.name = name;
        this.birthDate = birthDate;
        this.endDate = endDate;
    }

    public int getAge(){
        return 2023 - Integer.parseInt(birthDate.substring(6));
    }

    public double collectPay(){
        return 0.0;
    }

    public void terminate(String endDate){
        System.out.println(name + " has terminated the contract on " + endDate);
        this.endDate = endDate;
    }
}
