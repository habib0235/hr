package com.habib.hr.dto;

import java.util.Objects;

public class LocationDTO {

	private Long id;
	private String streetAddress;
	private String postalCode;
	private String city;
	private String stateProvince;
	private CountryDTO country;

	public LocationDTO() {
	}

	public LocationDTO(Long id, String streetAddress, String postalCode, String city, String stateProvince,
			CountryDTO country) {
		this.id = id;
		this.streetAddress = streetAddress;
		this.postalCode = postalCode;
		this.city = city;
		this.stateProvince = stateProvince;
		this.country = country;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getStreetAddress() {
		return streetAddress;
	}

	public void setStreetAddress(String streetAddress) {
		this.streetAddress = streetAddress;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getStateProvince() {
		return stateProvince;
	}

	public void setStateProvince(String stateProvince) {
		this.stateProvince = stateProvince;
	}

	public CountryDTO getCountry() {
		return country;
	}

	public void setCountry(CountryDTO country) {
		this.country = country;
	}

	@Override
	public int hashCode() {
		return Objects.hash(city, country, id, postalCode, stateProvince, streetAddress);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		LocationDTO other = (LocationDTO) obj;
		return Objects.equals(city, other.city) && Objects.equals(country, other.country)
				&& Objects.equals(id, other.id) && Objects.equals(postalCode, other.postalCode)
				&& Objects.equals(stateProvince, other.stateProvince)
				&& Objects.equals(streetAddress, other.streetAddress);
	}

}
