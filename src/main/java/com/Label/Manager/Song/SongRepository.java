package com.Label.Manager.Song;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface SongRepository extends CrudRepository<Song, String> {
    public List<Song> findByAlbumId(String albumId);

}
