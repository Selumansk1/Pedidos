package com.pedidos.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pedidos.model.Pedido;
import com.pedidos.service.PedidoService;

@RestController
public class PedidoController {
    
    @Autowired
    private PedidoService pedidoService;

    @PostMapping("/enviar")
    public ResponseEntity<String> receberPedido(@RequestBody Pedido pedido) {
        try {
            pedidoService.processarPedido(pedido);
            return ResponseEntity.ok("Pedido recebido com sucesso");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro ao receber o pedido: " + e.getMessage());
        }
    }

    @GetMapping("/consultar")
    public ResponseEntity<List<Pedido>> consultarPedidos(@RequestParam(required = false) Integer numeroPedido, @RequestParam(required = false) String dataCadastro) {

        List<Pedido> pedidos = pedidoService.consultarPedidos(numeroPedido, dataCadastro);
        return ResponseEntity.ok(pedidos);
    }
}