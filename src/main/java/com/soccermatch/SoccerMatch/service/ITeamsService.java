package com.soccermatch.SoccerMatch.service;

import java.util.List;
import java.util.Optional;

import com.soccermatch.SoccerMatch.entity.Teams;

public interface ITeamsService extends CrudService<Teams,Integer> {
	Optional<List<Teams>> fetchTeamsByUsers(Integer id) throws Exception;
}
