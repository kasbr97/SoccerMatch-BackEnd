package com.soccermatch.SoccerMatch.repository;

import com.soccermatch.SoccerMatch.entity.People;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPeopleRepository extends JpaRepository<People,Integer> {
}
