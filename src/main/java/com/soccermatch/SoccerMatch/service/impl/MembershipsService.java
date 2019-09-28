package com.soccermatch.SoccerMatch.service.impl;

import com.soccermatch.SoccerMatch.entity.Memberships;
import com.soccermatch.SoccerMatch.entity.People;
import com.soccermatch.SoccerMatch.repository.IMembershipsRepository;
import com.soccermatch.SoccerMatch.service.IMembershipsService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class MembershipsService implements IMembershipsService {
    @Autowired
    private IMembershipsRepository membershipsRepository;

    @Transactional
    @Override
    public Memberships Insert(Memberships u) throws Exception{
        return membershipsRepository.save(u);
    }
    @Transactional
    @Override
    public Memberships Update(Memberships t) throws Exception {
        // TODO Auto-generated method stub
        return membershipsRepository.save(t);
    }
    @Transactional(readOnly=true)
    @Override
    public List<Memberships> FindAll() throws Exception {
        // TODO Auto-generated method stub
        return membershipsRepository.findAll();
    }
    @Transactional(readOnly=true)
    @Override
    public Optional<Memberships> findById(Integer id) throws Exception {
        // TODO Auto-generated method stub
        return membershipsRepository.findById(id);
    }
    @Transactional
    @Override
    public void deleteById(Integer id) throws Exception {
        membershipsRepository.deleteById(id);

    }
    @Transactional
    @Override
    public void deleteAll() throws Exception {
        membershipsRepository.deleteAll();
    }
}
