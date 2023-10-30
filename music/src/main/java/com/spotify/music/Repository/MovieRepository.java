package com.spotify.music.Repository;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spotify.music.entity.Movie;



public interface MovieRepository extends JpaRepository<Movie, Integer>{

    // List<Optional<Song>> findSongsByMovieName(String name);
    
}

