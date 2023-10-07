package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;

class VendaTest {

    @Test
    void testGetProximoSequencialItem() {

        Venda venda = new Venda();
        Assertions.assertEquals(1,venda.getProximoSequencialItem());

        venda.adicionarItem(new Item(1, new Produto(1, BigDecimal.valueOf(1.00)), BigDecimal.valueOf(1.00)));
        Assertions.assertEquals(2,venda.getProximoSequencialItem());

        venda.adicionarItem(new Item(2, new Produto(1, BigDecimal.valueOf(1.00)), BigDecimal.valueOf(1.00)));
        Assertions.assertEquals(3, venda.getProximoSequencialItem());

        venda.adicionarItem(new Item(5, new Produto(1, BigDecimal.valueOf(1.00)), BigDecimal.valueOf(1.00)));
        Assertions.assertEquals(6, venda.getProximoSequencialItem());

        venda.removerItem(1);
        Assertions.assertEquals(6, venda.getProximoSequencialItem());

        venda.removerItem(5);
        Assertions.assertEquals(3, venda.getProximoSequencialItem());

    }

    @Test
    void testAdicionarItem() {

        Venda venda = new Venda();
        venda.adicionarItem(new Item(1, new Produto(1, BigDecimal.valueOf(2.00)), BigDecimal.valueOf(1.00)));

        Assertions.assertEquals(2, venda.getProximoSequencialItem());
        Assertions.assertEquals(BigDecimal.valueOf(2.00).setScale(2, RoundingMode.HALF_UP), venda.getTotal());

    }

    @Test
    void testRemoverItem() {

        Venda venda = new Venda();
        venda.adicionarItem(new Item(1, new Produto(1, BigDecimal.valueOf(2.00)), BigDecimal.valueOf(1.00)));
        venda.adicionarItem(new Item(2, new Produto(2, BigDecimal.valueOf(3.00)), BigDecimal.valueOf(1.00)));

        venda.removerItem(2);

        Assertions.assertEquals(2, venda.getProximoSequencialItem());
        Assertions.assertEquals(BigDecimal.valueOf(2.00).setScale(2, RoundingMode.HALF_UP), venda.getTotal());

        venda.removerItem(1);

        Assertions.assertEquals(1, venda.getProximoSequencialItem());
        Assertions.assertEquals(BigDecimal.valueOf(0.00).setScale(2, RoundingMode.HALF_UP), venda.getTotal());

    }

    @Test
    void testAdicionarRecebimento() {

        Venda venda = new Venda();

        venda.adicionarRecebimento(new Recebimento(1, BigDecimal.valueOf(3.00)));
        Assertions.assertEquals(BigDecimal.valueOf(3.00).setScale(2, RoundingMode.HALF_UP), venda.getPagamentoTotal());

        venda.adicionarRecebimento(new Recebimento(1, BigDecimal.valueOf(1.55)));
        Assertions.assertEquals(BigDecimal.valueOf(4.55).setScale(2, RoundingMode.HALF_UP), venda.getPagamentoTotal());

    }

    @Test
    void testRemoverRecebimento() {

        Venda venda = new Venda();
        venda.adicionarRecebimento(new Recebimento(1, BigDecimal.valueOf(3.00)));
        venda.adicionarRecebimento(new Recebimento(2, BigDecimal.valueOf(1.55)));

        venda.removerRecebimento(1);
        Assertions.assertEquals(BigDecimal.valueOf(1.55).setScale(2, RoundingMode.HALF_UP), venda.getPagamentoTotal());

        venda.removerRecebimento(2);
        Assertions.assertEquals(BigDecimal.valueOf(0.00).setScale(2, RoundingMode.HALF_UP), venda.getPagamentoTotal());

    }

    @Test
    void testGetTroco() {

        Venda venda = new Venda();
        venda.adicionarItem(new Item(1, new Produto(1, BigDecimal.valueOf(2.00)), BigDecimal.valueOf(1.00)));
        venda.adicionarRecebimento(new Recebimento(1, BigDecimal.valueOf(3.00)));

        Assertions.assertEquals(BigDecimal.valueOf(1.00).setScale(2, RoundingMode.HALF_UP), venda.getTroco());

    }

    @Test
    void testGetTotal() {

        Venda venda = new Venda();
        venda.adicionarItem(new Item(1, new Produto(1, BigDecimal.valueOf(2.23)), BigDecimal.valueOf(1.234)));

        Assertions.assertEquals(BigDecimal.valueOf(2.75).setScale(2, RoundingMode.HALF_UP), venda.getTotal());

    }

    @Test
    void testGetPagamentoPendente() {

        Venda venda = new Venda();
        venda.adicionarItem(new Item(1, new Produto(1, BigDecimal.valueOf(2.00)), BigDecimal.valueOf(1.00)));

        Assertions.assertEquals(BigDecimal.valueOf(2.00).setScale(2, RoundingMode.HALF_UP), venda.getPagamentoPendente());

        venda.adicionarRecebimento(new Recebimento(1, BigDecimal.valueOf(1.00)));
        Assertions.assertEquals(BigDecimal.valueOf(1.00).setScale(2, RoundingMode.HALF_UP), venda.getPagamentoPendente());

    }

    @Test
    void testGetPagamentoTotal() {

        Venda venda = new Venda();
        venda.adicionarRecebimento(new Recebimento(1, BigDecimal.valueOf(3.00)));
        venda.adicionarRecebimento(new Recebimento(1, BigDecimal.valueOf(1.55)));

        Assertions.assertEquals(BigDecimal.valueOf(4.55).setScale(2, RoundingMode.HALF_UP), venda.getPagamentoTotal());

    }

}
