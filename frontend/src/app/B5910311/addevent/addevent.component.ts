import { Component, OnInit } from '@angular/core';
import { SporteventService } from '../sportevent.service';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-addevent',
  templateUrl: './addevent.component.html',
  styleUrls: ['./addevent.component.css']
})
export class AddeventComponent implements OnInit {

eventstaffs:Array<any>;
locations:Array<any>;
stypes:Array<any>;

my : any = {
  eventstaff:'',
  location:'',
  stype:'',
  eventname:'',
  detail:'',
  price:''
}


  constructor(private sporteventService: SporteventService,private httpClient:HttpClient) { }

  ngOnInit() {

    this.sporteventService.showAllEventStaff().subscribe(data => {this.eventstaffs = data;})

    this.sporteventService.showAllLocation().subscribe(data => {this.locations = data;})

    this.sporteventService.showAllSportTypes().subscribe(data => {this.stypes= data;})

  }


  save(){

    if(this.my.eventname === '' || this.my.detail === '' || this.my.eventstaff === '' || this.my.price === '' || this.my.stype === '' || this.my.location === '')
    alert('กรุณากรอกข้อมูล');
    else {
      this.httpClient.post('http://localhost:8080/event/'+this.my.eventname+'/'+this.my.detail+'/'+this.my.stype+'/'+this.my.location+'/'+this.my.eventstaff+'/'+this.my.price,null).subscribe(
        data => {
            console.log('POST Request is successful', data);
        },
        error => {
          alert('บันทึกสำเร็จ');
          document.location.href = 'http://localhost:4200/allsportevent'; 
            console.log('Error', error);
        })
      }

}
  }


