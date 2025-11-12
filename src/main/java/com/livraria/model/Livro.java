package com.livraria.model;
import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name= "livro")
public class Livro {

    private Long id;
    private String titulo;
    private int anoPublicacao;
    private int classificacaoIndicativa;
    private String isbn;
    //autor
    private Editora editora;
    private BigDecimal preco;
    private int qtdeEstoque; // seria bom implementar uma classe só pra isso, mas por enquanto nao




}
