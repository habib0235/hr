import { Component, OnInit } from '@angular/core';
import { CountryService } from '../services/country.service';
import { Country } from '../model/country';

@Component({
  selector: 'app-country-list',
  templateUrl: './country-list.component.html',
  styleUrls: ['./country-list.component.css']
})
export class CountryListComponent implements OnInit {


  constructor(private countryService: CountryService) { }

  ngOnInit(): void {
    this.getCountryList();
  }

  countryList: Country[] = [];
  editCountry: Country = {};

  displayCountryDetails = false;
  addFlag: boolean = true;

  getCountryList(): void {
    this.countryService.getCountryListAll()
      .subscribe(countryList => {
        this.countryList = countryList;
        this.editCountry = {};
      });
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
        this.countryList.push(country);
        this.displayCountryDetails = false;
      });

  }

  updateCountry(countryId?: string, country?: Country) {
    this.countryService.updateCountry(countryId, country).subscribe(
      country => {
        let indexToUpdate = this.countryList.findIndex(item => item.id === country.id);
        this.countryList[indexToUpdate] = country;
        this.displayCountryDetails = false;
      });
  }

  cancelCountryEdit() {
    this.displayCountryDetails = false;
  }

}
