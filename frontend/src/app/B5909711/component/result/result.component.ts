import { Component, OnInit } from '@angular/core';
import { ResultService } from '../../service/result/result.service';
import { Router } from '@angular/router';
import { HttpClient } from '@angular/common/http';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Observable } from 'rxjs/observable';
import { DataSource } from '@angular/cdk/collections';

export interface PeriodicElement {
  resultID: number;
  resultName: string;
  resultAddress: string;
  resultDate: Date;
  sportsType: {
    sportName: string;
  }
  ratingEntity: {
    ratingName: string;
  }
  provinceEntity: {
    provinceName: string;
  }
  sportsEvent:{
    eventName: string;
  }
  personTypeEntity:{
    personTypeName: string;
  }
}

export class RoomdataSource extends DataSource<any>{
  constructor(private resultService:ResultService){
    super();
  }
  connect(): Observable<PeriodicElement[]> {
    console.log('Hey.Guy');
    return this.resultService.getShow();
  }
  disconnect(){}
}


@Component({
  selector: 'app-result',
  templateUrl: './result.component.html',
  styleUrls: ['./result.component.css']
})
export class ResultComponent implements OnInit {
  Activities: Array<any>;
  SportsType: Array<any>;
  Province: Array<any>;
  Rating: Array<any>;
  PersonType: Array<any>;
  room: Array<any>;
  DataSelect: Array<any>;

  view: any = {
    activities: null,
    sportsType: null,
    inputName: null,
    inputDate: null,
    inputAddress: null,
    provin: null,
    rating: null,
    personType: null,
    selectShow: null
  }

  refresh() {
    this.resultService.getShow().subscribe((res) => {
      this.room = res;
      this.dataSource = new RoomdataSource(this.resultService);
    });
  }

  displayedColumns: string[] = ['resultID','ratingName', 'resultName','resultAddress', 'provinceName','resultDate','sportName','eventName','personTypeName'];
  dataSource = new RoomdataSource(this.resultService);
  constructor(private resultService: ResultService, private httpClient: HttpClient, private router: Router, private _formBuilder: FormBuilder) { }

  ngOnInit() {
    this.resultService.getActivitiesName().subscribe(data => {
      this.Activities = data;
      console.log(this.Activities);
    });

    this.resultService.getSportstype().subscribe(data => {
      this.SportsType = data;
      console.log(this.SportsType);
    });

    this.resultService.getProvinceName().subscribe(data => {
      this.Province = data;
      console.log(this.Province);
    });

    this.resultService.getRatingName().subscribe(data => {
      this.Rating = data;
      console.log(this.Rating);
    });

    this.resultService.getPersonTypeName().subscribe(data => {
      this.PersonType = data;
      console.log(this.PersonType);
    });
  }

  Save() {
    if (this.view.activities == null) {
      alert('กรุณาเลือกชื่อกิจกรรม');
    }
    else if (this.view.sportsType == null) {
      alert('กรุณาเลือกชนิดกีฬา');
    }
    else if(this.view.inputName == null) {
      alert('กรุณาระบุชื่อ');
    }
    else if(this.view.rating == null) {
      alert('กรุณาเลือกอันดับ');
    }
    else if (this.view.personType == null) {
      alert('กรุณาเลือกประเภทบุคคล');
    }
    else if(this.view.inputDate == null) {
      alert('กรุณาระบุวันที่และเวลา');
    }
    else if(this.view.inputAddress == null) {
      alert('กรุณาระบุที่อยู่สถานที่แข่ง');
    }
    else if(this.view.provin == null) {
      alert('กรุณาระบุจังหวัด');
    }
    else{
      this.save_func();
    }
    
    console.log('activities', this.view.activities)
    console.log('sportsType', this.view.sportsType)
    console.log('inputName', this.view.inputName)
    console.log('rating', this.view.rating)
    console.log('personType', this.view.personType)
    console.log('inputDate', this.view.inputDate)
    console.log('inputAddress', this.view.inputAddress)
    console.log('provin', this.view.provin)
  }
  save_func() {this.httpClient.get('http://localhost:8080/Result/' + this.view.activities + '/' + this.view.sportsType + '/' + this.view.inputName + '/' + this.view.rating + '/' + this.view.personType + '/' + this.view.inputDate + '/' + this.view.inputAddress + '/' + this.view.provin, this.view)
      .subscribe(
        data => {
          console.log('PUT Request is successfully', data);
          this.refresh();
        },
        error => {
          console.log('Error', error);
        }
      );
  }

  SelectShow(){
    console.log('Hello NS');
    if(this.view.selectShow == null){
      this.dataSource = new RoomdataSource(this.resultService);
    }
    else {
      this.resultService.getSelectShow(this.view.selectShow)
      .subscribe(res =>{
        this.dataSource = res;
        console.log(this.dataSource);
      })
    }  
  } 
}
