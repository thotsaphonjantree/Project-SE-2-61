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

//import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
//import { FormsModule } from '@angular/forms';
//import { RouterModule, Routes } from '@angular/router';
import { RegisterComponent } from './B5901890/component/register/register.component';
import { RegisterserviceService } from './B5901890/service/registerservice.service';
import { from } from 'rxjs';


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
    },
    {
      path: 'Department',
      component: DepartmentComponent
    },
    {
      path: 'RegisterStaff',
      component:RegisterComponent
    }
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
    RegisterComponent
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
  providers: [DepartmentService,RegisterserviceService],
  bootstrap: [AppComponent]
})
export class AppModule { }
