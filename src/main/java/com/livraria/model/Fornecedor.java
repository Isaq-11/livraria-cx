package com.livraria.model;
import jakarta.persistence.*;

@Entity
@Table(name= "fornecedor")
public class Fornecedor extends Pessoa{

    @Column(nullable = false, unique = true, length = 14)
    private String cnpj;

    @Column(nullable = false, unique = true, length = 100)
    private String razaoSocial;

    public Fornecedor(){}
    public Fornecedor(String nome, String razaoSocial, String cnpj, String email, String telefone){
        super(nome, email, telefone);
        this.cnpj=cnpj;
        this.razaoSocial = razaoSocial;
    }

    public String getCnpj() {return cnpj;}
    public void setCnpj(String cnpj) {this.cnpj = cnpj;}

    public String getRazaoSocial(){return razaoSocial;}
    public void setRazaoSocial(String razaoSocial){this.razaoSocial = razaoSocial;}
}
