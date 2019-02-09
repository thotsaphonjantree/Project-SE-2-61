import { Component, OnInit } from '@angular/core';
import { ReservePlaceService } from '../reserve-place.service';
import { HttpClient} from '@angular/common/http';

@Component({
  selector: 'app-event-store',
  templateUrl: './event-store.component.html',
  styleUrls: ['./event-store.component.css']
})
export class EventStoreComponent implements OnInit {

  storename: '';
  eventII: '';
  octime: '';
  storetype: '';
  storetel: '';
  staffI: '';
  eventUI: Array<any>;
  storetypeUI: Array<any>;
  staffUI: Array<any>;
  constructor(private reservePlaceService: ReservePlaceService, private httpClient: HttpClient) { }

  ngOnInit() {
    this.reservePlaceService.showAllSportEvent().subscribe(data => {
      this.eventUI = data;
    });

    this.reservePlaceService.showAllStoreType().subscribe(data => {
      this.storetypeUI = data;
    });
    this.reservePlaceService.showAllStaff().subscribe(data => {
      this.staffUI = data;
    });

  }

  save() {
    if (this.storename === '' ||
        this.eventII === undefined ||
        this.octime === '' ||
        this.storetype === undefined ||
        this.storetel === '') {
    alert('กรุณากรอกข้อมูลให้ครบถ้วน');
    } else {
        this.httpClient.post('http://localhost:8080/store/create/' + this.storename + '/' + this.eventII + '/'
         + this.octime + '/' + this.storetel + '/' + this.storetype + '/' + this.staffI, null).subscribe(
        data => {
            console.log('PUT Request is successful', data);
        },
        error => {
            console.log('---Error----', error);
            // window.location.reload();
        }
        );
      }
  }

}
