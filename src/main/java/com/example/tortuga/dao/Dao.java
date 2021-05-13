package com.example.tortuga.dao;

import com.example.tortuga.entity.TortugaClient;

import java.util.Collection;

public interface Dao<T> {

    Collection<T> getAll();

    T getClientById(long id);

    Boolean updateClient(long id, TortugaClient tortugaClient);

    Boolean deleteClient(long id);

    Boolean addClient(TortugaClient tortugaClient);
}
