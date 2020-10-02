import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Record } from 'src/app/model/record';
import { RecordService } from 'src/app/services/record-service';

@Component({
  selector: 'app-record-info',
  templateUrl: './record-info.component.html',
  styleUrls: ['./record-info.component.scss']
})
export class RecordInfoComponent implements OnInit {

  record:Record;

  constructor(public recordSvc:RecordService, 
    private currentRoute: ActivatedRoute) { 
  
  }

  ngOnInit(): void {
    let id = +this.currentRoute.snapshot.params.id;
    this.recordSvc.getRecords().subscribe( records => {
      this.record = records.find(r => r.id === id);
    });

  }

}
