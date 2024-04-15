package com.pedidos.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pedidos.model.Clientes;
import com.pedidos.model.Pedido;
import com.pedidos.repository.ClientesRepository;
import com.pedidos.repository.PedidoRepository;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class PedidoService {

    @Autowired
    private PedidoRepository pedidosRepository;

    @Autowired
    private ClientesRepository clientesRepository;

    public void processarPedido(Pedido pedido) {
            Pedido pedidoExistente = pedidosRepository.findByNumeroControle(pedido.getNumeroControle());
        if(pedidoExistente != null) {
            throw new RuntimeException("Número de controle já cadastrado");
        }
            Clientes cliente = clientesRepository.findByCodigoCliente(pedido.getCodigoCliente());
        if(cliente == null) {
            throw new RuntimeException("Cliente não cadastrado");
        }

        if(pedido.getDataCadastro() == "") {
            Date dataAtual = new Date();
            SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
            String dataFormatada = formato.format(dataAtual); 
            pedido.setDataCadastro(dataFormatada);
        }

        if(pedido.getQuantidade() == 0) {
            pedido.setQuantidade(1);
        }

        double desconto = 0;

        if(pedido.getQuantidade() >= 5 && pedido.getQuantidade() < 10) {
            desconto = 0.05;
        } else if(pedido.getQuantidade() == 10) {
            desconto = 0.10;
        }

        pedido.setValor(pedido.getValor() * pedido.getQuantidade() * (1 - desconto));
        pedidosRepository.save(pedido);
    }

    public List<Pedido> consultarPedidos(Integer numeroPedido, String dataCadastro) {
        if(numeroPedido != null) {
            return pedidosRepository.findById(numeroPedido);
        } else if(dataCadastro != "") {
            return pedidosRepository.findByDataCadastro(dataCadastro);
        } else {
            return pedidosRepository.findAll();
        }
    }
}