package com.soccermatch.SoccerMatch.repository;
import com.soccermatch.SoccerMatch.entity.Teams;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
@Repository
public interface ITeamsRepository extends JpaRepository<Teams,Integer> {
	
	@Query(value ="select t.id, t.description, t.name from Team t join Membership m on m.id_team = t.id where m.id_person =?1", nativeQuery = true)
	Optional<List<Teams>> fetchTeamsByUser(Integer id);

}
