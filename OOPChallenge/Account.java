public class Account {

    private int accountNumber;
    private double accountBalance;
    private String customerName;
    private String email;
    private String phoneNumber;

    public int getAccountNumber() {
        return accountNumber;
    }

    public double getAccountBalance() {
        return accountBalance;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public void setAccountBalance(double accountBalance) {
        this.accountBalance = accountBalance;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void depositFunds(double amount){
        if (amount < 0){
            System.out.println("You can't deposit a negative amount");
        } else if (amount == 0){
            System.out.println("There is nothing to deposit");
        } else {
            accountBalance += amount;
            System.out.println("Deposit completed successfully");
        }
        System.out.println("Updated account balance: " + accountBalance + "$");
    }

    public void withdrawFunds(double amount){
        if (amount < 0){
            System.out.println("You can't withdraw a negative amount");
        } else if (amount == 0) {
            System.out.println("There is nothing to withdraw");
        } else if (amount > accountBalance){
            System.out.println("Not enough funds to complete the transaction");
        } else {
            accountBalance -= amount;
            System.out.println("Withdrawal completed successfully");
        }
        System.out.println("Updated account balance: " + accountBalance + "$");
    }
}
