import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';
import { Country } from '../model/country';

@Component({
  selector: 'app-country-details',
  templateUrl: './country-details.component.html',
  styleUrls: ['./country-details.component.css']
})
export class CountryDetailsComponent implements OnInit {

  constructor() { }

  ngOnInit(): void {

  }

  @Input() country: Country = {};
  @Input() addFlag: boolean = false;

  @Output() saveCountryEvent = new EventEmitter<Country>();
  @Output() cancelOperationEvent = new EventEmitter();


  cancelOperation(): void {
    this.cancelOperationEvent.emit();
  }

  saveCountry() {
    this.saveCountryEvent.emit(this.country);
  }

}
