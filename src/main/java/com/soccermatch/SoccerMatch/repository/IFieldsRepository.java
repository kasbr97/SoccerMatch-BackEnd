package com.soccermatch.SoccerMatch.repository;

import com.soccermatch.SoccerMatch.entity.Fields;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface IFieldsRepository extends JpaRepository<Fields,Integer> {
	@Query(value = "from Fields f join Places p on f.id_places = p.id where p.id = ?1",nativeQuery = true)
	List<Fields>fetchPlaceFields(Integer id);
}
