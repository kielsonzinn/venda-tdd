package org.example;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Venda {

    private final List<Item> itens = new ArrayList<>();

    private final List<Recebimento> recebimentos = new ArrayList<>();

    public Integer getProximoSequencialItem() {

        return itens.stream()
                .map(Item::getSequencial)
                .max(Integer::compareTo)
                .orElse(0) + 1;

    }

    public void adicionarItem(Item item) {

        itens.add(item);

    }

    public void removerItem(Integer sequencial) {

        Iterator<Item> iterator = itens.iterator();

        while (iterator.hasNext()) {

            Item item = iterator.next();

            if (item.getSequencial().equals(sequencial)) {

                iterator.remove();
                break;

            }

        }

    }

    public BigDecimal getTroco() {

        return getTotal().subtract(getPagamentoTotal()).multiply(BigDecimal.valueOf(-1)).setScale(2, RoundingMode.HALF_UP);

    }

    public void adicionarRecebimento(Recebimento recebimento) {

        recebimentos.add(recebimento);

    }

    public void removerRecebimento(Integer sequencial) {

        Iterator<Recebimento> iterator = recebimentos.iterator();

        while (iterator.hasNext()) {

            Recebimento recebimento = iterator.next();

            if (recebimento.getSequencial().equals(sequencial)) {

                iterator.remove();
                break;

            }

        }

    }

    public BigDecimal getTotal() {

        return itens.stream()
                .map(Item::getPrecoTotal)
                .reduce(BigDecimal.ZERO, BigDecimal::add)
                .setScale(2, RoundingMode.HALF_UP);

    }

    public BigDecimal getPagamentoPendente() {

        return getTotal().subtract(getPagamentoTotal()).setScale(2, RoundingMode.HALF_UP);

    }

    public BigDecimal getPagamentoTotal() {

        return recebimentos.stream()
                .map(Recebimento::getPagamento)
                .reduce(BigDecimal.ZERO, BigDecimal::add)
                .setScale(2, RoundingMode.HALF_UP);

    }

}
