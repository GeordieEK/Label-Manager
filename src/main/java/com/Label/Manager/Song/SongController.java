package com.Label.Manager.Song;

import com.Label.Manager.Album.Album;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

//Tells Spring this is a REST controller
@RestController
// @RequestMapping signifies the type of request and its url path, it is used at class level
@RequestMapping(path = "/album/{albumId}/song")
public class SongController {

    private SongService songService;

    // @Autowired annotation marks this as something that is involved in dependency injection
    // This means when your method runs, there's an instance of the dependent object available
    @Autowired
    public SongController(SongService songService) {
        this.songService = songService;
    }

    // @GetMapping is @RequestMapping combined with .GET and is used at method level
    @GetMapping
    public List<Song> getAllSongs(@PathVariable String albumId) {
        return songService.getAllSongs(albumId);
    }

    @GetMapping(path = "/{id}")
    // @PathVariable tells spring to pull the variable from the url path portion in {}
    // They will automatically match if the variable in the path and code are the same, or it can be passed as a parameter to @PathVariable
    public Optional<Song> getSong(@PathVariable String id) {
        return songService.getSong(id);
    }

    // @RequestBody allows for the .json payload of the request body to be converted to a song instance
    @PostMapping
    public void addSong(@RequestBody Song song, @PathVariable String albumId) {
        song.setAlbum(new Album(albumId, "", "", 0, 0, 0));
        songService.addSong(song);
    }

    @PutMapping(path = "/{id}")
    public void updateSong(@RequestBody Song song, @PathVariable String albumId, @PathVariable Long id) {
        song.setAlbum(new Album(albumId, "", "", 0, 0, 0));
        songService.updateSong(song);
    }

    @DeleteMapping(path = "/{id}")
    public void deleteSong(@PathVariable String id) {
        songService.deleteSong(id);
    }
}
