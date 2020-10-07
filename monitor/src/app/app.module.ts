import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';

import { AppComponent } from './app.component';
import { HomeComponent } from './components/home/home.component';
import {CommonModule} from '@angular/common';
import { FormsModule} from '@angular/forms';

import "../styles.scss";
import { NewRecord } from './components/new-record/new-record.component';
import { HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';
import { LoginComponent } from './components/login/login.component';
import { RecordInfoComponent } from './components/record-info/record-info.component';
import { RecordTableComponent } from './components/home/record-table/record-table.component';
import { DashboardComponent } from './components/dashboard/dashboard.component';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { NgxChartsModule }from '@swimlane/ngx-charts'; 
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';

import { AuthHttpInterceptor, AuthModule } from '@auth0/auth0-angular';
import { NavbarComponent } from './components/navbar/navbar.component';
import { environment as env } from '../environments/environment';
import { FontAwesomeModule } from '@fortawesome/angular-fontawesome';
import { ProfileComponent } from './components/profile/profile.component';
import { FooterComponent } from './components/footer/footer.component';

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    NewRecord,
    LoginComponent,
    RecordInfoComponent,
    RecordTableComponent,
    DashboardComponent,
    NavbarComponent,
    ProfileComponent,
    FooterComponent
  ],
  imports: [
    BrowserModule,
    BrowserAnimationsModule,        
    AppRoutingModule,
    CommonModule,
    FormsModule,
    HttpClientModule,
    NgbModule,
    NgxChartsModule,
    FontAwesomeModule,
    AuthModule.forRoot({
      ...env.auth,
      httpInterceptor: {
        ...env.httpInterceptor,
      },
    }),
  ],
  providers: [{
    provide: HTTP_INTERCEPTORS,
    useClass: AuthHttpInterceptor,
    multi: true,
  }],
  bootstrap: [AppComponent]
})
export class AppModule { }
