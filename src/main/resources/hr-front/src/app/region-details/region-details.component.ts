import { Component, OnInit, Input } from '@angular/core';
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

}
