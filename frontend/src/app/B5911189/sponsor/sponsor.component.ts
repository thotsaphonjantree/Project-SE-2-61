import { Component, OnInit } from '@angular/core';
import { HttpClient} from '@angular/common/http';
import {SponsorService} from "../Service/sponsor.service";

@Component({
  selector: 'app-sponsor',
  templateUrl: './sponsor.component.html',
  styleUrls: ['./sponsor.component.css']
})
export class SponsorComponent implements OnInit {
  recordstatus: Array<any>;
  recordTransfer: Array<any>;
  views: any = {
    name: null,
    statusSelect: null,
    transferSelect: null,
    phonenumber: null,
    Address: null,
    amount: null
  };
  constructor(private sponsorService: SponsorService, private httpClient: HttpClient) { }

  ngOnInit() {
    this.sponsorService.getStatus().subscribe(data => {
      this.recordstatus = data;
      console.log(this.recordstatus);
    });

    this.sponsorService.getTransfer().subscribe(data => {
      this.recordTransfer = data;
      console.log(this.recordTransfer);
    });


  }

  Save() {
    if (this.views.name == null) {
      alert('กรุณากรอกชื่อ');
    } else if (this.views.statusSelect == null) {
      alert('กรุณาระบุสถานะ');
    } else if (this.views.transferSelect == null) {
      alert('กรุณาระบุรับมอบ');
    }else if (this.views.amount == null) {
      alert('กรุณาจำนวนเงิน');
    } else if (this.views.phonenumber == null) {
      alert('กรุณากรอกเบอร์โทรศัพท์');
    } else if (this.views.Address == null) {
      alert('กรุณากรอกที่อยู่');
    }  else {
      this.SaveData();
      alert('บันทึกเรียบร้อย');
    }
  }
  SaveData() {
    this.httpClient.get('http://localhost:8080/SponsorRegis/'+ this.views.name + '/' + this.views.statusSelect  + '/'  + this.views.Address  + '/' + this.views.transferSelect + '/' + this.views.amount+ '/' + this.views.phonenumber , this.views)
      .subscribe(
        data => {
          console.log('PUT Request is successful', data);
        },
        error => {
          console.log(this.views.name);
          console.log(this.views.statusSelect);
          console.log(this.views.Address);
          console.log(this.views.transferSelect);
          console.log(this.views.amount);
          console.log(this.views.phonenumber);
          console.log('Error', error);
        }
      );
  }



}
