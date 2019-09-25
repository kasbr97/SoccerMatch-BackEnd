package com.soccermatch.SoccerMatch.service.impl;

import com.soccermatch.SoccerMatch.entity.Payments;
import com.soccermatch.SoccerMatch.repository.IPaymentsRepository;
import com.soccermatch.SoccerMatch.service.IPaymentsService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class PaymentsService implements IPaymentsService {
    @Autowired
    private IPaymentsRepository paymentsRepository;

    @Transactional
    @Override
    public Payments Insert(Payments u) throws Exception{
        return paymentsRepository.save(u);
    }
    @Transactional
    @Override
    public Payments Update(Payments t) throws Exception {
        // TODO Auto-generated method stub
        return paymentsRepository.save(t);
    }
    @Transactional(readOnly=true)
    @Override
    public List<Payments> FindAll() throws Exception {
        // TODO Auto-generated method stub
        return paymentsRepository.findAll();
    }
    @Transactional(readOnly=true)
    @Override
    public Optional<Payments> findById(Integer id) throws Exception {
        // TODO Auto-generated method stub
        return paymentsRepository.findById(id);
    }
    @Transactional
    @Override
    public void deleteById(Integer id) throws Exception {
        paymentsRepository.deleteById(id);

    }
    @Transactional
    @Override
    public void deleteAll() throws Exception {
        paymentsRepository.deleteAll();
    }
}
