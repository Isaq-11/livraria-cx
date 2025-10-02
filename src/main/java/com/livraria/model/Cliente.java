package com.livraria.model;
import jakarta.persistence.*;

@Entity
@Table(name = "cliente")
public class Cliente extends Pessoa {

    @Column(nullable = false, unique = true, length = 11)
    private String cpf;

    public Cliente(){}
    public Cliente(String nome, String cpf, String email, String telefone){
        super(nome, email, telefone);
        this.cpf=cpf;
    }

    public String getCpf() {return cpf;}
    public void setCpf(String cpf) {this.cpf=cpf;}
}
