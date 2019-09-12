package com.soccermatch.SoccerMatch.service.impl;

import com.soccermatch.SoccerMatch.entity.Fees;
import com.soccermatch.SoccerMatch.repository.IFeesRepository;
import com.soccermatch.SoccerMatch.service.IFeesService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class FeesService implements IFeesService{
    @Autowired
    private IFeesRepository feesRepository;

    @Transactional
    @Override
    public Fees Insert(Fees u) throws Exception{
        return feesRepository.save(u);
    }
    @Transactional
    @Override
    public Fees Update(Fees t) throws Exception {
        // TODO Auto-generated method stub
        return feesRepository.save(t);
    }
    @Transactional(readOnly=true)
    @Override
    public List<Fees> FindAll() throws Exception {
        // TODO Auto-generated method stub
        return feesRepository.findAll();
    }
    @Transactional(readOnly=true)
    @Override
    public Optional<Fees> findById(Integer id) throws Exception {
        // TODO Auto-generated method stub
        return feesRepository.findById(id);
    }
    @Transactional
    @Override
    public void deleteById(Integer id) throws Exception {
        feesRepository.deleteById(id);

    }
    @Transactional
    @Override
    public void deleteAll() throws Exception {
        feesRepository.deleteAll();
    }
}
