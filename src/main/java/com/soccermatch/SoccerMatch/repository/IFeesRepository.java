package com.soccermatch.SoccerMatch.repository;

import com.soccermatch.SoccerMatch.entity.Fees;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IFeesRepository extends JpaRepository<Fees,Integer> {
}
