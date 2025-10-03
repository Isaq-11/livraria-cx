package com.livraria.model;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="autor")
public class Autor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String nome;

    @ManyToMany(mappedBy = "autores")
    private List<Livro> livros = new ArrayList<>();


    public Autor(){}
    public Autor(String nome){this.nome = nome;}


    public Long getId() {return id;}
    public void setId(Long id) {this.id=id;};

    public String getNome() {return nome;}
    public void setNome(String nome) {this.nome=nome;}

    public List<Livro> getLivros(){return livros;}
    public void setLivros(List<Livro> livros) {this.livros=livros;}


    public void addLivro(Livro livro) {
        if (!livros.contains(livro)) {
            livros.add(livro);
            livro.getAutores().add(this); // mantém consistência bidirecional
        }
    }

    // Remove um livro do autor
    public void removeLivro(Livro livro) {
        if (livros.contains(livro)) {
            livros.remove(livro);
            livro.getAutores().remove(this); // mantém consistência bidirecional
        }
    }

}
