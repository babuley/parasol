import { Component, Input, OnInit } from '@angular/core';
import { Record } from 'src/app/model/record';

@Component({
  selector: 'record-table',
  templateUrl: './record-table.component.html',
  styleUrls: ['./record-table.component.scss']
})
export class RecordTableComponent implements OnInit {

  @Input()
  showDetails:boolean = false;

  @Input()
  records:Record[];

  page = 1;
  pageSize = 10;

  constructor() { }

  ngOnInit(): void {
  }

}
