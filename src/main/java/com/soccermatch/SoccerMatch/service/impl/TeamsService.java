package com.soccermatch.SoccerMatch.service.impl;

import com.soccermatch.SoccerMatch.entity.Teams;
import com.soccermatch.SoccerMatch.repository.ITeamsRepository;
import com.soccermatch.SoccerMatch.service.CrudService;
import com.soccermatch.SoccerMatch.service.ITeamsService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class TeamsService implements ITeamsService {
    @Autowired
    private ITeamsRepository teamsRepository;

    @Transactional
    @Override
    public Teams Insert(Teams u) throws Exception{
        return teamsRepository.save(u);
    }
    @Transactional
    @Override
    public Teams Update(Teams t) throws Exception {
        // TODO Auto-generated method stub
        return teamsRepository.save(t);
    }
    @Transactional(readOnly=true)
    @Override
    public List<Teams> FindAll() throws Exception {
        // TODO Auto-generated method stub
        return teamsRepository.findAll();
    }
    @Transactional(readOnly=true)
    @Override
    public Optional<Teams> findById(Integer id) throws Exception {
        // TODO Auto-generated method stub
        return teamsRepository.findById(id);
    }
    @Transactional
    @Override
    public void deleteById(Integer id) throws Exception {
        teamsRepository.deleteById(id);

    }
    @Transactional
    @Override
    public void deleteAll() throws Exception {
        teamsRepository.deleteAll();
    }
}
