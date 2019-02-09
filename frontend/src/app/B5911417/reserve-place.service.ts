import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';

@Injectable({
  providedIn: 'root'
})
export class ReservePlaceService {

  constructor(private http: HttpClient) {}
  public API = '//localhost:8080';

  showAllPlaceEvent(): Observable<any> {
    return this.http.get('//localhost:8080/placeevent');
  }

  showAllSportEvent(): Observable<any> {
    return this.http.get('//localhost:8080/sportevent');
  }

  showAllStaff(): Observable<any> {
    return this.http.get('//localhost:8080/showstaff');
  }

  showAllReserve(): Observable<any> {
    return this.http.get('//localhost:8080/reserve');
  }
  showAllStores(): Observable<any> {
    return this.http.get('//localhost:8080/showstore');
  }
  showAllStoreType(): Observable<any> {
    return this.http.get('//localhost:8080/showstoretype');
  }

}
