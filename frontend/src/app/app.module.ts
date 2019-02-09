import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import {MatFormFieldModule} from '@angular/material/form-field';
import {MatSelectModule} from '@angular/material/select';
import {
  MatCheckboxModule,
  MatAutocompleteModule,
  MatDatepickerModule,
  MatRadioModule,
  MatSlideToggleModule,
  MatSliderModule,
  MatMenuModule,
  MatGridListModule,
  MatSidenavModule,
  MatStepperModule,
  MatPaginatorModule,
  MatSortModule,
  MatTableModule,
  MatSnackBarModule,
  MatTooltipModule,
  MatDialogModule,
  MatProgressBarModule,
  MatProgressSpinnerModule,
  MatIconModule,
  MatChipsModule,
  MatButtonToggleModule,
  MatExpansionModule,
  MatTabsModule,
  MatNativeDateModule
} from '@angular/material';
import { AppComponent } from './app.component';
import { HttpClientModule } from '@angular/common/http';
import { MatButtonModule, MatCardModule, MatInputModule, MatListModule, MatToolbarModule } from '@angular/material';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { RouterModule, Routes } from '@angular/router';
import { SporteventComponent } from './B5910311/sportevent/sportevent.component';
import { PaymentComponent } from './B5926329/payment/payment.component';
import { CheckstatusComponent } from './B5926329/checkstatus/checkstatus.component';
import { MemberloginComponent } from './B5926329/memberlogin/memberlogin.component';
import { DepartmentComponent } from './B5909711/component/department/department.component';
import { DepartmentService } from './B5909711/service/department/department.service';
import { AccountComponent} from "./B5911189/account/account.component";
import { SponsorComponent } from './B5911189/sponsor/sponsor.component';
import {TableComponent} from "./B5911189/table/table.component";

//import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
//import { FormsModule } from '@angular/forms';
//import { RouterModule, Routes } from '@angular/router';
import { RegisterComponent } from './B5901890/component/register/register.component';
import { RegisterserviceService } from './B5901890/service/registerservice.service';
import { from } from 'rxjs';
import { ReservePlaceComponent } from './B5911417/reserve-place/reserve-place.component';
import { ReservePlaceService } from './B5911417/reserve-place.service';
import { SeePlaceXComponent } from './B5911417/see-place-x/see-place-x.component';

import { AllsporteventComponent } from './B5910311//allsportevent/allsportevent.component';
import { SporteventService } from './B5910311/sportevent.service';
import { AddeventComponent } from './B5910311/addevent/addevent.component';
import { ResultComponent } from './B5909711/component/result/result.component';
import { ResultService } from './B5909711/service/result/result.service';

import { EventdetailComponent } from './B5910311/eventdetail/eventdetail.component';
import { ProfileComponent } from './B5910311/profile/profile.component';
import { ProfiledetailComponent } from './B5910311/profiledetail/profiledetail.component';
import { UpdateeventComponent } from './B5910311/updateevent/updateevent.component';
import { UpdateprofileComponent } from './B5910311/updateprofile/updateprofile.component';


import { RegisterMComponent } from './B5901890/component/registerMedia/registermedia.component';

import { RegisterserMviceService } from './B5901890/serviceMedia/registerservicemedia.service';
import {SponsorService} from "./B5911189/Service/sponsor.service";
import { StableComponent } from './B5911189/stable/stable.component';




const appRoutes: Routes = [

    {
    path: 'payment',
    component: PaymentComponent
    }
    ,    {
      path: 'ReservePlace',
      component: ReservePlaceComponent
      }
      ,
      {
        path: 'SeePlaceX',
        component: SeePlaceXComponent
        }
        ,
    {
      path: 'memberlogin',
      component: MemberloginComponent
      }
    ,
    {
      path: 'checkstatus',
      component: CheckstatusComponent
    }
    ,
    {
      path: 'sportevent',
      component: SporteventComponent
    },
    {
      path: 'Department',
      component: DepartmentComponent
    },
    {
      path: 'RegisterStaff',
      component:RegisterComponent
    },
    { path: 'account' , component: AccountComponent},
    { path: 'table' , component: TableComponent},{
      path: 'allsportevent',
      component: AllsporteventComponent
    },
    {
    path: 'stable',
    component:StableComponent
    },
    {
      path: 'addevent',
      component: AddeventComponent
    },
    {
    path: 'sponsor',
    component: SponsorComponent
    },
    {
      path: 'Result',
      component: ResultComponent
    },
    {
      path: 'updateevent',
      component: UpdateeventComponent
    },
    {
      path: 'profile',
      component: ProfileComponent
    },
    {
      path: 'updateprofile',
      component: UpdateprofileComponent
    }
    ,
    {
      path: 'profiledetail',
      component: ProfiledetailComponent
    },
    {
      path: 'eventdetail/:seid',
      component: EventdetailComponent
    },


    {
      path: 'RegisterMedia',
      component:RegisterMComponent}

];

@NgModule({
  declarations: [
    AppComponent,
    SporteventComponent,
    PaymentComponent,
    CheckstatusComponent,
    MemberloginComponent,
    AppComponent,
    DepartmentComponent,
    RegisterComponent,
    AccountComponent,
    TableComponent,
    ReservePlaceComponent,
    SeePlaceXComponent,
    AllsporteventComponent,
    AddeventComponent,
    ResultComponent,
    EventdetailComponent,
    ProfileComponent,
    ProfiledetailComponent,
    UpdateeventComponent,
    UpdateprofileComponent,
    RegisterMComponent,
    SponsorComponent,
    StableComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    BrowserAnimationsModule,
    MatButtonModule,
    MatCardModule,
    MatInputModule,
    MatListModule,
    MatSelectModule,
    MatToolbarModule,
    FormsModule,
    MatSelectModule,
    MatFormFieldModule,
    RouterModule.forRoot(appRoutes),
    BrowserAnimationsModule,
    MatButtonModule,
    MatCardModule,
    MatInputModule,
    MatListModule,
    MatToolbarModule,
    FormsModule,
    RouterModule.forRoot(appRoutes),
    MatCheckboxModule,
    MatAutocompleteModule,
    MatDatepickerModule,
    MatFormFieldModule,
    MatRadioModule,
    MatSelectModule,
    MatSliderModule,
    MatSlideToggleModule,
    MatMenuModule,
    MatSidenavModule,
    MatGridListModule,
    MatCardModule,
    MatStepperModule,
    MatTabsModule,
    MatExpansionModule,
    MatNativeDateModule,
    MatButtonToggleModule,
    MatChipsModule,
    MatIconModule,
    MatProgressSpinnerModule,
    MatProgressBarModule,
    MatDialogModule,
    MatTooltipModule,
    MatSnackBarModule,
    MatTableModule,
    MatSortModule,
    MatPaginatorModule,
    RouterModule.forRoot(appRoutes),
    ReactiveFormsModule
  ],
  providers: [SporteventService,DepartmentService,RegisterserviceService, ReservePlaceService,ResultService,RegisterserMviceService,SponsorService],
  bootstrap: [AppComponent]
})
export class AppModule { }
