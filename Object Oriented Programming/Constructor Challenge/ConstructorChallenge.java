public class ConstructorChallenge {

    private String customerName;
    private int creditLimit;
    private String email;

    public String getCustomerName() {
        return customerName;
    }
    public int getCreditLimit() {
        return creditLimit;
    }
    public String getEmail() {
        return email;
    }

    //this is called constructor chaining. In this example, we covered a constructor chained 2 times using 'this' keyword
    public ConstructorChallenge(String customerName, int creditLimit, String email){
        this.customerName = customerName;
        this.creditLimit = creditLimit;
        this.email = email;
    }

    public ConstructorChallenge(){
        this("John", "johnstones@gmail.com");
    }

    public ConstructorChallenge(String customerName, String email){
        this(customerName, 100, email);
    }
}
