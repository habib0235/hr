import { HttpClient } from '@angular/common/http';
import { of } from 'rxjs';
import { CountryService } from './country.service';
import { Country } from '../model/country';

let httpClientSpy: jasmine.SpyObj<HttpClient>;
let countryService: CountryService;
describe('CountryService', () => {
    beforeEach(() => {
        httpClientSpy = jasmine.createSpyObj('HttpClient', ['get']);
        countryService = new CountryService(httpClientSpy);
    });

    it('should return expected countries (HttpClient called once)', (done: DoneFn) => {
        const expectedCountries: Country[] =
            [{ id: 'BE', name: 'Belgium', region: {id: 1, name: 'Europe'}}, { id: 'BR', name: 'Brazil' , region: {id: 2, name: 'Americas'}}];

        httpClientSpy.get.and.returnValue(of(expectedCountries));

        countryService.getCountryListAll().subscribe({
            next: countries => {
                expect(countries)
                    .withContext('expected countries')
                    .toEqual(expectedCountries);
                done();
            },
            error: done.fail
        });
        expect(httpClientSpy.get.calls.count())
            .withContext('one call')
            .toBe(1);
    });
});
