package com.livraria.model;
import jakarta.persistence.*;

@Entity
@DiscriminatorValue("fornecedor")
public class Fornecedor extends PessoaJuridica{

}
