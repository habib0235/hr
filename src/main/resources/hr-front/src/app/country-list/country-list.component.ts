import { Component, Input, ViewChild } from '@angular/core';
import { MatPaginator } from '@angular/material/paginator';
import { MatTableDataSource } from '@angular/material/table';
import { CountryService } from '../services/country.service';
import { Country } from '../model/country';
import { Region } from '../model/region';

@Component({
  selector: 'app-country-list',
  templateUrl: './country-list.component.html',
  styleUrls: ['./country-list.component.css'],
})
export class CountryListComponent {

  constructor(private countryService: CountryService) { }

  ngOnInit(): void {
    this.getCountryList();
  }

  dataSource = new MatTableDataSource<Country>();
  displayedColumns: string[] = ['id', 'name', 'region'];
  @ViewChild(MatPaginator) paginator!: MatPaginator;
  editCountry: Country = {};

  displayCountryDetails = false;
  addFlag: boolean = true;

  @Input() region?: Region;

  ngOnChanges() {
    this.getCountryList();
  }

  getCountryList(): void {
    if (this.region) {
      this.countryService.getCountryListByRegion(this.region)
        .subscribe(countryList => {
          this.dataSource = new MatTableDataSource<Country>(countryList);
          this.dataSource.paginator = this.paginator;
          this.editCountry = {};
        });
    } else {
      this.countryService.getCountryListAll()
        .subscribe(countryList => {
          this.dataSource = new MatTableDataSource<Country>(countryList);
          this.dataSource.paginator = this.paginator;
          this.editCountry = {};
        });
    }
  }

  onCountrySelected(selectedCountry: Country): void {
    if (this.editCountry === selectedCountry) {
      this.editCountry = {};
      this.displayCountryDetails = false;
    } else {
      this.editCountry = selectedCountry;
      this.displayCountryDetails = true;
      this.addFlag = false;
    }
  }

  newCountry() {
    this.editCountry = {};
    this.displayCountryDetails = true;
    this.addFlag = true;
  }

  saveCountry(country: Country) {
    if (this.addFlag) {
      this.createCountry(country);
    } else {
      this.updateCountry(country.id, country);
    }
  }

  createCountry(country: Country) {
    this.countryService.createCountry(country)
      .subscribe(country => {
        this.dataSource.data.push(country);
        this.displayCountryDetails = false;
      });

  }

  updateCountry(countryId?: string, country?: Country) {
    this.countryService.updateCountry(countryId, country).subscribe(
      country => {
        let indexToUpdate = this.dataSource.data.findIndex(item => item.id === country.id);
        this.dataSource.data[indexToUpdate] = country;
        this.displayCountryDetails = false;
      });
  }

  cancelCountryEdit() {
    this.displayCountryDetails = false;
  }

}
