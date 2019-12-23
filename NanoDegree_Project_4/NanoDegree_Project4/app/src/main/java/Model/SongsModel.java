package Model;

import java.util.Date;

public class SongsModel {
    private String name;
    private String artist_name;
    private Date date;

    public SongsModel(String name, String artist_name, Date date) {
        this.name = name;
        this.artist_name = artist_name;
        this.date = date;
    }

    public SongsModel()
    {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getArtist_name() {
        return artist_name;
    }

    public void setArtist_name(String artist_name) {
        this.artist_name = artist_name;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
