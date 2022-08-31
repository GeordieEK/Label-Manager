package com.Label.Manager.Album;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class AlbumService {

    // @Autowired means that when Spring creates an instance of albumService,
    // it's going to inject an instance of albumRepository, ready to use in methods.
    @Autowired
    private AlbumRepository albumRepository;

    private ArrayList<com.Label.Manager.Album.Album> albumList = new ArrayList<>(Arrays.asList(

    ));

    public List<Album> getAllAlbums() {
        //findAll() will connect to the DB, run a query, get all album rows,
        // convert each of them to album instances and return them
        List<Album> albums = new ArrayList<>();
        // ::add is a method reference which is like a lambda expression (more info on lambda basics at javabrains.io)
        albumRepository.findAll().forEach(albums::add);
        return albums;
    }

    public Optional<Album> getalbum(String id) {
        // return albumList.stream().filter(s -> s.getId().equals(id)).findFirst().orElse(null);
        return albumRepository.findById(id);
    }

    public void addalbum(Album album) {
        albumRepository.save(album);
    }

    public void updatealbum(Long id, Album album) {
//        for (int i = 0; i < albumList.size(); i++) {
//            album s = albumList.get(i);
//            if (s.getId().equals(id)) {
//                albumList.set(i, album);
//                return;
//            }
//        }
        albumRepository.save(album);
    }

    public void deletealbum(String id) {
        // albumList.removeIf(s -> s.getId().equals(id));
        albumRepository.deleteById(id);
    }
}
