package org.example;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

public class Venda {

    private List<Item> itens = new ArrayList<>();

    private List<Recebimento> recebimentos = new ArrayList<>();

    public Integer getProximoSequencialItem() {

        Integer max = 0;

        for (Item item : itens) {
            if (item.getSequencial() > max) {
                max = item.getSequencial();
            }
        }

        return max + 1;

    }

    public void adicionarItem(Item item) {
        itens.add(item);
    }

    public void removerItem(Integer sequencial) {
        for (Item item : itens) {
            if (item.getSequencial().equals(sequencial)) {
                itens.remove(item);
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
        for (Recebimento recebimento : recebimentos) {
            if (recebimento.getSequencial().equals(sequencial)) {
                recebimentos.remove(recebimento);
                break;
            }
        }
    }

    public BigDecimal getTotal() {
        BigDecimal total = new BigDecimal(0.00);

        for (Item item : itens) {
            total = total.add(item.getPrecoTotal());
        }

        return total.setScale(2, RoundingMode.HALF_UP);
    }

    public BigDecimal getPagamentoPendente() {
        return getTotal().subtract(getPagamentoTotal()).setScale(2, RoundingMode.HALF_UP);
    }

    public BigDecimal getPagamentoTotal() {

        BigDecimal total = new BigDecimal(0.00);

        for (Recebimento recebimento : recebimentos) {
            total = total.add(recebimento.getPagamento());
        }

        return total.setScale(2, RoundingMode.HALF_UP);
    }

}
