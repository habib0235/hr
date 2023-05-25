import { Component, OnInit, Input, Output, EventEmitter } from '@angular/core';
import { Region } from '../model/region';

@Component({
  selector: 'app-region-details',
  templateUrl: './region-details.component.html',
  styleUrls: ['./region-details.component.css']
})
export class RegionDetailsComponent implements OnInit {

  constructor() { }

  ngOnInit(): void {
  }

  @Input() region: Region = {};

  @Output() saveRegionEvent = new EventEmitter<Region>();
  @Output() cancelOperationEvent = new EventEmitter();


  cancelOperation(): void {
    this.cancelOperationEvent.emit();
  }

  saveRegion(region: Region) {
    this.saveRegionEvent.emit(region);
  }

}
