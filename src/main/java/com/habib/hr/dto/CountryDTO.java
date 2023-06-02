package com.habib.hr.dto;

public class CountryDTO {

	private String id;
	private String name;
	private RegionDTO region;

	public CountryDTO() {
	}

	public CountryDTO(String id, String name, RegionDTO region) {
		this.id = id;
		this.name = name;
		this.region = region;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public RegionDTO getRegion() {
		return region;
	}

	public void setRegion(RegionDTO region) {
		this.region = region;
	}

}
