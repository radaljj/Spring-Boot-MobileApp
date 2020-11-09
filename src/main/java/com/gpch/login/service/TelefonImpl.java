package com.gpch.login.service;

import com.gpch.login.model.Telefon;
import com.gpch.login.repository.TelefonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class TelefonImpl implements TelefonService {

    @Autowired
    TelefonRepository repository;

    @Override
    public List<Telefon> getAllTelefon() {
        return (List<Telefon>) repository.findAll();
    }


    @Override
    public List<Telefon> pretraga(String keyword) {
        if (keyword != null) {
            return repository.search(keyword);
        }
        return (List<Telefon>) repository.findAll();
    }


    @Override
    public Telefon getTelefonById(int id) {
        return repository.findById(id).get();
    }


    @Override
    public void saveTelefon(Telefon telefon) {
        repository.save(telefon);
    }

    @Override
    public void deleteTelefon(int id) {

        repository.deleteById(id);
    }


}
