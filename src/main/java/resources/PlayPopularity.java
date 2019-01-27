package resources;

public class PlayPopularity {
    int numberOfPlays;
    int[] popularity;

    public PlayPopularity() {
    }

    public PlayPopularity(int numberOfPlays, int[] popularity) {
        this.numberOfPlays = numberOfPlays;
        this.popularity = popularity;
    }

    public int getNumberOfPlays() {
        return numberOfPlays;
    }

    public void setNumberOfPlays(int numberOfPlays) {
        this.numberOfPlays = numberOfPlays;
    }

    public int[] getPopularity() {
        return popularity;
    }

    public void setPopularity(int[] popularity) {
        this.popularity = popularity;
    }
}
