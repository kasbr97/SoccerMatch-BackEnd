package com.soccermatch.SoccerMatch.repository;

import com.soccermatch.SoccerMatch.entity.People;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface IPeopleRepository extends JpaRepository<People,Integer> {
	
}
