import { Injectable } from '@angular/core';
import { Song } from './song';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Artist } from './home/Artist';
import { Category } from './home/Category';

@Injectable({
  providedIn: 'root'
})
export class HomeServiceService {
    
song : Song = {name: "", movie: "", link: "" };
  constructor(private _http: HttpClient) {}

  getHeaders(): HttpHeaders {
    return new HttpHeaders({
      'Authorization': 'Bearer ' + localStorage.getItem('token')
    });
  }


  getSongsForHome() : Observable<Song[]>{
    const headers = this.getHeaders();
    return this._http.get<Song[]>(`http://localhost:8080/api/songs/homeSongs`, {headers});
  }
  getArtists(): Observable<Artist[]> {
    const headers = this.getHeaders();
    return this._http.get<Artist[]>(`http://localhost:8080/api/songs/getArtistNames`, {headers});
  }

  getCategories() : Observable<Category[]>{
    const headers = this.getHeaders();
    console.log("hey i am going");
    return this._http.get<Category[]>(`http://localhost:8080/api/songs/getCategoryNames`, {headers});
  }

  saveSong(song: Song): void{
    this.song = song;
    console.log("saved");
  }

  getSavedSong(): Song{
    return this.song;
  }

  




}
