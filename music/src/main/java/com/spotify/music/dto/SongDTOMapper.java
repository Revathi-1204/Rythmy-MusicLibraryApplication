package com.spotify.music.dto;

import com.spotify.music.entity.Song;

public class SongDTOMapper {

    public static SongDTO mapToSongDTO(Song song) {
        var songDTO = new SongDTO();
        songDTO.setSongName(song.getName());
        songDTO.setMovieName(song.getMovie().getName());
        var commaSeparatedArtistNameList = "";
        for (var artist : song.getArtists()) {
            commaSeparatedArtistNameList += artist.getName() + " ";
        }
        songDTO.setArtistName(commaSeparatedArtistNameList);
        songDTO.setLink(song.getMovie().getPictureLink());
        return songDTO;

    }
}