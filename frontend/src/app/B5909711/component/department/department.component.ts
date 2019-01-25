import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { DepartmentService } from '../../service/department/department.service';
import { HttpClient} from '@angular/common/http';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';
import { Observable } from 'rxjs/observable';
import { DataSource } from '@angular/cdk/collections';
import { CompileShallowModuleMetadata } from '@angular/compiler';

export interface PeriodicElement {
  relatedinformationID: number;
  relatedinformationName: string;
  relatedinformationAddress: string;
  relatedinformationPhone: string;
  relatedinformationEmail: string;
  relatedinformationDate: Date;
  agencyTypeEntity: {
    agencyName: string;
  }
  activitiesEntity: {
    activitiesName: string;
  }
  countryEntity: {
    countryName: string;
  }
  provinceEntity: {
    provinceName: string;
  }
  testEntity:{
    tActivities: string;
  }
}

export class RoomdataSource extends DataSource<any>{
  constructor(private departmentService: DepartmentService){
    super();
  }
  connect(): Observable<PeriodicElement[]> {
    console.log('Hey.Guy');
    return this.departmentService.getShow();
  }
  disconnect(){}
}

@Component({
  selector: 'app-department',
  templateUrl: './department.component.html',
  styleUrls: ['./department.component.css']
})
export class DepartmentComponent implements OnInit {
  room: Array<any>;
  AgencyType: Array<any>;
  Province: Array<any>;
  Country: Array<any>;
  Activities: Array<any>;
  Test: Array<any>;

  // startDate = new Date(1990, 0, 1);
  view: any = {
    ID: '',
    agent: '',
    provin: '',
    country: '',
    Nameoforganization: '',
    activities: '',
    inputTime: '',
    Addressagency: '',
    Inputdataphonenumber: '',
    Inputdatae_mail: '',
    test: ''
  }

  select: any = {
    selectID: '',
    selectAgent: '',
    selectProvin: '',
    selectCountry: '',
    selectNameoforganization: '',
    selectActivities: '',
    selectInputTime: '',
    selectAddressagency: '',
    selectInputdataphonenumber: '',
    selectDataE_mail: ''
  }

  save = false;
  stat :number = 0;
  isLinear = false;
  firstFormGroup: FormGroup;
  secondFormGroup: FormGroup;

  displayedColumns: string[] = ['relatedinformationID', 'activitiesName', 'agencyName','relatedinformationPhone', 'relatedinformationName','countryName','relatedinformationDate','provinceName','relatedinformationAddress','relatedinformationEmail'];
  dataSource = new RoomdataSource(this.departmentService);

  constructor(private departmentService: DepartmentService , private httpClient: HttpClient,private router : Router,private _formBuilder: FormBuilder) { }

  ngOnInit() {
    this.refresh();
    this.departmentService.getAgencyName().subscribe(data => {
      this.AgencyType = data;
      console.log(this.AgencyType);
    });

    this.departmentService.getCountryName().subscribe(data => {
      this.Country = data;
      console.log(this.Country);
    });

    this.departmentService.getProvinceName().subscribe(data => {
      this.Province = data;
      console.log(this.Province);
    });

    this.departmentService.getActivitiesName().subscribe(data => {
      this.Activities = data;
      console.log(this.Activities);
    });

    this.departmentService.getTName().subscribe(data => {
      this.Test = data;
      console.log(this.Test);
    });

    this.firstFormGroup = this._formBuilder.group({
      firstCtrl: ['', Validators.required]
    });

    this.secondFormGroup = this._formBuilder.group({
      secondCtrl: ['', Validators.required]
    });

  }

  refresh() {
    this.departmentService.getShow().subscribe((res) => {
      this.room = res;
      this.dataSource = new RoomdataSource(this.departmentService);
    });
  }

