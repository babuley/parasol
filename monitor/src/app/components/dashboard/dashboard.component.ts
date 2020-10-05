import { Component, OnInit } from '@angular/core';
import { AggregateItem, ReadingType, Record } from 'src/app/model/record';
import { RecordService } from 'src/app/services/record-service';

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.scss']
})
export class DashboardComponent implements OnInit {
 
  readingTypes:ReadingType[] = [ReadingType.gas, ReadingType.electricity, ReadingType.water];

  records: Record[];
  gasRecords: Record[];
  electricityRecords: Record[];
  waterRecords: Record[];

  aggregatedItems: AggregateItem[];

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

      this.aggregatedItems = this.aggregateRecord(this.records);
    })
  }
  
  

  aggregateRecord(rgds:Record[]) {
    let items = [];    

    this.readingTypes.forEach( rt => {
       let subset = this.filterByResource(rgds, rt);
       let rsum = subset.map( r=> {return Number(r.value);}).reduce( 
        (accu, c) => {return accu + c;}, 0);
        let ai = new AggregateItem(rt.toString(), rsum);
        items.push(ai);
    });
    return items;    
  }

  filterByResource(records:Record[], resource:ReadingType) {
    return records.filter(r => {
        return r.readingType === resource;
    })
  }
}
