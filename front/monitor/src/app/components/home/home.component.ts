import { Component, OnInit } from '@angular/core';
import { Record } from 'src/app/model/record';
import { RecordService } from 'src/app/services/record-service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.scss']
})
export class HomeComponent implements OnInit {

  showId = true;
  records: Record[];

  constructor(public recordsSvc: RecordService) { }

  ngOnInit(): void {
    this.fetchRecords();
  }

  fetchRecords() {
    this.recordsSvc.getRecords().subscribe(records => {
      this.records = records;
    })
  }

  toggleId() {
    this.showId = !this.showId;
  }

  createRecord(record: Record) {
    this.recordsSvc.addRecord(record).subscribe( () => {
      this.fetchRecords();
    });    
  }

}
