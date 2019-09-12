package com.soccermatch.SoccerMatch.service.impl;

import com.soccermatch.SoccerMatch.entity.Rents;
import com.soccermatch.SoccerMatch.repository.IRentsRepository;
import com.soccermatch.SoccerMatch.service.CrudService;
import com.soccermatch.SoccerMatch.service.IRentsService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class RentsService implements IRentsService {
    @Autowired
    private IRentsRepository rentsRepository;
    @Override
    @Transactional
    public Rents Insert(Rents rents) throws Exception {
        return rentsRepository.save(rents);
    }

    @Override
    @Transactional
    public Rents Update(Rents rents) throws Exception {
        return rentsRepository.save(rents);
    }

    @Override
    @Transactional(readOnly=true)
    public List<Rents> FindAll() throws Exception {
        return rentsRepository.findAll();
    }

    @Override
    @Transactional(readOnly=true)
    public Optional<Rents> findById(Integer integer) throws Exception {
        return rentsRepository.findById(integer);
    }

    @Override
    @Transactional
    public void deleteById(Integer integer) throws Exception {
         rentsRepository.deleteById(integer);
    }

    @Override
    @Transactional
    public void deleteAll() throws Exception {
        rentsRepository.deleteAll();
    }
}
