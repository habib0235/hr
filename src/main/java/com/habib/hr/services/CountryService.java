package com.habib.hr.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.habib.hr.dto.CountryDTO;
import com.habib.hr.entities.Country;
import com.habib.hr.entities.Region;
import com.habib.hr.repositories.CountryRepository;
import com.habib.hr.repositories.RegionRepository;

@Service
public class CountryService {

	@Autowired
	private CountryRepository repository;

	@Autowired
	private RegionRepository regionRepository;

	@Autowired
	private SharedService sharedService;

	public CountryDTO getCountryById(String id) {
		Country country = repository.findById(id).get();
		CountryDTO countryDTO = sharedService.MapSingleObject(country, CountryDTO.class);
		return countryDTO;
	}

	public List<CountryDTO> getCountriesList() {
		List<Country> list = repository.findAll();
		return sharedService.MapListOfObject(list, CountryDTO.class);
	}

	public List<CountryDTO> getCountriesListByRegion(Long regionId) {
		Region region = regionRepository.findById(regionId).get();
		List<Country> list = repository.findByRegion(region);

		return sharedService.MapListOfObject(list, CountryDTO.class);
	}

	public CountryDTO createCountry(CountryDTO country) {
		Country entity = sharedService.MapSingleObject(country, Country.class);
		Country retCountry = repository.save(entity);
		return sharedService.MapSingleObject(retCountry, CountryDTO.class);
	}

	public CountryDTO updateCountry(String countryId, CountryDTO country) {
		Country entity = repository.findById(countryId).get();
		entity.setId(country.getId());
		entity.setName(country.getName());
		Country retCountry = repository.save(entity);
		return sharedService.MapSingleObject(retCountry, CountryDTO.class);
	}

}
