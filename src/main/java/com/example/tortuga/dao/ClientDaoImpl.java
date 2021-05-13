package com.example.tortuga.dao;

import com.example.tortuga.entity.TortugaClient;

import com.example.tortuga.mapper.TortugaClientRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public class ClientDaoImpl implements Dao<TortugaClient> {

    private NamedParameterJdbcTemplate template;

    public ClientDaoImpl(@Autowired NamedParameterJdbcTemplate template) {
        this.template = template;
    }

    @Override
    public Collection<TortugaClient> getAll() {
        String query = "SELECT * FROM clients";
        return template.query(query, new TortugaClientRowMapper());
    }

    @Override
    public TortugaClient getClientById(long id) {
        String query = "SELECT client FROM clients WHERE id= :id";
        SqlParameterSource param = new MapSqlParameterSource("id", id);
        return template.queryForObject(query, param, new TortugaClientRowMapper());
    }

    @Override
    public Boolean updateClient(long id, TortugaClient tortugaClient) {
        String query = "UPDATE clients SET firstname=:firstName, lastname=:lastName, surname=:surName WHERE id=:id";
        SqlParameterSource params = new MapSqlParameterSource("id", id)
                .addValue("firstName", tortugaClient.getFirstName())
                .addValue("lastName", tortugaClient.getLastName())
                .addValue("surName", tortugaClient.getSurName());
        return template.update(query, params) != 0;
    }

    @Override
    public Boolean deleteClient(long id) {
        String query = "DELETE FROM clients WHERE id=:id";
        SqlParameterSource param = new MapSqlParameterSource("id", id);
        return template.update(query, param) != 0;
    }

    @Override
    public Boolean addClient(TortugaClient tortugaClient) {
        String query = "INSERT INTO clients (firstName, lastName, surName) VALUES (:firstName, :lastName, :surName)";
        SqlParameterSource params = new MapSqlParameterSource("firstName", tortugaClient.getFirstName())
                .addValue("lastName", tortugaClient.getLastName())
                .addValue("surName", tortugaClient.getSurName());
        return template.update(query, params) != 0;
    }
}
