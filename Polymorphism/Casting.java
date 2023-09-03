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
    }
}
