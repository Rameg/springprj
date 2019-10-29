package com.venancio.springprj.domain;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.venancio.springprj.domain.enums.EstadoPagamento;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import java.util.Date;

@Getter
@Setter
@Entity
public class PagamamentoComBoleto extends Pagamento{
    private static final long serialVersionUID = 1L;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private Date dataVencimento;
    @JsonFormat(pattern = "dd/MM/yyyy")
    private Date dataPagamentoo;

    public PagamamentoComBoleto(){}

    public PagamamentoComBoleto(Integer id, EstadoPagamento estado, Pedido pedido, Date dataVencimento, Date dataPagamentoo) {
        super(id, estado, pedido);
        this.dataVencimento = dataVencimento;
        this.dataPagamentoo = dataPagamentoo;
    }
}
