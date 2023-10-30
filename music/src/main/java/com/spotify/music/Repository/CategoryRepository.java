package com.spotify.music.Repository;

import org.springframework.data.repository.CrudRepository;

import com.spotify.music.entity.SongCategory;

public interface CategoryRepository extends CrudRepository<SongCategory, Integer> {

}
