package com.pedidos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pedidos.model.Pedido;
import java.util.List;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Long> {

    public Pedido findByNumeroControle(Long numeroControle);
    public List<Pedido> findById(int id);
    public List<Pedido> findByDataCadastro(String datacadastro);
    public List<Pedido> findAll();

}