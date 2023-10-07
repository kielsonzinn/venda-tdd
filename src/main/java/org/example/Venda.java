package org.example;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Venda {

    private List<Item> itens = new ArrayList<>();

    private List<Recebimento> recebimentos = new ArrayList<>();

    public Integer getProximoSequencialItem() {
        //TODO IMPLEMENTAR
        return 0;
    }

    public void adicionarItem(Item item) {
        //TODO IMPLEMENTAR
    }

    public void removerItem(Integer sequencial) {
        //TODO IMPLEMENTAR
    }

    public BigDecimal getTroco() {
        //TODO IMPLEMENTAR
        return BigDecimal.valueOf(0.00);
    }

    public void adicionarRecebimento(Recebimento recebimento) {
        //TODO IMPLEMENTAR
    }

    public void removerRecebimento(Integer sequencial) {
        //TODO IMPLEMENTAR
    }

    public BigDecimal getTotal() {
        //TODO IMPLEMENTAR
        return BigDecimal.valueOf(0.00);
    }

    public BigDecimal getPagamentoPendente() {
        //TODO IMPLEMENTAR
        return BigDecimal.valueOf(0.00);
    }

    public BigDecimal getPagamentoTotal() {
        //TODO IMPLEMENTAR
        return BigDecimal.valueOf(0.00);
    }

}
