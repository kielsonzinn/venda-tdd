package org.example;

import java.math.BigDecimal;

public class Produto {

    private final Integer id;

    private final BigDecimal preco;

    public Produto(Integer id, BigDecimal preco) {

        this.id = id;
        this.preco = preco;

    }

    @SuppressWarnings("unused")
    public Integer getId() {

        return id;

    }

    public BigDecimal getPreco() {

        return preco;

    }

}
