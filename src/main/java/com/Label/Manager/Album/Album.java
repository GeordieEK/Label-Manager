package com.Label.Manager.Album;

import javax.persistence.*;

@Entity
@Table(name="album")
public class Album {
    @Id
    @Column(name= "album_id")
    private String id;
    @Column(name="album_title")
    private String albumTitle;
    @Column(name="release_date")
    private String releaseDate;
    @Column(name="album_sales")
    private int albumSales;
    @Column(name="prod_cost")
    private float cost;
    @Column(name="album_revenue")
    private int revenue;

    public Album() {
    }

    public Album(String id, String albumTitle, String releaseDate, int albumSales, float cost, int revenue) {
        this.id = id;
        this.albumTitle = albumTitle;
        this.releaseDate = releaseDate;
        this.albumSales = albumSales;
        this.cost = cost;
        this.revenue = revenue;
    }

    public String getId() {
        return id;
    }

    public void setId(String catalogNum) {
        this.id = catalogNum;
    }

    public String getAlbumTitle() {
        return albumTitle;
    }

    public void setAlbumTitle(String albumTitle) {
        this.albumTitle = albumTitle;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public int getAlbumSales() {
        return albumSales;
    }

    public void setAlbumSales(int albumSales) {
        this.albumSales = albumSales;
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
        return "album{" +
                "catalogNum='" + id + '\'' +
                ", albumTitle='" + albumTitle + '\'' +
                ", releaseDate='" + releaseDate + '\'' +
                ", albumSales=" + albumSales +
                ", cost=" + cost +
                ", revenue=" + revenue +
                '}';
    }
}
