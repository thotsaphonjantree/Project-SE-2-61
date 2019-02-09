import { Component, OnInit } from '@angular/core';
import { ReservePlaceService } from '../reserve-place.service';
import { HttpClient} from '@angular/common/http';

@Component({
  selector: 'app-see-store',
  templateUrl: './see-store.component.html',
  styleUrls: ['./see-store.component.css']
})
export class SeeStoreComponent implements OnInit {
  storeUI: Array<any>;
  constructor(private reservePlaceService: ReservePlaceService, private httpClient: HttpClient) { }

  ngOnInit() {
    this.reservePlaceService.showAllStores().subscribe(data => {
      this.storeUI = data;
  });

  }

}
