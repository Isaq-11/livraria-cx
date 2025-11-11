package com.livraria.model;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="livro")
public class Livro {
 classificalçao indicaiva
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String titulo;

    @Column(nullable = false, length = 6)
    private String ano;

    @ManyToOne
    @JoinColumn(name= "editora_id")
    private Editora editora;

    //@Column(nullable = false, length = 6)
    private Fornecedor fornecedor;

    //@Column(nullable = false, length = 6)
    private Autor autor;

    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal preco;



    //@ManyToMany
    //@JoinTable(name="autor_livro",
    //        joinColumns = @JoinColumn (name= "id_livro"),
    //        inverseJoinColumns = @JoinColumn(name="id_autor"))
    //private List<Autor> autores = new ArrayList<>();

    public Livro(){}
    public Livro(String titulo, String ano, BigDecimal preco){
        this.titulo=titulo;
        this.ano = ano;
        this.preco = preco;
    }

    public Long getId() {return id;}
    public void setId(Long id) {this.id=id;};

    public String getTitulo() {return titulo;}
    public void setTitulo(String titulo) {this.titulo=titulo;}

    //public List<Autor> getAutores() { return autores; }
    //public void setAutores(List<Autor> autores) { this.autores = autores; }

    //// Métodos para manter o relacionamento bidirecional
    //public void addAutor(Autor autor) {
    //    if (!autores.contains(autor)) {
    //        autores.add(autor);
    //        autor.getLivros().add(this); // mantém consistência
    //    }
    //}
//
    //public void removeAutor(Autor autor) {
    //    if (autores.contains(autor)) {
    //        autores.remove(autor);
    //        autor.getLivros().remove(this); // mantém consistência
    //    }
    //}

}
