import { Injectable } from '@angular/core';
import { Country } from '../model/country';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { Region } from '../model/region';

@Injectable({
  providedIn: 'root'
})
export class CountryService {

  constructor(private http: HttpClient) { }

  getCountryListAll(): Observable<Country[]> {
    return this.http.get<Country[]>('http://localhost:8080/countries/list');
  }

  getCountryListByRegion(region: Region): Observable<Country[]> {
    return this.http.get<Country[]>(`http://localhost:8080/countries/${region.id}/list`);
  }

  createCountry(country: Country): Observable<Country> {
    if (country) {
      return this.http.post('http://localhost:8080/countries/create', country);
    }
    return new Observable();
  }

  updateCountry(countryId?: string, country?: Country): Observable<Country> {
    if (country) {
      return this.http.put(`http://localhost:8080/countries/update/${countryId}`, country);
    }
    return new Observable();
  }
}
