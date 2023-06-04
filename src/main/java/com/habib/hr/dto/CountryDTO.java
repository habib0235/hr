package com.habib.hr.dto;

import java.util.Objects;

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

	@Override
	public int hashCode() {
		return Objects.hash(id, name, region);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CountryDTO other = (CountryDTO) obj;
		return Objects.equals(id, other.id) && Objects.equals(name, other.name) && Objects.equals(region, other.region);
	}

}
