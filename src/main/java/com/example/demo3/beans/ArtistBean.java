package com.example.demo3.beans;

import com.example.demo3.dao.ArtistDao;
import com.example.demo3.entities.Artist;
import jakarta.ejb.EJB;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;

import java.io.Serializable;
import java.util.List;

@Named
@SessionScoped
public class ArtistBean implements Serializable {

    @EJB
    private ArtistDao artistDao;

    private Artist artist = new Artist();

    public List<Artist> getArtists() {
        return artistDao.findAll();
    }

    public Artist getArtist() {
        return artist;
    }

    public void setArtist(Artist artist) {
        this.artist = artist;
    }

    public void addArtist() {
        if (artist.getName() != null && !artist.getName().isBlank()) {
            artistDao.saveArtistToDB(artist);
            artist = new Artist();
        }
    }

    public String showAlbums(Artist a) {
        artist = a;
        return "albums_by_artist";
    }

    public void delete(Artist a) {
        artistDao.delete(a);
    }
}
