package com.Label.Manager.Album;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

//Tells Spring this is a REST controller
@RestController
// @RequestMapping signifies the type of request and its url path, it is used at class level
@RequestMapping(path = "api/v1")
public class AlbumController {

    // @Autowired annotation marks this as something that is involved in dependency injection
    // This means when your method runs, there's an instance of the dependent object available
    @Autowired
    private AlbumService albumService;

    // @GetMapping is @RequestMapping combined with .GET and is used at method level
    @GetMapping(path = "/album")
    public List<Album> getAllAlbums() {
        return albumService.getAllAlbums();
    }

    @GetMapping(path = "/album/{id}")
    // @PathVariable tells spring to pull the variable from the url path portion in {}
    // They will automatically match if the variable in the path and code are the same, or it can be passed as a parameter to @PathVariable
    public Optional<Album> getAlbum(@PathVariable String id) {
        return albumService.getalbum(id);
    }

    // @RequestBody allows for the .json payload of the request body to be converted to a album instance
    @PostMapping(path = "/album")
    public void addAlbum(@RequestBody Album album) {
        albumService.addalbum(album);
    }

    @PutMapping(path = "/album/{id}")
    public void updateAlbum(@RequestBody Album album, @PathVariable Long id) {
        albumService.updatealbum(id, album);
    }

    @DeleteMapping(path = "/album/{id}")
    public void deleteAlbum(@PathVariable String id) {
        albumService.deletealbum(id);
    }
}
