package controllers.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;
import resources.*;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class MusicService {
    private String url = "https://conuhacks-playback-api.touchtunes.com/plays?";
    private String api = "9923ac9b-8fd3-421f-b0e5-952f807c6885";
    private String urlToGetSongTitle = "https://conuhacks-playback-api.touchtunes.com/song/";

    public Map<Song, PlayPopularity> getPlays(double lat, double lng) {
        try {


            Map<String, String> parameters = new HashMap<>();
            String start = ZonedDateTime.now(ZoneOffset.UTC).minusDays(30 + 14).format(DateTimeFormatter.ISO_INSTANT);

            String end = ZonedDateTime.now(ZoneOffset.UTC).minusDays(30).format(DateTimeFormatter.ISO_INSTANT);
            parameters.put("startDate", start);
            parameters.put("endDate", end);

            URL url = new URL(this.url + ParameterStringBuilder.getParamsString(parameters) + "&limit=5000");
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");
            con.setRequestProperty("client-secret", api);
            con.setDoOutput(false);

            int status = con.getResponseCode();

            if (status == 500 || status == 405) {
                return null;
            }

            BufferedReader in = new BufferedReader(
                    new InputStreamReader(con.getInputStream()));
            String inputLine;
            StringBuffer content = new StringBuffer();
            while ((inputLine = in.readLine()) != null) {
                content.append(inputLine);
            }
            in.close();

            ObjectMapper mapper = new ObjectMapper();
            PlayResponse map = mapper.readValue(content.toString(), PlayResponse.class);

            con.disconnect();


        } catch (Exception e) {
            System.out.println(e);
        }

        return null;

    }


    private String getSongTitleFrom(int songID) {
        String songTitle = "";
        String completeURL = urlToGetSongTitle + String.valueOf(songID);

        try {

            URL url = new URL(completeURL);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");
            con.setRequestProperty("client-secret", api);
            con.setDoOutput(false);

            int status = con.getResponseCode();

            if (status == 500 || status == 405) {
                return null;
            }

            BufferedReader in = new BufferedReader(
                    new InputStreamReader(con.getInputStream()));
            String inputLine;
            StringBuffer content = new StringBuffer();
            while ((inputLine = in.readLine()) != null) {
                content.append(inputLine);
            }
            in.close();

            ObjectMapper mapper = new ObjectMapper();
            Song currentSong = mapper.readValue(content.toString(), Song.class);

            con.disconnect();

            songTitle = currentSong.getSongTitle();
        } catch (Exception e) {
            System.out.println(e);
        }


        return songTitle;
    }

    //Response contains plays
    private Map<Play, PlayPopularity> getStats(PlayResponse response, double lat, double lng, String[] genres) {
        //Creates new Hash Map
        Map<Play, PlayPopularity> map = new HashMap<Play, PlayPopularity>();

        int maxDistanceInKM = 100;

        for (Play play : response.getPlays()) {

            //Not the genre we looking for
            if (!Arrays.asList(genres).contains(play.getStyle())) continue;
            if (calculateDistance(lat, lng, play.getLatitude(), play.getLongitude()) > maxDistanceInKM) continue;

            //Song already added
            if (map.containsKey(play.getSongId())) {

                //holds the array
                PlayPopularity pp = map.get(play.getSongId());
                int[] changePopularityAtDay = pp.getPopularity();
                int indexForDay = getIndexInArrayAtDate(play.getPlayDate());
                int days = pp.getNumberOfPlays();

                //Increments
                changePopularityAtDay[indexForDay]++;
                pp.setNumberOfPlays(days++);
            }

            //Song is not added yet to the map
            else {
                //Array for PlayPopularity
                int[] popularityPerDay = new int[14];
                int indexDayPlayed = getIndexInArrayAtDate(play.getPlayDate());
                popularityPerDay[indexDayPlayed] = 1;
                map.put(play, new PlayPopularity(1, popularityPerDay));
            }
        }

        return map;
    }


    //Returns the correct HashMap
    public Map<Song, PlayPopularity> returnMapWithSongs(Map<Play, PlayPopularity> map) {
        Map<Song, PlayPopularity> resultingMap = new HashMap<Song, PlayPopularity>();

        for (Map.Entry<Play, PlayPopularity> entry : map.entrySet()) {
            Play key = entry.getKey();
            PlayPopularity pp = entry.getValue();

            resultingMap.put(new Song(key.getSongId(), getSongTitleFrom(key.getSongId())), pp);

        }

        return resultingMap;
    }


    //Returns the index which represents a day in the array
    private int getIndexInArrayAtDate(String Date) {

        int yearPlayedInInt = Integer.parseInt(Date.substring(0,3));
        int monthPlayedInInt = Integer.parseInt(Date.substring(5,6));
        int dayPlayedInInt = Integer.parseInt(Date.substring(7, 8));
        int currentDayInInt = Integer.parseInt(ZonedDateTime.now(ZoneOffset.UTC).format(DateTimeFormatter.ISO_INSTANT).substring(7, 8));
        int currentMonthInInt = Integer.parseInt(ZonedDateTime.now(ZoneOffset.UTC).format(DateTimeFormatter.ISO_INSTANT).substring(5, 6));
        int currentYearInInt = Integer.parseInt(ZonedDateTime.now(ZoneOffset.UTC).format(DateTimeFormatter.ISO_INSTANT).substring(0, 3));
        int difference = currentDayInInt - dayPlayedInInt;


            LocalDate d1 = LocalDate.of(yearPlayedInInt, monthPlayedInInt, dayPlayedInInt);
            LocalDate d2 = LocalDate.of(currentYearInInt, currentMonthInInt, currentDayInInt);

            difference = (int) ChronoUnit.DAYS.between(d1, d2);

        return difference;


    }


    private int calculateDistance(double lat1, double lng1, double lat2, double lng2) {

        double diffLat = Math.toRadians(lat2 - lat1);
        double diffLng = Math.toRadians(lng2 - lng1);
        double earth = 6371;
        double a = Math.sin(diffLat / 2) * Math.sin(diffLat / 2) + Math.cos(Math.toRadians(lat2)) * Math.cos(Math.toRadians(lat1)) * Math.sin(diffLng / 2) * Math.sin(diffLng / 2);
        double c = 2 * Math.asin(Math.sqrt(a));
        double res = earth * c;
        return (int) res;
    }

}


