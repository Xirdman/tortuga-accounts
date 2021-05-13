package com.example.tortuga.service;

import com.example.tortuga.entity.TortugaClient;

import java.util.Collection;
import java.util.Optional;

public interface ClientService {

    Collection<TortugaClient> getAllClients();

    Optional<TortugaClient> getClientById(long id);

    Boolean updateClient(long id, TortugaClient tortugaClient);

    Boolean deleteById(long id);

    Boolean addClient(TortugaClient tortugaClient);
}
