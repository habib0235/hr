package com.habib.hr.dto;

import java.util.Objects;

public class DepartmentDTO {

	private Long id;
	private String name;
	private EmployeeDTO manager;
	private LocationDTO location;

	public DepartmentDTO() {

	}

	public DepartmentDTO(Long id, String name, EmployeeDTO manager, LocationDTO location) {
		this.id = id;
		this.name = name;
		this.manager = manager;
		this.location = location;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public EmployeeDTO getManager() {
		return manager;
	}

	public void setManager(EmployeeDTO manager) {
		this.manager = manager;
	}

	public LocationDTO getLocation() {
		return location;
	}

	public void setLocation(LocationDTO location) {
		this.location = location;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, location, manager, name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DepartmentDTO other = (DepartmentDTO) obj;
		return Objects.equals(id, other.id) && Objects.equals(location, other.location)
				&& Objects.equals(manager, other.manager) && Objects.equals(name, other.name);
	}

}
