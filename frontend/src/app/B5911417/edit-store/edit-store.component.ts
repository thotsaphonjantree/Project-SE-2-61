import { Component, OnInit } from '@angular/core';
import { ReservePlaceService } from '../reserve-place.service';
import { HttpClient} from '@angular/common/http';

@Component({
  selector: 'app-edit-store',
  templateUrl: './edit-store.component.html',
  styleUrls: ['./edit-store.component.css']
})
export class EditStoreComponent implements OnInit {

  my: any = {

    storeID: null,
    EstoreName: null,
    EeventII: null,
    Eoctime: null,
    Estoretype: null,
    Estoretel: null,
  }

  storeUI: Array<any>;
  // storeID: '';
  // EstoreName: '';
  // EeventII: '';
  // Eoctime: '';
  // Estoretype: '';
  // Estoretel: '';
  EeventUI: Array<any>;
  EstoretypeUI: Array<any>;
  staffUI: Array<any>;

  constructor(private reservePlaceService: ReservePlaceService, private httpClient: HttpClient) { }

  ngOnInit() {
    this.reservePlaceService.showAllStores().subscribe(data => {
      this.storeUI = data;

  });
  this.reservePlaceService.showAllSportEvent().subscribe(data => {
    this.EeventUI = data;
  });

  this.reservePlaceService.showAllStoreType().subscribe(data => {
    this.EstoretypeUI = data;
  });
  this.reservePlaceService.showAllStaff().subscribe(data => {
    this.staffUI = data;
  });

  }


  edit() {

    this.httpClient.put('http://localhost:8080/updateStore/' +  this.my.storeID + '/' + this.my.EstoreName + '/' + this.my.Eoctime  +
     '/' + this.my.EeventII + '/' + this.my.Estoretype + '/' + this.my.Estoretel , this.my)

      .subscribe(
        data => {
          if ( data ) {
            console.log('Success');
          }

        },
        error => {
        console.log('Uncomplete', error);
      }
      );
  }


}
