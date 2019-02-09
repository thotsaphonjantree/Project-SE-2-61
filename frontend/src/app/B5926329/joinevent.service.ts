import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';


@Injectable({
  providedIn: 'root'
})
export class JoineventService {

  constructor(private http: HttpClient) { }

  getMemberById(id){
    return this.http.get('//localhost:8080/member/'+id);
  }

  getEventById(Eid){
    return this.http.get('//localhost:8080/event/'+Eid);
  }

  getAllEvent(): Observable<any>{
    return this.http.get('//localhost:8080/event');
  }

  getAllExpertLevel(): Observable<any>{
    return this.http.get('//localhost:8080/expertlevels');
  }

  getJoineventByMember(mid): Observable<any>{
    return this.http.get('//localhost:8080/jointbymember/'+mid);
  }
 
}
