public class SalariedEmployee extends Employee{

    private double annualSalary;
    private boolean isRetired;

    public SalariedEmployee(String name, String birthDate, String endDate, long employeeId,
                            String hireDate, double annualSalary, boolean isRetired) {
        super(name, birthDate, endDate, employeeId, hireDate);
        this.annualSalary = annualSalary;
        this.isRetired = isRetired;
    }

    @Override
    public double collectPay(){
        if (isRetired)
            return (int) (0.8 * (annualSalary / 26));
        return (int) annualSalary / 26; //say they're getting paid once every 2 weeks
    }

    public void retire(){
        terminate("29/08/2023");
        System.out.println("Therefore, " + name + " has retired");
        isRetired = true;
    }
}
