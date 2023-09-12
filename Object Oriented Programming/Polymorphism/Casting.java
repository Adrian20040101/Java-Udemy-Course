public class Casting {
    public static void main(String[] args) {
        Movie movie = Movie.getMovie("A", "Jaws");
        movie.watchMovie();

        //Adventure jaws = Movie.getMovie("A", "Jaws");   ->this won't compile, we need casting
        Adventure jaws = (Adventure) Movie.getMovie("A", "Jaws");
        jaws.watchMovie();

        Object comedy = Movie.getMovie("C", "Barbie");
        //comedy.watchMovie();   ->this won't compile, because the method is declared in the Movie class
        Comedy comedyMovie = (Comedy) comedy;
        comedyMovie.watchMovie();

        //we can declare variables and let Java determine their type at runtime using 'var' keyword
        var barbie = Movie.getMovie("C", "Barbie");
        barbie.watchMovie();

        //we can also create objects using var -> this is called Local Variable Type Inference (LVTI)
        var plane = new ScienceFiction("Plane");
        plane.watchMovie();

        //we can also test the type of the object created at runtime. Helps to better visualise which method and from which class the method should be executed
        Object unknown = Movie.getMovie("A", "John Wick");
        if (unknown.getClass().getSimpleName().equals("Adventure")){ //could have also used '==' to compare the two
            Adventure adventure = (Adventure) unknown;
            adventure.watchMovie();
        } else if (unknown instanceof Adventure){  //the instanceof operator lets us test the type of an object or an instance
            ((Adventure) unknown).watchMovie();
        } else if (unknown instanceof ScienceFiction scifi){  //if Java can identify that the object matches the type, it can extract data without having to cast. The object can be assigned to a binding variable and this variable is already typed as ScienceFiction variable
            scifi.watchMovie();
        }
    }
}
