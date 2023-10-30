import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Artist } from './home/Artist';
import { Song } from './song';
import { SongDTO } from './home/SongDTO';

@Injectable({
  providedIn: 'root'
})
export class SearchService {

  constructor(private _http: HttpClient) {}
  

  getHeaders(): HttpHeaders {
    return new HttpHeaders({
      'Authorization': 'Bearer ' + localStorage.getItem('token')
    });
  }

  searchBySongName(searchTerm : string): Observable<SongDTO>
  {
    const headers = this.getHeaders(); 
    return this._http.get<SongDTO>(`http://localhost:8080/api/songs/by-name/${searchTerm}`, {headers});

  }
  searchByArtist(searchTerm : string): Observable<SongDTO[]>
  {
    console.log("i am in service");
    console.log(searchTerm);
    const headers = this.getHeaders(); 
    return this._http.get<SongDTO[]>(`http://localhost:8080/api/songs/by-artist/${searchTerm}`, {headers});
  }
  searchByLanguage(searchTerm : string): Observable<SongDTO[]>
  {
    const headers = this.getHeaders(); 
    return this._http.get<SongDTO[]>(`http://localhost:8080/api/songs/by-language/${searchTerm}`, {headers});
  }
  searchByCategory(searchTerm : string): Observable<SongDTO[]>
  {
    const headers = this.getHeaders(); 
    return this._http.get<SongDTO[]>(`http://localhost:8080/api/songs/by-category/${searchTerm}`, {headers});
  }
  searchByMovie(searchTerm : string): Observable<SongDTO[]>
  {
    const headers = this.getHeaders(); 
    return this._http.get<SongDTO[]>(`http://localhost:8080/api/songs/by-movie/${searchTerm}`, {headers});
  }
}
