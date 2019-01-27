import { Component, OnInit } from '@angular/core';
import {ActivatedRoute, ParamMap, Router} from '@angular/router';
import {Song} from "../models/Song";
import {Playlist} from "../models/Playlist";
import {switchMap} from "rxjs/operators";

@Component({
  selector: 'app-results',
  templateUrl: './results.component.html',
  styleUrls: ['./results.component.css']
})
export class ResultsComponent implements OnInit {

  playlistName: string;

  currentSong: Song;
  constructor(private route: ActivatedRoute,
              private router: Router) {
    this.route.paramMap.pipe(
      switchMap((params: ParamMap) =>
        this.playlistName = params.get('name')))
  }

  ngOnInit() {
  }

}
