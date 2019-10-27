package com.soccermatch.SoccerMatch.service;


import java.util.List;
import java.util.Optional;

import com.soccermatch.SoccerMatch.entity.People;
import com.soccermatch.SoccerMatch.entity.Teams;

public interface IPeopleService extends CrudService<People,Integer> {
	
	Optional<People> fetchUserByUsername(String username) throws Exception;
	
	List<People>fetchTeamMembers(Integer id) throws Exception;
}
