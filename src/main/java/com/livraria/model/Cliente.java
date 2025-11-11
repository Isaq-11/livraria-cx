package com.livraria.model;
import jakarta.persistence.*;

@Entity
@DiscriminatorValue("Cliente")
public class Cliente extends Pessoa {

    endereco
    limite credito
    ??historico compras;


}
