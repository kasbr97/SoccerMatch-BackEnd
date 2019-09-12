package com.soccermatch.SoccerMatch.repository;

import com.soccermatch.SoccerMatch.entity.Memberships;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IMembershipsRepository extends JpaRepository<Memberships,Integer> {
}
