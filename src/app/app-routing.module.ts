import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LoginComponent } from './login/login.component';
import { NavbarComponent } from './navbar/navbar.component';
import { HomeComponent } from './home/home.component';
import { SearchComponent } from './search/search.component';
import { LibraryComponent } from './library/library.component';
import { UserComponent } from './user/user.component';
import { MusicPlayerComponent } from './music-player/music-player.component';


const routes: Routes = [
  {path: "" , component: LoginComponent},
  {path: "navbar", component: NavbarComponent},
  {path: "home", component: HomeComponent},
  {path: "search", component: SearchComponent},
  {path: "library", component: LibraryComponent},
  {path: "user", component: UserComponent},
  {path: "playMusic", component: MusicPlayerComponent}
  
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
