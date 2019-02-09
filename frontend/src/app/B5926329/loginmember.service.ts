import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';

@Injectable({
  providedIn: 'root'
})
export class LoginmemberService {

  constructor() { }

  setMemberLoginId(id){
    localStorage.setItem('key',id);
  }

  getMemberLoginId(){
    return localStorage.getItem('key');
  }
}
