package com.gpch.login.service;

import com.gpch.login.model.Telefon;


import java.util.List;

public interface TelefonService {
    List<Telefon> getAllTelefon();

    List<Telefon>pretraga(String keyword);


    Telefon getTelefonById(int id);

    void saveTelefon(Telefon telefon);

    void deleteTelefon(int id);

}
