import { Component, OnInit } from '@angular/core';
import { Song } from '../song';
import { HomeServiceService } from '../home-service.service';
import { Router } from '@angular/router';
import { Artist } from './Artist';
import { Category } from './Category';
import { SearchService } from '../search.service';
import { SongDTO } from './SongDTO';
import { AuthenticationService } from '../authentication.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit{

  songs : Song[] = [];
  artists: Artist[] = [];
  categories : Category[] = [];
  searchTerm: string = '';
  searchResults: SongDTO[] = [];
  flag: boolean = true;
  isLoggedIn: boolean = false;
  constructor(private homeService : HomeServiceService, private router: Router, private searchService: SearchService, private authSrvice: AuthenticationService) {}
  ngOnInit(): void {

    if(!this.authSrvice.checkLoggedInUser()){
      this.router.navigate(['']);
    }
    
      this.homeService.getSongsForHome().subscribe(res => this.songs = res);
      this.homeService.getArtists().subscribe(res => this.artists = res);
      this.homeService.getCategories().subscribe(res => this.categories = res);
      
  }

  displaySong(song: Song){
    this.homeService.saveSong(song);
    this.router.navigate(['playMusic']);
  }

  ByArtist() {
    console.log("by artist");
    this.searchService.searchByArtist(this.searchTerm).subscribe((results: SongDTO[]) => {
      this.searchResults = results;
      console.log(" i came back");
    });
  }

  ByCategory() {
    this.searchService.searchByCategory(this.searchTerm).subscribe((results: SongDTO[]) => {
      this.searchResults = results;
    });
  }

  setSearchTermAndByArtist(artist : string)
  {
    console.log("setatistnajhbjhs");
    this.searchTerm = artist;
    this.flag = false;
    this.ByArtist();
  }

  setSearchTermAndByCategory(category : string)
  {
    this.searchTerm = category;
    this.flag = false;
    this.ByCategory();
  }

  playSong(songdto : SongDTO)
  {
    var song : Song = {name: songdto.songName, movie: songdto.movieName, link: songdto.link};
      this.homeService.saveSong(song);
      this.router.navigate(['playMusic']);
  }

}
