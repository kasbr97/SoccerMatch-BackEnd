package com.soccermatch.SoccerMatch.repository;

import com.soccermatch.SoccerMatch.entity.Payments;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPaymentsRepository extends JpaRepository<Payments,Integer> {
}
