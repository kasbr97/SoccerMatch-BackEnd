package com.soccermatch.SoccerMatch.service;

import java.util.List;

import com.soccermatch.SoccerMatch.entity.Memberships;
import com.soccermatch.SoccerMatch.entity.People;

public interface IMembershipsService extends CrudService<Memberships,Integer> {
	List<People>fetchTeamMembers(Integer id) throws Exception;
}
