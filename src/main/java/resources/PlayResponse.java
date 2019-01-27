package resources;

public class PlayResponse {

    private double totalRecordsCount;

    private Play plays;

    //Constructors
    PlayResponse() {
    }

    PlayResponse(double totalRecordsCount, Play plays) {
        this.totalRecordsCount = totalRecordsCount;
        this.plays = plays;
    }


    //Setters and Getters
    public double getTotalRecordsCount() {
        return totalRecordsCount;
    }

    public void setTotalRecordsCount(double totalRecordsCount) {
        this.totalRecordsCount = totalRecordsCount;
    }

    public Play getPlays() {
        return plays;
    }

    public void setPlays(Play plays) {
        this.plays = plays;
    }
}
