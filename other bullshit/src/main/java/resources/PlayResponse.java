package resources;

import java.util.List;

public class PlayResponse {

    private double totalRecordsCount;

    private List<Play> plays;

    //Constructors
    PlayResponse() {
    }

    PlayResponse(double totalRecordsCount, List<Play> plays) {
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

    public List<Play> getPlays() {
        return plays;
    }

    public void setPlays(List<Play> plays) {
        this.plays = plays;
    }
}
