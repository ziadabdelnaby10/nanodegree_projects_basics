package com.example.nanodegree_project_6;

public class ParsedJson {
    private String name;
    private String tile;
    private String webUrl;
    private String date;
    private String author;

    public ParsedJson(String name, String tile, String webUrl, String date, String author) {
        this.name = name;
        this.tile = tile;
        this.webUrl = webUrl;
        this.date = date;
        this.author = author;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTile() {
        return tile;
    }

    public void setTile(String tile) {
        this.tile = tile;
    }

    public String getWebUrl() {
        return webUrl;
    }

    public void setWebUrl(String webUrl) {
        this.webUrl = webUrl;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
