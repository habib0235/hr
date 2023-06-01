import { HttpClient } from '@angular/common/http';
import { of } from 'rxjs';
import { RegionService } from './region.service';
import { Region } from '../model/region';

let httpClientSpy: jasmine.SpyObj<HttpClient>;
let regionService: RegionService;
describe('CountryService', () => {
    beforeEach(() => {
        httpClientSpy = jasmine.createSpyObj('HttpClient', ['get']);
        regionService = new RegionService(httpClientSpy);
    });

    it('should return expected regions (HttpClient called once)', (done: DoneFn) => {
        const expectedRegions: Region[] =
            [
                { id: 1, name: 'Europe' },
                { id: 2, name: 'Americas' },
                { id: 3, name: 'Asia' },
                { id: 4, name: 'Middle East and Africa' },
                { id: 5, name: 'Wakanda nouli o"' }
            ];

        httpClientSpy.get.and.returnValue(of(expectedRegions));

        regionService.getRegionList().subscribe({
            next: regions => {
                expect(regions)
                    .withContext('expected regions')
                    .toEqual(expectedRegions);
                done();
            },
            error: done.fail
        });
        expect(httpClientSpy.get.calls.count())
            .withContext('one call')
            .toBe(1);
    });
});
