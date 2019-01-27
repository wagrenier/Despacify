package resources;

public class Artist {

    private int artistID;
    private String artistTitle;

    //Constructors
    Artist(){
    }

    Artist(int artistID, String artistTitle){
        this.artistID = artistID;
        this.artistTitle = artistTitle;
    }

    //Setters and Getters
    public int getArtistID() {
        return artistID;
    }

    public void setArtistID(int artistID) {
        this.artistID = artistID;
    }

    public String getArtistTitle() {
        return artistTitle;
    }

    public void setArtistTitle(String artistTitle) {
        this.artistTitle = artistTitle;
    }
}
