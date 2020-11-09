package com.gpch.login.repository;

import com.gpch.login.model.Telefon;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TelefonRepository extends CrudRepository<Telefon,Integer> {
    @Query("SELECT t FROM Telefon t WHERE CONCAT(t.Marka, t.cena, t.Model, t.Lokacija,t.opis) LIKE %?1%")
    public List<Telefon> search(String keyword);
}
