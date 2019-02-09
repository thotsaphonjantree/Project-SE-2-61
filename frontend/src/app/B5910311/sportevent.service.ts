import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';

@Injectable({
  providedIn: 'root'
})
export class SporteventService {

  constructor(private http: HttpClient) { }
  public API = '//localhost:8080';

  showAllSportsEvent(): Observable<any> {
    return this.http.get('//localhost:8080/event');
  }
  showEventById(seid) {
    return this.http.get('//localhost:8080/event/' + seid);
  }

  showAllEventStaff(): Observable<any> {
    return this.http.get('//localhost:8080/staffname');
  }

  showAllLocation(): Observable<any> {
    return this.http.get('//localhost:8080/location');
  }

  showAllSportTypes(): Observable<any> {
    return this.http.get('//localhost:8080/sportstype');
  }
  showAlladdress(): Observable<any> {
    return this.http.get('//localhost:8080/address');
  }
  showAddressById(aid) {
  return this.http.get('//localhost:8080/address/' +aid);
  }
  showAllProfile(): Observable<any> {
    return this.http.get('//localhost:8080/profile');
  }
  ShowProfileById(pid) {
  return this.http.get('//localhost:8080/profile/' +pid);
  }
}
