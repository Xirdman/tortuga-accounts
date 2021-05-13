package com.example.tortuga.mapper;

import com.example.tortuga.entity.TortugaClient;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class TortugaClientRowMapper implements RowMapper<TortugaClient> {
    @Override
    public TortugaClient mapRow(ResultSet resultSet, int i) throws SQLException {
        TortugaClient tortugaClient = new TortugaClient();
        tortugaClient.setId(resultSet.getInt("id"));
        tortugaClient.setFirstName(resultSet.getString("firstname"));
        tortugaClient.setLastName(resultSet.getString("lastname"));
        tortugaClient.setSurName(resultSet.getString("surname"));
        return tortugaClient;
    }
}
