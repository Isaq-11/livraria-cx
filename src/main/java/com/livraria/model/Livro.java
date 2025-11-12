package com.livraria.model;
import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name= "livro")
public class Livro {

    private Long id;
    private String titulo;
    private int anoPublicacao;
    private int classificacaoIndicativa;
    private String isbn;
    private Autor autor;
    private Editora editora;
    private BigDecimal preco;
    private int qtdeEstoque; // seria bom implementar uma classe só pra isso, mas por enquanto nao

    private LocalDateTime dataCriacaoLivro;
    private LocalDateTime dataAtualizacaoLivro;

    public Livro(){}
    public Livro(String titulo, int anoPublicacao, int classificacaoIndicativa, String isbn,
                 Autor autor, Editora editora, BigDecimal preco, int qtdeEstoque){
        this.titulo= titulo;
        this.anoPublicacao= anoPublicacao;
        this.classificacaoIndicativa= classificacaoIndicativa;
        this.isbn= isbn;
        this.autor= autor;
        this.editora= editora;
        this.preco= preco;
        this.qtdeEstoque= qtdeEstoque;}

    @PrePersist
    protected void onCreate(){this.dataCriacaoLivro= LocalDateTime.now();
        this.dataAtualizacaoLivro= LocalDateTime.now();}

    @PreUpdate
    protected void onUpdate(){this.dataAtualizacaoLivro= LocalDateTime.now();}

    public String getTitulo(){return titulo;}
    public void setTitulo(String titulo){this.titulo= titulo;}

    public int getAnoPublicacao(){return anoPublicacao;}
    public void setAnoPublicacao(int anoPublicacao){this.anoPublicacao= anoPublicacao;}

    public int getClassificacaoIndicativa(){return classificacaoIndicativa;}
    public void setClassificacaoIndicativa(int classificacaoIndicativa){
        this.classificacaoIndicativa= classificacaoIndicativa;}

    public String getIsbn(){return isbn;}
    public void setIsbn(String isbn){this.isbn= isbn;}

    public Autor getAutor(){return autor;}
    public void setAutor(Autor autor){this.autor= autor;}

    public Editora getEditora(){return editora;}
    public void setEditora(Editora editora){this.editora= editora;}

    public BigDecimal getPreco(){return preco;}
    public void setPreco(BigDecimal preco){this.preco= preco;}

    public int getQtdeEstoque(){return qtdeEstoque;}
    public void setQtdeEstoque(int qtdeEstoque){this.qtdeEstoque= qtdeEstoque;}

    public Long getId(){return id;}
    public LocalDateTime getDataCriacaoLivro(){return dataCriacaoLivro;}
    public LocalDateTime getDataAtualizacaoLivro(){return dataAtualizacaoLivro;}

}
