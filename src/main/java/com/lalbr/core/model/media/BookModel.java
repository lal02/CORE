package com.lalbr.core.model.media;

import jakarta.persistence.*;

@Entity
@Table(name = "media_book")
public class BookModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "book_id")
    private Long id;

    @Column(name = "book_title")
    private String title;

    @Column(name = "book_author")
    private String author;

    @Column(name = "book_language")
    private String language;

    @Column(name = "book_pages")
    private int pages;

    @Column(name = "book_genre")
    private String genre;

    @Column(name = "book_subgenre")
    private String subGenre;

    @Column(name = "book_read")
    private boolean read;

    @Column(name = "book_series")
    private String series;

    @Column(name = "book_placeinseries")
    private double placeInSeries;

    @Column(name = "book_format")
    private String format;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getSubGenre() {
        return subGenre;
    }

    public void setSubGenre(String subGenre) {
        this.subGenre = subGenre;
    }

    public boolean isRead() {
        return read;
    }

    public void setRead(boolean read) {
        this.read = read;
    }

    public String getSeries() {
        return series;
    }

    public void setSeries(String series) {
        this.series = series;
    }

    public double getPlaceInSeries() {
        return placeInSeries;
    }

    public void setPlaceInSeries(double placeInSeries) {
        this.placeInSeries = placeInSeries;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }
}
