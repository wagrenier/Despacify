import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";

@Injectable({
  providedIn: 'root'
})
export class LocationService {

  readonly api ='good try';
  readonly  url = 'https://maps.googleapis.com/maps/api/geocode/json?address=';

  constructor(private http: HttpClient) {}

  getlatLong(address:string){
    return this.http.get(this.url + address +this.appendKey());
  }

  private appendKey(){
    return '&key=' + this.api;
  }
}
