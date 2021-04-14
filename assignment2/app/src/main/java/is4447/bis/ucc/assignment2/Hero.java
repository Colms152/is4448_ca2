package is4447.bis.ucc.assignment2;

public class Hero {
    private String id;
    private String name;
    private String realname;
    private String rating;
    private String teamaffiliation;

    public Hero(String ID, String Name, String Realname, String Rating, String Teamaffiliation) {
        id = ID;
        name = Name;
        realname = Realname;
        rating = Rating;
        teamaffiliation = Teamaffiliation;

    }

    @Override
    public String toString() {
        return "Hero{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", realname='" + realname + '\'' +
                ", rating='" + rating + '\'' +
                ", teamaffiliation='" + teamaffiliation + '\'' +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRealname() {
        return realname;
    }

    public void setRealname(String realname) {
        this.realname = realname;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getTeamaffiliation() {
        return teamaffiliation;
    }

    public void setTeamaffiliation(String teamaffiliation) {
        this.teamaffiliation = teamaffiliation;
    }
}
