package com.spotify.music.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

 

import com.spotify.music.entity.Library;

 

@Repository

public interface LibraryRepository extends JpaRepository<Library,Integer>{

	@Query(value="select * from library where song_id = ?1 and user_id = ?2", nativeQuery = true)
	List<Library> findByUserIdAndSongID(int songId, int userId);

   

}