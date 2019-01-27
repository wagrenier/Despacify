import { Component, OnInit } from '@angular/core';
import {FormControl} from "@angular/forms";
import {LocationService} from "../services/location.service";
import {MatSnackBar} from "@angular/material";
import {GoogleMapGeocodeResponse} from "../models/GoogleMapGeocodeResponse";
import {Router} from "@angular/router";


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

  readonly genres=['ALT - INDIE ROCK','RAP - HIP-HOP','ALT - ROCK','REGGAE','HEAVY METAL','SOUNDTRACK - BROADWAY','COUNTRY','COUNTRY - COUNTRY ROCK','RAP - OLD SCHOOL','ROCK - HARD ROCK','ALT - METAL','POP ROCK','POP','REGGAE - DANCEHALL','PUNK - SKA','ROCK','ELECTRO - DANCE','ROCK - SOUTHERN ROCK','POP - SOUL','ROCK - PROG ROCK','R&B - URBAN','LATIN - ROCK','PUNK - PUNKROCK','COUNTRY - POP','PUNK - POP','R&B - QUIETSTORM','R&B - SOUL','ALT - NEW WAVE','COUNTRY - CONTEMPORARY',];

  constructor(private locationService: LocationService, private snack: MatSnackBar, private router: Router) { }

  ngOnInit() {
  }

  submit(){
    this.locationService.getlatLong(this.locationController.value).subscribe((result)=>{

      let response = result as GoogleMapGeocodeResponse;
        let lat = response.results[0].geometry.location.lat;
        let lng = response.results[0].geometry.location.lng;

        console.log(lat + "+" + lng);

        this.router.navigate(['/playlist',this.nameController.value]);
      }
      ,()=> this.snack.open('Cannot get address','Ok'));
  }




}
