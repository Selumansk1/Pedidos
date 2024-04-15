package com.pedidos.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pedidos.model.Clientes;
import com.pedidos.model.Pedido;
import com.pedidos.repository.ClientesRepository;
import com.pedidos.repository.PedidoRepository;

import java.util.Date;
import java.util.List;

@Service
public class ClientesService {

    @Autowired
    private ClientesRepository clientesRepository;

    // public List<Clientes> consultarPedidos(int codigoCliente) {
    //     clientesRepository.findByCodigoCliente(codigoCliente);
    // }
}