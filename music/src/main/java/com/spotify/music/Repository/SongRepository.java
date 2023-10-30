package com.spotify.music.Repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.spotify.music.entity.Song;



public interface SongRepository extends JpaRepository<Song,Integer> {

    @Query("SELECT s FROM Song s JOIN s.artists a WHERE a.name = :artistName")
    List<Song> findByArtistName(@Param("artistName") String artistName);

    @Query("SELECT s FROM Song s JOIN s.movie m WHERE m.name = :movieName")
    List<Song> findByMovieName(@Param("movieName") String movieName);

    @Query("SELECT s FROM Song s JOIN s.songCategory c WHERE c.name = :categoryName")
    List<Song> findByCategoryName(@Param("categoryName") String categoryName);

    @Query("SELECT s FROM Song s WHERE s.language = :language")
    List<Song> findByLanguage(@Param("language") String language);

    @Query("SELECT s FROM Song s WHERE s.name = :name")
    Song findByName(@Param("name") String name);
//    
//    @Query("SELECT s FROM Song s WHERE s.name = :name")
//    List<Song> findSongsByName(@Param("name") String name);
    
    


}
