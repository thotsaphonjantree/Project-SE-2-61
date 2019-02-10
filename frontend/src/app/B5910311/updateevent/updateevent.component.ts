import { Component, OnInit } from '@angular/core';
import { SporteventService } from '../sportevent.service';
import { HttpClient } from '@angular/common/http';
import { Router } from '@angular/router';
import { ActivatedRoute } from '@angular/router';



@Component({
  selector: 'app-updateevent',
  templateUrl: './updateevent.component.html',
  styleUrls: ['./updateevent.component.css']
})
export class UpdateeventComponent implements OnInit {
    eventnames:Array<any>;
    eventstaffs:Array<any>;
    locations:Array<any>;
    stypes:Array<any>;

    update:object;
    
    my : any = {
      eventstaffs:'',
      locations:'',
      stypes:'',
      eventnames:'',
      detail:'',
      prices:''
    }
    view: any = {
      seid: null,
      eventstaff:null,
      location:null,
      stype:null,
      eventname:null,
      detail:null,
      price:null
    }
    text : String = ''
      constructor(private sporteventService: SporteventService,private httpClient:HttpClient,private router : Router,private route: ActivatedRoute) {
        this.route.params.subscribe( params => this.update = params.seid)
       }
    
      ngOnInit() {

        this.sporteventService.showAllSportsEvent().subscribe(data => {this.eventnames = data;})
    
        this.sporteventService.showAllEventStaff().subscribe(data => {this.eventstaffs = data;})
    
        this.sporteventService.showAllLocation().subscribe(data => {this.locations = data;})
    
        this.sporteventService.showAllSportTypes().subscribe(data => {this.stypes= data;})

        this.sporteventService.showEventById(this.update).subscribe(data => {this.update = data;})
    
      }

      edit(){
        if(this.view.seid === '' || this.view.eventname === null || this.view.detail === null || this.view.eventstaff === '' || this.view.price === null || this.view.stype === '' || this.view.location === '')
        this.text = "กรุณากรอกข้อมูลให้ครบถ้วน"
        else {
        this.httpClient.put('http://localhost:8080/updateevent/' +this.view.seid+'/'+ this.view.eventname + '/' + this.view.detail  +
         '/' + this.view.stype + '/' + this.view.location + '/' + this.view.eventstaff +'/'+ this.view.price,this.view)
    
          .subscribe(
            data => {
              if ( data ) {
                console.log('Success');
                this.text = "บันทึกสำเร็จ"
                // document.location.href = 'http://localhost:4200/allsportevent'; 
              }
            },
            error => {
              console.log('Error', error);
              this.text = "กรอกข้อมูลผิดพลาด"
            })
          }
      }
    
      
}
