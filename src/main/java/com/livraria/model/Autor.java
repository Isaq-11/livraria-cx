package com.livraria.model;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name="autor")
public class Autor {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    @Column(name= "nome_autor", length = 25, nullable = false)
    private String nome;

    @Column(name= "sobrenome_autor", length = 100, nullable = false)
    private String sobrenome;

    private String bibliografia= null;

    @Column(name= "data_criacao_autor", nullable = false)
    private LocalDateTime dataCriacaoAutor;
    @Column(name= "data_atualizacao_autor", nullable = false)
    private LocalDateTime dataAtualizacaoAutor;

    public Autor(){}
    public Autor(String nome, String sobrenome, String bibliografia){
        this.nome= nome;
        this.sobrenome= sobrenome;
        this.bibliografia= bibliografia;
    }

    @PrePersist
    protected void onCreateAutor(){this.dataCriacaoAutor= LocalDateTime.now();
        this.dataAtualizacaoAutor= LocalDateTime.now();}

    @PreUpdate
    protected void onUpdateAutor(){this.dataAtualizacaoAutor= LocalDateTime.now();}

    public String getNome(){return nome;}
    public void setNome(String nome){this.nome= nome;}

    public String getSobrenome(){return sobrenome;}
    public void setSobrenome(String sobrenome){this.sobrenome= sobrenome;}

    public String getBibliografia(){return bibliografia;}
    public void setBibliografia(String bibliografia){this.bibliografia= bibliografia;}

    public Long getId(){return id;}
    public LocalDateTime getDataCriacaoAutor(){return dataCriacaoAutor;}
    public LocalDateTime getDataAtualizacaoAutor(){return dataAtualizacaoAutor;}
}
