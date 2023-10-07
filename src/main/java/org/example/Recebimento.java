package org.example;

import java.math.BigDecimal;

public class Recebimento {

    private Integer sequencial;

    private BigDecimal pagamento;

    public Recebimento(Integer sequencial, BigDecimal pagamento) {
        this.sequencial = sequencial;
        this.pagamento = pagamento;
    }

    public Integer getSequencial() {
        return sequencial;
    }

    public BigDecimal getPagamento() {
        return pagamento;
    }

}
