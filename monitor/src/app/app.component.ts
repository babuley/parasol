import { Component } from '@angular/core';
import { IdentityService } from './services/identity.service';
import { RecordService } from './services/record-service';

@Component({
  selector: 'parasol',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent {
  title = 'monitor';


  constructor(public recordsSvc: RecordService    ) {

  }

  ngOnInit() {

  }

}
