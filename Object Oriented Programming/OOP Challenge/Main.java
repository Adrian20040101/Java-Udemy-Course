public class Main {
    public static void main(String[] args) {

        Account account = new Account();
        account.setCustomerName("John");
        account.setAccountBalance(200);
        account.setAccountNumber(420);
        account.setEmail("johnstones@gmail.com");
        account.setPhoneNumber("+3289671290");

        account.depositFunds(200.12);
        account.withdrawFunds(300.12);
    }
}
