package com.livraria.model;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class PedidoLivro {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne(optional = false)
    @JoinColumn(name= "livro_id", nullable = false)
    private Livro livro;

    @ManyToOne(optional = false)
    @JoinColumn(name= "fornecedor_id", nullable = false)
    private Fornecedor fornecedor;

    @Column(name= "data_pedido", nullable = false)
    private LocalDate dataPedido;

    @Column(length = 4)
    private int quantidade;

    @Column(name= "custo_unitario", precision = 10, scale = 2, nullable = false)
    private BigDecimal custo;

    private LocalDateTime dataCriacaoPedidoLivro;
    private LocalDateTime dataAtualizacaoPedidoLivro;

    public PedidoLivro(){}
    public PedidoLivro(Livro livro, Fornecedor fornecedor, LocalDate dataPedido, int quantidade,
                       BigDecimal custo){
        this.livro= livro;
        this.fornecedor= fornecedor;
        this.dataPedido= dataPedido;
        this.quantidade= quantidade;
        this.custo= custo;}

    @PrePersist
    protected void onCreatePedidoLivro(){
        this.dataCriacaoPedidoLivro= LocalDateTime.now();
        this.dataAtualizacaoPedidoLivro= LocalDateTime.now();}

    @PreUpdate
    protected void onUpdatePedidoLivro(){
        this.dataAtualizacaoPedidoLivro= LocalDateTime.now();}

    public Livro getLivro(){return livro;}
    public void setLivro(Livro livro){this.livro= livro;}

    public Fornecedor getFornecedor(){return fornecedor;}
    public void setFornecedor(Fornecedor fornecedor){this.fornecedor= fornecedor;}

    public LocalDate getDataPedido(){return dataPedido;}
    public void setDataPedido(LocalDate dataPedido ){this.dataPedido= dataPedido;}

    public int getQuantidade(){return quantidade;}
    public void setQuantidade(int quantidade){this.quantidade= quantidade;}

    public BigDecimal getCusto(){return custo;}
    public void setCusto(BigDecimal custo){this.custo= custo;}

    public Long getId(){return id;}
    public LocalDateTime getDataCriacaoPedidoLivro(){return dataCriacaoPedidoLivro;}
    public LocalDateTime getDataAtualizacaoPedidoLivro(){return dataAtualizacaoPedidoLivro;}
}
