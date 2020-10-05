import { Component, OnInit, Output, EventEmitter } from '@angular/core';
import { Record } from 'src/app/model/record';


@Component({
  selector: 'new-record',
  templateUrl: './new-record.component.html',
  styleUrls: ['./new-record.component.scss']
})
export class NewRecord implements OnInit {

  @Output() record = new EventEmitter();

  model;

  constructor() { }

  ngOnInit(): void {
    this.resetForm();
  }

  addRecord() {
    let newRecord = Object.assign({}, this.model, {
      date: new Date(this.model.date)      
    });
    console.log(newRecord);
    console.log(this.model.date);
    this.record.emit(newRecord);
  }

  resetForm(){
    this.model = {};
  }

}
