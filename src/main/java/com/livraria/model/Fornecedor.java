package com.livraria.model;
import jakarta.persistence.*;

@Entity
@Table(name= "fornecedor")
public class Fornecedor extends Pessoa{

    @Column(nullable = false, unique = true, length = 14)
    private String cnpj;

    public Fornecedor(){}
    public Fornecedor(String nome, String cnpj, String email, String telefone){
        super(nome, email, telefone);
        this.cnpj=cnpj;
    }

    public String getCnpj() {return cnpj;}
    public void setCnpj(String cnpj) {this.cnpj = cnpj;}
}
