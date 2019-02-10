import { Component, OnInit } from '@angular/core';
import { SporteventService } from '../sportevent.service';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-updateprofile',
  templateUrl: './updateprofile.component.html',
  styleUrls: ['./updateprofile.component.css']
})
export class UpdateprofileComponent implements OnInit {
  profile:Array<any>;
  adds:Array<any>;

  my : any = {
    memberId:null,
    name:null,
    username:null,
    password:null,
    pid:null,
    firstname:null,
    lastname:null,
    address:null
  }

  constructor(private sporteventService: SporteventService,private httpClient:HttpClient) { }

  ngOnInit() {
    this.sporteventService.showAlladdress().subscribe(data => {this.adds = data;})
    this.sporteventService.showAllProfile().subscribe(data => {this.profile = data;})
  }
  edit(){
    if(this.my.pid === '' || this.my.firstname === null || this.my.lastname === null || this.my.address === '' )
    alert('กรุณากรอกข้อมูล');
    else {
        this.httpClient.put('http://localhost:8080/updateprofile/'+this.my.pid+'/'+'/'+this.my.firstname+'/'+this.my.lastname+'/'+this.my.address ,this.my)
    
          .subscribe(
            data => {
              if ( data ) {
                console.log('Success');
                alert('บันทึกสำเร็จ');
                document.location.href = 'http://localhost:4200/profiledetail'; 
              }
    
            },
            error =>{
            console.log('Error', error);
          }
          )
      }
    }
}
