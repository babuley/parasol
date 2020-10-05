import { NumberValueAccessor } from '@angular/forms';

export class Record {
    id: number;
    customerId:string;
    accountId:string;
    when: Date;
    readingType: ReadingType;
    value: number;
   // recordedBy: string;
}


export class AggregateItem {
    constructor( public name:string, public value:number) {

    }
}

export enum ReadingType {gas = "gas", electricity = "electricity", water = "water"};