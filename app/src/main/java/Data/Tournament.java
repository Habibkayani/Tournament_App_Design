package Data;

public class Tournament {


    private String name;
    private String date;
    private int price;
    private String title;

    private String imagelist;

    public Tournament() {
    }

    public Tournament(String name, String date, int price, String title, String imagelist) {
        this.name = name;
        this.date = date;
        this.price = price;
        this.title = title;
        this.imagelist = imagelist;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImagelist() {
        return imagelist;
    }

    public void setImagelist(String imagelist) {
        this.imagelist = imagelist;
    }
}