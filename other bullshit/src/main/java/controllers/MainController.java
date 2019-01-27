package controllers;

import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

import controllers.services.MusicService;
import jsonreplyformats.Greeting;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import resources.PlayPopularity;
import resources.Song;

@RestController
public class MainController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @Autowired
    MusicService musicService;

    @RequestMapping("/greeting")
    public Greeting greeting(@RequestParam(value="name", defaultValue="World") String name) {
        return new Greeting(counter.incrementAndGet(),
                String.format(template, name));
    }

    @GetMapping("/plays")
    public Map<Song, PlayPopularity> getStats(@RequestParam()double lat, @RequestParam()double lng){
        return this.musicService.getPlays(lat, lng);
    }
}
