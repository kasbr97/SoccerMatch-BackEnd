package com.soccermatch.SoccerMatch.repository;

import com.soccermatch.SoccerMatch.entity.Places;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPlacesRepository extends JpaRepository<Places,Integer> {
}
