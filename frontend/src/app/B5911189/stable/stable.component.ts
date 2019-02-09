import { Component, OnInit } from '@angular/core';
import {DataSource} from "../../../../node_modules/@angular/cdk/collections";
import {Observable} from "../../../../node_modules/rxjs/Observable";
import {SponsorService} from "../Service/sponsor.service";


export interface SponsorTable {

  idSponsorRegis: number;
  phonenumber : string;
  nameSponsorRegis: string;


  sponsorStatus:{
  nameStatus: string;
}
  address: string;
  transfer:{
    nameTransfer: string;
  }
  amount: string;

}
@Component({
  selector: 'app-stable',
  templateUrl: './stable.component.html',
  styleUrls: ['./stable.component.css']
})


export class StableComponent implements OnInit {

  displayedColumns: string[] = ['idSponsorRegis','nameSponsorRegis', 'nameStatus', 'address', 'nameTransfer' , 'amount','phonenumber'];
  dataSource = new Sponsor(this.SponsorService);
  constructor(private SponsorService: SponsorService) { }

  ngOnInit() {
  }
}

export class Sponsor extends DataSource<any> {
  constructor(private SponsorService: SponsorService) {
    super();
  }
  connect(): Observable<SponsorTable[]> {
    return this.SponsorService.getRoom();
  }
  disconnect() {}
}
