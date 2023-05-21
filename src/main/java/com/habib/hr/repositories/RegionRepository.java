package com.habib.hr.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.habib.hr.entities.Region;

@Repository
public interface RegionRepository extends JpaRepository<Region, Long>{

}
