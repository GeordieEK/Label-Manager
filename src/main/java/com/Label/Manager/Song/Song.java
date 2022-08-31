package com.Label.Manager.Song;

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
