package com.soccermatch.SoccerMatch.service.impl;

import com.soccermatch.SoccerMatch.entity.Ubiquitous;
import com.soccermatch.SoccerMatch.repository.IUbiquitousRepository;
import com.soccermatch.SoccerMatch.service.CrudService;
import com.soccermatch.SoccerMatch.service.IUbiquitousService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class UbiquitousService implements IUbiquitousService {
    @Autowired
    private IUbiquitousRepository ubiquitousRepository;

    @Transactional
    @Override
    public Ubiquitous Insert(Ubiquitous u) throws Exception{
        return ubiquitousRepository.save(u);
    }
    @Transactional
    @Override
    public Ubiquitous Update(Ubiquitous t) throws Exception {
        // TODO Auto-generated method stub
        return ubiquitousRepository.save(t);
    }
    @Transactional(readOnly=true)
    @Override
    public List<Ubiquitous> FindAll() throws Exception {
        // TODO Auto-generated method stub
        return ubiquitousRepository.findAll();
    }
    @Transactional(readOnly=true)
    @Override
    public Optional<Ubiquitous> findById(Integer id) throws Exception {
        // TODO Auto-generated method stub
        return ubiquitousRepository.findById(id);
    }
    @Transactional
    @Override
    public void deleteById(Integer id) throws Exception {
        ubiquitousRepository.deleteById(id);

    }
    @Transactional
    @Override
    public void deleteAll() throws Exception {
        ubiquitousRepository.deleteAll();
    }
}
