package com.soccermatch.SoccerMatch.repository;

import com.soccermatch.SoccerMatch.entity.Memberships;
import com.soccermatch.SoccerMatch.entity.People;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface IMembershipsRepository extends JpaRepository<Memberships,Integer> {
	
	@Query("select p from People p join Membership m on m.person_id = p.id where m.team_id = ?1")
	List<People>fetchTeamMembers(Integer id);
}
