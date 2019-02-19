import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';

@Injectable({
  providedIn: 'root'
})
export class LoginmemberService {

  constructor(private http: HttpClient) { }

  authenticatedmember = false;
  setMemberLoginId(id){
    localStorage.setItem('key',id);
  }

  getMemberLoginId(){
    return localStorage.getItem('key');
  }

  MemberLogin(username: String, password: String): Observable<any> {
    return this.http.post('//localhost:8080/memberlogin/auth/'+ username + '/' + password , {});
 }
}
