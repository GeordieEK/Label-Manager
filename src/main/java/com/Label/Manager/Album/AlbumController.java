package com.Label.Manager.Album;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

//Tells Spring this is a REST controller
@RestController
// @RequestMapping signifies the type of request and its url path, it is used at class level
@RequestMapping(path = "/albums")
public class AlbumController {
    private AlbumService albumService;

    // @Autowired annotation marks this as something that is involved in dependency injection
    // This means when your method runs, there's an instance of the dependent object available
    @Autowired
    public AlbumController(AlbumService albumService) {
        this.albumService = albumService;
    }

    // @GetMapping is @RequestMapping combined with .GET and is used at method level
    @GetMapping
    public List<Album> getAllAlbums() {
        return albumService.getAllAlbums();
    }

    @GetMapping(path = "/{id}")
    // @PathVariable tells spring to pull the variable from the url path portion in {}
    // They will automatically match if the variable in the path and code are the same, or it can be passed as a parameter to @PathVariable
    public Optional<Album> getAlbum(@PathVariable String id) {
        return albumService.getAlbum(id);
    }

    // @RequestBody allows for the .json payload of the request body to be converted to an album instance
    @PostMapping
    public void addAlbum(@RequestBody Album album) {
        albumService.addAlbum(album);
    }

    @PutMapping(path = "/{id}")
    public void updateAlbum(@RequestBody Album album, @PathVariable Long id) {
        albumService.updateAlbum(id, album);
    }

    @DeleteMapping(path = "/{id}")
    public void deleteAlbum(@PathVariable String id) {
        albumService.deleteAlbum(id);
    }
}
