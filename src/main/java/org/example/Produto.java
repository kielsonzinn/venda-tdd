package org.example;

import java.math.BigDecimal;

public class Produto {

    private Integer id;

    private BigDecimal preco;

    public Produto(Integer id, BigDecimal preco) {
        this.id = id;
        this.preco = preco;
    }

    public Integer getId() {
        return id;
    }

    public BigDecimal getPreco() {
        return preco;
    }

}
