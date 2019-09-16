package com.soccermatch.SoccerMatch.repository;

import com.soccermatch.SoccerMatch.entity.Fields;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface IFieldsRepository extends JpaRepository<Fields,Integer> {
	@Query("select f from Field f join Place p on f.place_id = p.id where p.id = ?1")
	List<Fields>fetchTeamMembers(Integer id);
}
