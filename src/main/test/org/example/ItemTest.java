package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

class ItemTest {

    @Test
    void testPrecoTotal() {

        Item item = new Item(1, new Produto(1, BigDecimal.valueOf(1.99)), BigDecimal.valueOf(3.523));

        Assertions.assertEquals(BigDecimal.valueOf(7.01), item.getPrecoTotal());

    }

}
