package com.livraria.model;
import jakarta.persistence.*;

@MappedSuperclass
public class Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String nome;

    @Column(nullable = false, length = 100)
    private String email;

    @Column(length = 50)
    private String telefone;

    public Pessoa(){}
    public Pessoa(String nome, String email, String telefone){
        this.nome=nome;
        this.email=email;
        this.telefone=telefone;
    }

    public Long getId() {return id;}
    public void setId(Long id) {this.id=id;}

    public String getNome() {return nome;}
    public void setNome(String nome) {this.nome=nome;}

    public String getEmail() {return email;}
    public void setEmail(String email) {this.email=email;}

    public String getTelefone() {return telefone;}
    public void setTelefone(String telefone) {this.telefone=telefone;}
}
