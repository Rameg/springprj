package com.venancio.springprj.domain.enums;

import lombok.Getter;
import lombok.Setter;

@Getter
public enum EstadoPagamento {

    PENDENTE(1, "Pendente"),
    QUITADO(2, "Quitado"),
    CANCELADO(3, "Cancelado");

    private Integer codigo;
    private String descricao;

    EstadoPagamento(Integer codigo, String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }

    public static EstadoPagamento toEnum(Integer cod){
        if(cod == null) return null;

        for(EstadoPagamento x : EstadoPagamento.values()){
            if (cod.equals(x.getCodigo()))
                return x;
        }

        throw new IllegalArgumentException("Id inválido: " +  cod);
    }

}
