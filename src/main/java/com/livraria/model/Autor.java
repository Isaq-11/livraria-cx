package com.livraria.model;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name="autor")
public class Autor {

    private Long id;
    private String nome;
    private String sobrenome;
    private String bibliografia= null;

    private LocalDateTime dataCriacaoAutor;
    private LocalDateTime dataAtualizacaoAutor;

    public Autor(){}
    public Autor(String nome, String sobrenome, String bibliografia){
        this.nome= nome;
        this.sobrenome= sobrenome;
        this.bibliografia= bibliografia;
    }

    @PrePersist
    public void onCreateAutor(){this.dataCriacaoAutor= LocalDateTime.now();
        this.dataAtualizacaoAutor= LocalDateTime.now();}

    @PreUpdate
    public void onUpdateAutor(){this.dataAtualizacaoAutor= LocalDateTime.now();}

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
