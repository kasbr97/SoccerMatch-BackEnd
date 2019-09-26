package com.soccermatch.SoccerMatch.repository;

import com.soccermatch.SoccerMatch.entity.People;
import com.soccermatch.SoccerMatch.entity.Teams;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface IPeopleRepository extends JpaRepository<People,Integer> {
	
	@Query(value ="select * from Person p where p.username = ?1", nativeQuery = true)
	Optional<People> fetchUserByUsername(String username);
	
	@Query(value ="select t from Team t join Membership m on m.id_team = t.id where m.id_person = ?1", nativeQuery = true)
	Optional<List<Teams>> fetchTeamsByUser(Integer id);
	
}
