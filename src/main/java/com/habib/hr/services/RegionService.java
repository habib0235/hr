package com.habib.hr.services;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.habib.hr.entities.Region;
import com.habib.hr.repositories.RegionRepository;

@Service
public class RegionService {

	@Autowired
	private RegionRepository repository;

	public Region getRegion(Long id) {
		return repository.getReferenceById(id);
	}

	public Set<Region> getRegions() {
		return new HashSet<>(repository.findAll());
	}

	public List<Region> getRegionList() {
		return repository.findAll();
	}

}
