import { Injectable } from '@angular/core';
import { Country } from '../model/country';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { Region } from '../model/region';
import { Config } from '../shared/config';

@Injectable({
  providedIn: 'root'
})
export class CountryService {

  constructor(private http: HttpClient) { }

  private baseCountriesUrl = 'http://localhost:8080/countries';

  private options = Config.httpOptions;

  getCountryListAll(): Observable<Country[]> {
    const url = this.baseCountriesUrl + '/list';
    return this.http.get<Country[]>(url, this.options);
  }

  getCountryListByRegion(region: Region): Observable<Country[]> {
    const url = `${this.baseCountriesUrl}/region/${region.id}`;
    return this.http.get<Country[]>(url, this.options);
  }

  createCountry(country: Country): Observable<Country> {
    if (country) {
      const url = this.baseCountriesUrl + '/create';
      return this.http.post(url, country, this.options);
    }
    return new Observable();
  }

  updateCountry(countryId?: string, country?: Country): Observable<Country> {
    if (country) {
      const url = `${this.baseCountriesUrl}/update/${countryId}`;
      return this.http.put(url, country, this.options);
    }
    return new Observable();
  }
}
