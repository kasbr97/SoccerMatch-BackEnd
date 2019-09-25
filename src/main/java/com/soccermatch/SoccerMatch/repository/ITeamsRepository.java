package com.soccermatch.SoccerMatch.repository;
import com.soccermatch.SoccerMatch.entity.Teams;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface ITeamsRepository extends JpaRepository<Teams,Integer> {

}
