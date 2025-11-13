package com.livraria.model;
import jakarta.persistence.*;
import java.time.LocalDateTime;

public class AutorLivro {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne(optional = false)
    @JoinColumn(name= "autor_id", nullable = false)
    private Autor autor;

    @ManyToOne(optional = false)
    @JoinColumn(name= "livro_id", nullable = false)
    private Livro livro;

    @Column(name= "data_criacao_autorlivro", nullable = false)
    private LocalDateTime dataCriacaoAutorLivro;
    @Column(name= "data_atualizacao_autorlivro", nullable = false)
    private LocalDateTime dataAtualizacaoAutorLivro;

    public AutorLivro(){}
    public AutorLivro(Autor autor, Livro livro){
        this.autor= autor;
        this.livro= livro;}

    @PrePersist
    protected void onCreateAutorLivro(){
        this.dataCriacaoAutorLivro= LocalDateTime.now();
        this.dataAtualizacaoAutorLivro= LocalDateTime.now();}

    @PreUpdate
    protected void onUpdateAutorLivro(){
        this.dataAtualizacaoAutorLivro= LocalDateTime.now();}

    public Autor getAutor(){return autor;}
    public void setAutor(Autor autor){this.autor= autor;}

    public Livro getLivro(){return livro;}
    public void setLivro(Livro livro){this.livro= livro;}

    public Long getId(){return id;}
    public LocalDateTime getDataCriacaoAutorLivro(){return dataCriacaoAutorLivro;}
    public LocalDateTime getDataAtualizacaoAutorLivro(){return dataAtualizacaoAutorLivro;}
}
