package com.livraria.model;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name= "venda_livro")
public class VendaLivro {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    @ManyToOne(optional = false)
    @JoinColumn(name= "venda_id", nullable = false)
    private Venda venda;

    @ManyToOne(optional = false)
    @JoinColumn(name= "livro_id", nullable = false)
    private Livro livro;

    @Column(length= 4, nullable = false)
    private int quantidade;

    @Column(name="valor_unitario", nullable = false, precision=10, scale = 2)
    private BigDecimal valorUnitario;

    @Column(name="data_criacao_vendaLivro", nullable = false)
    private LocalDateTime dataCriacaoVendaLivro;
    @Column(name= "data_atualizacao_vendaLivro", nullable = false)
    private LocalDateTime dataAtualizacaoVendaLivro;

    public VendaLivro(){}
    public VendaLivro(Venda venda, Livro livro, int quantidade, BigDecimal valorUnitario){
        this.venda= venda;
        this.livro= livro;
        this.quantidade= quantidade;
        this.valorUnitario= valorUnitario;}

    @PrePersist
    protected void onCreateVendaLivro(){
        this.dataCriacaoVendaLivro= LocalDateTime.now();
        this.dataAtualizacaoVendaLivro= LocalDateTime.now();}

    @PreUpdate
    protected void onUpdateVendaLivro(){
        this.dataAtualizacaoVendaLivro= LocalDateTime.now();}

    public Venda getVenda(){return venda;}
    public void setVenda(Venda venda){this.venda= venda;}

    public Livro getLivro(){return livro;}
    public void setLivro(Livro livro){this.livro= livro;}

    public int getQuantidade(){return quantidade;}
    public void setQuantidade(int quantidade){this.quantidade= quantidade;}

    public BigDecimal getValorUnitario(){return valorUnitario;}
    public void setValorUnitario(BigDecimal valorUnitario){this.valorUnitario= valorUnitario;}

    public Long getId(){return id;}
    public LocalDateTime getDataCriacaoVendaLivro(){return dataCriacaoVendaLivro;}
    public LocalDateTime getDataAtualizacaoVendaLivro(){return dataAtualizacaoVendaLivro;}
}
