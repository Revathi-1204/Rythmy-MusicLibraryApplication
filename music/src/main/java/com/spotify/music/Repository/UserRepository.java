package com.spotify.music.Repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.spotify.music.entity.User;

public interface UserRepository extends CrudRepository<User, Integer> {

	 public Optional<User> findByName(String name);
	    public boolean existsByName(String name);
		public String findRoleByName(String username);

}
