package com.habib.hr.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

	public Country getCountryById(String id) {
		return repository.findById(id).get();
	}

	public List<Country> getCountriesList() {
		return repository.findAll();
	}

	public List<Country> getCountriesListByRegion(Long regionId) {
		Region region = regionRepository.findById(regionId).get();
		return repository.findByRegion(region);
	}

	public Country createCountry(Country country) {
		return repository.save(country);
	}

	public Country updateCountry(String countryId, Country country) {
		Country entity = repository.findById(countryId).get();
		entity.setId(country.getId());
		entity.setName(country.getName());
		return repository.save(entity);
	}

}
