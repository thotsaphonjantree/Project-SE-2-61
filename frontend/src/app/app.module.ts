import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import {MatFormFieldModule} from '@angular/material/form-field';
import {MatSelectModule} from '@angular/material/select';

import { AppComponent } from './app.component';
import { HttpClientModule } from '@angular/common/http';
import { MatButtonModule, MatCardModule, MatInputModule, MatListModule, MatToolbarModule } from '@angular/material';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { FormsModule } from '@angular/forms';
import { RouterModule, Routes } from '@angular/router';
import { SporteventComponent } from './B5910311/sportevent/sportevent.component';
import { PaymentComponent } from './B5926329/payment/payment.component';
import { CheckstatusComponent } from './B5926329/checkstatus/checkstatus.component';
import { MemberloginComponent } from './B5926329/memberlogin/memberlogin.component';



const appRoutes: Routes = [

    {
    path: 'payment',
    component: PaymentComponent
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
    }
];

@NgModule({
  declarations: [
    AppComponent,
    SporteventComponent,
    PaymentComponent,
    CheckstatusComponent,
    MemberloginComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    BrowserAnimationsModule,
    MatButtonModule,
    MatCardModule,
    MatInputModule,
    MatListModule,
    MatToolbarModule,
    FormsModule,
    MatSelectModule,
    MatFormFieldModule,
    RouterModule.forRoot(appRoutes)
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
