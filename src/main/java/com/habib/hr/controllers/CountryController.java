package com.habib.hr.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.habib.hr.dto.CountryDTO;
import com.habib.hr.services.CountryService;

@RestController
@RequestMapping(path = "countries")
public class CountryController {

	@Autowired
	private CountryService service;

	@GetMapping(path = "/list", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<List<CountryDTO>> getCountriesListAll() {
		List<CountryDTO> list = service.getCountriesList();
		return ResponseEntity.ok(list);
	}

	@GetMapping(path = "{regionId}", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<List<CountryDTO>> getCountriesListByRegion(@PathVariable Long regionId) {
		List<CountryDTO> list = service.getCountriesListByRegion(regionId);
		return ResponseEntity.ok(list);
	}

	@PostMapping(path = "/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<CountryDTO> createCountry(@RequestBody CountryDTO countryDto) {
		if (countryDto != null) {
			CountryDTO createCountry = service.createCountry(countryDto);
			return ResponseEntity.ok(createCountry);
		}
		return ResponseEntity.badRequest().build();
	}

	@PutMapping(path = "/update/{countryId}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<CountryDTO> updateCountry(@PathVariable String countryId, @RequestBody CountryDTO country) {
		CountryDTO retCountry = null;
		if (country != null) {
			retCountry = service.updateCountry(countryId, country);
			return ResponseEntity.ok(retCountry);
		}
		return ResponseEntity.badRequest().build();
	}

}
