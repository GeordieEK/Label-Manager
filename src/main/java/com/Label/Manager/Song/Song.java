package com.Label.Manager.Song;

import com.Label.Manager.Album.Album;

import javax.persistence.*;

@Entity
@Table(name="song")
public class Song {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="song_id")
    private String id;
    @Column(name="song_title")
    private String songTitle;
    @Column(name="song_sales")
    private int songSales;
    @Column(name="song_revenue")
    private int revenue;


    @ManyToOne
    @JoinColumn(referencedColumnName="album_id")
    private Album album;

    public Song() {
    }

    public Album getAlbum() {
        return album;
    }

    public void setAlbum(Album album) {
        this.album = album;
    }

    public String getId() {
        return id;
    }

    public void setId(String songId) {
        this.id = songId;
    }

    public String getSongTitle() {
        return songTitle;
    }

    public void setSongTitle(String songTitle) {
        this.songTitle = songTitle;
    }

    public int getSongSales() {
        return songSales;
    }

    public void setSongSales(int songSales) {
        this.songSales = songSales;
    }

    public int getRevenue() {
        return revenue;
    }

    public void setRevenue(int revenue) {
        this.revenue = revenue;
    }

    @Override
    public String toString() {
        return "Song{" +
                "songId='" + id + '\'' +
                ", songTitle='" + songTitle + '\'' +
                ", songSales=" + songSales +
                ", revenue=" + revenue +
                ", album=" + album +
                '}';
    }
}
