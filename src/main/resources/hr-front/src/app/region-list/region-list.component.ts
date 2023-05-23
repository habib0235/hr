import { Component, OnInit } from '@angular/core';
import { Region } from '../model/region';
import { RegionService } from '../services/region-service';

@Component({
  selector: 'app-region-list',
  templateUrl: './region-list.component.html',
  styleUrls: ['./region-list.component.css']
})
export class RegionListComponent implements OnInit {

  constructor(private regionService: RegionService) { }

  ngOnInit(): void {
    this.getRegionList();
  }

  regionList: Region[] = [];
  selectedRegion = {};

  getRegionList(): void {
    this.regionService.getRegionList()
      .subscribe(regionList => {
        this.regionList = regionList; console.log(regionList);
        this.selectedRegion = this.regionList[0];
      });
  }

}
