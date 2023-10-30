package com.spotify.music.service;

import java.util.ArrayList;

import java.util.List;

 

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

 

import com.spotify.music.Repository.LibraryRepository;

import com.spotify.music.Repository.SongRepository;

import com.spotify.music.Repository.UserRepository;

import com.spotify.music.dto.SongDTO;

import com.spotify.music.entity.Library;

import com.spotify.music.entity.Song;

import com.spotify.music.entity.User;

import com.spotify.music.exception.ResourceNotFoundException;

 

@Service

public class LibraryService {

 

    @Autowired

    private LibraryRepository libraryRepository;

 

    @Autowired

    private SongRepository songRepository;

 

    @Autowired

    private UserRepository userRepository;

 

    // Method to add a song to the library

    public void addSongToLibrary(int songId, int userId) throws ResourceNotFoundException {

        // Fetch the Song and User entities based on their IDs

        Song song = songRepository.findById(songId).orElse(null);

        User user = userRepository.findById(userId).orElse(null);

   

        if (song != null && user != null) {

            // Create a new Library entry and associate the Song and User

            Library libraryEntry = new Library();

            libraryEntry.setSong(song);

            libraryEntry.setUser(user);

            libraryRepository.save(libraryEntry);

        } else {

            throw new ResourceNotFoundException("Couldnt add successfully!");

        }

    }
    public boolean checkSong(int songId, int userId) {
    	List<Library> entity = libraryRepository.findByUserIdAndSongID(songId, userId);
    	return entity.isEmpty();
    	
    }

   

 

    // Method to delete a song from the library

    public void deleteSongFromLibrary(int libraryEntryId) {

        libraryRepository.deleteById(libraryEntryId);

    }

 

    public List<Song> allSongs(){

        List<Song> songs = new ArrayList<Song>();

        List<Library> lib = libraryRepository.findAll();

        for (Library libraryRecord: lib){

            var song = libraryRecord.getSong();

            songs.add(song);

        }

        return songs;

    }

}