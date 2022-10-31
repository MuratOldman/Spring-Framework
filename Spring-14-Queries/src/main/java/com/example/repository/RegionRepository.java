package com.example.repository;

import com.example.entity.Region;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RegionRepository extends JpaRepository<Region,Long> {

    //display all regions in Canada
   List<Region> findByCountry(String country);

   //display all regions in Canada without duplicates
    List<Region> findDistinctByCountry(String country);

    //Display all regions with country name includes 'United'
    List<Region> findByCountryContains(String name);

    //Display all regions with country name includes 'United' in order
    List<Region> findByCountryContainsOrderByCountry(String name);

    //Display top 2 regions in Canada
    List<Region> findTop2ByCountry(String country);

}
