package resources;

import java.util.Objects;

public class Play {

    private int songId;
    private double latitude;
    private String playDate;
    private int artistId;
    private double longitude;
    private String style;
    private String state;

    //Constructors
    Play (){
//
    }

    Play(int songId, double latitude, String playDate, int artistId, double longitude, String style){
        this.songId = songId;
        this.latitude = latitude;
        this.playDate = playDate;
        this.artistId = artistId;
        this.longitude = longitude;
        this.style = style;

    }

    //Setters and Getters
    public int getSongId() {
        return songId;
    }

    public void setSongId(int songId) {
        this.songId = songId;
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

    public int getArtistId() {
        return artistId;
    }

    public void setArtistId(int artistId) {
        this.artistId = artistId;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public String getStyle() {
        return style;
    }

    public void setStyle(String style) {
        this.style = style;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Play play = (Play) o;
        return songId == play.songId &&
                Double.compare(play.latitude, latitude) == 0 &&
                artistId == play.artistId &&
                Double.compare(play.longitude, longitude) == 0 &&
                Objects.equals(playDate, play.playDate) &&
                Objects.equals(style, play.style) &&
                Objects.equals(state, play.state);
    }

    @Override
    public int hashCode() {
        return Objects.hash(songId, latitude, playDate, artistId, longitude, style, state);
    }
}