  selectRow(row){
    this.select.selectID = row.relatedinformationID;
    this.select.selectAgent = row.agencyTypeEntity.agencyName;
    this.select.selectActivities = row.activitiesEntity.activitiesName;
    this.select.selectCountry = row.countryEntity.countryName;
    this.select.selectNameoforganization = row.relatedinformationName;
    this.select.selectProvin = row.provinceEntity.provinceName;
    this.select.selectInputTime = row.relatedinformationDate;
    this.select.selectInputdataphonenumber = row.relatedinformationPhone;
    this.select.selectDataE_mail = row.relatedinformationEmail;
    this.select.selectAddressagency = row.relatedinformationAddress;

    this.view.ID = this.select.selectID;
    this.view.agent = this.select.selectAgent;
    this.view.activities = this.select.selectActivities;
    this.view.country = this.select.selectCountry;
    this.view.Nameoforganization = this.select.selectNameoforganization;
    this.view.provin = this.select.selectProvin;
    this.view.inputTime = this.select.selectInputTime;
    this.view.Inputdataphonenumber = this.select.selectInputdataphonenumber;
    this.view.Inputdatae_mail = this.select.selectDataE_mail;
    this.view.Addressagency = this.select.selectAddressagency;

    console.log('ID', this.select.selectID)
    console.log('agent', this.select.selectAgent)
    console.log('activities', this.select.selectActivities)
    console.log('provin', this.select.selectProvin)
    console.log('country', this.select.selectCountry)
    console.log('Nameoforganization', this.select.selectNameoforganization)
    console.log('Date', this.select.selectInputTime)
    console.log('Addressagency', this.select.selectAddressagency)
    console.log('Inputdataphonenumber', this.select.selectInputdataphonenumber)
    console.log('Inputdatae_mail', this.select.selectDataE_mail)
  }

  Stat(){
    if(this.stat == 0){
      this.stat++;
      this.save = !this.save;
      console.log('Hey NS',this.save);
    }
  }

  Save() {
    if (this.view.agent == null) {
      alert('กรุณาเลือกประเถทหน่วยงาน');
    }
    else if (this.view.activities == null) {
      alert('กรุณาเลือกชื่อกิจกรรม');
    }
    else if (this.view.provin == null) {
      alert('กรุณาเลือกจังหวัด');
    }
    else if(this.view.country == null) {
      alert('กรุณาเลือกประเทศ');
    }
    else if(this.view.Nameoforganization == null) {
      alert('กรุณาระบุชื่อหน่วยงาน');
    }
    else if(this.view.inputTime == '') {
      alert('กรุณาระบุวันที่และเวลา');
    }
    else if(this.view.Addressagency == null) {
      alert('กรุณาระบุที่อยู่หน่วยงาน');
    }
    else if(this.view.Inputdataphonenumber == null) {
      alert('กรุณาระบุเบอร์โทรศัพท์');
    }
    else if(this.view.Inputdatae_mail == null){
      alert('กรุณาระบุE-mail');
    }
    else if(this.save == false) {
      this.save_func();
    }
    else if(this.save == true){
      this.updateType();
    }
    
    console.log('agent', this.view.agent)
    console.log('agent', this.view.activities)
    console.log('provin', this.view.provin)
    console.log('country', this.view.country)
    console.log('Nameoforganization', this.view.Nameoforganization)
    console.log('Date', this.view.inputTime)
    console.log('Addressagency', this.view.Addressagency)
    console.log('Inputdataphonenumber', this.view.Inputdataphonenumber)
    console.log('Inputdatae_mail', this.view.Inputdatae_mail)
  }
  save_func() {this.httpClient.get('http://localhost:8080/RelatedInformation/' + this.view.agent + '/' + this.view.provin + '/' + this.view.country + '/' + this.view.Nameoforganization + '/' + this.view.Addressagency + '/' + this.view.inputTime + '/' + this.view.Inputdataphonenumber + '/' + this.view.Inputdatae_mail + '/' + this.view.activities, this.view)
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

  updateType(){
    this.httpClient.put('http://localhost:8080/updateRelatedInformation/'+  this.view.ID + '/' + this.view.Nameoforganization + '/' + this.view.inputTime  + '/' + this.view.Addressagency + '/' + this.view.Inputdataphonenumber + '/' + this.view.Inputdatae_mail + '/' + this.view.agent + '/' + this.view.country + '/' + this.view.provin + '/' + this.view.activities, this.view)

      .subscribe(
        data => {
          if(data){
            console.log('Success');
            this.refresh();
            this.stat--;
            this.save = !this.save;
          }
            
        },
        error =>{
        console.log('Uncomplete',error);
      }
      );
  }

  next(){
    this.router.navigate(['/']);
  }

}
