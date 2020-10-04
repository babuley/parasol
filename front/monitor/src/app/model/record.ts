import { NumberValueAccessor } from '@angular/forms';

export class Record {
    id: number;
    customerId:string;
    accountId:string;
    when: Date;
    readingType: string;
    value: number;
   // recordedBy: string;
}