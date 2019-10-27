package com.soccermatch.SoccerMatch.service.impl;

import com.soccermatch.SoccerMatch.entity.Places;
import com.soccermatch.SoccerMatch.repository.IPlacesRepository;
import com.soccermatch.SoccerMatch.service.IPlacesService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class PlacesService implements IPlacesService {
    @Autowired
    private IPlacesRepository placesRepository;

    @Transactional
    @Override
    public Places Insert(Places u) throws Exception{
        return placesRepository.save(u);
    }
    @Transactional
    @Override
    public Places Update(Places t) throws Exception {
        // TODO Auto-generated method stub
        return placesRepository.save(t);
    }
    @Transactional(readOnly=true)
    @Override
    public List<Places> FindAll() throws Exception {
        // TODO Auto-generated method stub
        return placesRepository.findAll();
    }
    @Transactional(readOnly=true)
    @Override
    public Optional<Places> findById(Integer id) throws Exception {
        // TODO Auto-generated method stub
        return placesRepository.findById(id);
    }
    @Transactional
    @Override
    public void deleteById(Integer id) throws Exception {
        placesRepository.deleteById(id);

    }
    @Transactional
    @Override
    public void deleteAll() throws Exception {
        placesRepository.deleteAll();
    }
}
