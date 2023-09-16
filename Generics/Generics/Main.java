package dev.lpa;

interface Player{
    String name();  //doesn't need implementation in the records, because name is implicitly implemented
}

record FootballPlayer(String name, String position, int age) implements Player{}

record BasketballPlayer(String name, String position, int age) implements Player{}

record BaseballPlayer(String name, String position, int age) implements Player{}

public class Main {
    public static void main(String[] args) {

        FootballTeam barcelona1 = new FootballTeam("Barcelona");
        FootballTeam realMadrid1 = new FootballTeam("Real Madrid");
        scoreResult(barcelona1, 2, realMadrid1, 1);

        SportsTeam barcelona2 = new SportsTeam("Barcelona");
        SportsTeam realMadrid2 = new SportsTeam("Real Madrid");
        scoreResult(barcelona2, 2, realMadrid2, 1);

        Team<FootballPlayer, Affiliation> barcelona = new Team<>("Barcelona");
        Team<FootballPlayer, Affiliation> realMadrid = new Team<>("Real Madrid");
        scoreResult(barcelona, 2, realMadrid, 1);

        var newPlayer1 = new FootballPlayer("Lionel Messi", "Right Winger",  36);
        barcelona.addTeamMember(newPlayer1);
        var newPlayer2 = new FootballPlayer("Cristiano Ronaldo", "Striker", 38);
        realMadrid.addTeamMember(newPlayer2);
        var newPlayer3 = new FootballPlayer("Neymar", "Left Winger", 30);
        barcelona.addTeamMember(newPlayer3);

        barcelona.listTeamRoster();
        realMadrid.listTeamRoster();

        //add some basketball players

        SportsTeam lakers1 = new SportsTeam("LA Lakers");
        Team<BasketballPlayer, Affiliation> lakers = new Team<>("LA Lakers");
        var leBron = new BasketballPlayer("LeBron James", "Point Forward", 40);
        lakers.addTeamMember(leBron);
        lakers.listTeamRoster();

        //the code above looks good, but there is a problem. What if we'd add a football player to LA. That shouldn't be allowed
        var ramos = new FootballPlayer("Sergio Ramos", "Centre Back", 37);
        //lakers.addTeamMember(ramos);  -> this line doesn't work anymore after adding a generic class, which is what we need
        lakers.listTeamRoster();  //we can see that, that works. Sergio Ramos is now an LA Lakers basketball player, which really shouldn't be allowed. For this, we create a generic class

        //let's add a team with affiliation

        var padresAffiliation = new Affiliation("San Diego", "CA", "USA");
        var padres = new Team<BaseballPlayer, Affiliation>("San Diego Padres", padresAffiliation);
        padres.addTeamMember(new BaseballPlayer("John Evans", "Central Midfielder", 26));
        padres.listTeamRoster();

        //we can also pass a String as the Affiliation

        var tigers = new Team<BaseballPlayer, String>("Detroit Tigers",
                "Detroit (MI) in USA");
        tigers.addTeamMember(new BaseballPlayer("Luis Morales", "Central Midfielder", 30));
        tigers.listTeamRoster();

    }

    public static void scoreResult(FootballTeam team1, int scoreTeam1, FootballTeam team2, int scoreTeam2){
        String message = team1.setScore(scoreTeam1, scoreTeam2);
        team2.setScore(scoreTeam2, scoreTeam1);
        System.out.printf("%s %s %s with a final score of %d:%d%n", team1, message, team2,
                scoreTeam1, scoreTeam2);
    }

    public static void scoreResult(SportsTeam team1, int scoreTeam1, SportsTeam team2, int scoreTeam2){
        String message = team1.setScore(scoreTeam1, scoreTeam2);
        team2.setScore(scoreTeam2, scoreTeam1);
        System.out.printf("%s %s %s with a final score of %d:%d%n", team1, message, team2,
                scoreTeam1, scoreTeam2);
    }

    public static void scoreResult(Team team1, int scoreTeam1, Team team2, int scoreTeam2){
        String message = team1.setScore(scoreTeam1, scoreTeam2);
        team2.setScore(scoreTeam2, scoreTeam1);
        System.out.printf("%s %s %s with a final score of %d:%d%n", team1, message, team2,
                scoreTeam1, scoreTeam2);
    }
}
