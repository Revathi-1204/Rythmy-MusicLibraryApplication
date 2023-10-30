package com.spotify.music.entity;
import java.util.HashSet;
import java.util.Set;

// import java.util.Locale.Category;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Entity
@Data
public class Song {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private int id;

    @Column
    private String name;
    private String language;
    
    @ManyToMany
    @JoinTable(
        name = "song_artist", // The name of the junction table
        joinColumns = @JoinColumn(name = "song_id"), // Column in this entity
        inverseJoinColumns = @JoinColumn(name = "artist_id") // Column in the related entity (Artist)
    )
    private Set<Artist> artists = new HashSet<>();

    @ManyToOne
    @JoinColumn(name="movie_id", referencedColumnName = "id")
    private Movie movie;

    @ManyToOne
    @JoinColumn(name="category_id", referencedColumnName = "id")
    private SongCategory songCategory;
    
}
