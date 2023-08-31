import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        //these method calls perfectly sum up the benefits of polymorphism
        //we don't need to create a specific subclass variable, we just need to create an object from the subclass, and Java will determine at runtime which method it should execute

        Movie movie1 = new Movie("Oppenheimer");
        movie1.watchMovie();
        Movie movie2 = new Adventure("Rise of Rome");
        movie2.watchMovie();
        Movie movie3 = new Comedy("Barbie");
        movie3.watchMovie();
        Movie movie4 = new ScienceFiction("Toy Story");
        movie4.watchMovie();

        //here is another way to create objects of different class types, by calling the getMovie method

        Movie movie5 = Movie.getMovie("Science", "Star Wars");
        movie5.watchMovie();

        //yet another way of visualizing the effect of polymorphism is by prompting the user to type in the data, and then based on the input let Java decide which methods it should call and what should be printed
        Scanner s = new Scanner(System.in);
        while (true){
            System.out.print("Enter the movie type (A for Adventure, C for comedy, S for" +
                    "Science Fiction or Q to quit): ");
            String type = s.nextLine();
            if ("Qq".contains(type)) break;
            System.out.print("Enter the movie title: ");
            String title = s.nextLine();
            Movie movie = Movie.getMovie(type, title);
            movie.watchMovie();
        }
    }
}
