package com.soccermatch.SoccerMatch.service;

import java.util.List;

import com.soccermatch.SoccerMatch.entity.Fields;

public interface IFieldsService extends CrudService<Fields,Integer> {
	List<Fields> fetchPlaceFields(Integer id) throws Exception;
}

