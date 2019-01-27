import { Component, OnInit } from '@angular/core';
import {FormControl} from "@angular/forms";


@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.css']
})

export class DashboardComponent implements OnInit {

  //The Variables
  nameController = new FormControl('');
  locationController = new FormControl('');
  genreController = new FormControl('');
  ageGroupController = new FormControl('');


  readonly genres=['ALT - INDIE ROCK','RAP - HIP-HOP','ALT - ROCK','REGGAE','HEAVY METAL','SOUNDTRACK - BROADWAY','COUNTRY','COUNTRY - COUNTRY ROCK','RAP - OLD SCHOOL','ROCK - HARD ROCK','ALT - METAL','POP ROCK','POP','REGGAE - DANCEHALL','PUNK - SKA','ROCK','ELECTRO - DANCE','ROCK - SOUTHERN ROCK','POP - SOUL','ROCK - PROG ROCK','R&B - URBAN','LATIN - ROCK','PUNK - PUNKROCK','COUNTRY - POP','PUNK - POP','R&B - QUIETSTORM','R&B - SOUL','ALT - NEW WAVE','COUNTRY - CONTEMPORARY',];

  constructor() { }

  ngOnInit() {
  }

  submit(){

  }

  getLatLong(){


  }



}
