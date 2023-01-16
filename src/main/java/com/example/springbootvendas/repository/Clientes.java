package com.example.springbootvendas.repository;

import com.example.springbootvendas.entity.Cliente;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class Clientes {

    private static final String INSERT = "insert into cliente (name) values(?) ";
    private static final String SELECT_ALL = "select * from cliente ";
    private static final String UPDATE = "update cliente set name = ? where id = ?";
    private static final String DELETE = "delete from cliente where id = ?";
    private static final String FINDNAME = "select * from cliente where name like ?";

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private EntityManager entityManager;

    @Transactional
    public Cliente save(Cliente cliente){
        entityManager.persist(cliente);
        return cliente;
    }

    public Cliente update(Cliente cliente){
        jdbcTemplate.update(UPDATE, cliente.getName(), cliente.getId());
        return cliente;
    }

    public void delete(Cliente cliente){
       delete(cliente.getId());
    }

    public void delete(Integer id){
        jdbcTemplate.update(DELETE, id);
    }

    public List<Cliente> findName(String name){
        return jdbcTemplate.query(FINDNAME,new Object[]{"%" + name + "%"}, getRowMapper());
    }

    public List<Cliente> selectAll(){
        return jdbcTemplate.query(SELECT_ALL, getRowMapper());
    }

    private RowMapper<Cliente> getRowMapper() {
        return new RowMapper<Cliente>() {
            @Override
            public Cliente mapRow(ResultSet rs, int rowNum) throws SQLException {
                Integer id = rs.getInt("id");
                String name = rs.getString("name");
                return new Cliente(id, name);
            }
        };
    }
}
