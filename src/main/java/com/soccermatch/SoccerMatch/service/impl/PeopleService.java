package com.soccermatch.SoccerMatch.service.impl;

import com.soccermatch.SoccerMatch.entity.People;
import com.soccermatch.SoccerMatch.repository.IPeopleRepository;
import com.soccermatch.SoccerMatch.service.IPeopleService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class PeopleService implements IPeopleService {
    @Autowired
    private IPeopleRepository peopleRepository;

    @Transactional
    @Override
    public People Insert(People u) throws Exception{
        return peopleRepository.save(u);
    }
    @Transactional
    @Override
    public People Update(People t) throws Exception {
        // TODO Auto-generated method stub
        return peopleRepository.save(t);
    }
    @Transactional(readOnly=true)
    @Override
    public List<People> FindAll() throws Exception {
        // TODO Auto-generated method stub
        return peopleRepository.findAll();
    }
    @Transactional(readOnly=true)
    @Override
    public Optional<People> findById(Integer id) throws Exception {
        // TODO Auto-generated method stub
        return peopleRepository.findById(id);
    }
    @Transactional
    @Override
    public void deleteById(Integer id) throws Exception {
        peopleRepository.deleteById(id);

    }
    @Transactional
    @Override
    public void deleteAll() throws Exception {
        peopleRepository.deleteAll();
    }
}
