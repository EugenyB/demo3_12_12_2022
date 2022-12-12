package com.example.demo3.dao;

import com.example.demo3.entities.Artist;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import java.util.List;

@Stateless
public class ArtistDao {

    @PersistenceContext
    EntityManager em;

    public List<Artist> findAll() {
        return em.createNamedQuery("Artist.findAll", Artist.class).getResultList();
    }

    public void saveArtistToDB(Artist artist) {
        em.persist(artist);
    }

    public void delete(Artist a) {
        Artist artist = em.find(Artist.class, a.getId());
        if (artist != null) {
            em.remove(artist);
        }
    }
}
