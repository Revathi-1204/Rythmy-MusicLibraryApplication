package com.spotify.music.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spotify.music.Repository.SongRepository;
import com.spotify.music.entity.Song;

import java.util.List;

@Service
public class SongService {

    @Autowired
    private SongRepository songRepository;

     

    public Song saveSong(Song song) {
        return songRepository.save(song);
    }

    public List<Song> allSongs(){
        return songRepository.findAll();
    }

    public Song findSongsByName(String Name) {
        return songRepository.findByName(Name);
    }


    public List<Song> findSongsByArtistName(String artistName) {
        return songRepository.findByArtistName(artistName);
    }

    public List<Song> findSongsByMovieName(String movieName) {
        return songRepository.findByMovieName(movieName);

    }
    
    public List<Song> findSongsByCategoryName(String categoryName) {
        return songRepository.findByCategoryName(categoryName);

    }
    
    public List<Song> findSongsByLang(String language) {
        return songRepository.findByLanguage(language);

    }
    
}
