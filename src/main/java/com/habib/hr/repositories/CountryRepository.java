package com.habib.hr.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.habib.hr.entities.Country;
import com.habib.hr.entities.Region;

@Repository
public interface CountryRepository extends JpaRepository<Country, String> {
	
	List<Country> findByRegion(Region region);

}
