import { Component, OnDestroy, OnInit } from '@angular/core';
import { HomeServiceService } from '../home-service.service';
import { Router } from '@angular/router';
import { SearchService } from '../search.service';
import { AuthenticationService } from '../authentication.service';
import { HttpClient } from '@angular/common/http';
import { LibraryService } from '../library.service';
import { Song } from '../song';

@Component({
  selector: 'app-library',
  templateUrl: './library.component.html',
  styleUrls: ['./library.component.css']
})
export class LibraryComponent implements OnInit {
  songs: Song[] = [];
  constructor(private homeService : HomeServiceService, private router: Router, private searchService: SearchService, private authService: AuthenticationService, private http : HttpClient, private libser: LibraryService) {}
  ngOnInit(): void {
    if(!this.authService.checkLoggedInUser()){
      this.router.navigate(['']);
    }
    this.libser.getSongsForLibrary().subscribe(res => this.songs = res );

  }
  playSong(songdto : Song)
  {
    var song : Song = {name: songdto.name, movie: songdto.movie, link: songdto.link};
      this.homeService.saveSong(song);
      this.router.navigate(['playMusic']);
  }

  

}
