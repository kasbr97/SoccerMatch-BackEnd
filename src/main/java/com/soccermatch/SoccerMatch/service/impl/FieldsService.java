package com.soccermatch.SoccerMatch.service.impl;

import com.soccermatch.SoccerMatch.entity.Fields;
import com.soccermatch.SoccerMatch.repository.IFieldsRepository;
import com.soccermatch.SoccerMatch.service.IFieldsService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class FieldsService implements IFieldsService {
    @Autowired
    private IFieldsRepository fieldsRepository;

    @Transactional
    @Override
    public Fields Insert(Fields u) throws Exception{
        return fieldsRepository.save(u);
    }
    @Transactional
    @Override
    public Fields Update(Fields t) throws Exception {
        // TODO Auto-generated method stub
        return fieldsRepository.save(t);
    }
    @Transactional(readOnly=true)
    @Override
    public List<Fields> FindAll() throws Exception {
        // TODO Auto-generated method stub
        return fieldsRepository.findAll();
    }
    @Transactional(readOnly=true)
    @Override
    public Optional<Fields> findById(Integer id) throws Exception {
        // TODO Auto-generated method stub
        return fieldsRepository.findById(id);
    }
    @Transactional
    @Override
    public void deleteById(Integer id) throws Exception {
        fieldsRepository.deleteById(id);

    }
    @Transactional
    @Override
    public void deleteAll() throws Exception {
        fieldsRepository.deleteAll();
    }
	@Override
	public List<Fields> fetchPlaceFields(Integer id) throws Exception {
		return fieldsRepository.fetchPlaceFields(id);
	}
}
