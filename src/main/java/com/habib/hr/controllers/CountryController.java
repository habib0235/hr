package com.habib.hr.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.habib.hr.entities.Country;
import com.habib.hr.services.CountryService;

@RestController
@RequestMapping(path = "countries")
public class CountryController {

	@Autowired
	private CountryService service;

	@GetMapping(path = "/list")
	@ResponseBody
	public ResponseEntity<List<Country>> getCountriesListAll() {
		List<Country> list = service.getCountriesList();
		return ResponseEntity.ok(list);
	}

	@GetMapping(path = "{regionId}")
	@ResponseBody
	public ResponseEntity<List<Country>> getCountriesListByRegion(@PathVariable Long regionId) {
		List<Country> list = service.getCountriesListByRegion(regionId);
		return ResponseEntity.ok(list);
	}

	@PostMapping(path= "/create")
	@ResponseBody
	public ResponseEntity<Country> createCountry(@RequestBody Country country) {
		Country retCountry = null;
		if (country != null) {
			retCountry = service.createCountry(country);
			return ResponseEntity.ok(retCountry);
		}

		return ResponseEntity.badRequest().build();
	}
	
	@PutMapping(path= "/update/{countryId}")
	@ResponseBody
	public ResponseEntity<Country> updateCountry(@PathVariable String countryId, @RequestBody Country country) {
		Country retCountry = null;
		if (country != null) {
			retCountry = service.updateCountry(countryId, country);
			return ResponseEntity.ok(retCountry);
		}

		return ResponseEntity.badRequest().build();
	}

}
