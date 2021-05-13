package com.example.tortuga.service;

import com.example.tortuga.dao.Dao;
import com.example.tortuga.entity.TortugaClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;

@Service
public class ClientsServiceImpl implements ClientService {

    private Dao<TortugaClient> dao;

    public ClientsServiceImpl(@Autowired Dao<TortugaClient> dao) {
        this.dao = dao;
    }


    @Override
    public Collection<TortugaClient> getAllClients() {
        return dao.getAll();
    }

    @Override
    public Optional<TortugaClient> getClientById(long id) {
        return dao.getClientById(id);
    }

    @Override
    public Boolean updateClient(long id, TortugaClient tortugaClient) {
        return dao.updateClient(id, tortugaClient);
    }

    @Override
    public Boolean deleteById(long id) {
        return dao.deleteClient(id);
    }

    @Override
    public Boolean addClient(TortugaClient tortugaClient) {
        return dao.addClient(tortugaClient);
    }
}
