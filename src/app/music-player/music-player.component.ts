import { Component, OnInit } from '@angular/core';
import { HomeServiceService } from '../home-service.service';
import { Song } from '../song';
import { LibraryComponent } from '../library/library.component';
import { LibraryService } from '../library.service';

@Component({
  selector: 'app-music-player',
  templateUrl: './music-player.component.html',
  styleUrls: ['./music-player.component.css']
})
export class MusicPlayerComponent implements OnInit{

  song : Song = {name: "", movie: "", link: "" };
  status: any = {libStatus: ""};
  constructor(private homeService: HomeServiceService, private libraryService: LibraryService){}
  ngOnInit(): void {
    this.song = this.homeService.getSavedSong();
  }
  showOptions = false; // Initially, the options menu is hidden

  addSongToLibrary(songname: string): void {
    this.libraryService.addSongToLibrary(songname).subscribe(
      (res) => {
        this.status = res;
      console.log(this.status);
        if (this.status.libStatus === "added") {
          window.alert("Added to library");
        }
      }
    );
  }
  
  


}
