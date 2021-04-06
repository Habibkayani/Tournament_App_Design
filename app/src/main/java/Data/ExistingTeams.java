package Data;

public class ExistingTeams {


    private String title, image;
    private String id, rating;
    int  member;

    public ExistingTeams() {
    }

    public ExistingTeams(String title, String image, String id, String rating, int member) {
        this.title = title;
        this.image = image;
        this.id = id;
        this.rating = rating;
        this.member = member;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public int getMember() {
        return member;
    }

    public void setMember(int member) {
        this.member = member;
    }
}