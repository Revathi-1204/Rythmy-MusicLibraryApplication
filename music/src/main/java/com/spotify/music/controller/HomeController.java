package com.spotify.music.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spotify.music.Repository.ArtistRepository;
import com.spotify.music.Repository.CategoryRepository;
import com.spotify.music.dto.HomeArtistDTO;
import com.spotify.music.dto.HomeCategoryDTO;
import com.spotify.music.entity.Artist;
import com.spotify.music.entity.SongCategory;

@RestController
@CrossOrigin
@RequestMapping("/api/songs")

public class HomeController {
	@Autowired
	ArtistRepository artistRepository;
	
	@Autowired
	CategoryRepository categoryRepository;

	@GetMapping("/getArtistNames")
	public List<HomeArtistDTO> getArtistNames()
	{
		List<HomeArtistDTO> artistsDTO = new ArrayList<>();
		List<Artist> artists= artistRepository.findAll();
		
		for(Artist artist: artists)
		{
			HomeArtistDTO dto = new HomeArtistDTO();
			dto.setName(artist.getName());
			dto.setLink(artist.getLink());
			artistsDTO.add(dto);
		}
		return artistsDTO;		
	}
	

	@GetMapping("/getCategoryNames")
	public List<HomeCategoryDTO> getCategoryNames()
	{
		List<HomeCategoryDTO>  categories = new ArrayList<>();
		List<SongCategory> songCategories= (List<SongCategory>) categoryRepository.findAll();
		
		for(SongCategory songCategory: songCategories)
		{
			HomeCategoryDTO  dto = new HomeCategoryDTO();
			dto.setName(songCategory.getName());
			dto.setLink(songCategory.getLink());
			categories.add(dto);
		}
		return categories;		
	}
	
}
