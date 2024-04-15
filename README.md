Url de consulta com data de cadastro - localhost:8080/consultar?dataCadastro=dd/MM/yyyy
Url de consulta com numero do pedido - localhost:8080/consultar?numeroPedido=1
Url de consulta de todos os peiddos - localhost:8080/consultar

Url de cadastro de pedidos - localhost:8080/enviar
Body:
{
    "numeroControle": , 
    "dataCadastro": "dd/MM/yyyy", 
    "nome": "", 
    "valor": 0.00, 
    "quantidade": "", 
    "codigoCliente": 
}


Insert na tabelo de clientes 


insert into clientes (nome, codigo_cliente) values ("Cleiton", 1);
insert into clientes (nome, codigo_cliente) values ("Maria", 2);
insert into clientes (nome, codigo_cliente) values ("Jusé", 3);
insert into clientes (nome, codigo_cliente) values ("Raphaelly", 4);
insert into clientes (nome, codigo_cliente) values ("Jerundio", 5);
insert into clientes (nome, codigo_cliente) values ("Almir", 6);
insert into clientes (nome, codigo_cliente) values ("Clewerson", 7);
insert into clientes (nome, codigo_cliente) values ("Alaide", 8);
insert into clientes (nome, codigo_cliente) values ("Cristiane", 9);
insert into clientes (nome, codigo_cliente) values ("Lorena", 10);
