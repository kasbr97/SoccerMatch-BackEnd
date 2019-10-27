package com.soccermatch.SoccerMatch.repository;

import com.soccermatch.SoccerMatch.entity.Ubiquitous;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface IUbiquitousRepository extends JpaRepository<Ubiquitous,Integer> {
}
