import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';

import { AppComponent } from './app.component';
import { HomeComponent } from './components/home/home.component';
import {CommonModule} from '@angular/common';
import { FormsModule} from '@angular/forms';

import "../styles.scss";
import { NewRecord } from './components/new-record/new-record.component';
import { HttpClientModule } from '@angular/common/http';
import { LoginComponent } from './components/login/login.component';
import { RecordInfoComponent } from './components/record-info/record-info.component';
import { RecordTableComponent } from './components/home/record-table/record-table.component';
import { DashboardComponent } from './components/dashboard/dashboard.component';
import { NgxChartsModule }from '@swimlane/ngx-charts'; 
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    NewRecord,
    LoginComponent,
    RecordInfoComponent,
    RecordTableComponent,
    DashboardComponent
  ],
  imports: [
    BrowserModule,
    BrowserAnimationsModule,        
    AppRoutingModule,
    CommonModule,
    FormsModule,
    HttpClientModule,
    NgxChartsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
