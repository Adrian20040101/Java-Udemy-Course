public class Main {
    public static void main(String[] args) {

        //testing multiple constructors declarations
        ConstructorChallenge object1 = new ConstructorChallenge("Jonas", 1090, "jonas@gmail.com");
        System.out.println("Name = " + object1.getCustomerName() +
                " Credit Limit = " + object1.getCreditLimit() + " Email Address = " + object1.getEmail());

        ConstructorChallenge object2 = new ConstructorChallenge();
        System.out.println("Name = " + object2.getCustomerName() +
                " Credit Limit = " + object2.getCreditLimit() + " Email Address = " + object2.getEmail());

        ConstructorChallenge object3 = new ConstructorChallenge("Adi", "adita@gmail.com");
        System.out.println("Name = " + object3.getCustomerName() +
                " Credit Limit = " + object3.getCreditLimit() + " Email Address = " + object3.getEmail());
    }
}
