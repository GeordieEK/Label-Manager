package com.Label.Manager.Song;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class SongService {
    private final SongRepository songRepository;

    // private ArrayList<Song> songList = new ArrayList<>(Arrays.asList());
    @Autowired
    public SongService(SongRepository songRepository) {
        this.songRepository = songRepository;
    }

    public List<Song> getAllSongs(String albumId) {
        List<Song> songs = new ArrayList<>();
        songRepository.findByAlbumId(albumId).forEach(songs::add);
        return songs;
    }

    public Optional<Song> getSong(String id) {
        return songRepository.findById(id);
    }

    public void addSong(Song song) {
        songRepository.save(song);
    }

    public void updateSong(Song song) {
        songRepository.save(song);
    }

    public void deleteSong(String id) {
        // songList.removeIf(s -> s.getId().equals(id));
        songRepository.deleteById(id);
    }
}
