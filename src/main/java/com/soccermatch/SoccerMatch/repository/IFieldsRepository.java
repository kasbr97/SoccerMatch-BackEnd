package com.soccermatch.SoccerMatch.repository;

import com.soccermatch.SoccerMatch.entity.Fields;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IFieldsRepository extends JpaRepository<Fields,Integer> {
}
