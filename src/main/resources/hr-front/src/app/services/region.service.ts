import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable, throwError } from 'rxjs';
import { catchError, retry } from 'rxjs/operators';
import { Region } from '../model/region';

@Injectable({
    providedIn: 'root',
   })
export class RegionService {

    constructor(private http: HttpClient) { }

    getRegionList(): Observable<Region[]> {
        return this.http.get<Region[]>('http://localhost:8080/regions/list');
    }

    saveRegion(region: Region) : Observable<Region>{
        if(region) {
            console.log('region being saved');
            return this.http.post('http://localhost:8080/regions/save', region);
        }
        return new Observable();
    }
}