package com.Label.Manager.Album;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class AlbumService {
    private final AlbumRepository albumRepository;

    private ArrayList<com.Label.Manager.Album.Album> albumList = new ArrayList<>(Arrays.asList(

    ));

    // @Autowired means that when Spring creates an instance of albumService,
    // it's going to inject an instance of albumRepository, ready to use in methods.
    @Autowired
    public AlbumService(AlbumRepository albumRepository) {
        this.albumRepository = albumRepository;
    }

    public List<Album> getAllAlbums() {
        //findAll() will connect to the DB, run a query, get all album rows,
        // convert each of them to album instances and return them
        List<Album> albums = new ArrayList<>();
        // ::add is a method reference which is like a lambda expression (more info on lambda basics at javabrains.io)
        albumRepository.findAll().forEach(albums::add);
        return albums;
    }

    public Optional<Album> getAlbum(String id) {
        // return albumList.stream().filter(s -> s.getId().equals(id)).findFirst().orElse(null);
        return albumRepository.findById(id);
    }

    public void addAlbum(Album album) {
        albumRepository.save(album);
    }

    public void updateAlbum(Long id, Album album) {
//        for (int i = 0; i < albumList.size(); i++) {
//            album s = albumList.get(i);
//            if (s.getId().equals(id)) {
//                albumList.set(i, album);
//                return;
//            }
//        }
        albumRepository.save(album);
    }

    public void deleteAlbum(String id) {
        // albumList.removeIf(s -> s.getId().equals(id));
        albumRepository.deleteById(id);
    }
}
