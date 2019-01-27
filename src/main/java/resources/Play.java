package resources;

public class Play {

    private int songID;
    private double latitude;
    private String playDate;
    private int artistID;
    private double longtitude;
    private String style;

    //Constructors
    Play (){
//
    }

    Play(int songID, double latitude, String playDate, int artistID, double longtitude, String style){
        this.songID = songID;
        this.latitude = latitude;
        this.playDate = playDate;
        this.artistID = artistID;
        this.longtitude = longtitude;
        this.style = style;

    }

    //Setters and Getters
    public int getSongID() {
        return songID;
    }

    public void setSongID(int songID) {
        this.songID = songID;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public String getPlayDate() {
        return playDate;
    }

    public void setPlayDate(String playDate) {
        this.playDate = playDate;
    }

    public int getArtistID() {
        return artistID;
    }

    public void setArtistID(int artistID) {
        this.artistID = artistID;
    }

    public double getLongtitude() {
        return longtitude;
    }

    public void setLongtitude(double longtitude) {
        this.longtitude = longtitude;
    }

    public String getStyle() {
        return style;
    }

    public void setStyle(String style) {
        this.style = style;
    }
}
