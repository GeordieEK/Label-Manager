package com.Label.Manager.Song;

import com.Label.Manager.Album.Album;

import javax.persistence.*;

@Entity
@Table(name="song")
public class Song {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="catalog_num")
    private String catalogNum;
    @Column(name="song_title")
    private String songTitle;
    @Column(name="release_date")
    private String releaseDate;
    @Column(name="song_sales")
    private int songSales;
    @Column(name="prod_cost")
    private float cost;
    @Column(name="song_revenue")
    private int revenue;

    @ManyToOne
    @JoinColumn(name = "album_catalog_num")
    private Album album;

    public Song() {
    }

    public Song(String catalogNum, String songTitle, String releaseDate, int songSales, float cost, int revenue, String albumId) {
        this.catalogNum = catalogNum;
        this.songTitle = songTitle;
        this.releaseDate = releaseDate;
        this.songSales = songSales;
        this.cost = cost;
        this.revenue = revenue;
        this.album = new Album(albumId, "", "", 0, 0, 0);
    }

    public Album getAlbum() {
        return album;
    }

    public void setAlbum(Album album) {
        this.album = album;
    }

    public String getCatalogNum() {
        return catalogNum;
    }

    public void setCatalogNum(String catalogNum) {
        this.catalogNum = catalogNum;
    }

    public String getSongTitle() {
        return songTitle;
    }

    public void setSongTitle(String songTitle) {
        this.songTitle = songTitle;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public int getSongSales() {
        return songSales;
    }

    public void setSongSales(int songSales) {
        this.songSales = songSales;
    }

    public float getCost() {
        return cost;
    }

    public void setCost(float cost) {
        this.cost = cost;
    }

    public int getRevenue() {
        return revenue;
    }

    public void setRevenue(int revenue) {
        this.revenue = revenue;
    }

    @Override
    public String toString() {
        return "song{" +
                "catalogNum='" + catalogNum + '\'' +
                ", songTitle='" + songTitle + '\'' +
                ", releaseDate='" + releaseDate + '\'' +
                ", songSales=" + songSales +
                ", cost=" + cost +
                ", revenue=" + revenue +
                '}';
    }
}
