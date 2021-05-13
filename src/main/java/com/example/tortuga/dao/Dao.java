package com.example.tortuga.dao;

import com.example.tortuga.entity.TortugaClient;

import java.util.Collection;
import java.util.Optional;

public interface Dao<T> {

    Collection<T> getAll();

    Optional<T> getClientById(long id);

    Boolean updateClient(long id, TortugaClient tortugaClient);

    Boolean deleteClient(long id);

    Boolean addClient(TortugaClient tortugaClient);
}
