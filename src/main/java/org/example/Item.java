package org.example;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

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
        return getQuantidade().multiply(getProduto().getPreco()).setScale(2, RoundingMode.HALF_UP);
    }

}
