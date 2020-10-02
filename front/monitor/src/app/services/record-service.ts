import { Injectable } from "@angular/core";
import { Record } from "../model/record";
import { HttpClient } from "@angular/common/http";
import { map } from "rxjs/operators";
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class RecordService {

  public sortedRecords: Record[];

  constructor(private http: HttpClient) {

  }

  public getRecords(): Observable<Record[]> {
    return this.http.get<Record[]>('/api/records').pipe(
      map(records => {
        return records.map(r => {
          r.date = new Date(r.date);
          return r;
        })
      }),
      map(records => { 
        return records.sort((a: Record, b: Record) => this.sortRecords(a, b)); 
      })
    );
  }

  private sortRecords(a: Record, b: Record) {
    if (a.date > b.date) {
      return 1;
    } else if (a.date.getTime() == b.date.getTime()) {
      return 0;
    } else {
      return -1
    }
  }


  addRecord(record: Record) {
    return this.http.post('/api/records', record);  
  }

}
