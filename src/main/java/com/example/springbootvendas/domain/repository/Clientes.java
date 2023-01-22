package com.example.springbootvendas.domain.repository;

import com.example.springbootvendas.domain.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface Clientes extends JpaRepository<Cliente, Integer> {

    @Query(value = " select c from Cliente c where c.name like :name ")
    List<Cliente> findByNameLike(@Param("name") String name);

    @Query(value = "delete from Cliente c where c.name = :name")
    @Modifying
    void deleteByName(String name);

    boolean existsByName(String name);

    @Query(" select c from Cliente c left join fetch c.pedidos where c.id = :id ")
    Cliente findClienteFetchPedidos(@Param("id") Integer id);


}
