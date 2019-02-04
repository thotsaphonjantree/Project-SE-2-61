import { Component, OnInit } from '@angular/core';
import { ResultService } from '../../service/result/result.service';
import { Router } from '@angular/router';
import { HttpClient } from '@angular/common/http';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Observable } from 'rxjs/observable';
import { DataSource } from '@angular/cdk/collections';

export interface PeriodicElement {
  name: string;
  position: number;
  weight: number;
  symbol: string;
}

const ELEMENT_DATA: PeriodicElement[] = [
  {position: 1, name: 'Hydrogen', weight: 1.0079, symbol: 'H'},
  {position: 2, name: 'Helium', weight: 4.0026, symbol: 'He'},
  {position: 3, name: 'Lithium', weight: 6.941, symbol: 'Li'},
  {position: 4, name: 'Beryllium', weight: 9.0122, symbol: 'Be'},
  {position: 5, name: 'Boron', weight: 10.811, symbol: 'B'},
  {position: 6, name: 'Carbon', weight: 12.0107, symbol: 'C'},
  {position: 7, name: 'Nitrogen', weight: 14.0067, symbol: 'N'},
  {position: 8, name: 'Oxygen', weight: 15.9994, symbol: 'O'},
  {position: 9, name: 'Fluorine', weight: 18.9984, symbol: 'F'},
  {position: 10, name: 'Neon', weight: 20.1797, symbol: 'Ne'},
];



@Component({
  selector: 'app-result',
  templateUrl: './result.component.html',
  styleUrls: ['./result.component.css']
})
export class ResultComponent implements OnInit {
  Activities: Array<any>;
  SportsType: Array<any>;
  Province: Array<any>;

  view: any = {
    activities: null,
    sportsType: null,
    inputName: null,
    inputDate: null,
    inputAddress: null,
    provin: null,
    rating: null

  }

  displayedColumns: string[] = ['position', 'name', 'weight', 'symbol'];
  dataSource = ELEMENT_DATA;
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
  }

  first(){
    this.view.rating = 'อันดับ1';
    console.log(this.view.rating);
  }

  second(){
    this.view.rating = 'อันดับ2';
    console.log(this.view.rating);
  }

  third(){
    this.view.rating = 'อันดับ3';
    console.log(this.view.rating);
  }

}
