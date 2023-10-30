package com.spotify.music.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.spotify.music.Repository.UserRepository;
import com.spotify.music.dto.AddSongDTO;
import com.spotify.music.dto.HomeSongDTO;
import com.spotify.music.dto.SongDTO;
import com.spotify.music.dto.SongDTOMapper;
import com.spotify.music.dto.Status;
import com.spotify.music.entity.Song;
import com.spotify.music.entity.User;
import com.spotify.music.exception.ResourceNotFoundException;
import com.spotify.music.service.LibraryService;
import com.spotify.music.service.SongService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("/api/songs")
public class SongController {

    @Autowired
    private SongService songService;
    
    @Autowired
    private LibraryService libraryService;
    
    @Autowired
    private UserRepository userRepository;
    
    @GetMapping("/homeSongs")
    public List<HomeSongDTO> getSongsForHome()
    {
    	List<Song> songs = songService.allSongs();
    	List<HomeSongDTO> homeSongs = new ArrayList<HomeSongDTO>();	
    	for(Song song : songs)
    	{
    		HomeSongDTO sample = new HomeSongDTO();
    		sample.setName(song.getName());
    		sample.setMovie(song.getMovie().getName());
    		sample.setLink(song.getMovie().getPictureLink());
    		homeSongs.add(sample);
    	}
    	return homeSongs;
    }

     @PostMapping
    public Song saveSong(@RequestBody Song song) {
        return songService.saveSong(song);
    }

    @GetMapping("/all")
    public List<Song> allSongs(){
        return songService.allSongs();
    }

    @GetMapping("/by-name/{name}")
    public SongDTO findSongsByName(@PathVariable("name") String name) {
        Song song =  songService.findSongsByName(name);
        var songdto = SongDTOMapper.mapToSongDTO(song);
        return songdto;
    }

    @GetMapping("/by-artist/{artistName}")
    public List<SongDTO> findSongsByArtistName(@PathVariable("artistName") String artistName) throws ResourceNotFoundException {
    	List<Song> songs =  songService.findSongsByArtistName(artistName);
        if(songs.isEmpty())
            throw new ResourceNotFoundException("No song with the requested Name");
        List<SongDTO> songDTOs = new ArrayList<>();
        for (Song song : songs){
            songDTOs.add(SongDTOMapper.mapToSongDTO(song));
        }
        return songDTOs;
    }

    @GetMapping("/by-movie/{movieName}")
    public List<SongDTO> findSongsByMovieName(@PathVariable("movieName") String movieName) throws ResourceNotFoundException{
    	List<Song> songs =  songService.findSongsByMovieName(movieName);
        if(songs.isEmpty())
            throw new ResourceNotFoundException("No song with the requested Name");
        List<SongDTO> songDTOs = new ArrayList<>();
        for (Song song : songs){
            songDTOs.add(SongDTOMapper.mapToSongDTO(song));
        }
        return songDTOs;
    }

    @GetMapping("/by-category/{categName}")
    public List<SongDTO> findSongsByCategory(@PathVariable("categName") String category) throws ResourceNotFoundException {
    	List<Song> songs =  songService.findSongsByCategoryName(category);
        if(songs.isEmpty())
            throw new ResourceNotFoundException("No song with the requested Name");
        List<SongDTO> songDTOs = new ArrayList<>();
        for (Song song : songs){
            songDTOs.add(SongDTOMapper.mapToSongDTO(song));
        }
        return songDTOs;
    }

    @GetMapping("/by-language/{language}")
    public List<SongDTO> findSongsByLanguage(@PathVariable("language") String language) throws ResourceNotFoundException {
    	List<Song> songs =  songService.findSongsByLang(language);
        if(songs.isEmpty())
            throw new ResourceNotFoundException("No song with the requested Name");
        List<SongDTO> songDTOs = new ArrayList<>();
        for (Song song : songs){
            songDTOs.add(SongDTOMapper.mapToSongDTO(song));
        }
        return songDTOs;
    }
    
    @PostMapping("/addSongToLib")
    public Status addSongToLibrary(@RequestBody AddSongDTO addSongDTO) throws ResourceNotFoundException{
    	Status st = new Status();
    	Song song = songService.findSongsByName(addSongDTO.getSongname());
    	Optional<User> user = userRepository.findByName(addSongDTO.getUsername());
    	int song_id = song.getId();
    	int user_id = (int) user.get().getId();
    	if(libraryService.checkSong(song_id, user_id)) {
    		libraryService.addSongToLibrary(song_id, user_id);
    		st.setLibStatus("added");
    		return st;
    	}
    	else {
    	st.setLibStatus("exists");
    	return st;
    	}

    }

    // Delete a song from the library
    @DeleteMapping("/deleteSongFromLib")
    public void deleteSongFromLibrary(@RequestParam("library_id") int libraryEntryId){
        libraryService.deleteSongFromLibrary(libraryEntryId);
    }

    @GetMapping("/libSongs")
    public List<HomeSongDTO> getAllSongs() {
	    List<Song> songs = libraryService.allSongs();
	    List<HomeSongDTO> songDto = new ArrayList<HomeSongDTO>();
	    for(Song song: songs)
	    {
	    	HomeSongDTO dto = new HomeSongDTO();
	    	dto.setMovie(song.getMovie().getName());
	    	dto.setName(song.getName());
	    	dto.setLink(song.getMovie().getPictureLink());
	    	songDto.add(dto);
	    	System.out.println(dto.getName());
	    }
	    return songDto;
	}

}

