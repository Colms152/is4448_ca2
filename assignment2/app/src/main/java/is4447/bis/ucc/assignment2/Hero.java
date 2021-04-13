package is4447.bis.ucc.assignment2;

/**
 * Created by Michael Gleeson on 18/02/2021
 * Copyright (c) 2021 | gleeson.io
 */
public class Hero {
    private String ID, Name, RealName, Rating, Team;

    public Hero() {
    }

    public Hero(String ID, String name, String realname, String rating, String team) {
        this.ID = ID;
        Name = name;
        RealName = realname;
        Rating = rating;
        Team = team;

    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getRealName() { return RealName; }

    public void setRealName(String realname) {
        RealName = realname;
    }

    public String getRating() {
        return Rating;
    }

    public void setRating(String rating) {Rating = rating;}

    public String getTeam() {
        return Team;
    }

    public void setTeam(String team) {
        Team = team;
    }

    @Override
    public String toString() {
        return "id: " + ID + "\n" +
                "name: " + Name + "\n" +
                "realname:" + RealName + "\n" +
                "rating: " + Rating + "\n" +
                "teamaffiliation: " + Team;
    }
}
