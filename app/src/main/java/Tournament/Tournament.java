package Tournament;

public class Tournament {


    private String tournamentname;
    private String date;
    private int price;
    private int imagelist;

    public int getImagelist() {
        return imagelist;
    }

    public void setImagelist(int imagelist) {
        this.imagelist = imagelist;
    }

    public Tournament() {
    }

    public Tournament(String tournamentname, String date,int price) {
        this.tournamentname = tournamentname;
        this.date = date;
        this.price = price;
    }

    public String getTournamentname() {
        return tournamentname;
    }

    public void setTournamentname(String tournamentname) {
        this.tournamentname = tournamentname;
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
}
