import { Component, OnInit } from '@angular/core';
import { ReservePlaceService } from '../reserve-place.service';
import { HttpClient} from '@angular/common/http';

@Component({
  selector: 'app-reserve-place',
  templateUrl: './reserve-place.component.html',
  styleUrls: ['./reserve-place.component.css']
})
export class ReservePlaceComponent implements OnInit {

  placeUI: Array<any>;
  staffUI: Array<any>;
  eventUI: Array<any>;

  Startdate: null;
  Enddate: null;

  eventI: '';
  placeI: '';
  staffI: '';

  text : String = ''

  constructor(private httpClient: HttpClient, private reservePlaceService: ReservePlaceService) {



   }

  ngOnInit() {
    this.reservePlaceService.showAllPlaceEvent().subscribe(data => {
      this.placeUI = data;
    });
    this.reservePlaceService.showAllSportEvent().subscribe(data => {
      this.eventUI = data;
    });
    this.reservePlaceService.showAllStaff().subscribe(data => {
      this.staffUI = data;
    });
  }

  save() {
    if (this.eventI === undefined ||
        this.placeI === undefined ||
        this.staffI === undefined ||
        this.Startdate === undefined ||
        this.Enddate === undefined) {
    this.text = "กรุณากรอกข้อมูลให้ครบถ้วน"
    } else {
        this.httpClient.post('http://localhost:8080/reserve/create/' + this.eventI + '/' + this.placeI + '/'
         + this.staffI + '/' + this.Startdate + '/' + this.Enddate, null).subscribe(
        data => {
            console.log('PUT Request is successful', data);
            this.text = "บันทึกข้อมูลสำเร็จ"
        },
        error => {
            console.log('---Error----', error);
             window.location.reload();
             this.text = "กรอกข้อมูลให้ถูกต้อง"
        }
        );
      }
  }

}
