package com.habib.hr.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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

	@GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<Region> getRegion(@PathVariable Long id) {
		Region region = service.getRegion(id);
		return ResponseEntity.ok(region);
	}

	@GetMapping(path = "/list", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<List<Region>> getRegionList() {
		List<Region> regions = service.getRegionList();
		return ResponseEntity.ok(regions);
	}

	@PostMapping(path = "/save", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<Region> saveRegion(@RequestBody Region region) {
		Region retRegion = null;
		if (region != null) {
			if (region.getId() < 1) {
				retRegion = service.createRegion(region);
			} else {
				retRegion = service.updateRegion(region);
			}
			return ResponseEntity.ok(retRegion);
		}
		return ResponseEntity.badRequest().build();
	}

}
