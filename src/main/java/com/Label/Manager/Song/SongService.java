package com.Label.Manager.Song;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class SongService {

    // @Autowired means that when Spring creates an instance of songService,
    // it's going to inject an instance of songRepository, ready to use in methods.
    @Autowired
    private SongRepository songRepository;

    private ArrayList<Song> songList = new ArrayList<>(Arrays.asList(

    ));

    public List<Song> getAllSongs() {
        //findAll() will connect to the DB, run a query, get all song rows,
        // convert each of them to song instances and return them
        List<Song> songs = new ArrayList<>();
        // ::add is a method reference which is like a lambda expression (more info on lambda basics at javabrains.io)
        songRepository.findAll().forEach(songs::add);
        return songs;
    }

    public Optional<Song> getSong(String id) {
        // return songList.stream().filter(s -> s.getId().equals(id)).findFirst().orElse(null);
        return songRepository.findById(id);
    }

    public void addSong(Song song) {
        songRepository.save(song);
    }

    public void updateSong(Long id, Song song) {
//        for (int i = 0; i < songList.size(); i++) {
//            song s = songList.get(i);
//            if (s.getId().equals(id)) {
//                songList.set(i, song);
//                return;
//            }
//        }
        songRepository.save(song);
    }

    public void deleteSong(String id) {
        // songList.removeIf(s -> s.getId().equals(id));
        songRepository.deleteById(id);
    }
}
