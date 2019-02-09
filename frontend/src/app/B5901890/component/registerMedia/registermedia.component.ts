//import { Component, OnInit } from '@angular/core';

import { Component, OnInit } from '@angular/core';
//import { RegisterserviceService } from '../service/registerservice.service';
import { RegisterserMviceService } from '../../serviceMedia/registerservicemedia.service';
import { Router } from '@angular/router';
import { HttpClient} from '@angular/common/http';
import { DataSource } from '@angular/cdk/collections';
import { Observable } from 'rxjs/Observable';

export interface PeriodicElement {

nameMediaM:string;
genderMedia:{
nameGender: string;
}
kindMedia: {
kind_Media: string;
}
kindSport:{
kind_Sport: string;
}
nameCopany: String;
nameTel: String;
}


@Component({
  selector: 'app-register',
  templateUrl: './registermedia.component.html',
  styleUrls: ['./registermedia.component.css'],

})

export class RegisterMComponent implements OnInit {
  displayedColumns: string[] = ['nameMedia','kindMedia','genderMedia','kindSport','nameCopany','nameTel'];  //ตารางโชว์
  //มาจากHTMLตารางโชว์ matColumnDef="nameMedia" // matColumnDef="kindMedia"

  dataSource = new HistoryDataSource(this.relatedService);

  refreshs: Array<any>;//รีเฟรชตารางเรียวไทม์

  kindMedias: Array<any>;  //ป้อนค่าจากUI  //HTML ตรง *ngFor="let kind of kindMedias"
  genders: Array<any>;                   //*ngFor="let gender of genders"
  KindSports: Array<any>;
  register: Array<any>;
  view: any={
    KindMediaInput:null,
    Gender:null,
    NameInput:null,
    NameCompanyInput:null,
    KindSport:null,
    TelInput:null,
  }


  constructor(private relatedService: RegisterserMviceService , private httpClient: HttpClient,private router : Router) { }
  ngOnInit() {
    this.relatedService.getKindMedia().subscribe(data => { //getที่อยุ่service
      this.kindMedias = data;
      console.log(this.kindMedias);
    });

    this.relatedService.getGender().subscribe(data => {
      this.genders = data;
      console.log(this.genders);
    });

    this.relatedService.getKindSportMedia().subscribe(data => {
      this.KindSports = data;
      console.log(this.KindSports);
    });
  }

  Save(){

    if ((this.view.NameInput == null)||(this.view.NameInput >= '0')&&(this.view.NameInput <= '9')) { //จากhtml
      alert('กรุณากรอกชื่อสกุล');
    }
    else if (this.view.KindMediaInput == null) {//จากhtml
      alert('กรุณาเลือกประเภทสื่อ');
    }
    else if (this.view.Gender == null) {
      alert('กรุณาเลือกเพศ');
    }
    else if (this.view.NameCompanyInput == null) {
      alert('กรุณาชื่อบริษัท');
    }
    else if( this.view.KindSport == null){
      alert('กรุณาเลือกประเภทกีฬา');
    }
   // else if( this.view.TelInput == null){
    //  alert('กรุณาเกรอเบอร์');
    //}
    else if ((this.view.TelInput == null)||((this.view.TelInput.toUpperCase() >= 'A')&&(this.view.TelInput.toUpperCase() <= 'Z'))||
            ((this.view.TelInput >= 'ก')&&(this.view.TelInput <= 'ฮ'))) { //จากhtml
    alert('กรุณาใส่เบอร์');
    }
    else{

        this.save_func();

      }
  }
  save_func(){
    this.httpClient.get('http://localhost:8080/RegisterMedia/' +this.view.NameInput + '/' + this.view.KindMediaInput + '/'
    + this.view.Gender+ '/' + this.view.KindSport + '/' + this.view.NameCompanyInput + '/' + this.view.TelInput , this.view)  //จากhtml ตรงview.
    .subscribe(
      data => {
          console.log('PUT Request is successful', data);
          this.refresh();alert('บันทึกเรียบร้อย');
      },
      error => {
          console.log(this.view.NameInput);  //จากhtml
          console.log(this.view.KindMediaInput);
          console.log(this.view.Gender);
          console.log(this.view.KindSport);
          console.log(this.view.NameCompanyInput);

          console.log(this.view.telInput);


           console.log('Rrror', error);
alert('Error');
     }
);
    }

    refresh() { //รีเฟรชตารางเรียวไทม์
      this.relatedService.getShow().subscribe((res) => {
        this.refreshs = res;
        this.dataSource = new HistoryDataSource(this.relatedService);
      });
    }




  }
  export class HistoryDataSource extends DataSource<any> {
    constructor(private relatedService: RegisterserMviceService ) {
     super();
    }
    connect(): Observable<History[]>{
     return this.relatedService.getRegisterMedia();   //getที่อยุ่service

    }
    disconnect(){}
 }

