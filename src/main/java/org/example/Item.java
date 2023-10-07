package org.example;

import java.math.BigDecimal;

public class Item {

    private Integer sequencial;

    private Produto produto;

    private BigDecimal quantidade;

    public Item(Integer sequencial, Produto produto, BigDecimal quantidade) {
        this.sequencial = sequencial;
        this.produto = produto;
        this.quantidade = quantidade;
    }

    public Integer getSequencial() {
        return sequencial;
    }

    public Produto getProduto() {
        return produto;
    }

    public BigDecimal getQuantidade() {
        return quantidade;
    }

    public BigDecimal getPrecoTotal() {
        //TODO IMPLEMENTAR
        return BigDecimal.valueOf(0.00);
    }

}
