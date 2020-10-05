import { Component, OnInit } from '@angular/core';
import { ReadingType, Record } from 'src/app/model/record';
import { RecordService } from 'src/app/services/record-service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.scss']
})
export class HomeComponent implements OnInit {

  showDetails = true;
  records: Record[];
  gasRecords: Record[];
  electricityRecords: Record[];
  waterRecords: Record[];

  constructor(public recordsSvc: RecordService) { }

  ngOnInit(): void {
    this.fetchRecords();

  }

  fetchRecords() {
    this.recordsSvc.getRecords().subscribe(records => {
      this.records = records;
      this.gasRecords = this.filterByResource(records, ReadingType.gas);
      this.electricityRecords = this.filterByResource(records, ReadingType.electricity);
      this.waterRecords = this.filterByResource(records, ReadingType.water);
    })
  }

  filterByResource(records:Record[], resource:ReadingType) {
    return records.filter(r => {      
      console.log(r.readingType, resource, r.readingType === resource);
        return r.readingType === resource;
    })
  }


  toggleDetails() {
    this.showDetails = !this.showDetails;
  }

  createRecord(record: Record) {
    this.recordsSvc.addRecord(record).subscribe( () => {
      this.fetchRecords();
    });    
  }

}
