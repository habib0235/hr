package com.habib.hr.dto;

import java.util.Objects;

public class JobDTO {

	private Long id;
	private String title;
	private Integer minSalary;
	private Integer maxSalary;

	public JobDTO() {
	}

	public JobDTO(Long id, String title, Integer minSalary, Integer maxSalary) {
		this.id = id;
		this.title = title;
		this.minSalary = minSalary;
		this.maxSalary = maxSalary;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Integer getMinSalary() {
		return minSalary;
	}

	public void setMinSalary(Integer minSalary) {
		this.minSalary = minSalary;
	}

	public Integer getMaxSalary() {
		return maxSalary;
	}

	public void setMaxSalary(Integer maxSalary) {
		this.maxSalary = maxSalary;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, maxSalary, minSalary, title);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		JobDTO other = (JobDTO) obj;
		return Objects.equals(id, other.id) && Objects.equals(maxSalary, other.maxSalary)
				&& Objects.equals(minSalary, other.minSalary) && Objects.equals(title, other.title);
	}

}
