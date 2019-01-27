import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class PlaylistService {

  playList: Object;

  constructor() { }

  getPlaylist(){
    return this.playList;
  }

  setPlaylist(playList: Object){
    this.playList = playList;
  }
}
