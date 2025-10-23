package com.livraria.model;
import jakarta.persistence.*;

@Entity
@Table(name= "fornecedor")
public class Fornecedor extends Cnpj{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public Fornecedor(){}
    public Fornecedor(String nome, String razaoSocial, String cnpj, String email, String telefone){
        super(nome, cnpj, razaoSocial, email, telefone);

    public Long getId() {return id;}
    public void setId(Long id) {this.id=id;}
}
