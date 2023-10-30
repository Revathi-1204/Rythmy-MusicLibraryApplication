package com.spotify.music.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spotify.music.entity.Artist;



public interface ArtistRepository extends JpaRepository<Artist, Integer>{

    // List<Optional<Song>> findSongsByArtistName(String name);
    
}
