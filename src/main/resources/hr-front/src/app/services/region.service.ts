import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable, throwError } from 'rxjs';
import { catchError, retry } from 'rxjs/operators';
import { Region } from '../model/region';
import { Config } from '../shared/config';

@Injectable({
    providedIn: 'root',
})
export class RegionService {

    constructor(private http: HttpClient) { }

    private baseRegionsUrl = 'http://localhost:8080/regions';

    private options = Config.httpOptions;

    getRegionList(): Observable<Region[]> {
        const url = this.baseRegionsUrl + '/list';
        return this.http.get<Region[]>(url, this.options);
    }

    saveRegion(region: Region): Observable<Region> {
        if (region) {
            console.log('region being saved');
            const url = this.baseRegionsUrl + '/save';
            return this.http.post(url, region, this.options);
        }
        return new Observable();
    }
}