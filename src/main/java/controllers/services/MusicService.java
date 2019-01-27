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
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class MusicService {
    private String url = "https://conuhacks-playback-api.touchtunes.com/plays?";
    private String api = "9923ac9b-8fd3-421f-b0e5-952f807c6885";

    public Map<Song, PlayPopularity> getPlays(double lat, double lng, String[] genres) {
        try {


            Map<String, String> parameters = new HashMap<>();
            String start = ZonedDateTime.now(ZoneOffset.UTC).minusDays(30+14).format(DateTimeFormatter.ISO_INSTANT);

            String end = ZonedDateTime.now(ZoneOffset.UTC).minusDays(30).format(DateTimeFormatter.ISO_INSTANT);
            parameters.put("startDate", start);
            parameters.put("endDate", end);

            URL url = new URL(this.url + ParameterStringBuilder.getParamsString(parameters)+"&limit=5000");
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");
            con.setRequestProperty("client-secret", api);
            con.setDoOutput(false);

            int status = con.getResponseCode();

            if (status == 500 || status == 405 ) {
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

    private Map<Song, PlayPopularity> getStats(PlayResponse response, double lat, double lng, String[] genres) {
        //Creates new Hash Map
        Map<Song, PlayPopularity> map = new HashMap<Song, PlayPopularity>();

        for(Play play: response.getPlays()){

            if(Arrays.asList(genres).contains(play.getStyle())) continue;



        }

        return;
    }

    private int calculateDistance(double lat1, double lng1, double lat2, double lng2){

        double diffLat = Math.toRadians(lat2-lat1);
        double diffLng = Math.toRadians(lng2-lng1);
        double earth = 6371;
        double a = Math.sin(diffLat/2)*Math.sin(diffLat/2)+Math.cos(Math.toRadians(lat2))*Math.cos(Math.toRadians(lat1))*Math.sin(diffLng/2)*Math.sin(diffLng/2);
        double c = 2*Math.asin(Math.sqrt(a));
        double res = earth*c;
        return 1;
    }

}


