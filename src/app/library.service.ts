import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { SongDTO } from './home/SongDTO';
import { AuthenticationService } from './authentication.service';
import { Song } from './song';

@Injectable({
  providedIn: 'root'
})
export class LibraryService {

  constructor(private http: HttpClient, private authService: AuthenticationService) { }
  getHeaders(): HttpHeaders {
    return new HttpHeaders({
      'Authorization': 'Bearer ' + localStorage.getItem('token')
    });
  }

  addSongToLibrary(songname: string): Observable<string> {
    const songLibDTO = {
      songname: songname,
      username: this.authService.getUserName()
    };
  
    const headers = this.getHeaders();
  
    const options = {
      headers: headers
    };
  
    return this.http.post<string>('http://localhost:8080/api/songs/addSongToLib', songLibDTO, options);
  }

getSongsForLibrary(): Observable<Song[]>
{
  const headers = this.getHeaders();
  username: this.authService.getUserName();
  console.log("till heer");
  return this.http.get<Song[]>('http://localhost:8080/api/songs/libSongs', {headers: headers});
}

}