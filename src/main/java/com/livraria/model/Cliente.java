package com.livraria.model;
import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@DiscriminatorValue("Cliente")
public class Cliente extends Pessoa {

    private BigDecimal limiteCredito;
    //??historico compras;






}
