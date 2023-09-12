public class Hello {
    public static void main(String[] args) {
        System.out.println("Hello, Tim!");  //we use 'println' in this statement so that it displays this message on a single line and anything else on separate lines
        System.out.print("Hello, World!");

        boolean isAlien = false;
        if (isAlien == false) {   //expression can be simplified to !isAlien, but for now we let it as it is to enhance readability
            System.out.println("It is not an alien");
            System.out.println("It is a human");
        }else{
            System.out.println("It is an alien");
            System.out.println("It is from Mars");
        }

        int topScore = 100;
        int myScore = 80;

        if (myScore > 0 && myScore < topScore){   //doesn't have much sense to compare variables like that since in this example they have fixed values, but this is just for demonstration purposes on how logical AND operator works in if statements
            System.out.println("That is a valid score");
        }else{
            System.out.println("That is not a valid score");
        }

        if (myScore < 0 || myScore > topScore){   //this is pretty much the same as the code above, but it's written in a way in which it uses logical OR operator instead of the logical AND operator
            System.out.println("That is not a valid score");
        }else{
            System.out.println("That is a valid score");
        }

        //ternary operator
        String makeOfCar = "Audi";
        boolean isGerman = makeOfCar == "Bentley" ? true : false;
        if (isGerman){   //this expression is the simplified form of the expression if (isGerman == true)
            System.out.println("You own a german car");
        }else{
            System.out.println("You don't own a german car");
        }

        //or you can directly print messages using the ternary operator
        String s = isGerman ? "This is an Audi" : "This is not an Audi";
        System.out.println(s);

    }
}
