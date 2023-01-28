package com.example.springbootvendas.service.impl;

import com.example.springbootvendas.domain.entity.Cliente;
import com.example.springbootvendas.domain.entity.ItemPedido;
import com.example.springbootvendas.domain.entity.Pedido;
import com.example.springbootvendas.domain.entity.Produto;
import com.example.springbootvendas.domain.enums.StatusPedido;
import com.example.springbootvendas.domain.repository.Clientes;
import com.example.springbootvendas.domain.repository.ItensPedido;
import com.example.springbootvendas.domain.repository.Pedidos;
import com.example.springbootvendas.domain.repository.Produtos;
import com.example.springbootvendas.exception.RegraDeNegocioException;
import com.example.springbootvendas.dto.ItemPedidoDTO;
import com.example.springbootvendas.dto.PedidoDTO;
import com.example.springbootvendas.service.PedidoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PedidoServiceImpl implements PedidoService {

    private final Pedidos pedidos;
    private final Clientes clienteRepository;
    private final Produtos produtosRepository;
    private final ItensPedido itensPedidoRepository;

    @Override
    public Pedido salvar(PedidoDTO dto) {
        Integer idCliente = dto.getCliente();
        Cliente cliente = clienteRepository
                .findById(idCliente)
                .orElseThrow(() -> new RegraDeNegocioException("Código de cliente invalido"));

        Pedido pedido = new Pedido();
        pedido.setTotal(dto.getTotal());
        pedido.setDataPedido(LocalDate.now());
        pedido.setCliente(cliente);
        pedido.setStatus(StatusPedido.REALIZADO);

        List<ItemPedido> itensPedido = converterItens(pedido, dto.getItens());
        pedidos.save(pedido);
        itensPedidoRepository.saveAll(itensPedido);
        pedido.setItens(itensPedido);
        return pedido;
    }

    private List<ItemPedido> converterItens(Pedido pedido, List<ItemPedidoDTO> items) {
        if (items.isEmpty()) {
            throw new RegraDeNegocioException("Não é possível realizar um pedido sem items");
        }
        return items.stream().map(dto -> {
            Integer idProduto = dto.getProduto();
            Produto produto = produtosRepository
                    .findById(idProduto)
                    .orElseThrow(
                            () -> new RegraDeNegocioException("Código do produto invalido" + idProduto));

            ItemPedido itemPedido = new ItemPedido();
            itemPedido.setQuantidade(dto.getQuantidade());
            itemPedido.setPedido(pedido);
            itemPedido.setProduto(produto);

            return itemPedido;
        }).collect(Collectors.toList());
    }

    @Override
    public Optional<Pedido> obterPedidoCompleto(Integer id) {
        return pedidos.findByIdFetchItens(id);
    }
}