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
	
	@Query(value ="select p.id, p.dni, p.email, p.name, p.partner, p.password, p.phone_number, p.username, p.id_ubiquitous from Membership m join Person p on m.id_person = p.id where m.id_team = ?1", nativeQuery = true)
	List<People>fetchTeamMembers(Integer id);
}
