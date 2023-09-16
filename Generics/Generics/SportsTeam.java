package dev.lpa;

import java.util.ArrayList;
import java.util.List;

public class SportsTeam {

    private String teamName;
    private List<Player> teamMembers = new ArrayList<>();
    private int wins = 0;
    private int losses = 0;
    private int ties = 0;

    public SportsTeam(String teamName) {
        this.teamName = teamName;
    }

    public void addTeamMember(Player player){
        if (!teamMembers.contains(player)){
            teamMembers.add(player);
        } else {
            System.out.println("Player already in the team " + teamName);
        }
    }

    public void listTeamRoster(){
        if (teamMembers == null) System.out.println(teamName + " doesn't contain any players");
        else System.out.println(teamName + "'s Roster: ");
    }

    public String setScore(int ourScore, int theirScore){
        String message = "lost to";
        if (ourScore > theirScore){
            wins++;
            message = "won against";
        } else if (ourScore < theirScore){
            losses++;
        } else {
            ties++;
            message = "tied with";
        }
        return message;
    }

    @Override
    public String toString() {
        return teamName;
    }
}
