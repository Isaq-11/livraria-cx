package com.livraria.model;
import jakarta.persistence.*;

@MappedSuperclass
public abstract class Cnpj {

    @Column(nullable = false, length = 100)
    private String nome;

    @Column(nullable = false, unique = true, length = 14)
    private String cnpj;

    @Column(nullable = false, unique = true, length = 100)
    private String razaoSocial;

    @Column(nullable = false, length = 100)
    private String email;

    @Column(length = 50)
    private String telefone;

    public Cnpj(){}
    public Cnpj(String nome,String cnpj, String razaoSocial, String email, String telefone){
        this.nome=nome;
        this.cnpj = cnpj;
        this.razaoSocial = razaoSocial;
        this.email=email;
        this.telefone=telefone;
    }

    public String getNome() {return nome;}
    public void setNome(String nome) {this.nome=nome;}

    public String getCnpj() {return cnpj;}
    public void setCnpj(String cnpj) {this.cnpj = cnpj;}

    public String getRazaoSocial(){return razaoSocial;}
    public void setRazaoSocial(String razaoSocial){this.razaoSocial = razaoSocial;}

    public String getEmail() {return email;}
    public void setEmail(String email) {this.email=email;}

    public String getTelefone() {return telefone;}
    public void setTelefone(String telefone) {this.telefone=telefone;}
}
