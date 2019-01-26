import { Component, OnInit } from '@angular/core';
import {ActivatedRoute, Router} from '@angular/router';
import {Song} from "../models/Song";

@Component({
  selector: 'app-results',
  templateUrl: './results.component.html',
  styleUrls: ['./results.component.css']
})
export class ResultsComponent implements OnInit {


  currentSong: Song;
  constructor(private route: ActivatedRoute,
              private router: Router) { }

  ngOnInit() {
  }

}
