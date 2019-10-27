package com.soccermatch.SoccerMatch.repository;

import com.soccermatch.SoccerMatch.entity.Rents;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRentsRepository extends JpaRepository<Rents,Integer> {
}
