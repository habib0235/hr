
import { Component, ViewChild } from '@angular/core';
import { MatPaginator } from '@angular/material/paginator';
import { MatTableDataSource } from '@angular/material/table';
import { Region } from '../model/region';
import { RegionService } from '../services/region.service';

@Component({
  selector: 'app-region-list',
  templateUrl: './region-list.component.html',
  styleUrls: ['./region-list.component.css']
})
export class RegionListComponent {

  constructor(private regionService: RegionService) { }

  dataSource = new MatTableDataSource<Region>();
  displayedColumns: string[] = ['id', 'name'];
  @ViewChild(MatPaginator) paginator!: MatPaginator;

  editRegion: Region = {};
  selectedRegion?: Region;
  displayRegionDetails = false;
  
  ngAfterViewInit() {
    this.getRegionList();
  }

  getRegionList(): void {
    this.regionService.getRegionList()
      .subscribe(regionList => {
        this.dataSource = new MatTableDataSource<Region>(regionList);
        this.dataSource.paginator = this.paginator;
        this.editRegion = {};
      });
  }

  onRegionSelected(selectedRegion: Region): void {
    if (this.editRegion === selectedRegion) {
      this.selectedRegion = undefined;
      this.editRegion = {};
      this.displayRegionDetails = false;
    } else {
      this.selectedRegion = selectedRegion;
      this.editRegion = selectedRegion;
      this.displayRegionDetails = true;
    }
  }

  newRegion() {
    this.editRegion = { id: -1 };
    this.displayRegionDetails = true;
  }

  saveRegion(region: Region) {
    this.regionService.saveRegion(region)
      .subscribe(region => {
        let indexToUpdate = this.dataSource.data.findIndex(item => item.id === region.id);
        this.dataSource.data[indexToUpdate] = region;
      });
    this.displayRegionDetails = false;
  }

  cancelRegionEdit() {
    this.displayRegionDetails = false;
  }

}
