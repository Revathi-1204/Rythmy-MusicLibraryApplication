import { Component, OnInit } from '@angular/core';
import { Song } from '../song';
import { SearchService } from '../search.service';
import { SongDTO } from '../home/SongDTO';
import { HomeServiceService } from '../home-service.service';
import { Router } from '@angular/router';
import { AuthenticationService } from '../authentication.service';

@Component({
  selector: 'app-search',
  templateUrl: './search.component.html',
  styleUrls: ['./search.component.css']
})
export class SearchComponent implements OnInit {

  constructor(private searchService: SearchService, private homeService: HomeServiceService, private router:Router, private authSrvice: AuthenticationService) {
    this.flag = true;
  }
  ngOnInit(): void {
    if(!this.authSrvice.checkLoggedInUser()){
      this.router.navigate(['']);
    }
  }

  searchTerm: string = '';
  flag: boolean = true;
  selectedCategory: string = 'songName'; // Default category

  searchResults: SongDTO[] = [];
  song : SongDTO ;

  searchContent() {
    // Clear previous results
    this.searchResults = [];
    this.flag = false;

    console.log(this.searchTerm);
    // Perform the search based on the selected category
    if (this.selectedCategory === 'songName') {
      this.BySongName();
    } else if (this.selectedCategory === 'artist') {
      this.ByArtist();
    } else if (this.selectedCategory === 'language') {
      this.ByLanguage();
    } else if (this.selectedCategory === 'category') {
      this.ByCategory();
    }else if (this.selectedCategory === 'movie') {
      this.ByMovie();
    }
  }

  BySongName() {
    this.searchService.searchBySongName(this.searchTerm).subscribe((results: SongDTO) => {
      this.song = results;
      this.searchResults.push(this.song);
      console.log(results);
    });
  }

  ByArtist() {
    this.searchService.searchByArtist(this.searchTerm).subscribe((results: SongDTO[]) => {
      this.searchResults = results;
    });
  }

  ByLanguage() {
    this.searchService.searchByLanguage(this.searchTerm).subscribe((results: SongDTO[]) => {
      this.searchResults = results;
    });
  }

  ByCategory() {
    this.searchService.searchByCategory(this.searchTerm).subscribe((results: SongDTO[]) => {
      this.searchResults = results;
    });
  }

  ByMovie() {
    this.searchService.searchByMovie(this.searchTerm).subscribe((results: SongDTO[]) => {
      this.searchResults = results;
    });
  }

  playSong(songdto : SongDTO)
  {
    var song : Song = {name: songdto.songName, movie: songdto.movieName, link: songdto.link};
      this.homeService.saveSong(song);
      this.router.navigate(['playMusic']);
  }

  setSearchTermAndByLanguage(lang : string)
  {
    this.searchTerm = lang;
    this.flag = false;
    this.ByLanguage();
  }

  setSearchTermAndByMovie(movie : string)
  {
    this.searchTerm = movie;
    this.flag = false;
    this.ByMovie();
  }

  setSearchTermAndByArtist(artist : string)
  {
    this.searchTerm = artist;
    this.flag = false;
    this.ByArtist();
  }

}

