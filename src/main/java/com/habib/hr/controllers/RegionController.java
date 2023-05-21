package com.habib.hr.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.habib.hr.entities.Region;
import com.habib.hr.services.RegionService;

@RestController
@RequestMapping(path = "/regions")
public class RegionController {

	@Autowired
	private RegionService service;

	@RequestMapping(path = "/{id}")
	@ResponseBody
	public ResponseEntity<Region> getRegion(@PathVariable Long id) {
		Region region = service.getRegion(id);
		return ResponseEntity.ok(region);
	}

	
}
