import { Component, OnInit } from '@angular/core';
import { Region } from '../model/region';
import { RegionService } from '../services/region.service';

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
  editRegion: Region = {};

  displayRegionDetails = false;

  getRegionList(): void {
    this.regionService.getRegionList()
      .subscribe(regionList => {
        this.regionList = regionList;
        this.editRegion = {};
      });
  }

  onRegionSelected(selectedRegion: Region): void {
    if (this.editRegion === selectedRegion) {
      this.editRegion = {};
      this.displayRegionDetails = false;
    } else {
      this.editRegion = selectedRegion;
      this.displayRegionDetails = true;
    }
  }

  newRegion() {
    this.editRegion = { id: -1};
    this.displayRegionDetails = true;
  }

  saveRegion(region: Region) {
    this.regionService.saveRegion(region)
    .subscribe(region => 
      {
        let indexToUpdate = this.regionList.findIndex(item => item.id === region.id);
        this.regionList[indexToUpdate] = region;
      });
    this.displayRegionDetails = false;
    this.getRegionList();
  }

  cancelRegionEdit() {
    this.displayRegionDetails = false;
  }

}
