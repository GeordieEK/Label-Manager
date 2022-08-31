package com.Label.Manager.Song;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

//Tells Spring this is a REST controller
@RestController
// @RequestMapping signifies the type of request and its url path, it is used at class level
@RequestMapping(path = "api/v1")
public class SongController {

    // @Autowired annotation marks this as something that is involved in dependency injection
    // This means when your method runs, there's an instance of the dependent object available
    @Autowired
    private SongService songService;

    // @GetMapping is @RequestMapping combined with .GET and is used at method level
    @GetMapping(path = "/song")
    public List<Song> getAllSongs() {
        return songService.getAllSongs();
    }

    @GetMapping(path = "/song/{id}")
    // @PathVariable tells spring to pull the variable from the url path portion in {}
    // They will automatically match if the variable in the path and code are the same, or it can be passed as a parameter to @PathVariable
    public Optional<Song> getSong(@PathVariable String id) {
        return songService.getSong(id);
    }

    // @RequestBody allows for the .json payload of the request body to be converted to a song instance
    @PostMapping(path = "/song")
    public void addSong(@RequestBody Song song) {
        songService.addSong(song);
    }

    @PutMapping(path = "/song/{id}")
    public void updateSong(@RequestBody Song song, @PathVariable Long id) {
        songService.updateSong(id, song);
    }

    @DeleteMapping(path = "/song/{id}")
    public void deleteSong(@PathVariable String id) {
        songService.deleteSong(id);
    }
}
