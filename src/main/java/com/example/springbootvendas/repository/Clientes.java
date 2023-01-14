package com.example.springbootvendas.repository;

import com.example.springbootvendas.entity.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class Clientes {

    private static final String INSERT = "insert into cliente (name) values(?) ";
    private static final String SELECT_ALL = "select * from cliente ";

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public Cliente save(Cliente cliente){
        jdbcTemplate.update(INSERT, cliente.getName());
        return cliente;
    }

    public List<Cliente> selectAll(){
        return jdbcTemplate.query(SELECT_ALL, new RowMapper<Cliente>() {
            @Override
            public Cliente mapRow(ResultSet rs, int rowNum) throws SQLException {
                Integer id = rs.getInt("id");
                String name = rs.getString("name");
                return new Cliente(id, name);
            }
        });
    }
}
