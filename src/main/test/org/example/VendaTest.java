package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

class VendaTest {

    @Test
    void testGetProximoSequencialItem() {

        Venda venda = new Venda();
        Assertions.assertEquals(venda.getProximoSequencialItem(), 1);

        venda.adicionarItem(new Item(1, new Produto(1, BigDecimal.valueOf(1.00)), BigDecimal.valueOf(1.00)));
        Assertions.assertEquals(venda.getProximoSequencialItem(), 2);

        venda.adicionarItem(new Item(2, new Produto(1, BigDecimal.valueOf(1.00)), BigDecimal.valueOf(1.00)));
        Assertions.assertEquals(venda.getProximoSequencialItem(), 3);

        venda.adicionarItem(new Item(5, new Produto(1, BigDecimal.valueOf(1.00)), BigDecimal.valueOf(1.00)));
        Assertions.assertEquals(venda.getProximoSequencialItem(), 6);

        venda.removerItem(1);
        Assertions.assertEquals(venda.getProximoSequencialItem(), 6);

        venda.removerItem(5);
        Assertions.assertEquals(venda.getProximoSequencialItem(), 3);

    }

    @Test
    void testAdicionarItem() {

        Venda venda = new Venda();
        venda.adicionarItem(new Item(1, new Produto(1, BigDecimal.valueOf(2.00)), BigDecimal.valueOf(1.00)));

        Assertions.assertEquals(venda.getProximoSequencialItem(), 2);
        Assertions.assertEquals(venda.getTotal(),BigDecimal.valueOf(2.00));

    }

    @Test
    void testRemoverItem() {

        Venda venda = new Venda();
        venda.adicionarItem(new Item(1, new Produto(1, BigDecimal.valueOf(2.00)), BigDecimal.valueOf(1.00)));
        venda.adicionarItem(new Item(2, new Produto(2, BigDecimal.valueOf(3.00)), BigDecimal.valueOf(1.00)));

        venda.removerItem(2);

        Assertions.assertEquals(venda.getProximoSequencialItem(), 2);
        Assertions.assertEquals(venda.getTotal(), BigDecimal.valueOf(2.00));

        venda.removerItem(1);

        Assertions.assertEquals(venda.getProximoSequencialItem(), 1);
        Assertions.assertEquals(venda.getTotal(), BigDecimal.valueOf(0.00));

    }

    @Test
    void testAdicionarRecebimento() {

        Venda venda = new Venda();

        venda.adicionarRecebimento(new Recebimento(1, BigDecimal.valueOf(3.00)));
        Assertions.assertEquals(venda.getPagamentoTotal(), BigDecimal.valueOf(3.00));

        venda.adicionarRecebimento(new Recebimento(1, BigDecimal.valueOf(1.55)));
        Assertions.assertEquals(venda.getPagamentoTotal(), BigDecimal.valueOf(4.55));

    }

    @Test
    void testRemoverRecebimento() {

        Venda venda = new Venda();
        venda.adicionarRecebimento(new Recebimento(1, BigDecimal.valueOf(3.00)));
        venda.adicionarRecebimento(new Recebimento(1, BigDecimal.valueOf(1.55)));

        venda.removerRecebimento(1);
        Assertions.assertEquals(venda.getPagamentoTotal(), BigDecimal.valueOf(1.55));

        venda.removerRecebimento(2);
        Assertions.assertEquals(venda.getPagamentoTotal(), BigDecimal.valueOf(0.00));

    }

    @Test
    void testGetTroco() {

        Venda venda = new Venda();
        venda.adicionarItem(new Item(1, new Produto(1, BigDecimal.valueOf(2.00)), BigDecimal.valueOf(1.00)));
        venda.adicionarRecebimento(new Recebimento(1, BigDecimal.valueOf(3.00)));

        Assertions.assertEquals(venda.getTroco(), BigDecimal.valueOf(1.00));

    }

    @Test
    void testGetTotal() {

        Venda venda = new Venda();
        venda.adicionarItem(new Item(1, new Produto(1, BigDecimal.valueOf(2.23)), BigDecimal.valueOf(1.234)));

        Assertions.assertEquals(venda.getTotal(), BigDecimal.valueOf(2.75));

    }

    @Test
    void testGetPagamentoPendente() {

        Venda venda = new Venda();
        venda.adicionarItem(new Item(1, new Produto(1, BigDecimal.valueOf(2.00)), BigDecimal.valueOf(1.00)));

        Assertions.assertEquals(venda.getPagamentoPendente(), BigDecimal.valueOf(2.00));

        venda.adicionarRecebimento(new Recebimento(1, BigDecimal.valueOf(1.00)));
        Assertions.assertEquals(venda.getPagamentoPendente(), BigDecimal.valueOf(1.00));

    }

    @Test
    void testGetPagamentoTotal() {

        Venda venda = new Venda();
        venda.adicionarRecebimento(new Recebimento(1, BigDecimal.valueOf(3.00)));
        venda.adicionarRecebimento(new Recebimento(1, BigDecimal.valueOf(1.55)));

        Assertions.assertEquals(venda.getPagamentoTotal(), BigDecimal.valueOf(4.55));

    }

}
