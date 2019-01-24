import { Component, OnInit } from '@angular/core';
//import { RegisterserviceService } from '../service/registerservice.service';
import { RegisterserviceService } from '../../service/registerservice.service';
import { Router } from '@angular/router';
import { HttpClient} from '@angular/common/http';
import { DataSource } from '@angular/cdk/collections';
import { Observable } from 'rxjs/Observable';



export interface PeriodicElement {
  // nameRegisterStaff: string; //ชื่อ
  // kindName: string;     //work
  // sex: string;          //gender
  // room: number;         //age
  // num: number;          //tell
  nameRegisterStaff:string;
  genderStaff:{
    nameGender: string;
  }
  workStaff: {
    work: string;
  }
  ageStaff:{
    age: number;
  }
  tell:String;
}


@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css'],


})



export class RegisterComponent implements OnInit {
  displayedColumns: string[] = ['nameRegisterStaff','work','genderStaff','ageStaff','tell'];
  // displayedColumns: string[] = ['nameRegisterStaff', 'kindName', 'sex','room','num']; //ตารางโชว์
  dataSource = new HistoryDataSource(this.relatedService);

  refreshs: Array<any>;//รีเฟรชตารางเรียวไทม์
  works: Array<any>;  //ป้อนค่าจากUI //work
  genders: Array<any>;             //gender
  ages: Array<any>;
  register: Array<any>;
  view: any={
    KindWork:null,  
    Gender:null,  
    NameInput:null,
    TellInput:null,
    Age:null, 
  }


  constructor(private relatedService: RegisterserviceService , private httpClient: HttpClient,private router : Router) { }

  ngOnInit() {
    this.relatedService.getWork().subscribe(data => { 
      this.works = data;
      console.log(this.works);
    });
    
    this.relatedService.getGender().subscribe(data => { //getที่อยุ่service 
      this.genders = data; 
      console.log(this.genders);
    });

   
    this.relatedService.getAge().subscribe(data => {
      this.ages = data;
      console.log(this.ages);
    });
   
    

  }

  Save(){

    if (this.view.NameInput == null) { //จากhtml
      alert('กรุณากรอกชื่อสกุล');
    }
    else if (this.view.KindWork == null) {
      alert('กรุณาเลือกประเภทงาน');
    }
    else if (this.view.Gender == null) {
      alert('กรุณาเลือกเพศ');
    }
    else if ((this.view.TellInput == null)||((this.view.TellInput.toUpperCase() >= 'A')&&(this.view.TellInput.toUpperCase() <= 'Z'))||
            ((this.view.TellInput >= 'ก')&&(this.view.TellInput <= 'ฮ'))) { //จากhtml
      alert('กรุณาใส่เบอร์');
    }
    else if( this.view.Age == null){
      alert('กรุณาเลือกอายุ');
    }
    else{
      
        this.save_func();
        alert('บันทึกเรียบร้อย');
      }
  }
  save_func(){
    this.httpClient.get('http://localhost:8080/RegisterStaff/' +this.view.NameInput + '/' + this.view.KindWork + '/' 
    + this.view.Gender+ '/' + this.view.Age + '/' + this.view.TellInput, this.view)  //จากhtml
    .subscribe(
      data => {
          console.log('PUT Request is successful', data);
          this.refresh();
      },
      error => {
          console.log(this.view.NameInput);  //จากhtml
          console.log(this.view.KindWork);
          console.log(this.view.Gender);
        
          console.log(this.view.TellInput);
          console.log(this.view.Age);
          
           console.log('Rrror', error);
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
    constructor(private relatedService: RegisterserviceService ) {
     super();
    }
    connect(): Observable<History[]>{
     return this.relatedService.getRegisterStaff();   //getที่อยุ่service

    }
    disconnect(){}
 }

