package com.soccermatch.SoccerMatch.repository;

import com.soccermatch.SoccerMatch.entity.Memberships;
import com.soccermatch.SoccerMatch.entity.People;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface IMembershipsRepository extends JpaRepository<Memberships,Integer> {
	
	@Query(value ="select p.id, p.dni, p.email, p.name, p.partner, p.password, p.phone_number, p.username, p.id_ubiquitous from Membership m join Person p on m.id_person = p.id where m.id_team = ?1", nativeQuery = true)
	List<People>fetchTeamMembers(Integer id);
}
