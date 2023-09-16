package dev.lpa;

import java.util.ArrayList;
import java.util.List;

record Affiliation(String name, String type, String countryCode){
    @Override
    public String toString() {
        return name + " (" + type + ")" + " in " + countryCode;
    }
}

//public class Team<T>{} -> standard declaration of a generic class is a single capital letter, often T, placed in angle brackets
public class Team <T extends Player, S>{    //this declaration uses an upper bound to hinder the use of types like String, Integer etc. and restrict the types to just Player and its subclasses
    //we also add and S for affiliation, which represents the city or country that these teams are from
    private String teamName;
    private List<T> teamMembers = new ArrayList<>();
    private int wins = 0;
    private int losses = 0;
    private int ties = 0;
    S affiliation;

    public Team(String teamName) {
        this.teamName = teamName;
    }

    public Team(String teamName, S affiliation) {
        this.teamName = teamName;
        this.affiliation = affiliation;
    }

    public void addTeamMember(T t){
        if (!teamMembers.contains(t)){
            teamMembers.add(t);
        } else {
            System.out.println("Player already in the team " + teamName);
        }
    }

    public void listTeamRoster(){
        if (teamMembers == null) System.out.println(teamName + " doesn't contain anything   ");
        else {
            System.out.println();
            System.out.print(teamName + "'s Roster: ");
            System.out.println(affiliation == null ? "" : " Affiliation : " + affiliation);
            for (T t : teamMembers){
                System.out.println(t.name());  //if we weren't using T extends Player as type, we wouldn't have been able to access t.name(), because it would have been too generic
            }
        }
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
