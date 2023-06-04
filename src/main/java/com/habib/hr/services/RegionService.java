package com.habib.hr.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.habib.hr.dto.RegionDTO;
import com.habib.hr.entities.Region;
import com.habib.hr.repositories.RegionRepository;

@Service
public class RegionService {

	@Autowired
	private RegionRepository regionRepository;

	@Autowired
	private SharedService sharedService;

	public RegionDTO getRegion(Long id) {
		Region entity = regionRepository.findById(id).orElse(null);
		return sharedService.MapSingleObject(entity, RegionDTO.class);
	}

	public List<RegionDTO> getRegions() {
		List<Region> list = regionRepository.findAll();
		return sharedService.MapListOfObject(list, RegionDTO.class);
	}

	public List<RegionDTO> getRegionList() {
		return sharedService.MapListOfObject(regionRepository.findAll(), RegionDTO.class);
	}

	public RegionDTO createRegion(RegionDTO regionDto) {
		Region region = sharedService.MapSingleObject(regionDto, Region.class);
		region.setId(null);
		Region retRegion = regionRepository.save(region);
		return sharedService.MapSingleObject(retRegion, RegionDTO.class);
	}

	public RegionDTO updateRegion(RegionDTO regionDto) {
		Region region = sharedService.MapSingleObject(regionDto, Region.class);
		Region retRegion = regionRepository.save(region);
		return sharedService.MapSingleObject(retRegion, RegionDTO.class);
	}
}
